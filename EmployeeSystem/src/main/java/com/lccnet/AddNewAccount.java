package com.lccnet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class AddNewAccount
 */
public class AddNewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();//如果沒有 session==null就是直接跳轉進來的 踢出去
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		Connection con=null;
		RequestDispatcher view=null;
		
		if(session!=null&&userName 
				   !=null&&password!=null //符合一切規定後 進入連線中
				   &&userName.trim().length()!=0
				   &&password.trim().length()!=0){
				try {
					PreparedStatement stmt=null;
					PreparedStatement stmt2=null;
					ResultSet rs=null;//用於需要輸出結果的 沒有的話 就不需要特別設 
					try {
						ServletContext sc=getServletConfig().getServletContext();//取得整個webApp物件
						DataSource ds=(DataSource)sc.getAttribute("DBDataSource");
						con=ds.getConnection();
						String sqlStr="insert into order_project.customer (user_name,password) values(?,?)";
						stmt=con.prepareStatement(sqlStr);
						stmt.setString(1,userName);
						stmt.setString(2,password);
						stmt.executeUpdate();
						//檢查一下是否有新增成功 
						String confirmsqlStr="select * from customer where user_name=? and password=?";
						stmt2=con.prepareStatement(confirmsqlStr);
						stmt2.setString(1,userName);
						stmt2.setString(2,password);
						rs=stmt2.executeQuery();
							if(rs.next()) {
								String CreatAccountResult="success";
								request.setAttribute("CreatAccountResult",CreatAccountResult);
								view=request.getRequestDispatcher("index.jsp");
								session.invalidate();
								
							}
					}finally {
						if(stmt!=null)stmt.close();
						if(rs!=null)rs.close();
						if(stmt2!=null)stmt.close();
						if(con!=null)con.close();
					}
					
					
				}catch(SQLException|IllegalStateException e) {
					e.printStackTrace();
					view=request.getRequestDispatcher("index.jsp");
					session.invalidate();

					
				}
				
				
				
			}else{
				view=request.getRequestDispatcher("index.jsp");
				session.invalidate();
			}
		view.forward(request, response);//把資料轉交下個網頁
	}

}

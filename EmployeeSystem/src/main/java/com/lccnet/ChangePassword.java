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
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String newPassword;
	private int seachId;
    /**
     * @see HttpServlet#HttpServlet()
     */
	  public ChangePassword() {
			super();
			
		}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			Object obj=session.getAttribute("user");
			newPassword=request.getParameter("newPassword").trim();
			
			Connection con=null;
			RequestDispatcher view=null;
			
			if(session!=null&&newPassword!=null&&//沒有session就是記網頁跳進來的
			  newPassword.trim().length()!=0&&obj!=null) {//判斷輸入的資料是否是空指針 或無資料
				if(obj instanceof com.lccnet.model.User) {
					com.lccnet.model.User user=(com.lccnet.model.User)obj;
						userName=user.getUserName();
						password=user.getPassword();
				}
			
			try {	
					PreparedStatement stmt=null;
					PreparedStatement stmt2=null;
					ResultSet rs = null;	
						try {
							ServletContext sc=getServletConfig().getServletContext();
							DataSource ds=(DataSource)sc.getAttribute("DBDataSource");
							con=ds.getConnection();
							String sqlStr="SELECT customer_id FROM order_project.customer WHERE user_name = ?";
							stmt=con.prepareStatement(sqlStr);
							stmt.setString(1,userName);
							rs=stmt.executeQuery();
							
							if(rs.next()) {
								seachId=rs.getInt("customer_id");
							}//取得名稱對應主KEY
							
							String seachSqlStr="update order_project.customer set password=? where customer_id=? and user_name= ?";
							view=request.getRequestDispatcher("index.jsp");
							stmt2=con.prepareStatement(seachSqlStr);
							stmt2.setString(1,newPassword);
							stmt2.setInt(2, seachId);
							stmt2.setString(3,userName);
							stmt2.executeUpdate();//提交變更密碼
							session.invalidate();
						}finally {
							if(stmt2!=null)stmt.close();
							if(rs!=null)rs.close();
							if(stmt!=null)stmt.close();
							if(con!=null)con.close();
						}
				}catch(SQLException e) {
					e.printStackTrace();
					view=request.getRequestDispatcher("index.jsp");
					session.invalidate();
				}
			
			
		}else {
			view=request.getRequestDispatcher("index.jsp");
		}
			view.forward(request, response);
			
	}
	
	




}

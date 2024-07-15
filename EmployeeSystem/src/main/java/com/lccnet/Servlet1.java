package com.lccnet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
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


import com.lccnet.model.*;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }
	   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
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
					ResultSet rs = null;
					User user=new User();
					try {
						ServletContext sc=getServletConfig().getServletContext();
						DataSource ds=(DataSource)sc.getAttribute("DBDataSource");
						con=ds.getConnection();
						String sqlStr="select * from customer where user_name=? and password=?";
						stmt=con.prepareStatement(sqlStr);
						stmt.setString(1,userName);
						stmt.setString(2,password);
						rs=stmt.executeQuery();
							if(rs.next()) {
								user.setUserName(userName);
								user.setPassword(password);
								session.setAttribute("user",user);
								view=request.getRequestDispatcher("show.jsp");
							}else {
								String error="error";
								request.setAttribute("error",error);
								view=request.getRequestDispatcher("index.jsp");
								session.invalidate();
								
							}
							
					}finally {
						if(rs!=null)rs.close();
						if(stmt!=null)stmt.close();
						if(con!=null)con.close();
					}
					
					
				}catch(SQLException| IllegalArgumentException  | SecurityException  e) {
					e.printStackTrace();
					view=request.getRequestDispatcher("index.jsp");
					session.invalidate();
				}
			}else {
				view=request.getRequestDispatcher("index.jsp");
				session.invalidate();
			}
			view.forward(request, response);//把資料轉交下個網頁
		}
		
}
	



package com.lccnet;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;



public class DbServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try{
				Connection con=null;
				ServletContext sc=arg0.getServletContext();//取得webApp所有物件
				Context initCtx=new InitialContext();
				Context envCtx=(Context)initCtx.lookup("java:comp/env");
				DataSource ds=(DataSource)envCtx.lookup("jdbc/TestMySqlDB");
				sc.setAttribute("DBDataSource", ds);
			try {
				con=ds.getConnection();
				if(sc.getAttribute("DBDataSource")!=null) {
					System.out.println("DB CONNECTION is successfull");
					}else {
						System.out.println("DB CONNECTION is Error");
					}
			}finally {
				if(con!=null)con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

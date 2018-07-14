package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8"); 
		java.io.PrintWriter out = response.getWriter();
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		Connection con;
		Statement sql;
		ResultSet rs;
		String p="";
		String t="";
		try{Class.forName("com.mysql.jdbc.Driver").newInstance();}
		catch(Exception e){out.print(e);}
		try{
		    String uri="jdbc:mysql://localhost:3306/wirelessorder?useUnicode=true&characterEncoding=utf8&useOldAliasMetadataBehavior=true";
		    con=DriverManager.getConnection(uri,"wirelessorder","wirelessorder");
		    sql=con.createStatement();
		    String sqlstr="SELECT * FROM user WHERE userid='"+username+"'";
		    rs=sql.executeQuery(sqlstr);
		    while(rs.next())
		    {
			     p=rs.getString("password");
			     t=rs.getString("usertype");
		    }
		    
		   if(p.equals(password)&&t.equals("0"))
		    {
			   response.sendRedirect("order.jsp");
		    	
		    }
		   
		   else if(p.equals(password)&&t.equals("1"))
		    {
			   response.sendRedirect("cook.jsp");
		    	
		    }
		   
		   else if(p.equals(password)&&t.equals("2"))
		    {
		    	response.sendRedirect("Waiter.jsp");
		    }
		   else
		   {
			   out.write("<script>alert('用户名或密码有误！');window.location.href='login.jsp'</script>");
			   //response.sendRedirect("login.jsp");
		   }
		   con.close();
		}
         catch(SQLException e1){out.print(e1);}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

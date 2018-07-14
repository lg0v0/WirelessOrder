package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class autorequest
 */
@WebServlet("/autorequest")
public class autorequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public autorequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuffer json = new StringBuffer();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		json.append("[");
		try {
			dbDAO db = new dbDAO();
			ResultSet rs = db.query("select orderinfo.tableid,food.foodname,orderdetail.foodcount,orderdetail.foodstatus from orderinfo,food,orderdetail where orderinfo.orderid=orderdetail.orderid and food.foodid=orderdetail.foodid and orderdetail.foodstatus!='烹饪完成' and orderdetail.foodstatus!='未提交'");
			while (rs.next()) {
				json.append('{');
				// 注意每一个key-value对都要在引号之中，单引号或者双引号都可以
				json.append("'tableid':").append("'").append(rs.getString("tableid")).append("'").append(",");
				
				// 注意每一个key-value对都要在引号之中，单引号或者双引号都可以
				json.append("'foodname':").append("'").append(rs.getString("foodname")).append("'").append(",");
				
				// 注意每一个key-value对都要在引号之中，单引号或者双引号都可以
				json.append("'foodcount':").append("'").append(rs.getInt("foodcount")).append("'").append(",");
				
				// 注意每一个key-value对都要在引号之中，单引号或者双引号都可以
				json.append("'foodstatus':").append("'").append(rs.getString("foodstatus")).append("'");
				json.append("},");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 这是为了删除最后一次循环中出现的那个逗号
		json.deleteCharAt(json.length() - 1);
		json.append("]");
		
		//PrintStream out = new PrintStream(response.getOutputStream());
		// 搞完把json打印在本Servlet上，之后前台页面读这页的内容就可以了
		PrintWriter out=response.getWriter();
		out.write(json.toString());
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

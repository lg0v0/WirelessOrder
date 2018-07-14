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
 * Servlet implementation class Order
 */
@WebServlet("/Order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if(action.equals("showOrder"))
		{
			StringBuffer json = new StringBuffer(); 
	        json.append("[");  
	        try {  
	            dbDAO db = new dbDAO();
	            String sqlstr = "select * from orderinfo where orderstatus!='未提交'";
	            ResultSet rs = db.query(sqlstr);  
	            while (rs.next()) {  
	                json.append('{');  
	                //注意每一个key-value对都要在引号之中，单引号或者双引号都可以  
	                json.append("'ordernum':").append("'").append(rs.getString("ordernum")).append("'").append(",");  
	                json.append("'tableid':").append("'").append(rs.getString("tableid").trim()).append("'").append(",");  
	                json.append("'orderdate':").append("'").append(rs.getString("orderdate").trim()).append("'").append(",");
	                json.append("'totalprice':").append("'").append(rs.getString("totalprice").trim()).append("'").append(",");
	                json.append("'orderstatus':").append("'").append(rs.getString("orderstatus").trim()).append("'");
	                json.append("},");  
	            }             
	  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        //这是为了删除最后一次循环中出现的那个逗号  
	        json.deleteCharAt(json.length() - 1);  
	        json.append("]");
	        out.write(json.toString());
	        out.close();
		}
		else if(action.equals("changeOrderStatus"))
		{
			String orderid = request.getParameter("orderid");
			dbDAO db;
			try {
				db = new dbDAO();
				String sqlstr = "select orderstatus from orderinfo where orderid='" + orderid + "'";
				ResultSet rs = db.query(sqlstr);
				rs.next();
				if(!rs.getString("orderstatus").equals("已结账"))
				{
					sqlstr = "update orderinfo set orderstatus='已结账' where orderid='" + orderid + "'";
		            if(db.modify(sqlstr))
					{
						out.write("yes");
					}
					else
					{
						out.write("sql语句错误");
					}
					out.close();
				}
				else
				{
					out.write("已结账");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

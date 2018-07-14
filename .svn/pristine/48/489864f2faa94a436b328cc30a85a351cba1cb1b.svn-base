package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class SubmitOrder
 */
@WebServlet("/SubmitOrder")
public class SubmitOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitOrder() {
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
		String tablenum = request.getParameter("tablenum");
		try {
			dbDAO db = new dbDAO();
			String sqlstr = "select orderdetail.orderid,food.price,orderdetail.foodcount "
					+ "from food,orderinfo,orderdetail "
					+ "where orderinfo.orderid=orderdetail.orderid and orderdetail.foodid=food.foodid and "
					+ "tableid='" + tablenum + "' and orderstatus='未提交'";
			ResultSet rs = db.query(sqlstr);
			int price = 0;
			int foodcount = 0;
			int totalprice = 0;
			String orderid = "";
			while(rs.next())
			{
				price = Integer.parseInt(rs.getString("price"));
				foodcount = Integer.parseInt(rs.getString("foodcount"));
				totalprice += price * foodcount;
				orderid = rs.getString("orderid");
			}
			sqlstr = "update orderdetail set foodstatus='未烹饪' where orderid='" + orderid + "' and foodstatus='未提交'";
			if(db.modify(sqlstr))
			{
				sqlstr = "update orderinfo set totalprice='" + totalprice + "',orderstatus='未上菜' where orderid='" + orderid + "' and orderstatus='未提交'";
				if(db.modify(sqlstr))
				{
					out.write("yes");
					HttpSession session = request.getSession();
					session.removeAttribute("tablenum");
				}
				else
				{
					out.write("no1");
				}
			}
			else
			{
				out.write("no2");
			}
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

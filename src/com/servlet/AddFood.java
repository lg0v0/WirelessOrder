package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddFood
 */
@WebServlet(name = "AddFood", urlPatterns = { "/AddFood" })
public class AddFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFood() {
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
		
		HttpSession session = request.getSession();
		
		if(action.equals("table"))
		{
			String tablenum = request.getParameter("tablenumber");
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			String time = dateFormat.format(date);
			try {
				dbDAO db = new dbDAO();
				String sqlstr = "select tableid from orderinfo where orderstatus!='已结账' and tableid='" + tablenum + "'";
				ResultSet rs = db.query(sqlstr);
				if(rs.next())
				{
					out.write("no");
					out.close();
				}
				else
				{
					sqlstr = "insert into orderinfo(orderid,ordernum,tableid,orderdate,orderstatus) "
							+ "values('" + time + "','" + time + "','" + tablenum + "','" + time + "','" + "未提交" + "')";
					
					if(db.insert(sqlstr))
					{
						session.setAttribute("tablenum", tablenum);
						out.write("yes");
					}
					else
					{
						out.write("no");
					}
					out.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("addfood"))
		{
			String tablenum = request.getParameter("tablenumber");
			String foodid = request.getParameter("foodid");
			try {
				dbDAO db = new dbDAO();
				String sqlstr = "select orderid from orderinfo where tableid='" + tablenum + "' and orderstatus='未提交'";
				ResultSet rs = db.query(sqlstr);
				if(rs.next())
				{
					String orderid = rs.getString("orderid");
					sqlstr = "select * from orderdetail where foodid='" + foodid + "' and orderid='" + orderid + "'";
					rs = db.query(sqlstr);
					//相同的菜数量+1
					if(rs.next())
					{
						sqlstr = "update orderdetail set foodcount=foodcount+1 where foodid='" + foodid + "' and orderid='" + orderid + "'";
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
					//添加新的菜
					else
					{
						sqlstr = "insert into orderdetail(orderid,foodid,foodcount,foodstatus) values('" + orderid + "','"+ foodid +"',1,'未提交')";
						if(db.insert(sqlstr))
						{
							out.write("yes");
						}
						else
						{
							out.write("sql语句错误");
						}
						out.close();
					}
				}
				else
				{
					out.write("没有添加餐桌号");
					out.close();
				}
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			out.write("no");
			out.close();
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

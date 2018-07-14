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
 * Servlet implementation class ShowFoodStatus
 */
@WebServlet("/ShowFoodStatus")
public class ShowFoodStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFoodStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuffer json = new StringBuffer();
        json.append("[");  
        try {  
            dbDAO db = new dbDAO();  
            ResultSet rs = db.query("select tableinfo.tablenum,food.foodname,orderdetail.foodcount,orderdetail.foodstatus "
            		+ "from food,tableinfo,orderinfo,orderdetail "
            		+ "where tableinfo.tableid=orderinfo.tableid and food.foodid=orderdetail.foodid and "
            		+ "orderinfo.orderid=orderdetail.orderid and "
            		+ "orderstatus not in('δ�ύ','�ѽ���') order by tablenum,foodstatus desc");  
            while (rs.next()) {  
                json.append('{');  
                //ע��ÿһ��key-value�Զ�Ҫ������֮�У������Ż���˫���Ŷ�����  
                json.append("'tablenum':").append("'").append(rs.getString("tablenum")).append("'").append(",");  
                json.append("'foodname':").append("'").append(rs.getString("foodname").trim()).append("'").append(",");  
                json.append("'foodcount':").append("'").append(rs.getString("foodcount").trim()).append("'").append(",");
                json.append("'foodstatus':").append("'").append(rs.getString("foodstatus").trim()).append("'");
                json.append("},");  
            }             
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        //����Ϊ��ɾ�����һ��ѭ���г��ֵ��Ǹ�����  
        json.deleteCharAt(json.length() - 1);  
        json.append("]");  
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
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

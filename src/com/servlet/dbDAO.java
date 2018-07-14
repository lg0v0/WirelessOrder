package com.servlet;

import java.sql.*;  
  
public class dbDAO {  
    private Connection con;  
  
    // 构造函数，连接数据库  
    public dbDAO() throws Exception {  
        String dburl = "jdbc:mysql://localhost:3306/wirelessorder?useUnicode=true&characterEncoding=utf8&useOldAliasMetadataBehavior=true";  
        String dbusername = "wirelessorder";  
        String dbpassword = "wirelessorder";  
        Class.forName("com.mysql.jdbc.Driver");  
        this.con = DriverManager.getConnection(dburl, dbusername, dbpassword);  
    }  
  
    // 执行查询  
    public ResultSet query(String sql, Object... args) throws Exception {  
        PreparedStatement ps = con.prepareStatement(sql);  
        for (int i = 0; i < args.length; i++) {  
            ps.setObject(i + 1, args[i]);  
        }  
        return ps.executeQuery();  
    }  
  
    // 执行插入  
    public boolean insert(String sql, Object... args) throws Exception {  
        PreparedStatement ps = con.prepareStatement(sql);  
        for (int i = 0; i < args.length; i++) {  
            ps.setObject(i + 1, args[i]);  
        }  
        if (ps.executeUpdate() == 0) {  
            return false;  
        }  
        return true;  
    }  
  
    // 执行修改  
    public boolean modify(String sql, Object... args) throws Exception {  
        PreparedStatement ps = con.prepareStatement(sql);  
        for (int i = 0; i < args.length; i++) {  
            ps.setObject(i + 1, args[i]);  
        }  
        if (ps.executeUpdate() == 0) {  
            return false;  
        }  
        return true;  
    }  
  
    // 析构函数，中断数据库的连接  
    protected void finalize() throws Exception {  
        if (!con.isClosed() || con != null) {  
            con.close();  
        }  
    }  
}  
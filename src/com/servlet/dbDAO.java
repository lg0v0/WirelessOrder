package com.servlet;

import java.sql.*;  
  
public class dbDAO {  
    private Connection con;  
  
    // ���캯�����������ݿ�  
    public dbDAO() throws Exception {  
        String dburl = "jdbc:mysql://localhost:3306/wirelessorder?useUnicode=true&characterEncoding=utf8&useOldAliasMetadataBehavior=true";  
        String dbusername = "wirelessorder";  
        String dbpassword = "wirelessorder";  
        Class.forName("com.mysql.jdbc.Driver");  
        this.con = DriverManager.getConnection(dburl, dbusername, dbpassword);  
    }  
  
    // ִ�в�ѯ  
    public ResultSet query(String sql, Object... args) throws Exception {  
        PreparedStatement ps = con.prepareStatement(sql);  
        for (int i = 0; i < args.length; i++) {  
            ps.setObject(i + 1, args[i]);  
        }  
        return ps.executeQuery();  
    }  
  
    // ִ�в���  
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
  
    // ִ���޸�  
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
  
    // �����������ж����ݿ������  
    protected void finalize() throws Exception {  
        if (!con.isClosed() || con != null) {  
            con.close();  
        }  
    }  
}  
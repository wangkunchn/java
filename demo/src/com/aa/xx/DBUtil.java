package com.aa.xx;

import java.sql.*;

public class DBUtil {

    public static Connection connection;
    public static String driver="com.mysql.jdbc.Driver";
    public static String url="jdbc:mysql://localhost:3306/imooc";
    public static String user="root";
    public static String password="123456";
    static {
        try {
            //1.加载驱动程序
            Class.forName(driver);
            //2.获取数据库的连接
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
/*
    public static void main(String[] args) {
        //3.通过数据库的连接操作数据库，实现增删改查
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select user_name,age from imooc_goddess");
            while (rs.next()) {
                System.out.println(rs.getString("user_name")+","+ rs.getInt("age"));
            }
        } catch (SQLException e) {


        }
    }
*/

    public static Connection getConnection(){
        return connection;
    }

}

package com.weikun.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/9/23.
 */
public class DB {
    private static Connection conn;

    public static void main(String[] args) {
        System.out.print(getConnection());
    }
    public static void CloseConnection(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static Connection getConnection(){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://192.168.1.146:3306/test?useUnicode=true&characterEncoding=utf-8","root","root");


        }catch (Exception e){

            e.printStackTrace();
        }finally{

        }
        return conn;
    }
}

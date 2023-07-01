package com.tech.blog.helper;

import java.sql.*;

public class ConnectionProvider {
    
    private static Connection con;
    
    public  static Connection getConnection(){
        
        if(con==null){
            try {
            
            //driver class loading
            Class.forName("com.mysql.jdbc.Driver");
            
            //create connection
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog","root","");
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        
        return con;
    }
    
}

package com.tech.blog.dao;
import java.sql.*;

public class LikeDao {

    Connection con= null;

    public LikeDao(Connection con) {
        this.con=con;
    }
    

    public boolean insertLike(int pid, int uid){
        boolean f = false;
        
        String sql = " insert into likes(pId,userId) values("+pid+","+uid+") ; ";
        
        try {
            
            PreparedStatement pr = con.prepareStatement(sql);
            pr.executeUpdate();
            f=true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return f;
    }

    public int countLike(int pid, int uid){
       
        int count=0;
        
        String sql = " select count(*) from likes where pId="+pid+" and userId="+uid+" ;";
        
        try {
            
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
           
            if(rs.next()){
                count = rs.getInt(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return count;
    }

    public boolean isLikedByUser(int pid, int uid){
        boolean f = false;
        
        String sql = " select * from likes where pId="+pid+" and userId="+uid+" ; ";
        
        try {
            
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs=  pr.executeQuery();
            
            if(rs.next()){
            f= true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return f;
    }
    
    public boolean disLike(int pid, int uid){
        boolean f = false;
        
        String sql = " Delete from likes where  pId="+pid+" and userId="+uid+"   ";
        
        try {
            
            PreparedStatement pr = con.prepareStatement(sql);
            pr.executeUpdate();
            f=true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return f;
    }
        
}

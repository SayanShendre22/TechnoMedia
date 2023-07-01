package com.tech.blog.dao;

import com.tech.blog.entities.Posts;
import com.tech.blog.entities.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao {

    private Connection con;

    public UserDao(Connection con) {
        this.con = con;
    }

    public boolean saveUser(User user) {

        boolean f = false;

        try {

            String sql = "insert into user (name,email,gender,password,about) values(?,?,?,?,?) ; ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getAbout());

            ps.executeUpdate();

            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
    
    
    
    public User getUserByEmailAndPassword(String Email, String Password){
        
        User user=null;
        
        try {
            
            String sql = " Select * from user where email=? and password=?  ;" ; 
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, Email);
            ps.setString(2, Password);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                user= new User();
                
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setAbout(rs.getString("about"));
                user.setCurrentTime(rs.getTimestamp("rtime"));
                user.setProfile(rs.getString("profile"));
                user.setUserPosition(rs.getInt("position"));
                           
            }
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
    
        return user;
    }
    
    
    public boolean UpdateUser(User user){
        boolean status = false;
        
        
        try {

            String sql = "update user set name=? ,email=?,password=?,about=?, profile=? where id=?  ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getAbout());
            if(user.getProfile().length()==0){
                ps.setString(5, "defualt.png");
            }else{
                ps.setString(5, user.getProfile());
            }
            ps.setInt(6, user.getId());
           
           

            ps.executeUpdate();

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
    
    
     public User getUserByUserId(int userID){
         
         User user= null;
         
           try {
            
            String sql = " Select * from user where id="+userID+"  ;" ; 
            PreparedStatement ps= con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                user= new User();
                
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setAbout(rs.getString("about"));
                user.setCurrentTime(rs.getTimestamp("rtime"));
                user.setProfile(rs.getString("profile"));
                           
            }
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
         
         return user;
     }
     
     
//     update to teacher
     
      public boolean UpdateStudentToTeacher(User user) {

        boolean f = false;

        try {

            String sql = "update user set position=? where id='"+user.getId()+"' ; ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 2);

            ps.executeUpdate();

            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
      
      // Teacher by key
        public List<User> getTeacherByKeyWords(String key) {
        List<User> u = new ArrayList<>();
        User user= null;

        try {

            String sql = "select * from user WHERE name  LIKE '%"+key+"%' and position = '"+2+"' ;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

               user= new User();
                
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setAbout(rs.getString("about"));
                user.setCurrentTime(rs.getTimestamp("rtime"));
                user.setProfile(rs.getString("profile"));
                u.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }
       
        // get all teachers
      //fetch all posts
    public List<User> getAllTeachers() {
        List<User> u = new ArrayList<>();
        User user= null;

        try {

            String sql = "select * from user where position = '"+2+"' ;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                user= new User();
                
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setAbout(rs.getString("about"));
                user.setCurrentTime(rs.getTimestamp("rtime"));
                user.setProfile(rs.getString("profile"));
                u.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }
    
    //
    
    
}

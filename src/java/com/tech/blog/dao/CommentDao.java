
package com.tech.blog.dao;

import com.tech.blog.entities.Categories;
import com.tech.blog.entities.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CommentDao {
    
    
    private Connection con;

    public CommentDao(Connection con) {
        this.con = con;
    }

    
    public boolean addComment(Comment  c){
        
        boolean f = false;
        
        try {
            System.out.println("Try block");
            String sql = "insert into comment (commentMsg,uId,Pid)  values(?,?,?) ;";
            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, c.getComId());
            ps.setString(1, c.getComment());
            ps.setInt(2, c.getuId());
            ps.setInt(3, c.getPid());
             
            int i =ps.executeUpdate();
            System.out.println("value of i "+i);
            if(i>0){
                f=true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        
        return f;
    }
    
    
    public ArrayList<Comment> getAllCommentsByPostId(int pid){
        ArrayList<Comment> arc= new ArrayList<>();
        
        try {

            String sql = " select * from comment where  Pid="+pid+" ";
            Statement s = this.con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {

                int cid = rs.getInt("comId");
                String commentMsg = rs.getString("commentMsg");
                String commentTime = rs.getString("commentTime");
                int uId = rs.getInt("uId");

                Comment c = new Comment(commentMsg, uId, commentTime);
                arc.add(c);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        
        return arc;
    }
    
    
}

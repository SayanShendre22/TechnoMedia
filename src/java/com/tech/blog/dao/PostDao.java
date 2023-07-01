package com.tech.blog.dao;

import com.tech.blog.entities.Categories;
import com.tech.blog.entities.Posts;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class PostDao {

    private Connection con;

    public PostDao(Connection con) {
        this.con = con;
    }

    public ArrayList<Categories> getAllCategories() {

        ArrayList<Categories> list = new ArrayList();

        try {

            String sql = " select * from categories ";
            Statement s = this.con.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("cId");
                String name = rs.getString("name");
                String desc = rs.getString("description");

                Categories c = new Categories(id, name, desc);
                list.add(c);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean savePost(Posts p) {
        boolean f = false;

        try {

            String sql = "insert into posts (pTItle,pContent,pCode,pPic,catId,userId)  values(?,?,?,?,?,?)  ;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getpTItle());
            ps.setString(2, p.getpContent());
            ps.setString(3, p.getpCode());
            ps.setString(4, p.getpPic());
            ps.setInt(5, p.getCatId());
            ps.setInt(6, p.getUserId());

            ps.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    //fetch all posts
    public List<Posts> getAllPosts() {
        List<Posts> p = new ArrayList<>();

        try {

            String sql = "select * from posts order by pId desc ;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int pId = rs.getInt("pId");
                String pTitle = rs.getString("pTitle");
                String pContent = rs.getString("pContent");
                String pCode = rs.getString("pCode");
                String pPic = rs.getString("pPic");
                Timestamp ts = rs.getTimestamp("pDate");
                int cid = rs.getInt("catId");
                int userId = rs.getInt("userId");

                Posts post = new Posts(pId, pTitle, pContent, pCode, pPic, ts, cid, userId);
                p.add(post);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }

    //fetch all posts by cid
    public List<Posts> getAllPosts(int cid) {
        List<Posts> p = new ArrayList<>();

        try {

            String sql = "select * from posts where catId="+cid+" order by pId desc;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int pId = rs.getInt("pId");
                String pTitle = rs.getString("pTitle");
                String pContent = rs.getString("pContent");
                String pCode = rs.getString("pCode");
                String pPic = rs.getString("pPic");
                Timestamp ts = rs.getTimestamp("pDate");
                
                int userId = rs.getInt("userId");

                Posts post = new Posts(pId, pTitle, pContent, pCode, pPic, ts, cid, userId);
                p.add(post);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }
    
    public List<Posts> getAllPostsByKeyWords(String key) {
        List<Posts> p = new ArrayList<>();

        try {

            String sql = "select * from posts WHERE pTitle  LIKE '%"+key+"%' ;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int pId = rs.getInt("pId");
                String pTitle = rs.getString("pTitle");
                String pContent = rs.getString("pContent");
                String pCode = rs.getString("pCode");
                String pPic = rs.getString("pPic");
                int cid =  Integer.parseInt(rs.getString("catId"));
                Timestamp ts = rs.getTimestamp("pDate");
                
                int userId = rs.getInt("userId");

                Posts post = new Posts(pId, pTitle, pContent, pCode, pPic, ts,cid , userId);
                p.add(post);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }
    
   
    public Posts getPostByPostId(int pid){
        
        Posts post = null;
        
         try {

            String sql = "select * from posts where pId="+pid+"  ;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int cid = rs.getInt("catId");
                String pTitle = rs.getString("pTitle");
                String pContent = rs.getString("pContent");
                String pCode = rs.getString("pCode");
                String pPic = rs.getString("pPic");
                Timestamp ts = rs.getTimestamp("pDate");
                
                int userId = rs.getInt("userId");

                post = new Posts(pid, pTitle, pContent, pCode, pPic, ts, cid, userId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return post;
        
    }
    
    public List<Posts> getPostByUserId(int uid){
        
        Posts post = null;
        List<Posts> p = new ArrayList<>();
         try {

            String sql = "select * from posts where userId="+uid+"  ;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int cid = rs.getInt("catId");
                int pid = rs.getInt("pId");
                String pTitle = rs.getString("pTitle");
                String pContent = rs.getString("pContent");
                String pCode = rs.getString("pCode");
                String pPic = rs.getString("pPic");
                Timestamp ts = rs.getTimestamp("pDate");
                
                int userId = rs.getInt("userId");

                post = new Posts(pid, pTitle, pContent, pCode, pPic, ts, cid, userId);
                p.add(post);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return p;
        
    }
    
}

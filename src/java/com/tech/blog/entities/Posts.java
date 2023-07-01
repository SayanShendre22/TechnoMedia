
package com.tech.blog.entities;

import java.sql.*;


public class Posts {

    private int pId;
    private String pTItle;
    private String pContent;
    private String pCode;
    private String pPic;
    private Timestamp pDate;
    private int catId;
    private int userId;

    public Posts() {
    }

    public Posts(int pId, String pTItle, String pContent, String pCode, String pPic, Timestamp pDate, int catId, int userId) {
        this.pId = pId;
        this.pTItle = pTItle;
        this.pContent = pContent;
        this.pCode = pCode;
        this.pPic = pPic;
        this.pDate = pDate;
        this.catId = catId;
        this.userId = userId;
    }

    public Posts(String pTItle, String pContent, String pCode, String pPic, Timestamp pDate, int catId,int userId) {
        this.pTItle = pTItle;
        this.pContent = pContent;
        this.pCode = pCode;
        this.pPic = pPic;
        this.pDate = pDate;
        this.catId = catId;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpTItle() {
        return pTItle;
    }

    public void setpTItle(String pTItle) {
        this.pTItle = pTItle;
    }

    public String getpContent() {
        return pContent;
    }

    public void setpContent(String pContent) {
        this.pContent = pContent;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpPic() {
        return pPic;
    }

    public void setpPic(String pPic) {
        this.pPic = pPic;
    }

    public Timestamp getpDate() {
        return pDate;
    }

    public void setpDate(Timestamp pDate) {
        this.pDate = pDate;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    
    
    
    
}


package com.tech.blog.entities;


public class Comment {
    
    int comId;
    String comment;
    int uId;
    int Pid;
    String PDate;

    public Comment(String comment, int uId, String PDate) {
        this.comment = comment;
        this.uId = uId;
        this.PDate = PDate;
    }

    public String getPDate() {
        return PDate;
    }

    public void setPDate(String PDate) {
        this.PDate = PDate;
    }

    public Comment(String comment, int uId, int Pid) {
        this.comment = comment;
        this.uId = uId;
        this.Pid = Pid;
    }
    
    

    public Comment(int comId, String comment, int uId, int Pid) {
        this.comId = comId;
        this.comment = comment;
        this.uId = uId;
        this.Pid = Pid;
    }

    public Comment() {
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getPid() {
        return Pid;
    }

    public void setPid(int Pid) {
        this.Pid = Pid;
    }

    
    
    
}

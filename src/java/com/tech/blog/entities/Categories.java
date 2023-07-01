
package com.tech.blog.entities;


public class Categories {
    
    private int cId;
    private String name;
    private String discription;

    public Categories() {
    }

    public Categories(int cId, String name, String discription) {
        this.cId = cId;
        this.name = name;
        this.discription = discription;
    }

    public Categories(String name, String discription) {
        this.name = name;
        this.discription = discription;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
    
}

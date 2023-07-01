
package com.tech.blog.entities;


public class Message {
    
    private String Context;
    private String type;
    private String cssClass;

    public Message(String Context, String type, String cssClass) {
        this.Context = Context;
        this.type = type;
        this.cssClass = cssClass;
    }
    
    
    //getter and setter

    public String getContext() {
        return Context;
    }

    public void setContext(String Context) {
        this.Context = Context;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }
    
    
    
}

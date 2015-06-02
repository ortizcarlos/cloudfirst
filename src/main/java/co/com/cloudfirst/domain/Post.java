/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.cloudfirst.domain;

import java.util.Date;

/**
 *
 * @author Carlos
 */
public class Post {
    private String id;
    private String title;
    private String body;
    private Date  created;
    
    public Post(String title, String body) {
        this.title = title;
        this.body = body;
        this.created = new Date();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    
    public void setBody(String body) {
        this.body = body;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    

    public String getBody() {
        return body;
    }

    public Date getCreated() {
        return created;
    }

    public String getTitle() {
        return title;
    }
    
    
    
}

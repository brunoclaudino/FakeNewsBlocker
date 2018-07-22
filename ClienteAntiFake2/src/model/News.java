/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


/**
 * 
 * @author 
 */
public class News {
    private int id;
    private String title;
    
    public News(int newsId, String newsTitle){
        this.id = newsId;
        this.title = newsTitle;
    }
    
    public News(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

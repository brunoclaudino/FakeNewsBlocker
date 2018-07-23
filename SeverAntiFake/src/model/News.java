/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * 
 * @author Bruno Claudino Matias
 */
public class News implements Serializable{
    private int id;
    private String title;
    private float realAvg;
    public LinkedList<Float> avaliations = new LinkedList();
    
    public News(int newsId, String newsTitle){
        this.id = newsId;
        this.title = newsTitle;
    }
    
    public News(){
        
    }
    
    public void addAvaliation(Float points){ //Adiciona na lista uma avaliação
        this.avaliations.add(points);
    }
    
    public float getAvg(){ //Retorna a média do valor de todas as avaliações de uma notícia
        float avg = 0;
        for(int i = 0; i<this.avaliations.size();i++){
            avg += this.avaliations.get(i);
        }
        avg = avg/this.avaliations.size();
        this.realAvg = avg;
        return avg;
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

    public float getRealAvg() {
        return realAvg;
    }

    public void setRealAvg(float realAvg) {
        this.realAvg = realAvg;
    }
    
}

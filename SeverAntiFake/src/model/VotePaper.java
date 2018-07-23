/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 * 
 */
public class VotePaper {
    private int id;
    private boolean innocent;
    
    public VotePaper(int id, boolean vote){
        this.id = id;
        this.innocent = vote;
    }
    
    public VotePaper(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInnocent() {
        return innocent;
    }

    public void setInnocent(boolean innocent) {
        this.innocent = innocent;
    }
}

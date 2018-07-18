/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Bruno Claudino Matias
 */
public class Consensus implements Runnable{
    private int id;
    
    public Consensus(int idn){
        this.id = idn;
    }
    @Override
    public void run() {
        LinkedList<Boolean> fake = new LinkedList();
        LinkedList<Boolean> isTrue = new LinkedList();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Consensus.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i<controller.Talker.conf.size();i++){
            if(controller.Talker.conf.get(i).getId() == this.id){
                if(controller.Talker.conf.get(i).isInnocent()){
                    isTrue.add(true);
                }else{
                    fake.add(false);
                }
            }
        }
        if(isTrue.size()<fake.size() || isTrue.size() == fake.size()){
            //implementar smtp
        }
        for(int i = 0; i<controller.Talker.conf.size();i++){
            if(controller.Talker.conf.get(i).getId() == this.id){
                controller.Talker.conf.remove(i);
            }
        }
    }

}

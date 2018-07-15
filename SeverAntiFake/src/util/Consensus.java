/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.LinkedList;

/**
 * 
 * @author Bruno Claudino Matias
 */
public class Consensus implements Runnable{

    @Override
    public void run() {
        LinkedList<Boolean> fake = new LinkedList();
        LinkedList<Boolean> isTrue = new LinkedList();
        for(int i = 0; i<controller.Talker.conf.size();i++){
            if(controller.Talker.conf.get(i)){
                isTrue.add(true);
            }else{
                fake.add(false);
            }
        }
    }

}

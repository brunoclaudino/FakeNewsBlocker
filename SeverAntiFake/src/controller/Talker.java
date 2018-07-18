/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.rmi.RemoteException;
import java.util.LinkedList;
import model.News;
import model.RemoteMethods;
import model.Server;
import model.VotePaper;

/**
 * 
 * @author
 */
public class Talker implements RemoteMethods{
    public static boolean debug = true;
    public static LinkedList<Server> servers = new LinkedList();
    public static LinkedList<VotePaper> conf = new LinkedList();
    public static LinkedList<News> news = new LinkedList();
    
    public static void main(String[] args) {
        
    }

    @Override
    public float addAvaliation(float avaliation, int id) throws RemoteException {
        News temp = new News();
        for(int i = 0; i<news.size();i++){
            News oneSec = news.get(i);
            if(oneSec.getId() == id){
                temp = oneSec;
                break;
            }
        }
        temp.addAvaliation(avaliation);
        //implementar quando a média for menor que o desejado
        return temp.getAvg();
    }

    @Override
    public float giveAvg(int id) throws RemoteException {
        float avg = 0;
        for(int i = 0; i<news.size();i++){
            News oneSec = news.get(i);
            if(oneSec.getId() == id){
                avg = oneSec.getAvg();
                break;
            }
        }
        return avg;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.News;
import model.RemoteMethods;
import model.Server;
import model.VotePaper;
import util.Txt;

/**
 * 
 * @author
 */
public class Talker implements RemoteMethods{
    public static boolean debug = true;
    public static LinkedList<Server> servers = new LinkedList();
    public static LinkedList<VotePaper> conf = new LinkedList();
    public static LinkedList<News> news = new LinkedList();
    
    public Talker(){
        loadInfos();
    }
    
    public void runServer() {
        try {
            String name = "server";
            System.setProperty("java.rmi.server.hostname", "192.168.1.6");  
            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            RemoteMethods remote = new Talker();
            RemoteMethods stub = (RemoteMethods) UnicastRemoteObject.exportObject(remote, 0);
            registry.rebind(name, stub);
            System.out.println("Servidor rodando no IP " + InetAddress.getLocalHost().getHostAddress() + " e na porta " + Registry.REGISTRY_PORT);
        } catch (RemoteException e) {
            System.out.println ("Erro no servidor: " + e.getMessage()); 
        } catch (UnknownHostException ex) {
            Logger.getLogger(Talker.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        if(temp.getAvg() < 2.5){
                   
        }
        return temp.getAvg();
    }

    @Override
    public boolean giveAvg(int id) throws RemoteException {
        float avg = 0;
        for(int i = 0; i<news.size();i++){
            News oneSec = news.get(i);
            if(oneSec.getId() == id){
                avg = oneSec.getAvg();
                break;
            }
        }
        return avg >= 2.5;
    }
    
    public void loadInfos(){
        Txt reader = new Txt();
        reader.ReadNews();
        reader.ReadServers();
    }
}

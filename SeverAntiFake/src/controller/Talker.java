/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

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

/**
 * 
 * @author
 */
public class Talker implements RemoteMethods{
    public static boolean debug = true;
    public static LinkedList<Server> servers = new LinkedList();
    public static LinkedList<VotePaper> conf = new LinkedList();
    public static LinkedList<News> news = new LinkedList();
    private final Controller controller;
    
    public Talker (Controller c){
        this.controller = c;
    }
    
    public void runServer() {
        try {
            String name = "server";
            System.setProperty("java.rmi.server.hostname", "192.168.1.6");  
            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            RemoteMethods remote = new Talker(controller);
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
<<<<<<< HEAD
        //implementar quando a média for menor que o desejado
=======
>>>>>>> f4c4baeb874ba9537f1da76adda819628c26c1f9
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

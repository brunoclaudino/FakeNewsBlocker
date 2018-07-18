/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import controller.Talker;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.RemoteMethods;
import model.VotePaper;

/**
 * 
 * @author Bruno Claudino Matias
 */
public class Consensus implements Runnable{
    private int serverAddress;
    private int id;
    
    public Consensus(int location, int id){
        this.serverAddress = location;
        this.id = id;
    }
    @Override
    public void run() {
        try{
            RemoteMethods server = new Talker();
            if(controller.Talker.debug){
                System.out.println("Instânciou interface de métodos | Classe consensus - Método Run");
            }
            Registry registry = LocateRegistry.getRegistry();
            RemoteMethods service = (RemoteMethods) Naming.lookup(view.Main.serverNames.get(serverAddress));
            if(controller.Talker.debug){
                System.out.println("lookup está funcionando");
            }
            VotePaper paper = new VotePaper();
            paper.setInnocent(service.giveAvg(id));
            paper.setId(id);
            controller.Talker.conf.add(paper);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}

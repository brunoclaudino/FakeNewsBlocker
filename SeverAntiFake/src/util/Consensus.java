/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import controller.FileManager;
import controller.Talker;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import model.RemoteMethods;
import model.VotePaper;

/**
 * 
 * @author 
 */
public class Consensus implements Runnable{
    private final int serverAddress;
    private final int id;
    private final FileManager f = FileManager.getInstance();
    
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
            RemoteMethods service = (RemoteMethods) Naming.lookup("//"+controller.FileManager.servers.get(serverAddress).getAddress()+"/"+controller.FileManager.servers.get(serverAddress).getName());
            if(controller.Talker.debug){
                System.out.println("lookup está funcionando");
            }
            VotePaper paper = new VotePaper();
            paper.setInnocent(service.giveAvg(id));
            paper.setId(id);
            f.getVotes().add(paper);
        }catch(MalformedURLException | NotBoundException | RemoteException e){
            System.out.println(e.toString());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.RemoteMethods;


/**
 *
 * @author 
 */
public class RMIClient{
    
    Controller controller;
    RemoteMethods remote;
    
    /**Método construtor da classe, recebe um controller como parâmetro
     *
     * @param c a instância de um controller
     */
    public RMIClient(Controller c){
        this.controller = c;
    }
    
    /**Método que busca o servidor para realizar uma avaliação
     *
     * @return
     */
    public String conect() {
        try {
            String name = controller.getServerName();
            System.out.println(controller.getServerName());
            System.out.println(controller.getServerAdress());
            Registry registry = LocateRegistry.getRegistry(controller.getServerAdress(), Registry.REGISTRY_PORT);
            remote = (RemoteMethods) registry.lookup(name);
            return "success";
        } catch (NotBoundException | RemoteException e) {
            System.err.println("Exception: " + e.getMessage());
            return "error";
        }
    }   
    
    /**Método para adicionar uma avaliação referente a matéria representada pelo
     * id passado
     *
     * @param avaliation
     * @param id
     * @return
     */
    public String sendAvaliation(float avaliation, int id){
        try {
            return Float.toString(remote.addAvaliation(avaliation, id));
        } catch (RemoteException ex) {
            Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "erro";
    }
}
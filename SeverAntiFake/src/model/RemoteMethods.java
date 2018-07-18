/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Bruno Claudino Matias
 */
public interface RemoteMethods extends Remote{
    public float addAvaliation(float avaliation, int id)throws RemoteException;
    
    public boolean giveAvg(int id)throws RemoteException;
}

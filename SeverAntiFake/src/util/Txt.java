/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Server;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Txt {
    private BufferedReader read;
    private BufferedWriter write;
    
    public void ReadServers(){
        try {
            read = new BufferedReader(new FileReader(new File("servers.txt")));
            if(controller.Talker.debug){
                System.out.println("Começou a ler arquivo de texto");
            }
            String line = read.readLine();
            while(line != null){
                Server server = new Server();
                String[] infos = line.split("=");
                server.setName(infos[0]);
                server.setAddress(infos[1]);
                controller.Talker.servers.add(server);
                line = read.readLine();
                        
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Txt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Txt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

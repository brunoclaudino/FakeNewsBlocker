/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import controller.FileManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.News;
import model.Server;

/**
 * 
 * @author
 */
public class Txt {
    private BufferedReader read;
    private BufferedWriter write;
    private FileManager f = FileManager.getInstance();
    
    public void ReadServers(){
        try {
            read = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/controller/servers.txt")));
            if(controller.Talker.debug){
                System.out.println("Começou a ler arquivo de texto");
            }
            String line = read.readLine();
            while(line != null){
                Server server = new Server();
                String[] infos = line.split("=");
                server.setName(infos[0]);
                server.setAddress(infos[1]);
                f.getServers().add(server);
                line = read.readLine();
                        
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Txt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Txt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ReadNews(){
        try {
            read = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/controller/news.txt")));
            if(controller.Talker.debug){
                System.out.println("Começou a ler as notícias");
            }
            String line = read.readLine();
            while(line != null){
                News temp = new News();
                String[] info = line.split(";");
                temp.setId(Integer.parseInt(info[0]));
                temp.setTitle(info[1]);
                temp.setRealAvg(Float.parseFloat(info[2]));
                f.getNews().add(temp);
                line = read.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Txt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Txt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.HashMap;
import model.News;

/**
 *
 * @author lablenda2
 */
public class Controller {
    private final Talker server;
    public HashMap<Integer, News> news = new HashMap();
    
    public Controller(){
        readNews();
        server = new Talker(this);
        server.runServer();
    }
    
    public void readNews(){
        File f = new File("hashmap.ser");
        if(!f.exists()){
            BufferedReader StrR;
            try {
                News auxiliar;
                StrR = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/controller/news.txt")));
                String Str;
                String tableline[];
                while ((Str = StrR.readLine()) != null) {
                    tableline = Str.split(";");
                    auxiliar = new News (Integer.parseInt(tableline[0]), tableline[1]);
                    news.put(Integer.parseInt(tableline[0]),auxiliar);
                }
                StrR.close();
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        else{
            HashMap<Integer, News> map;
            FileInputStream fis;
            ObjectInputStream ois;
            try{
                fis = new FileInputStream("hashmap.ser");
                ois = new ObjectInputStream(fis);
                map = (HashMap) ois.readObject();
                ois.close();
                fis.close();
            }catch(IOException ioe){
                System.out.println("Error: " + ioe.getMessage());
                return;
            }catch(ClassNotFoundException c){
                System.out.println("Class not found");
                return;
            }
            news = map;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.LinkedList;
import model.News;
import model.Server;
import model.VotePaper;
import util.Txt;

/**
 *
 * @author
 */
public class FileManager {
    public static LinkedList<Server> servers = new LinkedList();
    public static LinkedList<VotePaper> conf = new LinkedList();
    public static LinkedList<News> news = new LinkedList();
    public static FileManager manager;
    
    public static FileManager getInstance(){
        if(manager==null){
            manager = new FileManager();
            manager.loadInfos();
        }
        return manager;
    }
    
    public void loadInfos() {
        Txt reader = new Txt();
        reader.ReadNews();
        reader.ReadServers();
    }
    
    public LinkedList getServers(){
       return servers;
    }
    
    public LinkedList getNews(){
        return news;
    }
    
    public LinkedList getVotes(){
        return conf;
    }
    
    public void setVotes(LinkedList l){
        conf = l;
    }
}

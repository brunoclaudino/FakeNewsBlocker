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
import java.util.HashMap;
import java.util.LinkedList;
import model.News;
import model.Server;

/**
 *
 * @author
 */
public class Controller {

    private final HashMap<Integer, News> news;
    private final LinkedList<Server> servers;
    private int choosenSite;
    private final RMIClient intermediator;
    private boolean [] conected = {false, false, false};
    String answer;

    public Controller() {
        intermediator = new RMIClient(this);
        news = new HashMap<>();
        servers = new LinkedList();
        readInfo("servers");
        readInfo("news");
    }
    
    public void connect(){
        setConnection(0);
        setConnection(1);
        setConnection(2);
    }
    
    private String setConnection(int site){
        this.setChoosenSite(site);
        String conexao = intermediator.conect();
        if(conexao.equals("success"))
            conected[choosenSite] = true;
        
        return conexao;
    }

    private void readInfo(String file) {
        BufferedReader StrR;
        try {
            News aux;
            Server aux2;
            StrR = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/controller/" + file + ".txt")));
            String Str;
            String tableline[];
            while ((Str = StrR.readLine()) != null) {
                if (file.equals("news")) {
                    tableline = Str.split(";");
                    aux = new News(Integer.parseInt(tableline[0]), tableline[1]);
                    news.put(Integer.parseInt(tableline[0]), aux);
                } else {
                    tableline = Str.split("=");
                    aux2 = new Server(tableline[0], tableline[1]);
                    servers.add(aux2);
                }
            }
            StrR.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public String sendAvaliation(float avaliation, int newsId){
        if(conected[choosenSite] == true){
            System.out.println("Vou avaliar");
            intermediator.sendAvaliation(avaliation, newsId);
            return "send with success";
        }
        else{
            answer = setConnection(choosenSite);
            if(answer.equals("success")){
                conected[choosenSite] = true;
                return this.sendAvaliation(avaliation, newsId);
            }
            else
                return "serveroff";
            
        }
    }
    
    public void setChoosenSite(int choice){
        this.choosenSite = choice;
    }
    
    public int getChoosenSite(){
        return choosenSite;
    }
    
    public String getServerName(){
        return servers.get(choosenSite).getName();
    }
    
    public String getServerAdress(){
        return servers.get(choosenSite).getAddress();
    }
}

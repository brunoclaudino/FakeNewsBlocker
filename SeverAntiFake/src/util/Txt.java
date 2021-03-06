/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controller.FileManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
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

    public void ReadServers() {
        try {
            read = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/controller/servers.txt")));
            if (controller.Talker.debug) {
                System.out.println("Começou a ler arquivo de texto");
            }
            String line = read.readLine();
            while (line != null) {
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

    public void ReadNews() {
        try {
            read = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/controller/news.txt")));
            if (controller.Talker.debug) {
                System.out.println("Começou a ler as notícias");
            }
            String line = read.readLine();
            while (line != null) {
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

    /**
     * Método para serializar e salvar os dados referentes ao estoque dessa loja
     *
     */
    public void serializeList() {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(new File("listaNews.ser"));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(f.getNews());
            oos.close();
            fos.close();
            System.out.println("Salvou a lista");
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }
    }

    public LinkedList readList() {
        LinkedList<News> map;
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream("hashmap.ser");
            ois = new ObjectInputStream(fis);
            map = (LinkedList) ois.readObject();
            ois.close();
            fis.close();
            return map;
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
        }
        return null;
    }
}

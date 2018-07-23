/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.News;
import model.RemoteMethods;
import model.Server;
import model.VotePaper;
import util.Consensus;
import util.MailSender;
import util.Txt;

/**
 *
 * @author Uma dupla de 1.
 */
public class Talker implements RemoteMethods {

    public static boolean debug = true;
    public FileManager f = FileManager.getInstance();

    public void runServer() {
        try {
            Server s = (Server) f.getServers().getFirst();
            String name = s.getName();
            System.setProperty("java.rmi.server.hostname", s.getAddress());
            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            RemoteMethods remote = new Talker();
            RemoteMethods stub = (RemoteMethods) UnicastRemoteObject.exportObject(remote, 0);
            registry.rebind(name, stub);
            System.out.println("Servidor rodando no IP " + InetAddress.getLocalHost().getHostAddress() + " e na porta " + Registry.REGISTRY_PORT);
        } catch (RemoteException e) {
            System.out.println("Erro no servidor: " + e.getMessage());
        } catch (UnknownHostException ex) {
            Logger.getLogger(Talker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public float addAvaliation(float avaliation, int id) throws RemoteException {
        System.out.println("Avaliação: " + avaliation + "\nId: " + id);
        News temp = new News();
        for (int i = 0; i < f.getNews().size(); i++) {
            News oneSec = (News) f.getNews().get(i);
            if (oneSec.getId() == id) {
                temp = oneSec;
                break;
            }
        }
        temp.addAvaliation(avaliation);
        if (temp.getAvg() < 2.5) {
            LinkedList<Boolean> fake = new LinkedList();
            LinkedList<Boolean> isTrue = new LinkedList();
            VotePaper myVote = new VotePaper(0, false);
            f.getVotes().add(myVote);
            new Thread(new Consensus(1, id)).start();
            new Thread(new Consensus(2, id)).start();
            try {
                Thread.sleep(1000);
                for (int i = 0; i < f.getVotes().size(); i++) {
                    VotePaper vote = (VotePaper) f.getVotes().get(i);
                    int voteId = vote.getId();
                    if (voteId == id) {
                        if (vote.isInnocent()) {
                            isTrue.add(true);
                        } else {
                            fake.add(false);
                        }
                    }
                    if (isTrue.size() < fake.size() || isTrue.size() == fake.size()) {
                        MailSender mail = new MailSender();
                        mail.setNewsTitle(temp.getTitle());
                        new Thread(mail).start();
                    }
                    f.setVotes(new LinkedList());
                }
            } catch (InterruptedException e) {
                System.out.println(e.toString() + "---No metodo addAvaliation");
            }

        }
        Txt t = new Txt();
        t.serializeList();
        System.err.println("Victória está parecendo gente!!!!!");
        return temp.getAvg();
    }

    @Override
    public boolean giveAvg(int id) throws RemoteException {
        float avg = 0;
        for (int i = 0; i < f.getNews().size(); i++) {
            News oneSec = (News) f.getNews().get(i);
            if (oneSec.getId() == id) {
                avg = oneSec.getAvg();
                break;
            }
        }
        return avg >= 2.5;
    }
}

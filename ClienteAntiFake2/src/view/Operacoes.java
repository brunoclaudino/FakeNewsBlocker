/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class Operacoes implements ActionListener {

    private Sites news;
    private Controller controller;
    private String[] sites = {"BBC", "CBS", "CNN"};
    private int openNews = -1;

    public Operacoes() {
        news = new Sites(this);
        disableAll();
        news.setVisible(true);
        news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/App_page.png")));
        news.getBottonLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bar+nav.png")));
        controller = new Controller();
        Thread controlarHora = new Thread() {
            @Override
            public void run() {
                while (true) {
                    String horario;
                    Calendar calendar = new GregorianCalendar();
                    Date trialTime = new Date();
                    calendar.setTime(trialTime);
                    if(calendar.get(Calendar.MINUTE)<10 && calendar.get(Calendar.HOUR_OF_DAY)<10){
                        horario = "0" + calendar.get(Calendar.HOUR_OF_DAY) + ":0" + calendar.get(Calendar.MINUTE);
                    }
                    else if(calendar.get(Calendar.MINUTE)<10){
                        horario = calendar.get(Calendar.HOUR_OF_DAY) + ":0" + calendar.get(Calendar.MINUTE);
                    }
                    else if(calendar.get(Calendar.HOUR_OF_DAY)<10){
                        horario = "0" + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
                    }
                    else{
                        horario = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
                    }
                    news.getHour().setText(horario);
                }
            }
        };
        controlarHora.run();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(news.getBBC())) {
            news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/BBC/BBC_page.png")));
            news.getBottonLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/BBC/bbcBar+nav.png")));
            news.setVisible(true);
            news.repaint();
            controller.setChoosenSite(0);
            openNews = -1;
            enableButtons();
        } else if (e.getSource().equals(news.getCBS())) {
            news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/CBS/CBS_page.png")));
            news.getBottonLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/CBS/cbsBar+nav.png")));
            news.setVisible(true);
            news.repaint();
            controller.setChoosenSite(1);
            openNews = -1;
            enableButtons();
        } else if (e.getSource().equals(news.getCNN())) {
            news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNN/CNN_page.png")));
            news.getBottonLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNN/cnnBar+nav.png")));
            news.setVisible(true);
            news.repaint();
            controller.setChoosenSite(2);
            openNews = -1;
            enableButtons();
        } else if (e.getSource().equals(news.getHome())) {
            disableAll();
            news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/App_page.png")));
            news.getBottonLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bar+nav.png")));
            news.repaint();
            openNews = -1;
        } else if (e.getSource().equals(news.getNews1())) {
            getNews(1);
        } else if (e.getSource().equals(news.getNews2())) {
            getNews(2);
        } else if (e.getSource().equals(news.getNews3())) {
            getNews(3);
        } else if (e.getSource().equals(news.getNews4())) {
            getNews(4);
        } else if (e.getSource().equals(news.getNews5())) {
            getNews(5);
        } else if (e.getSource().equals(news.getNews6())) {
            getNews(6);
        } else if (e.getSource().equals(news.getPage1())) {
            getPages(1);
        } else if (e.getSource().equals(news.getPage2())) {
            getPages(2);
        } else if (e.getSource().equals(news.getPage3())) {
            getPages(3);
        } else if (e.getSource().equals(news.getPage4())) {
            getPages(4);
        } else if (e.getSource().equals(news.getPage5())) {
            getPages(5);
        } else if (e.getSource().equals(news.getBack())) {
            if (openNews == -1) {
                disableAll();
                news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/App_page.png")));
                news.getBottonLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bar+nav.png")));
                news.repaint();
            } else {
                String choice = sites[controller.getChoosenSite()];
                news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + choice + "/" + choice + "_page.png")));
                enableButtons();
            }
        }
    }

    public void disableButtons() {
        news.getNews1().setEnabled(false);
        news.getNews2().setEnabled(false);
        news.getNews3().setEnabled(false);
        news.getNews4().setEnabled(false);
        news.getNews5().setEnabled(false);
        news.getNews6().setEnabled(false);
        news.getPage1().setEnabled(true);
        news.getPage2().setEnabled(true);
        news.getPage3().setEnabled(true);
        news.getPage4().setEnabled(true);
        news.getPage5().setEnabled(true);
    }

    public void enableButtons() {
        news.getNews1().setEnabled(true);
        news.getNews2().setEnabled(true);
        news.getNews3().setEnabled(true);
        news.getNews4().setEnabled(true);
        news.getNews5().setEnabled(true);
        news.getNews6().setEnabled(true);
        news.getPage1().setEnabled(false);
        news.getPage2().setEnabled(false);
        news.getPage3().setEnabled(false);
        news.getPage4().setEnabled(false);
        news.getPage5().setEnabled(false);
    }

    public void disableAll() {
        news.getNews1().setEnabled(false);
        news.getNews2().setEnabled(false);
        news.getNews3().setEnabled(false);
        news.getNews4().setEnabled(false);
        news.getNews5().setEnabled(false);
        news.getNews6().setEnabled(false);
        news.getPage1().setEnabled(false);
        news.getPage2().setEnabled(false);
        news.getPage3().setEnabled(false);
        news.getPage4().setEnabled(false);
        news.getPage5().setEnabled(false);
    }

    public void getNews(int newsNumber) {
        disableButtons();
        String choice = sites[controller.getChoosenSite()];
        news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + choice + "/" + choice + "_news" + newsNumber + ".1.png")));
        news.repaint();
        openNews = newsNumber;
    }

    public void getPages(int pageNumber) {
        String choice = sites[controller.getChoosenSite()];
        news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + choice + "/" + choice + "_news" + openNews + "." + pageNumber + ".png")));
    }

}

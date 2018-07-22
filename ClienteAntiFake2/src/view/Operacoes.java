/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author
 */
public class Operacoes implements ActionListener {

    private Home app;
    private Sites news;
    private Controller controller;
    private String[] sites = {"BBC", "CBS", "CNN"};
    private int openNews = -1;

    public Operacoes() {
        news = new Sites(this);
        app = new Home(this);
        controller = new Controller();
        app.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(app.getBBC()) || e.getSource().equals(news.getBBC())) {
            app.setVisible(false);
            news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/BBC/BBC_page.png")));
            news.getBottonLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/BBC/bbcBar+nav.png")));
            news.setVisible(true);
            repaintWindows();
            controller.setChoosenSite(0);
            openNews = -1;
        } else if (e.getSource().equals(app.getCBS()) || e.getSource().equals(news.getCBS())) {
            app.setVisible(false);
            news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/CBS/CBS_page.png")));
            news.getBottonLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/CBS/cbsBar+nav.png")));
            news.setVisible(true);
            repaintWindows();
            controller.setChoosenSite(1);
            openNews = -1;
        } else if (e.getSource().equals(app.getCNN()) || e.getSource().equals(news.getCNN())) {
            app.setVisible(false);
            news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNN/CNN_page.png")));
            news.getBottonLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNN/cnnBar+nav.png")));
            news.setVisible(true);
            repaintWindows();
            controller.setChoosenSite(2);
            openNews = -1;
        } else if (e.getSource().equals(news.getHome())) {
            news.setVisible(false);
            app.setVisible(true);
            repaintWindows();
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
        } else if (e.getSource().equals(news.getNews5())) {
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
        }

//       
//        else if(e.getSource().equals(google.getMinimizeButton())){
//            google.setExtendedState(JFrame.ICONIFIED);
//        }
//        else if(e.getSource().equals(google.getGoogleSearch())){
//            String texto = google.getSearch().getText();
//            if(texto.equals("noticias") || texto.equals("site de noticias")){
//                search = new Search();
//                search.getSearchBox().setText(texto);
//                google.setVisible(false);
//                search.setVisible(true);
//            }
//        }
//        else if(e.getSource().equals(google.getImLucky())){
//            JOptionPane.showMessageDialog(google, "Não, você não tá com sorte. Agora usa o outro botão :)");
//        }
    }

    public void repaintWindows() {
        news.repaint();
        app.repaint();
    }

    public void disableButtons() {
        news.getNews1().setEnabled(false);
        news.getNews2().setEnabled(false);
        news.getNews3().setEnabled(false);
        news.getNews4().setEnabled(false);
        news.getNews5().setEnabled(false);
        news.getNews6().setEnabled(false);
    }

    public void enableButtons() {
        news.getNews1().setEnabled(true);
        news.getNews2().setEnabled(true);
        news.getNews3().setEnabled(true);
        news.getNews4().setEnabled(true);
        news.getNews5().setEnabled(true);
        news.getNews6().setEnabled(true);
    }

    public void getNews(int newsNumber) {
        disableButtons();
        String choice = sites[controller.getChoosenSite()];
        news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + choice + "/" + choice + "_news" + newsNumber + ".1.png")));
        repaintWindows();
        openNews = newsNumber;
    }

    public void getPages(int pageNumber) {
        String choice = sites[controller.getChoosenSite()];
        news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + choice + "/" + choice + "_news" + openNews + "." + pageNumber + ".png")));
    }

}

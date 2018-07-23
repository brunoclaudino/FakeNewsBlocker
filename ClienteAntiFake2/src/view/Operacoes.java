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
    private final Controller controller;
    private final String[] sites = {"BBC", "CBS", "CNN"};
    private int openNews = -1;
    private final Evaluate evaluateForm = new Evaluate(this);
    private float average = -1;

    public Operacoes() {
        news = new Sites(this);
        disableAll();
        disableEvaluate();
        news.setVisible(true);
        news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/App_page.png")));
        news.getBottonLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bar+nav.png")));
        controller = new Controller();
        controller.connect();
        Thread controlarHora = new Thread() {
            @Override
            public void run() {
                while (true) {
                    String horario;
                    Calendar calendar = new GregorianCalendar();
                    Date trialTime = new Date();
                    calendar.setTime(trialTime);
                    if (calendar.get(Calendar.MINUTE) < 10 && calendar.get(Calendar.HOUR_OF_DAY) < 10) {
                        horario = "0" + calendar.get(Calendar.HOUR_OF_DAY) + ":0" + calendar.get(Calendar.MINUTE);
                    } else if (calendar.get(Calendar.MINUTE) < 10) {
                        horario = calendar.get(Calendar.HOUR_OF_DAY) + ":0" + calendar.get(Calendar.MINUTE);
                    } else if (calendar.get(Calendar.HOUR_OF_DAY) < 10) {
                        horario = "0" + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
                    } else {
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
            disableEvaluate();
            news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/BBC/BBC_page.png")));
            news.getBottonLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/BBC/bbcBar+nav.png")));
            news.setVisible(true);
            news.repaint();
            controller.setChoosenSite(0);
            openNews = -1;
            enableButtons();
            average = -1;
        } else if (e.getSource().equals(news.getCBS())) {
            disableEvaluate();
            news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/CBS/CBS_page.png")));
            news.getBottonLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/CBS/cbsBar+nav.png")));
            news.setVisible(true);
            news.repaint();
            controller.setChoosenSite(1);
            openNews = -1;
            enableButtons();
            average = -1;
        } else if (e.getSource().equals(news.getCNN())) {
            disableEvaluate();
            news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNN/CNN_page.png")));
            news.getBottonLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/CNN/cnnBar+nav.png")));
            news.setVisible(true);
            news.repaint();
            controller.setChoosenSite(2);
            openNews = -1;
            enableButtons();
            average = -1;
        } else if (e.getSource().equals(news.getHome())) {
            disableEvaluate();
            disableAll();
            news.getSite_label().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/App_page.png")));
            news.getBottonLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bar+nav.png")));
            news.repaint();
            openNews = -1;
            average = -1;
        } else if (e.getSource().equals(news.getNews1())) {
            disableEvaluate();
            getNews(1);
            average = -1;
        } else if (e.getSource().equals(news.getNews2())) {
            disableEvaluate();
            getNews(2);
            average = -1;
        } else if (e.getSource().equals(news.getNews3())) {
            disableEvaluate();
            getNews(3);
            average = -1;
        } else if (e.getSource().equals(news.getNews4())) {
            disableEvaluate();
            getNews(4);
            average = -1;
        } else if (e.getSource().equals(news.getNews5())) {
            disableEvaluate();
            getNews(5);
            average = -1;
        } else if (e.getSource().equals(news.getNews6())) {
            disableEvaluate();
            getNews(6);
            average = -1;
        } else if (e.getSource().equals(news.getPage1())) {
            disableEvaluate();
            getPages(1);
            average = -1;
        } else if (e.getSource().equals(news.getPage2())) {
            disableEvaluate();
            getPages(2);
            average = -1;
        } else if (e.getSource().equals(news.getPage3())) {
            disableEvaluate();
            getPages(3);
            average = -1;
        } else if (e.getSource().equals(news.getPage4())) {
            disableEvaluate();
            getPages(4);
            average = -1;
        } else if (e.getSource().equals(news.getPage5())) {
            enableEvaluate();
            getPages(5);
            average = -1;
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
            average = -1;
        } else if (e.getSource().equals(evaluateForm.getStar_1())) {
            evaluateForm.getjLabel1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/One_star.png")));
            evaluateForm.repaint();
            average = 1;
        } else if (e.getSource().equals(evaluateForm.getStar_2_half1())) {
            evaluateForm.getjLabel1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/One_star_and_a_half.png")));
            evaluateForm.repaint();
            average = (float) 1.5;
        } else if (e.getSource().equals(evaluateForm.getStar_2_half2())) {
            evaluateForm.getjLabel1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Two_stars.png")));
            evaluateForm.repaint();
            average = 2;
        } else if (e.getSource().equals(evaluateForm.getStar_3_half1())) {
            evaluateForm.getjLabel1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Two_stars_and_a_half.png")));
            evaluateForm.repaint();
            average = (float) 2.5;
        } else if (e.getSource().equals(evaluateForm.getStar_3_half2())) {
            evaluateForm.getjLabel1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/three_stars.png")));
            evaluateForm.repaint();
            average = 3;
        } else if (e.getSource().equals(evaluateForm.getStar_4_half1())) {
            evaluateForm.getjLabel1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/three_stars_and_a_half.png")));
            evaluateForm.repaint();
            average = (float) 3.5;
        } else if (e.getSource().equals(evaluateForm.getStar_4_half2())) {
            evaluateForm.getjLabel1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Four_stars.png")));
            evaluateForm.repaint();
            average = 4;
        } else if (e.getSource().equals(evaluateForm.getStar_5_half1())) {
            evaluateForm.getjLabel1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Four_stars_and_a_half.png")));
            evaluateForm.repaint();
            average = (float) 4.5;
        } else if (e.getSource().equals(evaluateForm.getStar_5_half2())) {
            evaluateForm.getjLabel1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Five_stars.png")));
            evaluateForm.repaint();
            average = 5;
        } else if (e.getSource().equals(evaluateForm.getSend())) {
            String answer = controller.sendAvaliation(average, openNews);
            if(answer.equals("send with success")){
                JOptionPane.showMessageDialog(news, "Your evaluation was send! Thank you for you time!");
            }
            else{
                JOptionPane.showMessageDialog(news, "Unfortunately we didn't make to connect to our server. Sorry :/");
            }
            evaluateForm.setVisible(false);
            evaluateForm.getjLabel1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Zero_stars.png")));
        } else if (e.getSource().equals(news.getEvaluate())) {
            evaluateForm.setVisible(true);
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

    public void disableEvaluate() {
        news.getEvaluate().setVisible(false);
        news.getEvaluate().setEnabled(false);
    }

    public void enableEvaluate() {
        news.getEvaluate().setVisible(true);
        news.getEvaluate().setEnabled(true);
    }

}

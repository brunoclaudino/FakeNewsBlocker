/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author 
 */
public class Sites extends javax.swing.JFrame {
    
    private static final Point point = new Point();
    
    /**
     * Creates new form Sites
     */
    public Sites(Operacoes op) {
        setUndecorated(true);
        initComponents();
        BBC.addActionListener(op);
        CNN.addActionListener(op);
        CBS.addActionListener(op);
        Home.addActionListener(op);
        news1.addActionListener(op);
        news2.addActionListener(op);
        news3.addActionListener(op);
        news4.addActionListener(op);
        news5.addActionListener(op);
        news6.addActionListener(op);
        page1.addActionListener(op);
        page2.addActionListener(op);
        page3.addActionListener(op);
        page4.addActionListener(op);
        page5.addActionListener(op);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                point.x = e.getX();
                point.y = e.getY();
            }
        });
        
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e){
                Point p = getLocation();
                setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
            }
        });
        
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(15);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public JLabel getBottonLabel() {
        return bottonLabel;
    }

    public void setBottonLabel(JLabel bottonLabel) {
        this.bottonLabel = bottonLabel;
    }

    public JLabel getSite_label() {
        return site_label;
    }

    public void setSite_label(JLabel site_label) {
        this.site_label = site_label;
    }

    public JButton getBBC() {
        return BBC;
    }

    public JButton getCBS() {
        return CBS;
    }

    public JButton getCNN() {
        return CNN;
    }

    public JButton getHome() {
        return Home;
    }

    public JButton getNews1() {
        return news1;
    }

    public JButton getNews2() {
        return news2;
    }

    public JButton getNews3() {
        return news3;
    }

    public JButton getNews4() {
        return news4;
    }

    public JButton getNews5() {
        return news5;
    }

    public JButton getNews6() {
        return news6;
    }

    public JButton getPage1() {
        return page1;
    }

    public JButton getPage2() {
        return page2;
    }

    public JButton getPage3() {
        return page3;
    }

    public JButton getPage4() {
        return page4;
    }

    public JButton getPage5() {
        return page5;
    } 
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Home = new javax.swing.JButton();
        BBC = new javax.swing.JButton();
        CNN = new javax.swing.JButton();
        CBS = new javax.swing.JButton();
        topLabel = new javax.swing.JLabel();
        bottonLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        page5 = new javax.swing.JButton();
        page4 = new javax.swing.JButton();
        page3 = new javax.swing.JButton();
        page2 = new javax.swing.JButton();
        page1 = new javax.swing.JButton();
        news1 = new javax.swing.JButton();
        news2 = new javax.swing.JButton();
        news3 = new javax.swing.JButton();
        news4 = new javax.swing.JButton();
        news5 = new javax.swing.JButton();
        news6 = new javax.swing.JButton();
        site_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Home.setBorderPainted(false);
        Home.setContentAreaFilled(false);
        getContentPane().add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 690, 50, 70));

        BBC.setBorderPainted(false);
        BBC.setContentAreaFilled(false);
        getContentPane().add(BBC, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 689, 50, 70));

        CNN.setBorderPainted(false);
        CNN.setContentAreaFilled(false);
        getContentPane().add(CNN, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 690, 50, 70));

        CBS.setBorderPainted(false);
        CBS.setContentAreaFilled(false);
        getContentPane().add(CBS, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 690, 50, 70));

        topLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/top_bar.png"))); // NOI18N
        getContentPane().add(topLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        bottonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BBC/bbcBar+nav.png"))); // NOI18N
        getContentPane().add(bottonLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, -1, -1));

        jScrollPane1.setBorder(null);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        page5.setBorderPainted(false);
        page5.setContentAreaFilled(false);
        jPanel1.add(page5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 580, 30, 20));

        page4.setBorderPainted(false);
        page4.setContentAreaFilled(false);
        jPanel1.add(page4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 550, 30, 20));

        page3.setBorderPainted(false);
        page3.setContentAreaFilled(false);
        jPanel1.add(page3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, 30, 20));

        page2.setBorderPainted(false);
        page2.setContentAreaFilled(false);
        jPanel1.add(page2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 10, 10));

        page1.setBorderPainted(false);
        page1.setContentAreaFilled(false);
        jPanel1.add(page1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 30, 30));

        news1.setBorderPainted(false);
        news1.setContentAreaFilled(false);
        jPanel1.add(news1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 480, 70));

        news2.setBorderPainted(false);
        news2.setContentAreaFilled(false);
        jPanel1.add(news2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 320, 30));

        news3.setBorderPainted(false);
        news3.setContentAreaFilled(false);
        jPanel1.add(news3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 770, 320, 30));

        news4.setBorderPainted(false);
        news4.setContentAreaFilled(false);
        jPanel1.add(news4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, 160, 40));

        news5.setBorderPainted(false);
        news5.setContentAreaFilled(false);
        jPanel1.add(news5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 620, 160, 50));

        news6.setBorderPainted(false);
        news6.setContentAreaFilled(false);
        jPanel1.add(news6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 780, 180, 30));

        site_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BBC/BBC_page.png"))); // NOI18N
        jPanel1.add(site_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 533, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBC;
    private javax.swing.JButton CBS;
    private javax.swing.JButton CNN;
    private javax.swing.JButton Home;
    private javax.swing.JLabel bottonLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton news1;
    private javax.swing.JButton news2;
    private javax.swing.JButton news3;
    private javax.swing.JButton news4;
    private javax.swing.JButton news5;
    private javax.swing.JButton news6;
    private javax.swing.JButton page1;
    private javax.swing.JButton page2;
    private javax.swing.JButton page3;
    private javax.swing.JButton page4;
    private javax.swing.JButton page5;
    private javax.swing.JLabel site_label;
    private javax.swing.JLabel topLabel;
    // End of variables declaration//GEN-END:variables
}

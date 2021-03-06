/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author victo
 */
public class Evaluate extends javax.swing.JFrame {

    /**
     * Creates new form Evaluate
     * @param op
     */
    public Evaluate(Operacoes op) {
        initComponents();
        Star_1.addActionListener(op);
        Star_2_half1.addActionListener(op);
        Star_2_half2.addActionListener(op);
        Star_3_half1.addActionListener(op);
        Star_3_half2.addActionListener(op);
        Star_4_half1.addActionListener(op);
        Star_4_half2.addActionListener(op);
        Star_5_half1.addActionListener(op);
        Star_5_half2.addActionListener(op);
        send.addActionListener(op);
    }

    public JButton getStar_1() {
        return Star_1;
    }

    public JButton getStar_2_half1() {
        return Star_2_half1;
    }

    public JButton getStar_2_half2() {
        return Star_2_half2;
    }

    public JButton getStar_3_half1() {
        return Star_3_half1;
    }

    public JButton getStar_3_half2() {
        return Star_3_half2;
    }

    public JButton getStar_4_half1() {
        return Star_4_half1;
    }

    public JButton getStar_4_half2() {
        return Star_4_half2;
    }

    public JButton getStar_5_half1() {
        return Star_5_half1;
    }

    public JButton getStar_5_half2() {
        return Star_5_half2;
    }

    public JButton getSend() {
        return send;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Star_1 = new javax.swing.JButton();
        Star_2_half1 = new javax.swing.JButton();
        Star_2_half2 = new javax.swing.JButton();
        Star_3_half1 = new javax.swing.JButton();
        Star_3_half2 = new javax.swing.JButton();
        Star_4_half1 = new javax.swing.JButton();
        Star_4_half2 = new javax.swing.JButton();
        Star_5_half1 = new javax.swing.JButton();
        Star_5_half2 = new javax.swing.JButton();
        send = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Star_1.setBorderPainted(false);
        Star_1.setContentAreaFilled(false);
        getContentPane().add(Star_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 130, -1, 30));

        Star_2_half1.setBorderPainted(false);
        Star_2_half1.setContentAreaFilled(false);
        getContentPane().add(Star_2_half1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 20, 40));

        Star_2_half2.setBorderPainted(false);
        Star_2_half2.setContentAreaFilled(false);
        getContentPane().add(Star_2_half2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 20, 40));

        Star_3_half1.setBorderPainted(false);
        Star_3_half1.setContentAreaFilled(false);
        getContentPane().add(Star_3_half1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 20, 40));

        Star_3_half2.setBorderPainted(false);
        Star_3_half2.setContentAreaFilled(false);
        getContentPane().add(Star_3_half2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 20, 40));

        Star_4_half1.setBorderPainted(false);
        Star_4_half1.setContentAreaFilled(false);
        getContentPane().add(Star_4_half1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 20, 40));

        Star_4_half2.setBorderPainted(false);
        Star_4_half2.setContentAreaFilled(false);
        getContentPane().add(Star_4_half2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 20, 40));

        Star_5_half1.setBorderPainted(false);
        Star_5_half1.setContentAreaFilled(false);
        getContentPane().add(Star_5_half1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 20, 40));

        Star_5_half2.setBorderPainted(false);
        Star_5_half2.setContentAreaFilled(false);
        getContentPane().add(Star_5_half2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 20, 40));

        send.setText("Send evaluation");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });
        getContentPane().add(send, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Zero_stars.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 210));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Star_1;
    private javax.swing.JButton Star_2_half1;
    private javax.swing.JButton Star_2_half2;
    private javax.swing.JButton Star_3_half1;
    private javax.swing.JButton Star_3_half2;
    private javax.swing.JButton Star_4_half1;
    private javax.swing.JButton Star_4_half2;
    private javax.swing.JButton Star_5_half1;
    private javax.swing.JButton Star_5_half2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton send;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class Operacoes implements ActionListener {
    Google google;
    
    public Operacoes(){
        google = new Google(this);
        google.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(google.getCloseButton()) || e.getSource().equals(google.getCloseButton1())){
            System.exit(0);
        }
        else if(e.getSource().equals(google.getMinimizeButton())){
            google.setExtendedState(JFrame.ICONIFIED);
        }
        else if(e.getSource().equals(google.getGoogleSearch())){
            String texto = google.getSearch().getText();
            if(texto.equals("noticias") || texto.equals("site de noticias")){
                //realizar a pesquisa
            }
        }
        else if(e.getSource().equals(google.getImLucky())){
            JOptionPane.showMessageDialog(google, "Não, você não tá com sorte. Agora usa o outro botão :)");
        }
    }
    
}

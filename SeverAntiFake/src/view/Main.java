/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Talker;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author lablenda2
 */
public class Main {
    public static LinkedList<String> serverNames = new LinkedList();
    private static final Talker t = new Talker();;
    public static void main(String[] args) {
        System.out.println("Digite o nome do Servidor para iniciar");
        Scanner in = new Scanner(System.in);
        serverNames.add(in.next());
        System.out.println("Digite o nome do server 2");
        serverNames.add(in.next());
        System.out.println("Digite o nome");
        serverNames.add(in.next());
        t.runServer(serverNames.getFirst());
    }
}

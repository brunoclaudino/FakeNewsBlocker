/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Talker;

/**
 *
 * @author lablenda2
 */
public class Main {
    private static final Talker t = new Talker();
    public static void main(String[] args) {
        t.runServer();
    }
}

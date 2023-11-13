/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JFrame;
import view.FrmMain;
import view.FrmTabela;
import view.FrmTabela2;

/**
 *
 * @author vojislav
 */
public class Main {
    public static void main(String[] args) {
        // samo pozivam sve 3 forme koje su mi neophodne 
        JFrame frmMain = new FrmMain();
        frmMain.setVisible(true);
        JFrame frmTabela = new FrmTabela();
        frmTabela.setVisible(true);
        JFrame frmTabela2 = new FrmTabela2();
        frmTabela2.setVisible(true);
    }
}

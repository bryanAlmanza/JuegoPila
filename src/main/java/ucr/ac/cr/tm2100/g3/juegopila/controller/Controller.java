/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.juegopila.controller;

import ucr.ac.cr.tm2100.g3.juegopila.model.Personaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.tm2100.g3.juegopila.view.History;
import ucr.ac.cr.tm2100.g3.juegopila.view.Instruccions;
import ucr.ac.cr.tm2100.g3.juegopila.view.Play;

/**
 *
 * @author bombe
 */
public class Controller implements ActionListener, MouseListener, KeyListener {

    

    

    //actionPerformed,para manejar los botones del menu
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "History":
                
                break;
            case "Instructions":
                break;
            case "Play":

                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }

    //eventos del mouse, para manejar los disparos en el juegos
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //eventos del teclado para manejar los movimientos del personaje
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}

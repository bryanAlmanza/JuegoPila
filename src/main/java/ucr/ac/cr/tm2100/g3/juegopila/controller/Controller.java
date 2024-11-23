/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.juegopila.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.tm2100.g3.juegopila.view.GUIHistoria;
import ucr.ac.cr.tm2100.g3.juegopila.view.GUIInstrucciones;
import ucr.ac.cr.tm2100.g3.juegopila.view.GUIJuego;
import ucr.ac.cr.tm2100.g3.juegopila.view.GUITablero;
import ucr.ac.cr.tm2100.g3.juegopila.view.PanelTablero;

//import ucr.ac.cr.tm2100.g3.juegopila.view.Play;
/**
 *
 * @author bombe
 */
public class Controller implements ActionListener, MouseListener, KeyListener {

    private GUIJuego guiJuego;
    private GUIInstrucciones guiInst;
    private GUIHistoria guiHis;
    private GUITablero guiTab;
    private PanelTablero panelTablero;
    
    
    public Controller() {
        guiJuego = new GUIJuego(this);
        guiJuego.setVisible(true);
        guiInst = new GUIInstrucciones();
        guiHis=new GUIHistoria();
        guiInst.escuchar(this);
        guiHis.escuchar(this);
        guiTab=new GUITablero(this);
        panelTablero=new PanelTablero();
    }

    //actionPerformed,para manejar los botones del menu
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "instrucciones":
                System.out.println("Lol");
                guiInst.setVisible(true);
                guiJuego.setVisible(false);
                break;
            case "historia":
                System.out.println("que");
                guiHis.setVisible(true);
                guiJuego.setVisible(false);
                break;
            case "jugar":
                System.out.println("Mejor ponte a estudiar");
                guiTab.setVisible(true);
                panelTablero.setControlador(this);
                
                guiJuego.setVisible(false);
                break;
            case "salir":
                System.exit(0);
                break;
            case "salirInst":
                guiInst.setVisible(false);
                guiJuego.setVisible(true);
                break;
            case "salirHis":
                guiHis.setVisible(false);
                guiJuego.setVisible(true);
                break;
                
        }
        
    }

    //eventos del mouse, para manejar los disparos en el juegos
    @Override
    public void mouseClicked(MouseEvent e) {
        
        System.out.println("Presiono click X: "+e.getX()+", Y: "+e.getY());
        
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

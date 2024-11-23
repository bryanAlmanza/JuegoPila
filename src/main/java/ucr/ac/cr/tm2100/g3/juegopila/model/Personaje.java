/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.juegopila.model;

import javax.swing.ImageIcon;



/**
 *
 * @author bombe
 */
public class Personaje {

    private String clase;
    private int vida;
    private int danho;
    
    public Personaje(String clase, int vida, int danho) {
        this.clase = clase;
        this.vida = vida;
        this.danho = danho;
    }

    public Personaje() {
        this.clase = "";
        this.vida = 3;
        this.danho = 1;
    }
    
            
    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public void perderVida(){
        vida--;
    }

    public int getDanho() {
        return danho;
    }

    public void setDanho(int danho) {
        this.danho = danho;
    }

    @Override
    public String toString() {
        return "Caracteristicas del Personaje:" + "\nclase:" + clase + "\nvida:" + vida + "\ndanho:" + danho;
    }

}

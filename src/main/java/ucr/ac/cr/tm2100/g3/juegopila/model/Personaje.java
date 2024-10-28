/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.juegopila.model;

/**
 *
 * @author bombe
 */
public class Personaje {
    private String clase;
    private int vida;
    private int danho;
    private int velocidad;

    public Personaje(String clase, int vida, int danho, int velocidad) {
        this.clase = clase;
        this.vida = vida;
        this.danho = danho;
        this.velocidad = velocidad;
    }

    public Personaje() {
        this.clase="";
        this.vida=0;
        this.danho=0;
        this.velocidad=0;
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

    public int getDanho() {
        return danho;
    }

    public void setDanho(int danho) {
        this.danho = danho;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Caracteristicas del Personaje:" + "\nclase:" + clase + "\nvida:" + vida + "\ndanho:" + danho + "\nvelocidad:" + velocidad;
    }
    
    
    
    
}

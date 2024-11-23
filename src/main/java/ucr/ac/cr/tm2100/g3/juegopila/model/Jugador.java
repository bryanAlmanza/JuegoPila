/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.juegopila.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author bombe
 */
public class Jugador extends Personaje {

    private int x;
    private int y;
    private int[][] matriz;
    private boolean vivo;
    private ImageIcon icono = new ImageIcon("./src/main/resources/img/JugadorDown.png");
    private List<Balas> balas = new ArrayList<>();//arraylist para generar varias balas

    public Jugador(String clase, int vida, int danho) {
        super(clase, vida, danho);

    }

    public Jugador(int x, int y, int[][] matriz) {
    this.x = x;
    this.y = y;
    this.matriz = matriz;
}

    public void dibujar(Graphics g) {
        icono.paintIcon(null, g, x, y);
    }

    public void mover(int dx, int dy) {
        int nuevaX = x + dx;
        int nuevaY = y + dy;

        // Verificar si el nuevo movimiento es un camino válido
        if (esCamino(nuevaX, nuevaY)) {
            x = nuevaX;
            y = nuevaY;
        }
    }

    public boolean esCamino(int posicionX, int posicionY) {
        return x >= 0 && y >= 0 && posicionX < matriz[0].length && posicionY < matriz.length && matriz[posicionY][posicionX] == 0;
    }

    public void disparar(int direccion) {

        if (balas.size() < 10) {
            Balas nuevaBala = new Balas(x, y, direccion, matriz);
            Thread hiloBala = new Thread(nuevaBala);//creacion del hilo con la referencia a ejecutar
            hiloBala.start();//se inicia el hilo
            balas.add(nuevaBala);           
        }
    }

    public void recibirDanho(int cantidadDanho) {
        if (vivo) {
            setVida(getVida() - cantidadDanho);
            if (getVida() <= 0) {
                vivo = false;
            }
        }
    }

    public void actualizarBalas() {
        balas.removeIf(Balas -> !Balas.isActivo());
    }

    public boolean colisionaConBala(Jugador jugador, List<Balas> balas) {
        actualizarBalas();
        for (Balas bala : balas) {
            if (jugador.getX() == bala.getX() && jugador.getY() == bala.getY()) {
                bala.setActivo(false); // Desactiva la bala tras la colisión
                return true; // Colisión detectada
            }
        }
        return false; // No hubo colisión
    }

    public void verificarColisiones() {

        for (Balas bala : balas) {
            if (colisionaConBala(this, this.balas)) { // Verifica si hay colisión con alguna bala
                recibirDanho(this.getDanho()); // Aplica el daño al enemigo afectado
            }
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setIcono(ImageIcon icono) {
        this.icono = icono;
    }

    public ImageIcon getIcono() {
        return icono;
    }

}

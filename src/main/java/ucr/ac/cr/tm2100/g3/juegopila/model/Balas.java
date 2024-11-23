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
public class Balas implements Runnable {

    private int x;
    private int y;
    private int direccion;
    private int cantidad;
    private int matriz[][];
    private boolean recolectado;
    private boolean activo = true;
    private ImageIcon icono;
    
     public Balas(int x, int y, int direccion, int[][] matriz) {
        this.x = x;
        this.y = y;
        this.direccion = direccion;
        this.matriz = matriz;
    }
    //metodo dibujar
    
    @Override
    public void run() {
        while (activo) {
            // Mueve la bala según su dirección
            switch (direccion) {
                case 0:
                    y--;
                    break; // Arriba
                case 1:
                    y++;
                    break; // Abajo
                case 2:
                    x--;
                    break; // Izquierda
                case 3:
                    x++;
                    break; // Derecha
            }
        }

        //Verifica que la bala este dentro de los limites del mapa y si la bala pasa los limites del mapa se detiene
        if (x < 0 || y < 0 || x >= matriz[0].length || y >= matriz.length || matriz[y][x] != 0) {
            activo = false; // Detiene la bala
        }
        
        try {
                Thread.sleep(100); // Velocidad de la bala
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int sumarBalas() {
        return cantidad++;
    }

    public int gastarBalas() {
        return cantidad--;
    }

    public boolean isRecolectado() {
        return recolectado;
    }
    
    public boolean isActivo(){
        return activo;
    }

    public void recolectar() {
        this.recolectado = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    public boolean getActivo(){
        return activo;
    }
    
    public void setActivo(boolean activo){
        this.activo=activo;
    }    
}

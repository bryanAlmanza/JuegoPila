/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tm2100.g3.juegopila.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author bombe
 */
public class Enemigo extends Personaje implements Runnable {

    private int x;
    private int y;
    private int[][] matriz;
    private ImageIcon icono;
    private boolean movimiento, vivo;
    private List<Balas> balas = new ArrayList<>();//arraylist para generar varias balas
    private Random random = new Random();

    public Enemigo(String clase, int vida, int danho) {
        super(clase, vida, danho);
    }

    // Constructor para inicializar la posición y el laberinto
    public Enemigo(int iniciarX, int iniciarY, int[][] laberinto) {
        this.x = iniciarX;
        this.y = iniciarY;
        this.matriz = laberinto;
        this.movimiento = true;
    }

    // Método para verificar si la posición es válida y transitable
    public boolean esCamino(int posicionX, int posicionY) {
        return x >= 0 && y >= 0 && posicionX < matriz[0].length && posicionY < matriz.length && matriz[posicionY][posicionX] == 0;
    }

    // Método run para la lógica de movimiento
    @Override
    public void run() {
        //Dirección random: 0 = arriba, 1 = abajo, 2 = izquierda, 3 = derecha
        int direccion = random.nextInt(4);
        int posicionX = x;
        int posicionY = y;

        while (movimiento) {
            // Switch para actualizar las coordenadas según la dirección
            switch (direccion) {
                case 0:
                    posicionY--;
                    icono=new ImageIcon("./src/main/resources/img/enemigoRigth");
                    disparar(direccion);
                    actualizarBalas();
                    break;
                case 1:
                    posicionY++;
                    icono=new ImageIcon("./src/main/resources/img/enemigoLeft");
                    disparar(direccion);
                    actualizarBalas();
                    break;
                case 2:
                    posicionX--;
                    icono=new ImageIcon("./src/main/resources/img/enemigoUp");
                    disparar(direccion);
                    actualizarBalas();
                    break;
                case 3:
                    posicionX++;
                    icono=new ImageIcon("./src/main/resources/img/enemigoDown");
                    disparar(direccion);
                    actualizarBalas();
                    break;
            }

            //Para actualizar las posiciones
            if (esCamino(posicionX, posicionY)) {
                x = posicionX;
                y = posicionY;
            }
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void dibujar(Graphics g) {
        icono.paintIcon(null, g, x, y);
    }

    public void disparar(int direccion) {

        if (balas.size() < 10) {
            Balas nuevaBala = new Balas(x, y, direccion, matriz);//referencia del hilo
            Thread hiloBala = new Thread(nuevaBala);//creacion del hilo con la referencia a ejecutar
            hiloBala.start();//se inicia el hilo
            balas.add(nuevaBala);//el arraylist anade balas como valor            
        }
    }

    public void recibirDanho(int cantidadDanho) {
        
        if (vivo) { // Solo recibe daño si está vivo
            int nuevaVida = getVida() - cantidadDanho; // Obtiene la vida actual y la reduce
            setVida(nuevaVida); // Actualiza la vida del personaje

            if (getVida() == 0) { // Si la vida llega a 0
                this.vivo = false; // Muere el enemigo
                detener();
            }
        }
    }

    public void actualizarBalas() {
        balas.removeIf(Balas -> !Balas.isActivo());
    }

    public boolean colisionaConBala(Enemigo enemigo, List<Balas> balas) {
        for (Balas bala : balas) {
            if (enemigo.getX() == bala.getX() && enemigo.getY() == bala.getY()) {
                bala.setActivo(false); // Desactiva la bala tras la colisión
                return true; // Indica que hubo una colisión
            }
        }
        return false; // No hubo colisión
    }

    public void verificarColisiones(List<Enemigo> enemigos) {
        for (Enemigo enemigo : enemigos) {
            for (Balas bala : balas) {
                if (colisionaConBala(enemigo, this.balas)) { // Verifica si hay colisión con alguna bala
                    enemigo.recibirDanho(this.getDanho()); // Aplica el daño al enemigo afectado
                }
            }
        }
    }

    public void detener() {
        this.movimiento = false; // Detiene el movimiento
    }   
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

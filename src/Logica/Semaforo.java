package Logica;

import Presentacion.Ventana;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Semaforo implements Runnable {
    
    private final Bombillo bombilloRojo;
    private final Bombillo bombilloAmarillo;
    private final Bombillo bombilloVerde;
    private int recorrido;
    private boolean activado;
    private boolean automatico;
    private int uniTiempo;
    private final Ventana ventana;
    
    public Semaforo(Ventana ventana){
        this.ventana = ventana;
        recorrido = 0;
        uniTiempo = 100;
        bombilloRojo = new Bombillo(new Color(164, 0, 0), Color.RED, 45);
        bombilloAmarillo = new Bombillo(new Color(176, 168, 0), Color.YELLOW, 120);
        bombilloVerde = new Bombillo(new Color(4, 151, 0), Color.GREEN, 198);
        automatico = true;
        activado = false;
        iniciar();
    }
    
    private void iniciar() {
        Thread hiloPrograma = new Thread(this);
        hiloPrograma.start();        
    }
    
    @Override
    public void run() {
        Canvas lienzo = ventana.getLienzoSemaforo();
        int width = lienzo.getWidth();
        int height = lienzo.getHeight();
        BufferedImage buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
          
        while(true){
            esperar();
            actualizar();
            dibujar(buffer, lienzo);
            ventana.setNumPbrRecorrido(recorrido);
        }
    }
    
    private void esperar() {
        try {
            Thread.sleep(uniTiempo);
        } catch (InterruptedException ex) {}
    }
    
    private void actualizar() {
        if (activado){
            if(automatico){
                switch (recorrido){
                    case 50:
                    case 90:
                        bombilloAmarillo.setEncendido(true);
                        bombilloVerde.setEncendido(false);
                        bombilloRojo.setEncendido(false);
                        break;
                    case 55:
                        bombilloAmarillo.setEncendido(false);
                        bombilloVerde.setEncendido(true);
                        bombilloRojo.setEncendido(false);
                        break;
                    case 95:
                    case 1:
                        bombilloAmarillo.setEncendido(false);
                        bombilloVerde.setEncendido(false);
                        bombilloRojo.setEncendido(true);
                        break;
                    default:
                        break;
                }
            } else {
                if (recorrido % 4 == 0){
                    bombilloRojo.cambiarColor();
                    bombilloAmarillo.cambiarColor();
                    bombilloVerde.cambiarColor();
                }
            }
            
            recorrido = recorrido == 100 ? 0 : recorrido + 1;
        }
    }
    
    private void dibujar(BufferedImage buffer, Canvas lienzo){
        Graphics lapizPrincipal = lienzo.getGraphics();
        Graphics lapiz = buffer.getGraphics();
        
        lapiz.clearRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
               
        lapiz.setColor(Color.DARK_GRAY);
        lapiz.fillRect(40, 20, 120, 250);
        lapiz.fillRect(85, 270, 30, 30);
        bombilloRojo.dibujar(lapiz);
        bombilloAmarillo.dibujar(lapiz);
        bombilloVerde.dibujar(lapiz);
        
        lapizPrincipal.drawImage(buffer, 0, 0, null);
    }
    
    public void setColorBombillo(Color color, boolean isSelected){        
        if(color == Color.RED){
            bombilloRojo.setColor(isSelected);
        } else if (color == Color.YELLOW){
            bombilloAmarillo.setColor(isSelected);
        } else {
            bombilloVerde.setColor(isSelected);
        }
    }
    
    public void setAutomatico(boolean automatico){
        this.automatico = automatico;
        this.activado = !automatico;
        
        if(automatico){
            boolean valor1  =  !bombilloRojo.getEncendido();
            valor1 = valor1 && !bombilloAmarillo.getEncendido();
            valor1 = valor1 && bombilloVerde.getEncendido();
            if (valor1){
                recorrido = 50;
            } else {
                recorrido = 1;
            }
        }
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }

    public void setUniTiempo(int uniTiempo){
        this.uniTiempo = uniTiempo;
    }
    
}

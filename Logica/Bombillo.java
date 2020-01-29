package Logica;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class Bombillo {
    
    private boolean encendido;
    private boolean titilando;
    private final Color colorOscuro;
    private final Color colorClaro;
    private final int posY;
    
    
    public Bombillo(Color colorOscuro, Color colorClaro, int posY){
        this.colorClaro = colorClaro;
        this.colorOscuro = colorOscuro;
        this.posY = posY;
    }
    
    public boolean getEncendido(){
        return encendido;
    }
    
    public void setEncendido(boolean encendido){
        this.encendido = encendido;
    }
    
    public void cambiarColor(){
        if (titilando){
            encendido = !encendido;
        }
    }
    
    public void setColor(boolean isSelected){
        if (isSelected) {
            String datoString = JOptionPane.showInputDialog("Escriba si quiere que el semaforo '1 para prender' o '2 para titilar'");
            int dato = Integer.parseInt(datoString);
            if(dato == 1){
                encendido = true;
            } else if(dato == 2){
                titilando = true;
            }
        } else {
            encendido = false;
            titilando = false;
        }
    }
    
    public void dibujar(Graphics lapiz){
        if (encendido) {
            lapiz.setColor(colorClaro);
        } else { 
            lapiz.setColor(colorOscuro);
        }
        
        int posX=77;
        int alto=60;
        int ancho=51;
        lapiz.fillOval(posX, posY, ancho, alto);
    }
    
}

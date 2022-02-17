package abstracto.logica;

import abstracto.interfaces.Dibujo;
import abstracto.interfaces.Encendido;
import java.awt.Color;
import java.awt.Graphics;

public class Bombillo implements Dibujo, Encendido{
    
    private boolean encendido;
    private final Color colorApagado;
    private final Color colorEncendido;
    private final int posY;
    
    public Bombillo(Color colorOscuro, Color colorClaro, int posY){
        this.colorEncendido = colorClaro;
        this.colorApagado = colorOscuro;
        this.posY = posY;
    }
    
    @Override
    public void setEncendido(boolean encendido){
        this.encendido = encendido;
    }

    @Override
    public void dibujar(Graphics lapiz){        
        int posX=77;
        int alto=60;
        int ancho=51;
        lapiz.setColor(encendido ? colorEncendido : colorApagado);
        lapiz.fillOval(posX, posY, ancho, alto);
    }
    
}

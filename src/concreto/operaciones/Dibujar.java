package concreto.operaciones;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import abstracto.logica.Dibujo;
import abstracto.logica.Operacion;

public class Dibujar implements Operacion {

    private final int ancho;
    private final int alto;
    private final Image buffer;
    private final Dibujo[] bombillos;
    private final Canvas lienzoVentana;
    
    public Dibujar(Canvas lienzoVentana, Dibujo[] bombillos) {
        this.bombillos = bombillos;
        this.lienzoVentana = lienzoVentana;
        ancho = lienzoVentana.getWidth();
        alto = lienzoVentana.getHeight();
        buffer = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public void realizar() {
        Graphics lapizPrincipal = lienzoVentana.getGraphics();
        Graphics lapizBuffer = buffer.getGraphics();
        
        //Dibuja el semaforo
        lapizBuffer.clearRect(0, 0, ancho, alto);
        lapizBuffer.setColor(Color.DARK_GRAY);
        lapizBuffer.fillRect(40, 20, 120, 250);
        lapizBuffer.fillRect(85, 270, 30, 30);
        
        //Dibuja los bombillos
        for (Dibujo bombillo : bombillos) {
            bombillo.dibujar(lapizBuffer);
        }
        
        lapizPrincipal.drawImage(buffer, 0, 0, null);
  
    }

}

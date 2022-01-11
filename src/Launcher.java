import Logica.Bombillo;
import Logica.Dibujo;
import Logica.Operacion;
import Logica.Semaforo;
import Operaciones.Actualizar;
import Operaciones.Dibujar;
import Operaciones.Dormir;
import Presentacion.Ventana;
import java.awt.Canvas;
import java.awt.Color;

public class Launcher {
    
    public static void main(String[] args) {
        
        Canvas lienzo = new Canvas();
        lienzo.setBounds(30, 30, 200, 300);
        
        Bombillo bombilloRojo = new Bombillo(new Color(164, 0, 0), Color.RED, 45);
        Bombillo bombilloAmarillo = new Bombillo(new Color(176, 168, 0), Color.YELLOW, 120);
        Bombillo bombilloVerde = new Bombillo(new Color(4, 151, 0), Color.GREEN, 198);
        
        Dibujo[] dibujos = {bombilloRojo, bombilloAmarillo, bombilloVerde};
        Actualizar actualizar = new Actualizar(bombilloRojo, bombilloAmarillo, bombilloVerde);
        
        int cont;
        Operacion[] operaciones = new Operacion[3];
        
        cont = 0;
        operaciones[cont++] = new Dibujar(lienzo, dibujos);
        operaciones[cont++] = new Dormir();
        operaciones[cont++] = actualizar;
        
        Semaforo semaforo = new Semaforo(operaciones);
        Ventana ventana = new Ventana(lienzo, actualizar);
        
        Thread hiloPrograma = new Thread(semaforo);
        hiloPrograma.start();
    } 

}
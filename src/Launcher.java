import abstracto.logica.Bombillo;
import abstracto.logica.Click;
import abstracto.logica.Dibujo;
import abstracto.logica.Operacion;
import abstracto.logica.Semaforo;
import concreto.operaciones.Actualizar;
import concreto.operaciones.Dibujar;
import concreto.operaciones.Dormir;
import abstracto.presentacion.Ventana;
import concreto.click.ClickDetener;
import concreto.click.ClickIniciar;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Launcher {
    
    public static void main(String[] args) {
        
        //Establece el lookAndFeel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException 
                 | IllegalAccessException 
                 | InstantiationException 
                 | UnsupportedLookAndFeelException ex) {
            System.out.println("No se puede implementar LookAndFeel");
        }
        
        Canvas lienzo = new Canvas();
        lienzo.setBounds(30, 30, 200, 300);
        
        Bombillo bombilloRojo = new Bombillo(new Color(164, 0, 0), Color.RED, 45);
        Bombillo bombilloAmarillo = new Bombillo(new Color(176, 168, 0), Color.YELLOW, 120);
        Bombillo bombilloVerde = new Bombillo(new Color(4, 151, 0), Color.GREEN, 198);
        
        Dibujo[] dibujos = {bombilloRojo, bombilloAmarillo, bombilloVerde};
        Actualizar actualizar = new Actualizar(bombilloRojo, bombilloAmarillo, bombilloVerde);
        
        int cont;
        
        cont = 0;
        Operacion[] operaciones = new Operacion[3];
        operaciones[cont++] = new Dibujar(lienzo, dibujos);
        operaciones[cont++] = new Dormir();
        operaciones[cont++] = actualizar;
        
        cont = 0;
        Click[] clicks = new Click[2];
        clicks[cont++] = new ClickIniciar(actualizar);
        clicks[cont++] = new ClickDetener(actualizar);
        
        Semaforo semaforo = new Semaforo(operaciones);
        Ventana ventana = new Ventana(lienzo, clicks);
        
        Thread hiloPrograma = new Thread(semaforo);
        hiloPrograma.start();
    } 

}
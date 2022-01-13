import abstracto.logica.Bombillo;
import abstracto.interfaces.Dibujo;
import abstracto.interfaces.Operacion;
import abstracto.logica.Semaforo;
import abstracto.presentacion.Ventana;
import concreto.operaciones.OpActualizar;
import concreto.operaciones.OpDibujar;
import concreto.estados.EstIniciado;
import concreto.estados.EstPausado;
import java.awt.Canvas;
import java.awt.Color;
import java.util.ArrayList;
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
        
        OpActualizar opActualizar = new OpActualizar(bombilloRojo, bombilloAmarillo, bombilloVerde);
        OpDibujar opDibujar = new OpDibujar(lienzo, dibujos);
        
        ArrayList<Operacion> operaciones = new ArrayList<>();
        operaciones.add(opDibujar);
                
        Object cerrojo = new Object();
        Semaforo semaforo = new Semaforo(operaciones, cerrojo);
        
        String[] nombresBotones = {"Iniciar", "Pausar"};
        EstIniciado estIniciado = new EstIniciado(opActualizar, operaciones);
        EstPausado estPausado = new EstPausado(opActualizar, operaciones);
        
        estIniciado.setContextoEstados(semaforo, estPausado);
        estPausado.setContextoEstados(semaforo, estIniciado);
        semaforo.setEstado(estPausado);
        
        Ventana ventana = new Ventana(lienzo, nombresBotones, semaforo, cerrojo);
        
        Thread hiloPrograma = new Thread(semaforo);
        hiloPrograma.start();
    } 

}
package abstracto.logica;

import java.util.ArrayList;

public class Semaforo implements Runnable {

    private final ArrayList<Operacion> operaciones;
    private final Object cerrojo;
    
    public Semaforo(ArrayList<Operacion> operaciones, Object cerrojo){
        this.operaciones = operaciones;
        this.cerrojo = cerrojo;
    }
    
    @Override
    public void run() {
        while(true){
            synchronized(cerrojo){
                operaciones.forEach(operacion -> {
                    operacion.realizar();
                });
            }
            
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {}
        }
    }    

}

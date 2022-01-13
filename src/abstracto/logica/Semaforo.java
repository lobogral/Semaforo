package abstracto.logica;

import abstracto.interfaces.Contexto;
import abstracto.interfaces.Operacion;
import abstracto.interfaces.Estado;
import java.util.ArrayList;

public class Semaforo implements Runnable, Contexto {

    private final ArrayList<Operacion> operaciones;
    private final Object cerrojo;
    private Estado estado;
    
    public Semaforo(ArrayList<Operacion> operaciones,
                    Object cerrojo){
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

    @Override
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public void solicitar(String orden) {
        estado.procesar(orden);
    }

}

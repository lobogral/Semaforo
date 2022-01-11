package Logica;

public class Semaforo implements Runnable {

    private final Operacion[] operaciones;
    
    public Semaforo(Operacion[] operaciones){
        this.operaciones = operaciones;
    }
    
    @Override
    public void run() {
        while(true){
            for (Operacion operacion : operaciones) {
                operacion.realizar();
            }
        }
    }    

}

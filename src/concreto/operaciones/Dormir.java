package concreto.operaciones;

import abstracto.logica.Operacion;

public class Dormir implements Operacion {

    @Override
    public void realizar() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException ex) {}
    }
    
}

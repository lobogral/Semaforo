package Operaciones;

import Logica.Operacion;

public class Dormir implements Operacion {

    @Override
    public void realizar() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {}
    }
    
}

package concreto.click;

import abstracto.logica.Click;
import concreto.operaciones.Actualizar;

public class ClickDetener implements Click{

    private final Actualizar actualizar;

    public ClickDetener(Actualizar actualizar){
        this.actualizar = actualizar;
    }
    
    @Override
    public void ejecutar(){
        actualizar.setActivado(false);
    }

    @Override
    public String getNombre() {
        return "Detener";
    }

}

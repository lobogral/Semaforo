package concreto.click;

import abstracto.logica.Click;
import concreto.operaciones.Actualizar;

public class ClickIniciar implements Click{

    private final Actualizar actualizar;

    public ClickIniciar(Actualizar actualizar){
        this.actualizar = actualizar;
    }
    
    @Override
    public void ejecutar(){
        actualizar.setActivado(true);
    }

    @Override
    public String getNombre() {
        return "Iniciar";
    }

}
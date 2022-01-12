package concreto.click;

import abstracto.logica.Click;
import abstracto.logica.Operacion;
import concreto.operaciones.Actualizar;
import java.util.ArrayList;

public class ClickIniciar implements Click{

    private final Actualizar actualizar;
    private final ArrayList<Operacion> operaciones;

    public ClickIniciar(Actualizar actualizar, 
                        ArrayList<Operacion> operaciones){
        this.actualizar = actualizar;
        this.operaciones = operaciones;
    }
    
    @Override
    public void ejecutar(){
        if(!operaciones.contains(actualizar)){
            operaciones.add(actualizar);
        }
    }

    @Override
    public String getNombre() {
        return "Iniciar";
    }

}
package concreto.estados;

import abstracto.interfaces.CambioEstado;
import abstracto.interfaces.Estado;
import abstracto.interfaces.Operacion;
import concreto.operaciones.OpActualizar;
import java.util.ArrayList;

public class EstPausado implements Estado {

    private final OpActualizar opActualizar;
    private final ArrayList<Operacion> operaciones;
    private CambioEstado cambioEstado;
    private EstIniciado estIniciado;
    private EstApagado estApagado;

    public EstPausado(OpActualizar actualizar,
                      ArrayList<Operacion> operaciones){
        this.opActualizar = actualizar;
        this.operaciones = operaciones;
    }
    
    public void addCambioEstados(CambioEstado cambioEstado, 
                                 EstIniciado estIniciado,
                                 EstApagado estApagado){
        this.estIniciado = estIniciado;
        this.estApagado = estApagado;
        this.cambioEstado = cambioEstado;
    }

    @Override
    public void procesar(String orden) {
        if(orden.equals("Iniciar")){
            operaciones.add(opActualizar);
            cambioEstado.setEstado(estIniciado);
        } else if (orden.equals("Apagar")){
            opActualizar.apagar();
        } else {
            System.out.println(orden + ", orden no ejecutable");
        }
    }
    
}

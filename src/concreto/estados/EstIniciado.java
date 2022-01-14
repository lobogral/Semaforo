package concreto.estados;

import abstracto.interfaces.CambioEstado;
import abstracto.interfaces.Estado;
import abstracto.interfaces.Operacion;
import concreto.operaciones.OpActualizar;
import java.util.ArrayList;

public class EstIniciado implements Estado {
    
    private final ArrayList<Operacion> operaciones;
    private final OpActualizar opActualizar;
    private CambioEstado cambioEstado;
    private EstPausado estPausado;
    
    public EstIniciado(OpActualizar opActualizar,
                       ArrayList<Operacion> operaciones){
        this.opActualizar = opActualizar;
        this.operaciones = operaciones;
    }
    
    public void addCambioEstados(CambioEstado cambioEstado, EstPausado estPausado){
        this.estPausado = estPausado;
        this.cambioEstado = cambioEstado;
    }
    
    @Override
    public void procesar(String orden) {
        if (orden.equals("Pausar")){
            operaciones.remove(opActualizar);
            cambioEstado.setEstado(estPausado);
        } else {
            System.out.println(orden + ", orden no ejecutable");
        }
    }

}

package concreto.estados;

import abstracto.interfaces.Estado;
import abstracto.interfaces.Operacion;
import concreto.operaciones.OpActualizar;
import java.util.ArrayList;
import abstracto.interfaces.Contexto;

public class EstIniciado implements Estado {
    
    private final ArrayList<Operacion> operaciones;
    private final OpActualizar opActualizar;
    private Contexto contexto;
    private EstPausado estPausado;
    
    public EstIniciado(OpActualizar opActualizar,
                       ArrayList<Operacion> operaciones){
        this.opActualizar = opActualizar;
        this.operaciones = operaciones;
    }
    
    public void setContextoEstados(Contexto contexto, EstPausado estPausado){
        this.estPausado = estPausado;
        this.contexto = contexto;
    }
    
    @Override
    public void procesar(String orden) {
        if (orden.equals("Pausar")){
            operaciones.remove(opActualizar);
            contexto.setEstado(estPausado);
        } else {
            System.out.println(orden + ", orden no ejecutable");
        }
    }

}

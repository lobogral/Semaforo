package concreto.estados;

import abstracto.interfaces.Estado;
import abstracto.interfaces.Operacion;
import concreto.operaciones.OpActualizar;
import java.util.ArrayList;
import abstracto.interfaces.Contexto;

public class EstPausado implements Estado {

    private final OpActualizar opActualizar;
    private final ArrayList<Operacion> operaciones;
    private Contexto contexto;
    private EstIniciado estIniciado;

    public EstPausado(OpActualizar actualizar,
                      ArrayList<Operacion> operaciones){
        this.opActualizar = actualizar;
        this.operaciones = operaciones;
    }
    
    public void setContextoEstados(Contexto contexto, EstIniciado estIniciado){
        this.estIniciado = estIniciado;
        this.contexto = contexto;
    }

    @Override
    public void procesar(String orden) {
        if(orden.equals("Iniciar")){
            operaciones.add(opActualizar);
            contexto.setEstado(estIniciado);
        } else {
            System.out.println(orden + ", orden no ejecutable");
        }
    }
    
}

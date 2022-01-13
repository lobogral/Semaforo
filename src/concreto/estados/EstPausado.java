package concreto.estados;

import abstracto.interfaces.Estado;
import abstracto.interfaces.Operacion;
import concreto.operaciones.OpActualizar;
import java.util.ArrayList;
import abstracto.interfaces.Contexto;

public class EstPausado implements Estado {

    private final OpActualizar actualizar;
    private final ArrayList<Operacion> operaciones;
    private Contexto contexto;
    private EstIniciado iniciado;

    public EstPausado(OpActualizar actualizar,
                   ArrayList<Operacion> operaciones){
        this.actualizar = actualizar;
        this.operaciones = operaciones;
    }
    
    public void setContextoEstados(Contexto contexto, EstIniciado iniciado){
        this.iniciado = iniciado;
        this.contexto = contexto;
    }

    @Override
    public void procesar(String orden) {
        if(orden.equals("Iniciar")){
            operaciones.add(actualizar);
            contexto.setEstado(iniciado);
        } else {
            System.out.println(orden + ", orden no ejecutable");
        }
    }
    
}

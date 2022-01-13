package concreto.estados;

import abstracto.interfaces.Estado;
import abstracto.interfaces.Operacion;
import concreto.operaciones.OpActualizar;
import java.util.ArrayList;
import abstracto.interfaces.Contexto;

public class EstIniciado implements Estado {
    
    private final ArrayList<Operacion> operaciones;
    private final OpActualizar actualizar;
    private Contexto contexto;
    private EstPausado pausado;
    
    public EstIniciado(OpActualizar actualizar,
                    ArrayList<Operacion> operaciones){
        this.actualizar = actualizar;
        this.operaciones = operaciones;
    }
    
    public void setContextoEstados(Contexto contexto, EstPausado pausado){
        this.pausado = pausado;
        this.contexto = contexto;
    }
    
    @Override
    public void procesar(String orden) {
        if (orden.equals("Pausar")){
            operaciones.remove(actualizar);
            contexto.setEstado(pausado);
        } else {
            System.out.println(orden + ", orden no ejecutable");
        }
    }

}

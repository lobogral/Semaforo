package concreto.operaciones;

import abstracto.interfaces.Encendido;
import abstracto.interfaces.Operacion;

public class OpActualizar implements Operacion {
    
    private final Encendido bombilloRojo;
    private final Encendido bombilloAmarillo;
    private final Encendido bombilloVerde;
    private int recorrido;
    
    public OpActualizar(Encendido bombilloRojo, 
                        Encendido bombilloAmarillo, 
                        Encendido bombilloVerde){
        this.bombilloRojo = bombilloRojo;
        this.bombilloAmarillo = bombilloAmarillo;
        this.bombilloVerde = bombilloVerde;
        this.recorrido = 0;
    }
    
    @Override
    public void realizar() {    
        switch (recorrido){
            case 0:
                bombilloRojo.setEncendido(true);
                break;
            case 50:
                bombilloRojo.setEncendido(false);
                bombilloAmarillo.setEncendido(true);
                break;
            case 55:
                bombilloAmarillo.setEncendido(false);
                bombilloVerde.setEncendido(true);
                break;
            case 90:
                bombilloVerde.setEncendido(false);
                bombilloAmarillo.setEncendido(true);
                break;
            case 95:
                bombilloAmarillo.setEncendido(false);
                bombilloRojo.setEncendido(true);
                break;
            default:
                break;
        }
        recorrido = recorrido == 100 ? 0 : recorrido + 1;
    }
    
    public void apagar(){
        bombilloRojo.setEncendido(false);
        bombilloAmarillo.setEncendido(false);
        bombilloVerde.setEncendido(false);
        recorrido = 0;
    }
    
}

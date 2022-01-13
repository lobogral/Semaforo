package concreto.operaciones;

import abstracto.logica.Bombillo;
import abstracto.interfaces.Operacion;

public class OpActualizar implements Operacion {
    
    private final Bombillo bombilloRojo;
    private final Bombillo bombilloAmarillo;
    private final Bombillo bombilloVerde;
    private int recorrido;
    
    public OpActualizar(Bombillo bombilloRojo, 
                        Bombillo bombilloAmarillo, 
                        Bombillo bombilloVerde){
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
    
}

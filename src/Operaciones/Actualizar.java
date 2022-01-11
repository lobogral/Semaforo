package Operaciones;

import Logica.Bombillo;
import Logica.Operacion;

public class Actualizar implements Operacion {
    
    private final Bombillo bombilloRojo;
    private final Bombillo bombilloAmarillo;
    private final Bombillo bombilloVerde;
    private boolean activado;
    private int recorrido;
    
    public Actualizar(Bombillo bombilloRojo, 
                      Bombillo bombilloAmarillo, 
                      Bombillo bombilloVerde){
        this.bombilloRojo = bombilloRojo;
        this.bombilloAmarillo = bombilloAmarillo;
        this.bombilloVerde = bombilloVerde;
        this.recorrido = 0;
    }
    
    @Override
    public void realizar() {
        if (activado){
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
           
    public void setActivado(boolean activado){
        this.activado = activado;
    }
    
}

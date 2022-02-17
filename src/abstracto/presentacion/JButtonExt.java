package abstracto.presentacion;

import abstracto.interfaces.Contexto;
import javax.swing.JButton;

public class JButtonExt extends JButton{
    
    private final Object cerrojo;
    private final Contexto contexto;
    
    public JButtonExt(int posX, 
                      int posY, 
                      String nombre,
                      Object cerrojo,
                      Contexto contexto){
        this.contexto = contexto;
        this.cerrojo = cerrojo;
        setText(nombre);
        setBounds(posX, posY, 80, 30);
    }
    
    public void ejecutar(){
        synchronized(cerrojo){
            contexto.solicitar(getText());
        }
    }
}

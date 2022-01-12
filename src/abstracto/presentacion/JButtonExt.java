package abstracto.presentacion;

import abstracto.logica.Click;
import javax.swing.JButton;

public class JButtonExt extends JButton{
    
    private final Click oprimir;
    private final Object cerrojo;
    
    public JButtonExt(int posX, 
                      int posY, 
                      Click oprimir, 
                      Object cerrojo){
        this.oprimir = oprimir;
        this.cerrojo = cerrojo;
        setText(oprimir.getNombre());
        setBounds(posX, posY, 80, 23);
    }
    
    public void ejecutar(){
        synchronized(cerrojo){
            oprimir.ejecutar();
        }
    }
}

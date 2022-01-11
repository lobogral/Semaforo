package abstracto.presentacion;

import abstracto.logica.Click;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class JButtonExt extends JButton{
    
    private final Click oprimir;
    
    public JButtonExt(int posX, int posY, Click oprimir, ActionListener actionListener){
        this.oprimir = oprimir;
        setText(oprimir.getNombre());
        setBounds(posX, posY, 80, 23);
        addActionListener(actionListener);
    }
    
    public void ejecutar(){
        oprimir.ejecutar();
    }
}

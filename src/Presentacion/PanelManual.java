package Presentacion;


import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class PanelManual extends JPanel {
    
    private final JCheckBox jcbRojo;
    private final JCheckBox jcbAmarillo;
    private final JCheckBox jcbVerde;
    
    public PanelManual(){
        
        this.setBorder(BorderFactory.createTitledBorder("Colores"));
        this.setLayout(new GridLayout(3, 1));
        this.setVisible(false);
        this.setEnabled(false);

        jcbRojo = new JCheckBox();
        jcbRojo.setText("Rojo");
        this.add(jcbRojo);

        jcbAmarillo = new JCheckBox();
        jcbAmarillo.setText("Amarillo");
        this.add(jcbAmarillo);

        jcbVerde = new JCheckBox();
        jcbVerde.setText("Verde");
        this.add(jcbVerde);
        
        this.setBounds(260, 140, 130, 180);

    }
    
    public void addActionListener(ActionListener actionListener) {
        jcbRojo.addActionListener(actionListener);
        jcbAmarillo.addActionListener(actionListener);
        jcbVerde.addActionListener(actionListener);
    }
    
    public boolean isSelectedJcbRojo(){
        return jcbRojo.isSelected();
    }
    
    public boolean isSelectedJcbAmarillo(){
        return jcbAmarillo.isSelected();
    }
    
    public boolean isSelectedJcbVerde(){
        return jcbVerde.isSelected();
    }
    
}

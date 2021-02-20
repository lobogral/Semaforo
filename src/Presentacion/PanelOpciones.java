package Presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelOpciones extends JPanel {
    
    private final JRadioButton btnAutomatico;
    private final JRadioButton btnManual;
    
    public PanelOpciones(){

        this.setBorder(BorderFactory.createTitledBorder("Opciones"));
        this.setLayout(new GridLayout(2, 1));
        
        this.setBounds(260, 30, 130, 100);
        
        btnAutomatico = new JRadioButton("Automatico", true);
        btnManual = new JRadioButton("Manual", false);
        
        ButtonGroup grpBotones = new ButtonGroup();
        grpBotones.add(btnAutomatico);
        grpBotones.add(btnManual);
        
        this.add(btnAutomatico);
        this.add(btnManual);
    }
    
    
    public void addActionListener(ActionListener actionListener) {
        btnAutomatico.addActionListener(actionListener);
        btnManual.addActionListener(actionListener);
    }
    
}

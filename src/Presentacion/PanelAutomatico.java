package Presentacion;

import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelAutomatico extends JPanel {
    
    private final JButton btnIniciar;
    private final JButton btnDetener;
    private final JButton btnVel;
    
    public PanelAutomatico(){

        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(null);

        btnIniciar = new JButton();
        btnIniciar.setText("Iniciar");
        this.add(btnIniciar);
        btnIniciar.setBounds(20, 20, 80, 23);

        btnDetener = new JButton();
        btnDetener.setText("Detener");
        this.add(btnDetener);
        btnDetener.setBounds(20, 80, 80, 23);

        btnVel = new JButton();
        btnVel.setText("Velocidad");
        this.add(btnVel);
        btnVel.setBounds(20, 140, 80, 23);

        
        this.setBounds(260, 140, 130, 180);
    }

    public void addActionListener(ActionListener actionListener) {
        btnIniciar.addActionListener(actionListener);
        btnDetener.addActionListener(actionListener);
        btnVel.addActionListener(actionListener);
    }
    
}

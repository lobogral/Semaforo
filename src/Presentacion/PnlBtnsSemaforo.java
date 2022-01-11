package Presentacion;

import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PnlBtnsSemaforo extends JPanel {
    
    private final JButton btnIniciar;
    private final JButton btnDetener;
    
    public PnlBtnsSemaforo(){

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
        
        this.setBounds(260, 30, 130, 300);
    }

    public void addActionListener(ActionListener actionListener) {
        btnIniciar.addActionListener(actionListener);
        btnDetener.addActionListener(actionListener);
    }
    
}

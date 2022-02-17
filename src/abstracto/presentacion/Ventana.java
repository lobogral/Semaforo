package abstracto.presentacion;

import abstracto.interfaces.Contexto;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Ventana extends JFrame implements ActionListener {

    public Ventana(Canvas lienzoSemaforo, String[] nombresBotones, Contexto contexto, Object cerrojo) {

        //Define el panel de los botones
        JPanel pnlBotones = new JPanel();
        pnlBotones.setBorder(BorderFactory.createEtchedBorder());
        pnlBotones.setLayout(null);

        JButtonExt jButtonExt;
        ActionListener actionListener = this;
        int cont = 20;
        for (String nombreBoton : nombresBotones) {
            jButtonExt = new JButtonExt(20, cont, nombreBoton, cerrojo, contexto);
            jButtonExt.addActionListener(actionListener);
            pnlBotones.add(jButtonExt);
            cont += 60;
        }
        
        getContentPane().add(pnlBotones);
        pnlBotones.setBounds(260, 30, 130, 300);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        pack();
        
        //Opciones de la ventana
        this.setBounds(30, 30, 430, 400);
        this.setTitle("Semaforo");
        this.setVisible(true);
        
        // Acciones respecto al canvas del semaforo y al panel de botones
        getContentPane().add(lienzoSemaforo);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButtonExt btnExt = (JButtonExt)(e.getSource());
        btnExt.ejecutar();
    }
}
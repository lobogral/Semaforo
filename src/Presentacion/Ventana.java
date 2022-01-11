package Presentacion;

import Operaciones.Actualizar;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class Ventana extends JFrame implements ActionListener {

    private PnlBtnsSemaforo pnlBtnsSemaforo;
    private final Actualizar actualizar;

    public Ventana(Canvas lienzoSemaforo, Actualizar actualizar) {
        this.actualizar = actualizar;
        initComponents();
        capturarEventos();
        // Acciones respecto al canvas del semaforo
        getContentPane().add(lienzoSemaforo);
    }

    private void initComponents() {
        
        //Establece el lookAndFeel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException 
                 | IllegalAccessException 
                 | InstantiationException 
                 | UnsupportedLookAndFeelException ex) {
            System.out.println("No se puede implementar LookAndFeel");
        }
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        //Inicio panel de la barra de tiempo y subelementos   
        
        JPanel pnlPbrRecorrido = new JPanel();
        pnlPbrRecorrido.setLayout(null);

        getContentPane().add(pnlPbrRecorrido);

        // Inicio sobre panel opciones y subelementos       
        pnlBtnsSemaforo = new PnlBtnsSemaforo();
        getContentPane().add(pnlBtnsSemaforo);        

        pack();
        
        //Opciones de la ventana
        this.setBounds(30, 30, 430, 480);
        this.setTitle("Semaforo");
        this.setVisible(true);
        
    }   
    
    private void capturarEventos(){
        ActionListener actionListener = this;
        pnlBtnsSemaforo.addActionListener(actionListener);
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        /**
         * Opciones secundarias con los botones automaticos
         */
        if (comando.equals("Iniciar")) {
            actualizar.setActivado(true);
        }
        if (comando.equals("Detener")) {
            actualizar.setActivado(false);
        }
    }
}
package Presentacion;

import Logica.Semaforo;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class Ventana extends JFrame implements ActionListener {

    private PanelAutomatico pnlAutomatico;
    private PanelManual pnlManual;
    private PanelOpciones pnlOpciones;
    private final Semaforo semaforo;
    private Canvas lienzoSemaforo;
    private JProgressBar pbrCiclo;

    public Ventana() {
        initComponents();
        capturarEventos();
        semaforo = new Semaforo(this);
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
        } catch (Exception ex) {
            System.out.println("No se puede implementar LookAndFeel");
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        //Inicio panel de la barra de tiempo y subelementos   
        
        JPanel pnlPbrRecorrido = new JPanel();
        pnlPbrRecorrido.setLayout(null);

        pbrCiclo = new JProgressBar();
        pbrCiclo.setFont(new Font("Tahoma", 0, 18));
        pbrCiclo.setOpaque(true);
        pbrCiclo.setStringPainted(true);
        pbrCiclo.setMaximum(100);
        pnlPbrRecorrido.add(pbrCiclo);
        pbrCiclo.setBounds(10, 30, 340, 50);

        getContentPane().add(pnlPbrRecorrido);
        pnlPbrRecorrido.setBounds(20, 320, 360, 100);

        // Inicio sobre panel opciones y subelementos
        
        pnlOpciones = new PanelOpciones();
        getContentPane().add(pnlOpciones);
        
        pnlAutomatico = new PanelAutomatico();
        getContentPane().add(pnlAutomatico);

        pnlManual = new PanelManual();
        getContentPane().add(pnlManual);
        
        
        // Acciones respecto al canvas del semaforo
        
        lienzoSemaforo = new Canvas();
        getContentPane().add(lienzoSemaforo);
        lienzoSemaforo.setBounds(30, 30, 200, 300);

        pack();
        
        //Opciones de la ventana
        this.setBounds(30, 30, 430, 480);
        this.setTitle("Semaforo");
        this.setVisible(true);
        
    }   
    
    private void capturarEventos(){
        ActionListener actionListener = this;
        pnlOpciones.addActionListener(actionListener);
        pnlManual.addActionListener(actionListener);
        pnlAutomatico.addActionListener(actionListener);
    }

    public Canvas getLienzoSemaforo() {
        return lienzoSemaforo;
    }

    public void setNumPbrRecorrido(int tiempoActual){
        if(tiempoActual>=1){
            pbrCiclo.setValue(tiempoActual);
            pbrCiclo.setString(tiempoActual + "%");
        } else {
            pbrCiclo.setValue(0);
        }
    } 
     
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        /**
         * Nota: Los botones Automático y manual son 
         * los mas importantes del programa
         */
        if(comando.equals("Automatico")){
            pnlManual.setVisible(false);
            pnlManual.setEnabled(false);
            pnlAutomatico.setVisible(true);
            pnlAutomatico.setEnabled(true);
            semaforo.setAutomatico(true);
        }
        if(comando.equals("Manual")){
            pnlManual.setVisible(true);
            pnlManual.setEnabled(true);
            pnlAutomatico.setVisible(false);
            pnlAutomatico.setEnabled(false);
            semaforo.setAutomatico(false);
        }
        /**
         * Opciones secundarias con los botones manuales
         */
        if (comando.equals("Rojo")) {
            semaforo.setColorBombillo(Color.RED, pnlManual.isSelectedJcbRojo());
        }
        if (comando.equals("Amarillo")) {
            semaforo.setColorBombillo(Color.YELLOW, pnlManual.isSelectedJcbAmarillo());
        }
        if (comando.equals("Verde")) {
            semaforo.setColorBombillo(Color.GREEN, pnlManual.isSelectedJcbVerde());
        }
        /**
         * Opciones secundarias con los botones automaticos
         */
        if (comando.equals("Iniciar")) {
            semaforo.setActivado(true);
        }
        if (comando.equals("Detener")) {
            semaforo.setActivado(false);
        }
        if (comando.equals("Velocidad")) {
            String datoString = JOptionPane.showInputDialog("¿A que velocidad quiere el semaforo?"
                + "\n entre menor sea el numero, mas rapido es"
                + "\n se cuenta en milisegundos");
            semaforo.setUniTiempo(Integer.parseInt(datoString));
        }

    }

}
package Presentacion;

import Logica.Semaforo;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class Ventana extends JFrame implements ActionListener {

    private final Semaforo semaforo;
    private JCheckBox btnRojo;
    private JCheckBox btnAmarillo;
    private JCheckBox btnVerde;
    private JButton btnPlay;
    private JButton btnStop;
    private JButton btnConf;
    private Canvas lienzoSemaforo;
    private JProgressBar pbrRecorrido;
    private JPanel pnlAutomatico;
    private JPanel pnlManual;
    private JRadioButton btnAutomatico;
    private JRadioButton btnManual;

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

        // Inicio panel automatico y subelementos
        
        pnlAutomatico = new JPanel();
        pnlAutomatico.setBorder(BorderFactory.createEtchedBorder());
        pnlAutomatico.setLayout(null);

        btnPlay = new JButton();
        btnPlay.setText("Play");
        pnlAutomatico.add(btnPlay);
        btnPlay.setBounds(20, 20, 70, 23);

        btnStop = new JButton();
        btnStop.setText("Stop");
        pnlAutomatico.add(btnStop);
        btnStop.setBounds(20, 80, 70, 23);

        btnConf = new JButton();
        btnConf.setText("Tiempo");
        pnlAutomatico.add(btnConf);
        btnConf.setBounds(20, 140, 69, 23);

        getContentPane().add(pnlAutomatico);
        pnlAutomatico.setBounds(260, 140, 110, 180);

        //Inicio panel de la barra de tiempo y subelementos   
        
        JPanel pnlPbrRecorrido = new JPanel();
        pnlPbrRecorrido.setLayout(null);

        pbrRecorrido = new JProgressBar();
        pbrRecorrido.setFont(new Font("Tahoma", 0, 18));
        pbrRecorrido.setOpaque(true);
        pbrRecorrido.setStringPainted(true);
        pbrRecorrido.setMaximum(100);
        pnlPbrRecorrido.add(pbrRecorrido);
        pbrRecorrido.setBounds(10, 30, 340, 50);

        getContentPane().add(pnlPbrRecorrido);
        pnlPbrRecorrido.setBounds(20, 320, 360, 100);

        // Inicio sobre panel opciones y subelementos
        
        JPanel pnlOpciones = new JPanel();
        pnlOpciones.setBorder(BorderFactory.createTitledBorder("Opciones"));
        pnlOpciones.setLayout(new GridLayout(2, 1));
        getContentPane().add(pnlOpciones);
        pnlOpciones.setBounds(260, 30, 110, 100);
        
        btnAutomatico = new JRadioButton("Automatico", true);
        btnManual = new JRadioButton("Manual", false);
        
        ButtonGroup grpBotones = new ButtonGroup();
        grpBotones.add(btnAutomatico);
        grpBotones.add(btnManual);
        
        pnlOpciones.add(btnAutomatico);
        pnlOpciones.add(btnManual);

        // Inicio panel Manual y subelementos
        
        pnlManual = new JPanel();
        pnlManual.setBorder(BorderFactory.createTitledBorder("Colores"));
        pnlManual.setLayout(new GridLayout(3, 1));
        pnlManual.setVisible(false);
        pnlManual.setEnabled(false);

        btnRojo = new JCheckBox();
        btnRojo.setText("Rojo");
        pnlManual.add(btnRojo);

        btnAmarillo = new JCheckBox();
        btnAmarillo.setText("Amarillo");
        pnlManual.add(btnAmarillo);

        btnVerde = new JCheckBox();
        btnVerde.setText("Verde");
        pnlManual.add(btnVerde);

        getContentPane().add(pnlManual);
        pnlManual.setBounds(260, 140, 110, 180);
        
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
        //Intrucciones principales
        btnAutomatico.addActionListener(this);
        btnManual.addActionListener(this);
        //Instrucciones secundarias de Manual
        btnRojo.addActionListener(this);
        btnAmarillo.addActionListener(this);
        btnVerde.addActionListener(this);
        //Instrucciones secundarias del Automatico
        btnPlay.addActionListener(this);
        btnStop.addActionListener(this);
        btnConf.addActionListener(this);
    }

    public Canvas getLienzoSemaforo() {
        return lienzoSemaforo;
    }

    public void setNumPbrRecorrido(int tiempoActual){
        if(tiempoActual>=1){
            pbrRecorrido.setValue(tiempoActual);
            pbrRecorrido.setString(tiempoActual + "%");
        } else {
            pbrRecorrido.setValue(0);
        }
    } 
     
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Nota: Los botones Automático y manual son 
         * los mas importantes del programa
         */
        if(e.getSource() == btnAutomatico){
            pnlManual.setVisible(false);
            pnlManual.setEnabled(false);
            pnlAutomatico.setVisible(true);
            pnlAutomatico.setEnabled(true);
            semaforo.setAutomatico(true);
        }
        if(e.getSource()== btnManual){
            pnlManual.setVisible(true);
            pnlManual.setEnabled(true);
            pnlAutomatico.setVisible(false);
            pnlAutomatico.setEnabled(false);
            semaforo.setAutomatico(false);
        }
        /**
         * Opciones secundarias con los botones manuales
         */
        if (e.getSource() == btnRojo) {
            semaforo.setColorBombillo(Color.RED, btnRojo.isSelected());
        }
        if (e.getSource() == btnAmarillo) {
            semaforo.setColorBombillo(Color.YELLOW, btnAmarillo.isSelected());
        }
        if (e.getSource() == btnVerde) {
            semaforo.setColorBombillo(Color.GREEN, btnVerde.isSelected());
        }
        /**
         * Opciones secundarias con los botones automaticos
         */
        if (e.getSource() == btnPlay) {
            semaforo.setActivado(true);
        }
        if (e.getSource() == btnStop) {
            semaforo.setActivado(false);
        }
        if (e.getSource() == btnConf) {
            String datoString = JOptionPane.showInputDialog("¿A que velocidad quiere el semaforo?"
                + "\n entre menor sea el numero, mas rapido es"
                + "\n se cuenta en milisegundos");
            semaforo.setUniTiempo(Integer.parseInt(datoString));
        }

    }

}
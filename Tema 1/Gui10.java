package GUI;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Gui10 extends JFrame implements ChangeListener{
    private ButtonGroup grupoBotones;
    private JRadioButton radio1, radio2, radio3;
    public Gui10(){
        setLayout(null); //Layout absoluto
        setTitle("Ejemplo 10"); //Título del JFrame
        setSize(350, 230); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true); //Mostrar JFrame
        grupoBotones = new ButtonGroup(); 
        
        radio1=new JRadioButton("Tamaño del Jframe 640*480");
        radio1.setBounds(10,20,200,30);
        radio1.addChangeListener((ChangeListener) this);
        add(radio1);
        grupoBotones.add(radio1);
    
        radio2=new JRadioButton("Tamaño del Jframe 800*600");
        radio2.setBounds(10,50,200,30);
        radio2.addChangeListener((ChangeListener) this);
        add(radio2);
        grupoBotones.add(radio2);
        
        radio3=new JRadioButton("Tamaño del Jframe 1024*768");
        radio3.setBounds(10,80,200,30);
        radio3.addChangeListener((ChangeListener) this);
        add(radio3);
        grupoBotones.add(radio3);

    }
    
    
    
    
    
    @Override
   public void stateChanged(ChangeEvent e) {
    if (radio1.isSelected()) {
        setSize(640,480);
        setTitle("Ejemplo 11/640-480");
        this.getContentPane().setBackground(Color.orange);
        }
    if (radio2.isSelected()) {
        setSize(800,600);
        setTitle("Ejemplo 11/800-600");
        this.getContentPane().setBackground(Color.PINK);
        }
    if (radio3.isSelected()) {
        setSize(1024,768);
        setTitle("Ejemplo 11/1024-768");
        this.getContentPane().setBackground(Color.darkGray);
        }
    }
}
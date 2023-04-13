package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;                                                                                                      
import javax.swing.JTextField;
import java.awt.event.ActionListener;

public class Gui12 extends JFrame {
       private JLabel label1,label2,label3,label4;
       private JTextField textfield1,textfield2,textfield3,textfield4;
       
    public Gui12(){
        super("Captura Datos");
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        
        label1 = new JLabel("Nombre");//1
        label1.setBounds(10,10,100,30);
        add(label1);
        textfield1 = new JTextField();
        textfield1.setBounds(80,10,150,30);
        add(textfield1);
        label2= new JLabel("Nombre");//2
        label2.setBounds(10,40,100,30);
        add(label2);
        textfield2 = new JTextField();
        textfield2.setBounds(80,40,150,30);
        add(textfield2);
        label3= new JLabel("Nombre");//3
        label3.setBounds(10,70,100,30);
        add(label3);
        textfield3 = new JTextField();
        textfield3.setBounds(80,70,150,30);
        add(textfield3);
        label4= new JLabel("Nombre");//4
        label4.setBounds(10,100,100,30);
        add(label4);
        textfield4 = new JTextField();
        textfield4.setBounds(80,100,150,30);
        add(textfield4);
        
        JButton boton1= new JButton("Aceptar");
        boton1.setBounds(0, 150, 80, 30);
        add(boton1);
        JButton boton2= new JButton("Mensaje");
        boton2.setBounds(90, 150, 100, 30);
        add(boton2);
        JButton boton3= new JButton("Cancelar");
        boton3.setBounds(200, 150, 90, 30);
        add(boton3);
        /*
        setLayout(new BorderLayout(150,30));
        add(new JButton("Mensaje"),BorderLayout.CENTER);
        add(new JButton("Aceptar"),BorderLayout.SOUTH);
        add(new JButton(""),BorderLayout.WEST);*/
        setVisible(true);}
}

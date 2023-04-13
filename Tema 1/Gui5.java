package GUI;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Gui5  extends JFrame{
    public Gui5(){
        super("Ventana/Herencia");//titulo
       //agrega FlowLayout
       getContentPane().setLayout(new FlowLayout());
       //Intsancian componentes
        JButton boton=new JButton("Boton");
        JLabel etiqueta = new JLabel("Dato");
        JTextField textfield =new JTextField(10);
        JCheckBox checkbox =new JCheckBox("check box");
        
        //Componentes
        getContentPane().add(boton);
        getContentPane().add(etiqueta);
        getContentPane().add(textfield);
        getContentPane().add(checkbox);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();//ventana con tamaño necesario
        setVisible(true);
    }
    
}

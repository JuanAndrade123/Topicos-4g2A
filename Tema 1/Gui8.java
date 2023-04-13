    package GUI;
import IO.Jopi;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

public class Gui8 extends JFrame implements ActionListener {
    private final JButton boton1;
    private final JTextField textfield1;
    private final JLabel label1;
    
    public Gui8(){
    super("Gui8: Activacion Oyente");//
       setLayout(null);
       setSize(300,150);
       setResizable(false);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        //Etiqueta para escribir texto
        label1 = new JLabel("Nombre");
        label1.setBounds(10,10,100,30);
        add(label1);
        
        //campo de texo
        textfield1 = new JTextField();
        textfield1.setBounds(80,10,150,30);
        add(textfield1);
        
        boton1 = new JButton("Aceptar");
        boton1.setBounds(100, 50, 100, 30);
        add(boton1);
        boton1.addActionListener(this);
        
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1){
            Jopi.outMessage("Hola"+textfield1.getText(),"Titulo", Jopi.ERROR_ICON);
        }
    }
}

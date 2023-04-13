package GUI;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui6 extends JFrame{
    //contstantes Y componentes (Objetos)
    public Gui6(){
        super("Ventana/Herencia");
        getContentPane().setLayout(new GridLayout(4,3,5,5));
        for(int i=1; i<=10;i++)
            add(new JButton(Integer.toString(i)));
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}

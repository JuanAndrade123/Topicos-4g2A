package Media;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pictures {

    private Icon [] imagenes = new ImageIcon[10];
    
    private String [] url = {"/Media/Images/1.png",
                         "/Media/Images/2.png",
                         "/Media/Images/3.jpg",
                         "/Media/Images/4.png",
                         "/Media/Images/5.png",
                         "/Media/Images/6.png",
                         "/Media/Images/7.png",
                         "/Media/Images/8.png",
                         "/Media/Images/9.jpg",
                         "/Media/Images/10.png"};
    
    public Pictures (JLabel ajuste) {
        // Mezclar las imagenes
        for (int i = 0; i < 10; i++)
            imagenes[i] = new ImageIcon(new ImageIcon(getClass().getResource(url[i])).getImage()
                .getScaledInstance(ajuste.getWidth(), ajuste.getHeight(), 0));
    }
        
    public Icon getIcon (int i) {
        return imagenes[i];
    }
    
    public void mezclar(int indice1, int indice2) {
        Icon aux = imagenes[indice1];
        imagenes[indice1] = imagenes[indice2];
        imagenes[indice2] = aux;
    }
    
}

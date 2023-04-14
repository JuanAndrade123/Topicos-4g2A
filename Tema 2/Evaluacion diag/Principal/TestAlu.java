package Principal;
import EntradaSalida.Almacenar;
import javax.swing.JOptionPane;

public class TestAlu {
    
    public static void MenuA(){
       Almacenar obj=new Almacenar(15);
        byte op=0;
        do{
            op=Byte.parseByte(JOptionPane.showInputDialog(null,"""
                                                          1) Agregar alumno
                                                          2) Ver objetos
                                                          3) Ordenar
                                                          4) Salir
                                                          """));
            switch(op){
                case 1 -> obj.agregarObj();
                
                case 2 -> {
                    if (obj.arrayV())System.out.println("Arreglo vacio");
                    else obj.verObj();}
                
                case 3-> obj.ordenar();
                
                
                case 4 -> op=4;        
                
                default -> System.out.println("Vaalor invalido");
                
            }}while ((byte)op!=4);
        
        }
    
     public static void main(String[]args){
         MenuA();}
}

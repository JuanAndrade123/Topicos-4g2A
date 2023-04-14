package EntradaSalida;
import IO.Jopi;
public class MetodoL {
    
    public static String Nom(String msj){
       String name;
        while (true) {
            name = Jopi.inString(msj, "NOMBRE", Jopi.NO_ICON);
            if (validarNom(name))
                return name;
            else
                Jopi.outMessage("Contiene Caracteres no Validos", "ERROR", Jopi.ERROR_ICON);
        }
    }
    private static boolean validarNom (String name) {
        return (name != null && name.trim().matches("([a-z A-Z]|\\s)+"));
    }
    
     public static String NoC(String msg) {
        String noCtrl;
        while (true) {
            noCtrl = Jopi.inString(msg, "NUMERO DE CONTROL", Jopi.NO_ICON);
            if (validarNC(noCtrl))
                return noCtrl;
            else
                Jopi.outMessage("Invalido", "ERROR", Jopi.ERROR_ICON);
        }
    }
    private static boolean validarNC(String noCtrl) {
        return (noCtrl != null && noCtrl.matches("[0-9]{8}"));
    }
  
    
   
    public static byte Semestre(){
        String valores[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
        return convert(Jopi.listObject("SEMESTRE", "SELECCIONE", Jopi.NO_ICON, valores));
    }
    
    private static byte convert(Object object) {
        return  Byte.parseByte(String.valueOf(object));
    }
    

    public static byte Edad(String msj) {
        byte edad;
        while (true) {
            edad = Jopi.inByte(msj, "EDAD", Jopi.NO_ICON);
            if (validarEd(edad))
                return edad;
            else
                Jopi.outMessage("El rango de edad es invalida", "ERROR", Jopi.ERROR_ICON);
        }
    }
    private static boolean validarEd (byte age) {
        return (age >= 17 && age <= 40);
    }
}

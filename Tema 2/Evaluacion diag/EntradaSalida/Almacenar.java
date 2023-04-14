package EntradaSalida;
import TDA.Alumno;

public class Almacenar {
    private Alumno alu[];
    private byte i;
    
    public Almacenar(int tam){
    alu=new Alumno [tam];
    i=-1;
    }
    
    public boolean arrayV(){
        return (i==-1);
    }
    private Alumno crearA(){
        Alumno aux= new Alumno();
        aux.setNc(MetodoL.NoC("Ingrese el num de control:"));
        aux.setNom(MetodoL.Nom("Ingrese un nombre:"));
        aux.setSem(MetodoL.Semestre());
        aux.setEdad(MetodoL.Edad("Ingrese edad:"));
        return aux;
    }
    public void agregarObj(){
        if (i<alu.length){
        alu[++i]=crearA();
            }else {
                System.out.println("Array lleno");}
    }
    
    public void verObj(){
        String cad="";
        for(byte j=0;j<=i;j++){
            cad+=alu[j].toString()+"\n";
        }
        System.out.println("Datos de alumnos: \n"+cad);
    }
    
    public void ordenar(){
    Alumno aux=new Alumno();
        for (int j = 0; j <=i; j++) {
            int num1=Integer.parseInt(alu[j].getNc());
            for (int k=j+1; k <= i; k++) {
               int num2=Integer.parseInt(alu[k].getNc());
                if(num1<num2){
                aux=alu[j];
                alu[j]=alu[k];
                alu[k]=aux;
                }
            }
        }
    }
}
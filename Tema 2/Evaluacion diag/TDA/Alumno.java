package TDA;
public class Alumno {
    private String nc;
    private String nom;
    private byte sem;
    private byte edad;

    public Alumno(String nc, String nom, byte sem, byte edad) {
        this.nc = nc;
        this.nom = nom;
        this.sem = sem;
        this.edad = edad;
    }    public Alumno() {}
    
    
    public String getNc() {
        return nc;
    }public void setNc(String nc) {
        this.nc = nc;}

    public String getNom() {
        return nom;
    }public void setNom(String nom) {
        this.nom = nom;}

    public byte getSem() {
        return sem;
    }public void setSem(byte sem) {
        this.sem = sem;}

    public byte getEdad() {
        return edad;
    }public void setEdad(byte edad) {
        this.edad = edad;}

    @Override
    public String toString() {
        return "{" + "NumCtrl=" + nc + ", Nombre=" + nom + ", Semestre=" + sem + ", Edad=" + edad + '}';
    }  
}
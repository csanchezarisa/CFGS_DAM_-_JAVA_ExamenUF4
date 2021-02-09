package assets.weapon;

public class Weapon {

    private String nom;
    private double potenciaAtac;

    public Weapon(String nom, double potenciaAtac) {
        this.nom = nom;
        this.potenciaAtac = potenciaAtac;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPotenciaAtac() {
        return potenciaAtac;
    }

    public void setPotenciaAtac(double potenciaAtac) {
        this.potenciaAtac = potenciaAtac;
    }
}

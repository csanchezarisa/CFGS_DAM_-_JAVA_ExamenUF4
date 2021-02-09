package assets.personatge;

import assets.weapon.Weapon;

import java.util.Scanner;

public abstract class Personatge {

    protected static Scanner teclat = new Scanner(System.in);

    protected String nom;
    protected FaccioEnum faccio;
    protected double potenciaAtac;
    protected int numeroArmes;
    protected Weapon[] armes;

    public Personatge(String nom, FaccioEnum faccio, double potenciaAtac, int numeroArmes, Weapon[] armes) {
        this.nom = nom;
        this.faccio = faccio;
        this.potenciaAtac = potenciaAtac;
        this.numeroArmes = numeroArmes;
        this.armes = armes;
    }

    public Personatge(FaccioEnum faction) {
        this.faccio = faction;
        teclat = new Scanner(System.in);
        System.out.print("Name: ");
        try {
            this.nom = teclat.nextLine();
        }
        catch (Exception e) {
            this.nom = "Nom amb error";
            teclat = new Scanner(System.in);
        }

        System.out.print("Attack power: ");
        try {
            this.potenciaAtac = teclat.nextDouble();
        }
        catch (Exception e) {
            this.potenciaAtac = 0;
            teclat = new Scanner(System.in);
        }

        System.out.print("How many weapons (1-10): ");
        try {
            this.numeroArmes = teclat.nextInt();
        }
        catch (Exception e) {
            this.numeroArmes = 1;
            teclat = new Scanner(System.in);
        }

        if (this.numeroArmes < 1) this.numeroArmes = 1;
        else if (this.numeroArmes > 10) this.numeroArmes = 10;

        armes = new Weapon[this.numeroArmes];
        for (int i = 0; i < this.numeroArmes; i++) {

            String weaponName;
            double weaponPower;
            teclat = new Scanner(System.in);

            System.out.print("Weapon " + (i + 1) + " Name: ");
            try {
                weaponName = teclat.nextLine();
            }
            catch (Exception e) {
                weaponName = "Weapon name with error";
                teclat = new Scanner(System.in);
            }

            System.out.print("Weapon " + (i + 1) + " Attack power: ");
            try {
                weaponPower = teclat.nextDouble();
            }
            catch (Exception e) {
                weaponPower = 1;
                teclat = new Scanner(System.in);
            }

            if (weaponPower < 1) weaponPower = 1;

            armes[i] = new Weapon(weaponName, weaponPower);
        }
    }

    protected double calcularPotenciaWeapons() {
        double potenciaCalculada = 0;

        for (Weapon weapon:
             this.armes) {
            potenciaCalculada += weapon.getPotenciaAtac();
        }

        return potenciaCalculada;
    }

    public abstract double averageAttackPower();

    protected abstract String getRaca();

    public void mostrarInformacio() {
        System.out.println(nom + " is an " + this.getRaca() + " in a " + faccio + " faction");
        System.out.println("Attack power without weapons: " + potenciaAtac);
        for (Weapon weapon:
             armes) {
            System.out.println("Weapon: " + weapon.getNom() + " - " + weapon.getPotenciaAtac());
        }
    }

    public FaccioEnum getFaccio() {
        return faccio;
    }
}

package assets.personatge;

import assets.weapon.Weapon;

import java.util.Scanner;

public class Elf extends Personatge {

    private double magia;

    public Elf(String nom, FaccioEnum faccio, double potenciaAtac, int numeroArmes, Weapon[] armes, double magia) {
        super(nom, faccio, potenciaAtac, numeroArmes, armes);
        this.magia = magia;
    }

    public Elf(FaccioEnum faction) {
        super(faction);

        System.out.print("Magia (0-0,99): ");
        try {
            this.magia = Personatge.teclat.nextDouble();
            if (this.magia < 0 || this.magia > 0.99) throw new Exception("Magia mal introduida");
        }
        catch (Exception e) {
            this.magia = 0;
            Personatge.teclat = new Scanner(System.in);
        }
    }

    @Override
    protected double calcularPotenciaWeapons() {

        double potenciaCalculada = 0;
        for (Weapon weapon:
             this.armes) {
            potenciaCalculada += (weapon.getPotenciaAtac() * (1 + this.magia));
        }

        return potenciaCalculada;
    }

    @Override
    public double averageAttackPower() {
        return this.potenciaAtac + calcularPotenciaWeapons() / this.numeroArmes;
    }

    @Override
    protected String getRaca() {
        return "Elf";
    }

    @Override
    public void mostrarInformacio() {
        super.mostrarInformacio();

        System.out.println("Magia: " + magia);
        System.out.println("Average attack power: " + averageAttackPower());
    }
}

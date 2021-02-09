package assets.personatge;

import assets.weapon.Weapon;

import java.util.Scanner;

public class Huma extends Personatge {

    private boolean inteligencia;

    public Huma(String nom, FaccioEnum faccio, double potenciaAtac, int numeroArmes, Weapon[] armes, boolean inteligencia) {
        super(nom, faccio, potenciaAtac, numeroArmes, armes);
        this.inteligencia = inteligencia;
    }

    public Huma(FaccioEnum faction) {
        super(faction);

        System.out.print("Intel·ligencia (1-Cert 2-Fals): ");
        char option;
        try {
            option = Personatge.teclat.nextLine().charAt(0);
        }
        catch (Exception e) {
            option = '2';
            Personatge.teclat = new Scanner(System.in);
        }

        switch (option) {
            case '1' -> this.inteligencia = true;
            default -> this.inteligencia = false;
        }

    }

    @Override
    public double averageAttackPower() {
        if (this.inteligencia)
            return (this.potenciaAtac * 1.33) + this.calcularPotenciaWeapons() / this.numeroArmes;
        else
            return this.potenciaAtac + this.calcularPotenciaWeapons() / this.numeroArmes;
    }

    @Override
    protected String getRaca() {
        return "Humà";
    }

    @Override
    public void mostrarInformacio() {
        super.mostrarInformacio();

        System.out.print("Intel·ligència: ");
        if (inteligencia)
            System.out.println("Si");
        else
            System.out.println("No");

        System.out.println("Average attack power: " + averageAttackPower());
    }
}

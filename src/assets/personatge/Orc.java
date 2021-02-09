package assets.personatge;

import assets.weapon.Weapon;

import java.util.Scanner;

public class Orc extends Personatge {

    private int tenacitat;

    public Orc(String nom, FaccioEnum faccio, double potenciaAtac, int numeroArmes, Weapon[] armes, int tenacitat) {
        super(nom, faccio, potenciaAtac, numeroArmes, armes);
        this.tenacitat = tenacitat;
    }

    public Orc(FaccioEnum faction) {
        super(faction);

        System.out.print("Tenacitat (1-3): ");
        try {
            this.tenacitat = Personatge.teclat.nextInt();
            if (tenacitat < 1 || tenacitat > 3) throw new Exception("Error tenacitat incorrecte");
        }
        catch (Exception e) {
            this.tenacitat = 1;
            Personatge.teclat = new Scanner(System.in);
        }
    }

    @Override
    public double averageAttackPower() {
        return this.potenciaAtac + ((this.calcularPotenciaWeapons() / this.numeroArmes) * this.tenacitat / 2 );
    }

    @Override
    protected String getRaca() {
        return "Orc";
    }

    @Override
    public void mostrarInformacio() {
        super.mostrarInformacio();

        System.out.println("Tenacitat: " + tenacitat);
        System.out.println("Average attack power: " + averageAttackPower());
    }
}

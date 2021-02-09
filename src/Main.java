import assets.personatge.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Personatge> LlistaPersonatges = new ArrayList<>();
    public static Scanner teclat;

    public static void main(String[] args) throws InterruptedException {
        menuPrincipal();
    }

    private static void menuPrincipal() throws InterruptedException {
        char optionSelected;
        teclat = new Scanner(System.in);

        do {

            netejarPantalla();
            mostrarMenuPrincipal();

            try {
                optionSelected = teclat.nextLine().charAt(0);
            }
            catch (Exception e) {
                optionSelected = ' ';
                teclat = new Scanner(System.in);
            }

            switch (optionSelected) {
                case '1' -> System.out.println("Sortint...");
                case '2' -> insertData();
                case '3' -> showData();
                case '4' -> fight();
                default -> System.out.println("No s'ha trobat l'opció");
            }
            stop();

        }
        while (optionSelected != '1');

    }

    private static void mostrarMenuPrincipal() {
        System.out.println("1. Exit");
        System.out.println("2. Insert data");
        System.out.println("3. Show data in console");
        System.out.println("4. Fight between factions");
        System.out.print("Chose an option: ");
    }

    private static void insertData() {

        char optionSelected;

        do {

            netejarPantalla();
            System.out.println("Vols afegir un nou personatge?");
            System.out.println("\tS -> Si \n\tN -> No");

            try {
                optionSelected = teclat.nextLine().toUpperCase().charAt(0);
            }
            catch (Exception e) {
                optionSelected = ' ';
                teclat = new Scanner(System.in);
            }

            switch (optionSelected) {
                case 'S' -> createNewCharacter();
                case 'N' -> System.out.println("Sortint...");
                default -> System.out.println("No s'ha trobat l'opció escollida");
            }

        }
        while (optionSelected != 'N');

    }

    private static void createNewCharacter() {
        int race;
        int faction;

        try {

            System.out.print("Chose race (1-Human 2-Orc 3-Elf): ");
            race = teclat.nextInt();

            System.out.print("Chose faction (1-Alliance 2-Horde): ");
            faction = teclat.nextInt();

        }
        catch (Exception e) {
            race = 0;
            faction = 0;
            teclat = new Scanner(System.in);
        }

        if (race < 1 || race > 3 || faction < 1 || faction > 2) {
            System.out.println("Error amb les dades introduides!");
            return;
        }

        try {

            FaccioEnum factionEnum;
            switch (faction) {
                case 1 -> factionEnum = FaccioEnum.ALLIANCE;
                case 2 -> factionEnum = FaccioEnum.HORDE;
                default -> throw new Exception("Error selection faction");
            }

            switch (race) {
                case 1 -> LlistaPersonatges.add(new Huma(factionEnum));
                case 2 -> LlistaPersonatges.add(new Orc(factionEnum));
                case 3 -> LlistaPersonatges.add(new Elf(factionEnum));
                default -> throw new Exception("No item selected");
            }
        }
        catch (Exception e) {
            System.out.println("Error " + e);
            return;
        }
    }

    private static void showData() {
        int index = 1;
        for (Personatge personatge:
             LlistaPersonatges) {
            System.out.println("Personatge " + index);
            personatge.mostrarInformacio();
            System.out.println("==========================");
            index++;
        }
    }

    private static void fight() throws InterruptedException {
        double alliancePower = 0;
        double hordePower = 0;

        for (Personatge personatge:
             LlistaPersonatges) {

            switch (personatge.getFaccio()) {
                case ALLIANCE -> alliancePower += personatge.averageAttackPower();
                case HORDE -> hordePower += personatge.averageAttackPower();
            }
        }

        System.out.println("The faction Alliance has " + alliancePower + " of power attack");
        System.out.println("The faction Horde has " + hordePower + " of power attack");
        if (alliancePower > hordePower)
            System.out.println("Alliance win!");
        else if (hordePower > alliancePower)
            System.out.println("Horde win!");
        else
            System.out.println("Tie, nobody wins...");
    }

    private static void netejarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static void stop() throws InterruptedException {
        Thread.sleep(3000);
    }

}

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        if (args.length > 0 && args[0].equals("demo")) { Demo.ejecutar(); return; }

        Scanner in = new Scanner(System.in, "UTF-8");
        System.out.print("Nombre: ");
        String nombre = in.nextLine();

        System.out.println("Clase: 1) Guerrero  2) Mago  3) Arquero  4) Pícaro");
        System.out.print("Clase: ");
        Personaje heroe = elegirCreador(in.nextLine().trim()).crearPersonaje(nombre);

        System.out.println("Equipamiento (separado por comas): 1) Espada  2) Armadura  3) Veneno  4) Amuleto  5) Bendición");
        System.out.print("Equipamiento: ");
        for (String s : in.nextLine().split(",")) heroe = equipar(heroe, s.trim());

        System.out.println("Enemigo: 1) Goblin  2) Orco  3) Dragón");
        System.out.print("Enemigo: ");
        Personaje enemigo = elegirEnemigo(in.nextLine().trim()).crearEnemigo();

        Demo.presentar(heroe, enemigo);
        new MotorCombate().iniciarCombate(heroe, enemigo);
    }

    static CreadorPersonaje elegirCreador(String op) {
        switch (op) {
            case "1": return new CreadorGuerrero();
            case "2": return new CreadorMago();
            case "3": return new CreadorArquero();
            case "4": return new CreadorPicaro();
            default: throw new IllegalArgumentException("Clase inválida: " + op);
        }
    }
    static CreadorEnemigo elegirEnemigo(String op) {
        switch (op) {
            case "1": return new CreadorGoblin();
            case "2": return new CreadorOrco();
            case "3": return new CreadorDragon();
            default: throw new IllegalArgumentException("Enemigo inválido: " + op);
        }
    }
    static Personaje equipar(Personaje p, String op) {
        switch (op) {
            case "1": return new EspadaDecorator(p);
            case "2": return new ArmaduraDecorator(p);
            case "3": return new VenenoDecorator(p);
            case "4": return new AmuletoRegeneracionDecorator(p);
            case "5": return new BendicionDecorator(p);
            case "": return p;
            default: throw new IllegalArgumentException("Objeto inválido: " + op);
        }
    }
}

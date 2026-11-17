public class Demo {
    static void presentar(Personaje heroe, Personaje enemigo) {
        System.out.println("Héroe: " + heroe.getDescripcion());
        System.out.println("ATK: " + heroe.getAtaque() + " | DEF: " + heroe.getDefensa()
                + " | VEL: " + heroe.getVelocidad() + " | HP: " + heroe.getHp());
        System.out.println("Enemigo: " + enemigo.getDescripcion() + " | ATK: " + enemigo.getAtaque()
                + " | DEF: " + enemigo.getDefensa() + " | HP: " + enemigo.getHp());
    }

    static void ejecutar() {
        System.out.println("CORRIDA 1: Mago + Espada + Veneno + Bendición vs Gobli");
        Azar.setSeed(1);
        Personaje h = new CreadorMago().crearPersonaje("Aria");
        h = new EspadaDecorator(h); h = new VenenoDecorator(h); h = new BendicionDecorator(h);
        Personaje e = new CreadorGoblin().crearEnemigo();
        presentar(h, e);
        new MotorCombate().iniciarCombate(h, e);

        System.out.println("\n\nCORRIDA 2: Guerrero + Armadura + Amuleto de regeneración vs Orco ");
        Azar.setSeed(2);
        h = new CreadorGuerrero().crearPersonaje("Thorin");
        h = new ArmaduraDecorator(h); h = new AmuletoRegeneracionDecorator(h);
        e = new CreadorOrco().crearEnemigo();
        presentar(h, e);
        new MotorCombate().iniciarCombate(h, e);

        System.out.println("\n\nCORRIDA 3: Pícaro + Veneno + Espada + Armadura + Bendición vs Dragón ");
        Azar.setSeed(3);
        h = new CreadorPicaro().crearPersonaje("Sombra");
        h = new VenenoDecorator(h); h = new EspadaDecorator(h);
        h = new ArmaduraDecorator(h); h = new BendicionDecorator(h);
        e = new CreadorDragon().crearEnemigo();
        presentar(h, e);
        new MotorCombate().iniciarCombate(h, e);

        System.out.println("\n\n CORRIDA 4: Arquero + Espada + Amuleto vs Goblin");
        Azar.setSeed(4);
        h = new CreadorArquero().crearPersonaje("Legolo");
        h = new EspadaDecorator(h); h = new AmuletoRegeneracionDecorator(h);
        e = new CreadorGoblin().crearEnemigo();
        presentar(h, e);
        new MotorCombate().iniciarCombate(h, e);
    }
}

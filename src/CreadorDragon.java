public class CreadorDragon extends CreadorEnemigo {
    @Override
    public Personaje crearEnemigo() {
        
        Personaje p = new PersonajeBase("Dragón ancestral", 200, 28, 14, 10);
        p.setEstrategia(new AtaqueHechizo());
        return p;
    }
}

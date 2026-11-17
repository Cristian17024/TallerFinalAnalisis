public class CreadorGoblin extends CreadorEnemigo {
    @Override
    public Personaje crearEnemigo() {
        
        Personaje p = new PersonajeBase("Goblin salvaje", 60, 12, 3, 14);
        p.setEstrategia(new AtaquePunalada());
        return p;
    }
}

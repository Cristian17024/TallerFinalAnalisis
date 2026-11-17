public class CreadorOrco extends CreadorEnemigo {
    @Override
    public Personaje crearEnemigo() {
        
        Personaje p = new PersonajeBase("Orco bruto", 110, 18, 8, 8);
        p.setEstrategia(new AtaqueEspada());
        return p;
    }
}

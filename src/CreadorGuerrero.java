public class CreadorGuerrero extends CreadorPersonaje {
    @Override
    public Personaje crearPersonaje(String nombre) {
        validarNombre(nombre);
        Personaje p = new PersonajeBase(nombre, 130, 20, 12, 8);
        p.setEstrategia(new AtaqueEspada());
        return p;
    }
}

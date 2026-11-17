public class CreadorPicaro extends CreadorPersonaje {
    @Override
    public Personaje crearPersonaje(String nombre) {
        validarNombre(nombre);
        Personaje p = new PersonajeBase(nombre, 95, 17, 6, 18);
        p.setEstrategia(new AtaquePunalada());
        return p;
    }
}

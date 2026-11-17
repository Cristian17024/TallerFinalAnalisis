public class CreadorArquero extends CreadorPersonaje {
    @Override
    public Personaje crearPersonaje(String nombre) {
        validarNombre(nombre);
        Personaje p = new PersonajeBase(nombre, 100, 18, 7, 15);
        p.setEstrategia(new AtaqueFlecha());
        return p;
    }
}

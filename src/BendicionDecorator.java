
public class BendicionDecorator extends PersonajeDecorator {
    public BendicionDecorator(Personaje p) { super(p); }
    @Override public int getAtaque() { return (int) (personaje.getAtaque() * 1.15); }
    @Override public int getDefensa() { return (int) (personaje.getDefensa() * 1.15); }
    @Override public int getVelocidad() { return (int) (personaje.getVelocidad() * 1.15); }
    @Override public String getDescripcion() { return personaje.getDescripcion() + " + Bendición"; }
}

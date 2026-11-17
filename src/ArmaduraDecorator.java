public class ArmaduraDecorator extends PersonajeDecorator {
    public ArmaduraDecorator(Personaje p) { super(p); }
    @Override public int getDefensa() { return personaje.getDefensa() + 8; }
    @Override public String getDescripcion() { return personaje.getDescripcion() + " + Armadura"; }
}

/** +5 ataque; modifica atacar(): suma daño extra y aplica DOT al objetivo. */
public class VenenoDecorator extends PersonajeDecorator {
    public VenenoDecorator(Personaje p) { super(p); }
    @Override public int getAtaque() { return personaje.getAtaque() + 5; }

    @Override
    public ResultadoAtaque atacar(Personaje objetivo) {
        ResultadoAtaque r = personaje.atacar(objetivo);
        objetivo.aplicarDot("veneno", 4, 3);   // 4 de daño por turno durante 3 turnos
        return new ResultadoAtaque(r.getDano() + 3, r.isCritico(), r.getEfecto() + " + veneno");
    }
    @Override public String getDescripcion() { return personaje.getDescripcion() + " + Veneno"; }
}

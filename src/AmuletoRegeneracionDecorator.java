import java.util.ArrayList;
import java.util.List;

public class AmuletoRegeneracionDecorator extends PersonajeDecorator {
    public AmuletoRegeneracionDecorator(Personaje p) { super(p); }
    @Override public int getDefensa() { return personaje.getDefensa() + 3; }

    @Override
    public List<String> procesarInicioTurno() {
        List<String> msgs = new ArrayList<>(personaje.procesarInicioTurno());
        if (getHp() > 0) {
            int antes = getHp();
            setHp(antes + 2);
            msgs.add("  [amuleto] " + getNombre() + " regenera 2 HP (" + antes + " -> " + getHp() + ")");
        }
        return msgs;
    }
    @Override public String getDescripcion() { return personaje.getDescripcion() + " + Amuleto"; }
}

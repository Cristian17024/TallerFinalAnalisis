import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonajeBase implements Personaje {
    private final String nombre;
    private int hp;
    private final int ataque;
    private final int defensa;
    private final int velocidad;
    private EstrategiaAtaque estrategia;
    private final List<Dot> dots = new ArrayList<>();

    private static class Dot {
        final String fuente; final int dano; int turnos;
        Dot(String f, int d, int t) { fuente = f; dano = d; turnos = t; }
    }

    public PersonajeBase(String nombre, int hp, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }

    @Override public String getNombre() { return nombre; }
    @Override public int getAtaque() { return ataque; }
    @Override public int getDefensa() { return defensa; }
    @Override public int getVelocidad() { return velocidad; }
    @Override public int getHp() { return hp; }
    @Override public void setHp(int hp) { this.hp = Math.max(0, hp); }
    @Override public EstrategiaAtaque getEstrategia() { return estrategia; }
    @Override public void setEstrategia(EstrategiaAtaque e) { this.estrategia = e; }

    @Override
    public ResultadoAtaque atacar(Personaje objetivo) {
        return estrategia.atacar(this, objetivo);
    }

    @Override
    public String getDescripcion() { return nombre + " (base)"; }

    @Override
    public void aplicarDot(String fuente, int dano, int turnos) {
        for (Dot d : dots) {
            if (d.fuente.equals(fuente)) { d.turnos = turnos; return; } // refresca
        }
        dots.add(new Dot(fuente, dano, turnos));
    }

    @Override
    public List<String> procesarInicioTurno() {
        List<String> msgs = new ArrayList<>();
        Iterator<Dot> it = dots.iterator();
        while (it.hasNext()) {
            Dot d = it.next();
            int antes = hp;
            setHp(hp - d.dano);
            msgs.add("  [" + d.fuente + "] " + nombre + " sufre " + d.dano
                    + " de daño continuo (HP " + antes + " -> " + hp + ")");
            if (--d.turnos <= 0) it.remove();
        }
        return msgs;
    }
}

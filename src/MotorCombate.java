import java.util.List;

public class MotorCombate {
    private final Bitacora bitacora = new Bitacora();

    public Bitacora getBitacora() { return bitacora; }

    public void iniciarCombate(Personaje heroe, Personaje enemigo) {
        System.out.println("Pelea");
        // El más rápido actúa primero (empate: el héroe)
        Personaje primero = enemigo.getVelocidad() > heroe.getVelocidad() ? enemigo : heroe;
        Personaje segundo = primero == heroe ? enemigo : heroe;
        System.out.println("Iniciativa: " + primero.getNombre() + " (VEL " + primero.getVelocidad() + ")");

        int turno = 1, jugados = 0;
        while (heroe.getHp() > 0 && enemigo.getHp() > 0 && turno <= 100) {
            System.out.println("\nTurno De: " + turno );
            jugados = turno;
            ejecutarTurno(primero, segundo);
            if (heroe.getHp() <= 0 || enemigo.getHp() <= 0) break;
            ejecutarTurno(segundo, primero);
            turno++;
        }
        bitacora.setTurnos(jugados);
        System.out.println("\nSe ah terminado");
        Personaje ganador = heroe.getHp() > 0 ? heroe : enemigo;
        System.out.println("Ganador: " + ganador.getDescripcion() + " (HP restante: " + ganador.getHp() + ")");
        bitacora.imprimirResumen(ganador.getNombre());
    }

    private void ejecutarTurno(Personaje atacante, Personaje defensor) {
        List<String> efectos = atacante.procesarInicioTurno();
        efectos.forEach(System.out::println);
        if (atacante.getHp() <= 0) {
            System.out.println("  " + atacante.getNombre() + " cae por los efectos continuos.");
            return;
        }
        ResultadoAtaque r = atacante.atacar(defensor);
        System.out.println(atacante.getDescripcion() + " usa "
                + atacante.getEstrategia().getClass().getSimpleName() + " sobre " + defensor.getNombre());
        System.out.println("  Daño: " + r.getDano() + (r.isCritico() ? " (¡CRÍTICO!)" : "")
                + " | Efecto: " + r.getEfecto());
        int antes = defensor.getHp();
        defensor.setHp(antes - r.getDano());
        System.out.println("  " + defensor.getNombre() + " HP: " + antes + " -> " + defensor.getHp());
        bitacora.registrar(atacante.getNombre(), r);
    }
}

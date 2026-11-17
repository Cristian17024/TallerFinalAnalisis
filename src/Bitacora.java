import java.util.LinkedHashMap;
import java.util.Map;

public class Bitacora {
    private final Map<String, int[]> stats = new LinkedHashMap<>(); // {dañoTotal, golpes, críticos}
    private int turnos;

    public void registrar(String quien, ResultadoAtaque r) {
        int[] s = stats.computeIfAbsent(quien, k -> new int[3]);
        s[0] += r.getDano(); s[1]++; if (r.isCritico()) s[2]++;
    }
    public void setTurnos(int t) { turnos = t; }

    public void imprimirResumen(String ganador) {
        System.out.println("\nResultados finales");
        System.out.println("Turnos jugados: " + turnos);
        for (Map.Entry<String, int[]> e : stats.entrySet()) {
            int[] s = e.getValue();
            System.out.println(e.getKey() + ": daño directo total=" + s[0] + ", ataques=" + s[1] + ", críticos=" + s[2]);
        }
        System.out.println("*** VICTORIA: " + ganador + " ***");
    }
}

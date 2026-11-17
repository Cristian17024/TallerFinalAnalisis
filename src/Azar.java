import java.util.Random;

public final class Azar {
    private static Random rnd = new Random();
    private Azar() {}
    public static void setSeed(long seed) { rnd = new Random(seed); }
    public static boolean probabilidad(int porcentaje) { return rnd.nextInt(100) < porcentaje; }
}

public class AtaqueHechizo implements EstrategiaAtaque {
    @Override
    public ResultadoAtaque atacar(Personaje a, Personaje o) {
        boolean crit = Azar.probabilidad(10);
        int base = Math.max(1, (int) (a.getAtaque() * 1.2) - o.getDefensa() / 4); // casi ignora la defensa
        return new ResultadoAtaque(crit ? base * 2 : base, crit, "hechizo");
    }
}

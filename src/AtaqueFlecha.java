public class AtaqueFlecha implements EstrategiaAtaque {
    @Override
    public ResultadoAtaque atacar(Personaje a, Personaje o) {
        boolean crit = Azar.probabilidad(25);
        int base = Math.max(1, a.getAtaque() - o.getDefensa() / 2);
        return new ResultadoAtaque(crit ? (int) (base * 1.8) : base, crit, "flecha");
    }
}

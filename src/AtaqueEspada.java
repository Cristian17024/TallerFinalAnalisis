public class AtaqueEspada implements EstrategiaAtaque {
    @Override
    public ResultadoAtaque atacar(Personaje a, Personaje o) {
        boolean crit = Azar.probabilidad(15);
        int base = Math.max(1, a.getAtaque() - o.getDefensa() / 2);
        return new ResultadoAtaque(crit ? base * 2 : base, crit, "espadazo");
    }
}

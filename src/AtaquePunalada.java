public class AtaquePunalada implements EstrategiaAtaque {
    @Override
    public ResultadoAtaque atacar(Personaje a, Personaje o) {
        boolean crit = Azar.probabilidad(30);
        int base = Math.max(1, a.getAtaque() - o.getDefensa());
        return new ResultadoAtaque(crit ? base * 3 : base, crit, "puñalada");
    }
}

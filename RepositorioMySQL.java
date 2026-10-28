public class RepositorioMySQL implements RepositorioDeNotas {
    @Override
    public void salvar(String matricula, Boletim boletim) {
        System.out.println("[MySQL simulado] Matrícula: " + matricula
                + " | Notas: " + boletim.getNotas());
    }
}

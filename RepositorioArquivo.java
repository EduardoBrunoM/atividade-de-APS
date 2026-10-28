public class RepositorioArquivo implements RepositorioDeNotas {
    @Override
    public void salvar(String matricula, Boletim boletim) {
        System.out.println("[Arquivo simulado] Matrícula: " + matricula
                + " | Notas: " + boletim.getNotas());
    }
}

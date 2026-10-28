public class ProcessadorDeNotas {
    private final RepositorioDeNotas repositorio;
    private final Notificador notificador;
    private final CalculadoraDeMedia calculadora;

    public ProcessadorDeNotas(RepositorioDeNotas repositorio,
                             Notificador notificador,
                             CalculadoraDeMedia calculadora) {
        this.repositorio = repositorio;
        this.notificador = notificador;
        this.calculadora = calculadora;
    }

    public void salvarNotas(String matricula, Boletim boletim) {
        repositorio.salvar(matricula, boletim);
    }

    public void enviarNotas(String destinatario, Boletim boletim) {
        notificador.enviar(destinatario, boletim, calculadora.calcularMedia(boletim));
    }
}

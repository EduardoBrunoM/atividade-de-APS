public class Main {
    public static void main(String[] args) {
        Boletim boletim = new Boletim();
        CalculadoraDeMedia calculadora = new CalculadoraDeMedia();

        boletim.adicionarNota(8.0);
        boletim.adicionarNota(9.0);
        boletim.adicionarNota(7.0);
        System.out.println("Notas: " + boletim.getNotas());
        System.out.println("Média: " + calculadora.calcularMedia(boletim));

        try {
            boletim.adicionarNota(12.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Nota rejeitada: " + e.getMessage());
        }
        System.out.println("Notas após tentativa: " + boletim.getNotas());

        Notificador notificador = new NotificadorEmail();
        ProcessadorDeNotas processador = new ProcessadorDeNotas(
                new RepositorioMySQL(), notificador, calculadora);
        processador.salvarNotas("2026001", boletim);
        processador.enviarNotas("aluno@universidade.edu.br", boletim);

        // Troca apenas a implementação injetada; ProcessadorDeNotas não muda.
        ProcessadorDeNotas outroProcessador = new ProcessadorDeNotas(
                new RepositorioArquivo(), notificador, calculadora);
        outroProcessador.salvarNotas("2026001", boletim);
    }
}

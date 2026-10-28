import java.util.ArrayList;
import java.util.List;

class Boletim {
    private final List<Double> notas = new ArrayList<>();

    public void adicionarNota(double nota) {
        if (!Double.isFinite(nota) || nota < 0 || nota > 10) {
            throw new IllegalArgumentException(
                "A nota deve ser um número finito entre 0 e 10."
            );
        }

        notas.add(nota);
    }

    public List<Double> getNotas() {
        return new ArrayList<>(notas);
    }

    public double calcularMedia() {
        return notas.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
    }
}

interface RepositorioDeNotas {
    void salvar(String matricula, Boletim boletim);
}

class RepositorioMySQL implements RepositorioDeNotas {
    @Override
    public void salvar(String matricula, Boletim boletim) {
        System.out.println("Salvando notas no MySQL...");
        // Implementação real do banco de dados
    }
}

class NotificadorEmail {
    public void enviar(String destinatario, double media) {
        System.out.println("Enviando média por e-mail para: "
                + destinatario);
        // Implementação real do envio de e-mail
    }
}

class ProcessadorDeNotas {
    private final RepositorioDeNotas repositorio;
    private final NotificadorEmail notificador;

    public ProcessadorDeNotas(
            RepositorioDeNotas repositorio,
            NotificadorEmail notificador) {
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    public void processar(
            String matricula,
            String destinatario,
            Boletim boletim) {

        double media = boletim.calcularMedia();

        repositorio.salvar(matricula, boletim);
        notificador.enviar(destinatario, media);
    }
}

public class Main {
    public static void main(String[] args) {

        Boletim boletim = new Boletim();

        boletim.adicionarNota(8.0);
        boletim.adicionarNota(9.0);
        boletim.adicionarNota(7.0);

        System.out.println("Notas: " + boletim.getNotas());
        System.out.println("Média: " + boletim.calcularMedia());

        try {
            boletim.adicionarNota(12.0);
        } catch (IllegalArgumentException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }

        System.out.println("Notas após tentativa: "
                + boletim.getNotas());

        RepositorioDeNotas repositorio = new RepositorioMySQL();
        NotificadorEmail notificador = new NotificadorEmail();

        ProcessadorDeNotas processador =
                new ProcessadorDeNotas(repositorio, notificador);

        processador.processar(
                "2026001",
                "aluno@universidade.edu.br",
                boletim
        );
    }
}

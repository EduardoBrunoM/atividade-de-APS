import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boletim {
    private final List<Double> notas = new ArrayList<>();

    public void adicionarNota(double nota) {
        if (!Double.isFinite(nota) || nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve ser finita e estar entre 0 e 10.");
        }
        notas.add(nota);
    }

    public List<Double> getNotas() {
        return Collections.unmodifiableList(notas);
    }
}

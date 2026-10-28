public class CalculadoraDeMedia {
    public double calcularMedia(Boletim boletim) {
        return boletim.getNotas().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }
}

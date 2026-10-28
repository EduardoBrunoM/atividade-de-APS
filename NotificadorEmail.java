public class NotificadorEmail implements Notificador {
    @Override
    public void enviar(String destinatario, Boletim boletim, double media) {
        System.out.println("[E-mail simulado] Para: " + destinatario
                + " | Notas: " + boletim.getNotas() + " | Média: " + media);
    }
}

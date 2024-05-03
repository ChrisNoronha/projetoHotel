// Hospede.java
public class Hospede extends Thread {
    private String nome;
    private Hotel hotel;

    public Hospede(String nome, Hotel hotel) {
        this.nome = nome;
        this.hotel = hotel;
    }

    @Override
    public void run() {
        try {
            Quarto quarto = hotel.alocaQuarto();
            Thread threadQuarto = new Thread(quarto); // Cria uma nova thread para o quarto
            threadQuarto.start(); // Inicia a thread do quarto
            // Realiza atividades no quarto
            hotel.adicionaFilaEspera(quarto);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

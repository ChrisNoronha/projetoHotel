
// Main.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(10);
        List<String> nomes = lerNomes("/nomes/nomesClientes.txt");

        if (nomes != null && !nomes.isEmpty()) {
            for (int i = 0; i < 50; i++) {
                String nome = nomes.get(i % nomes.size());
                Hospede hospede = new Hospede(nome, hotel);
                hospede.start();
                System.out.println("Hóspede " + nome + " foi criado.");
            }
        }
    }

    private static List<String> lerNomes(String arquivo) {
        List<String> nomes = new ArrayList<>();
        try (InputStream is = Main.class.getResourceAsStream(arquivo);
                BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                nomes.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nomes;
    }
}

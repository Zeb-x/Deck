import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Carta> baraja;
    public Deck() {
        String[] palos = {"Corazones", "Diamantes", "Picas", "Treboles"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        baraja = new ArrayList<>();

        for (String palo : palos) {
            for (String valor : valores) {
                Carta carta = new Carta();
                carta.palo = palo;
                carta.valor = valor;
                baraja.add(carta);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(baraja);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        Carta primera = baraja.get(0);
        System.out.println(primera.palo + "," + primera.valor);
        System.out.println("Quedan " + baraja.size() + " cartas");
    }

    public void pick() {
        int indice = (int) (Math.random() * baraja.size());
        Carta carta = baraja.remove(indice);
        System.out.println(carta.palo + "," + carta.valor);
        System.out.println("Quedan " + baraja.size() + " cartas");
    }

    public List<Carta> hand(int n) {
        List<Carta> mano = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mano.add(baraja.remove(0));
        }
        return mano;
    }

    public void imprimirBaraja() {
        System.out.println("Imprimiendo baraja...");
        for (Carta carta : baraja) {
            System.out.println("palo: " + carta.palo + ", valor: " + carta.valor);
        }
    }

    public int tamaño() {
        return baraja.size();
    }

    public static void main(String[] args) {
        Deck deck = new Deck();

        System.out.println("Tamaño de la baraja: " + deck.tamaño());
        deck.imprimirBaraja();

        deck.shuffle();
        deck.imprimirBaraja();

        System.out.println("\nhead:");
        deck.head();

        System.out.println("\nCarta pick:");
        deck.pick();

        List<Carta> mano = deck.hand(5);
        System.out.println("\nMano de 5 cartas:");
        for (Carta c : mano) {
            System.out.println("palo: " + c.palo + ", valor: " + c.valor);
        }

        System.out.println("Tamaño final de la baraja: " + deck.tamaño());
    }
}
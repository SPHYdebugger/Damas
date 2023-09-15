import java.sql.SQLOutput;
import java.util.Scanner;

public class Jugador {

    private char letraJugador;
    private char letraOponente;
    private int numeroFichasOponente;


    public Jugador(char letraJugador, char letraOponente, int numeroFichasOponente) {
        this.letraJugador = letraJugador;
        this.numeroFichasOponente = numeroFichasOponente;
        this.letraOponente = letraOponente;
    }

    public char getLetraJugador() {
        return letraJugador;
    }

    public void setLetraJugador(char letraJugador) {
        this.letraJugador = letraJugador;
    }

    public int getNumeroFichasOponente() {
        return numeroFichasOponente;
    }

    public void setNumeroFichasOponente(int numeroFichas) {
        this.numeroFichasOponente = numeroFichas;
    }

    public char getLetraOponente() {
        return letraOponente;
    }

    public void setLetraOponente(char letraOponente) {
        this.letraOponente = letraOponente;
    }
}

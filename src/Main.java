public class Main {

    public static void main(String[] args) {

        Jugador jugador1 = new Jugador('X','O',12);
        Jugador jugador2 = new Jugador('O','X',12);

        Tablero tablero = new Tablero(8,8);

    tablero.rellenarTablero();
    tablero.mostrarTablero();
do {
    tablero.moverJugador(jugador1);
    tablero.mostrarTablero();
    if(jugador1.getNumeroFichasOponente() == 0 || jugador1.getNumeroFichasOponente() == -1)
        break;
    tablero.moverJugador(jugador2);
    tablero.mostrarTablero();
    if(jugador2.getNumeroFichasOponente() == 0 || jugador2.getNumeroFichasOponente() == -1)
        break;
}while (jugador1.getNumeroFichasOponente()!=0 || jugador2.getNumeroFichasOponente()!=0
        || jugador1.getNumeroFichasOponente()!=-1 || jugador2.getNumeroFichasOponente()!=-1 );

if (jugador1.getNumeroFichasOponente()==0 || jugador2.getNumeroFichasOponente()==-1){
    System.out.println("Han ganado las fichas X");
} else  {
    System.out.println("Han ganado las fichas O");
}



    }

}

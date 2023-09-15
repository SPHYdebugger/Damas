import java.util.Scanner;

public class Tablero {

    private int filasTablero;
    private int columnasTablero;
    private char[][] tablero;

    static String green="\033[32m";
    static String yellow="\033[33m";
    static String blue="\033[34m";
    static String reset="\u001B[0m";
    static String red="\033[31m";

    public Tablero(int filasTablero, int columnasTablero) {
        this.filasTablero = filasTablero;
        this.columnasTablero = columnasTablero;
    }

    public int getFilasTablero() {
        return filasTablero;
    }

    public void setFilasTablero(int filasTablero) {
        this.filasTablero = filasTablero;
    }

    public int getColumnasTablero() {
        return columnasTablero;
    }

    public void setColumnasTablero(int columnasTablero) {
        this.columnasTablero = columnasTablero;
    }



    public void rellenarTablero() {

        tablero = new char[getFilasTablero()][getColumnasTablero()];
        for (int i = 0; i < getFilasTablero(); i++) {
            for (int j = 0; j < getColumnasTablero(); j++) {
                tablero[i][j] = 'L';
                if (i==0 && j%2 != 0) {
                    tablero[i][j] = 'X';
                }
                if (i==1 && j%2 == 0) {
                    tablero[i][j] = 'X';
                }
                if (i==2 && j%2 != 0) {
                    tablero[i][j] = 'X';
                }
                if (i==5 && j%2 == 0) {
                    tablero[i][j] = 'O';
                }
                if (i==6 && j%2 != 0) {
                    tablero[i][j] = 'O';
                }
                if (i==7 && j%2 == 0) {
                    tablero[i][j] = 'O';
                }

            }
        }
    }
    public void mostrarTablero() {



        for (int i = 0; i < filasTablero; i++) {
            for (int j = 0; j < columnasTablero; j++) {

                if (tablero[i][j] == 'X'){
                    System.out.print(green + 'X' + " " + reset);
                } else if (tablero[i][j] == 'O'){
                    System.out.print(yellow + 'O' + " " + reset);
                }
                else System.out.print(tablero[i][j] + " ");
            }
            System.out.println(" ");
            }

    }

    public void moverJugador(Jugador jugador){
        Scanner teclado = new Scanner(System.in);

        int filaInicial;
        int columnaInicial;
        String movimiento;
        System.out.println(blue + "LE TOCA MOVER A LAS " + jugador.getLetraJugador() + reset);
 do {
     try {
         System.out.println("Dime la fila inicial");
         filaInicial = teclado.nextInt();
         System.out.println("Dime la columna inicial");
         columnaInicial = teclado.nextInt();
     }catch (Exception e){
         System.out.println("Has introducido algo que no es una letra");
         System.out.println("Ten más cuidado la próxima vez jajaja" );
         filaInicial = 1;
         columnaInicial = 0;
     }
 }while (tablero[filaInicial][columnaInicial]== 'L');
teclado.nextLine();

        try{
            System.out.println("Hacia qué lado quieres mover??  A (izquierda) D (derecha)");
            movimiento = teclado.nextLine();

        }catch(Exception e){
            System.out.println("Has introducido algo que no es una letra, pierdes turno");
            System.out.println("Así tendrás más cuidado la próxima vez jajaja" );
            movimiento=" ";

        }




        switch (movimiento){
            case "A":
                if (jugador.getLetraJugador()=='X'){
                    if ((columnaInicial-1) < 0) {
                        System.out.println(red + "Te has salido del tablero y pierdes el turno" + reset);

                    } else if (tablero[filaInicial+1][columnaInicial-1]== 'L'){
                        tablero[filaInicial][columnaInicial] = 'L';
                        tablero[filaInicial+1][columnaInicial-1]=jugador.getLetraJugador();
                    } else if (tablero[filaInicial+1][columnaInicial-1]== jugador.getLetraOponente()){
                        tablero[filaInicial][columnaInicial] = 'L';
                        tablero[filaInicial+1][columnaInicial-1]='L';
                        tablero[filaInicial+2][columnaInicial-2]= jugador.getLetraJugador();
                        jugador.setNumeroFichasOponente(jugador.getNumeroFichasOponente()-1);
                    }else {
                        System.out.println(red + "Esa casilla no es tuya, pierdes turno" + reset);
                    }
                }else {
                    if ((columnaInicial-1) < 0) {
                        System.out.println(red + "Te has salido del tablero y pierdes el turno" + reset);
                    } else if (tablero[filaInicial-1][columnaInicial-1]== 'L'){
                        tablero[filaInicial][columnaInicial] = 'L';
                        tablero[filaInicial-1][columnaInicial-1]=jugador.getLetraJugador();
                    } else if (tablero[filaInicial-1][columnaInicial-1]== jugador.getLetraOponente()){
                        tablero[filaInicial][columnaInicial] = 'L';
                        tablero[filaInicial-1][columnaInicial-1]='L';
                        tablero[filaInicial-2][columnaInicial-2]= jugador.getLetraJugador();
                        jugador.setNumeroFichasOponente(jugador.getNumeroFichasOponente()-1);
                    }else {
                        System.out.println(red + "Esa casilla no es tuya, pierdes turno" + reset);
                    }
                }
                break;
            case "D":
                if (jugador.getLetraJugador()=='X'){
                    if ((columnaInicial+1) >= getColumnasTablero()) {
                        System.out.println(red + "Te has salido del tablero y pierdes el turno" + reset);
                    } else if (tablero[filaInicial+1][columnaInicial+1]== 'L'){
                        tablero[filaInicial][columnaInicial] = 'L';
                        tablero[filaInicial+1][columnaInicial+1]=jugador.getLetraJugador();
                    } else if (tablero[filaInicial+1][columnaInicial+1]== jugador.getLetraOponente()){
                        tablero[filaInicial][columnaInicial] = 'L';
                        tablero[filaInicial+1][columnaInicial+1]='L';
                        tablero[filaInicial+2][columnaInicial+2]= jugador.getLetraJugador();
                        jugador.setNumeroFichasOponente(jugador.getNumeroFichasOponente()-1);
                    }else {
                        System.out.println(red + "Esa casilla no es tuya, pierdes turno" + reset);
                    }
                }else {
                    if ((columnaInicial+1) >= getColumnasTablero()) {
                        System.out.println(red + "Te has salido del tablero y pierdes el turno" + reset);
                    } else if (tablero[filaInicial-1][columnaInicial+1]== 'L'){
                        tablero[filaInicial][columnaInicial] = 'L';
                        tablero[filaInicial-1][columnaInicial+1]=jugador.getLetraJugador();
                    } else if (tablero[filaInicial-1][columnaInicial+1]== jugador.getLetraOponente()){
                        tablero[filaInicial][columnaInicial] = 'L';
                        tablero[filaInicial-1][columnaInicial+1]='L';
                        tablero[filaInicial-2][columnaInicial+2]= jugador.getLetraJugador();
                        jugador.setNumeroFichasOponente(jugador.getNumeroFichasOponente()-1);
                    }else {
                        System.out.println(red + "Esa casilla no es tuya, pierdes turno" + reset);
                    }

                }
                break;
            case "P":
                System.out.println("HAS DADO LA PARTIDA POR PERDIDA");
                jugador.setNumeroFichasOponente(-1);
                break;
            default:
                System.out.println("Esa no es una letra válida, pierdes el turno");

        }


        System.out.println(blue + "Número de fichas  " + jugador.getLetraOponente() +
                " que faltan por comer =" + jugador.getNumeroFichasOponente() + reset );




    }




}




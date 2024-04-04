import classes.CGame;
import classes.CJugador;

import java.io.IOException;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String nplayer1,nplayer2;
        char pplayer1,pplayer2;
        Scanner scanner = new Scanner(System.in);
        CGame cGame;
        CJugador p1;
        CJugador p2;
        Random rand = new Random(Instant.now().toEpochMilli());
        int aux_turn;
        boolean turn = false;
        int piece_position;
        boolean aux_validate;
        boolean aux_isWinner = false;

        System.out.println("Bienvenido a Tic-Tac-Toe By Alex Juep");
        System.out.println("Ingrese el nombre del Jugador 1: ");
        nplayer1 = scanner.next();
        System.out.println("Ingrese una letra para el jugador 1: ");
        pplayer1 = scanner.next().charAt(0);
        pplayer1 = Character.toUpperCase(pplayer1);
        System.out.println("Ingrese el nombre del Jugador 2: ");
        nplayer2 = scanner.next();
        System.out.println("Ingrese una letra para el jugador 2: ");
        pplayer2 = scanner.next().charAt(0);
        pplayer2 = Character.toUpperCase(pplayer2);

        aux_turn = rand.nextInt(0,2);
        if(aux_turn == 1){
            turn = !turn;
        }


        p1 = new CJugador(nplayer1,turn,0,pplayer1);
        p2 = new CJugador(nplayer2,!turn,0,pplayer2);

        cGame = new CGame(p1,p2);
        cGame.startMap();
        cGame.paintMap();


        while(!aux_isWinner){
            aux_validate = false;
            if(p1.isTurn()){
                System.out.printf("================\nTurno del jugador %s\n",nplayer1);
            }else{
                System.out.printf("================\nTurno del jugador %s\n",nplayer2);
            }

            //Movimiento
            if(p1.isTurn()){
                do{
                    System.out.print("Ingrese el numero donde desea colocar la ficha: ");
                    piece_position = scanner.nextInt();
                    aux_validate = cGame.validatePieceInMap(piece_position,p1.getPiece());
                    if(!aux_validate){
                        System.out.println("Movimiento invalido, ingrese otra posicion");
                    }else{
                        cGame.setPieceInMap(piece_position,p1.getPiece());
                    }
                }while(!aux_validate);
            }else{
                do{
                    System.out.print("Ingrese el numero donde desea colocar la ficha: ");
                    piece_position = scanner.nextInt();
                    aux_validate = cGame.validatePieceInMap(piece_position,p2.getPiece());
                    if(!aux_validate){
                        System.out.println("Movimiento invalido, ingrese otra posicion");
                    }else{
                        cGame.setPieceInMap(piece_position,p2.getPiece());
                    }
                }while(!aux_validate);
            }


            cGame.paintMap();
            aux_isWinner = cGame.validateWinner(p1,p2);

            p1.setTurn(!p1.isTurn());
            p2.setTurn(!p2.isTurn());

        }
    }



}
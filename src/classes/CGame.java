package classes;

public class CGame{
    CMapa cMap;
    CJugador cPlayer1;
    CJugador cPlayer2;

    public CGame(CJugador player1, CJugador player2){
        this.cMap = new CMapa();
        this.cPlayer1 = player1;
        this.cPlayer2 = player2;
    }

    public void paintMap(){
        this.cMap.paintMap();
    }

    public void startMap(){
        this.cMap.startMap();
    }

    public boolean validatePieceInMap(int opt,char piece){
        return this.cMap.validatePieceInMap(opt,piece);
    }

    public boolean validateAllMap(char[][] aux_matriz, CJugador p){
        boolean result = false;
        if(aux_matriz[1][1] == p.getPiece() && aux_matriz[1][3] == p.getPiece() && aux_matriz[1][5] == p.getPiece()
                || aux_matriz[3][1] == p.getPiece() && aux_matriz[3][3] == p.getPiece() && aux_matriz[3][5] == p.getPiece()
                || aux_matriz[5][1] == p.getPiece() && aux_matriz[5][3] == p.getPiece() && aux_matriz[5][5] == p.getPiece()
                || aux_matriz[1][1] == p.getPiece() && aux_matriz[3][1] == p.getPiece() && aux_matriz[5][1] == p.getPiece()
                || aux_matriz[1][3] == p.getPiece() && aux_matriz[3][3] == p.getPiece() && aux_matriz[5][3] == p.getPiece()
                || aux_matriz[1][5] == p.getPiece() && aux_matriz[3][5] == p.getPiece() && aux_matriz[5][5] == p.getPiece()
                || aux_matriz[1][1] == p.getPiece() && aux_matriz[3][3] == p.getPiece() && aux_matriz[5][5] == p.getPiece()
                || aux_matriz[1][5] == p.getPiece() && aux_matriz[3][3] == p.getPiece() && aux_matriz[5][1] == p.getPiece()
        ){
            result = true;
        }
        return result;
    }

    public boolean validateWinner(CJugador p1, CJugador p2){
        boolean result = false;
        char aux_matriz[][] = this.cMap.getMatriz();
        if(validateAllMap(aux_matriz,p1) || validateAllMap(aux_matriz,p2)){
            if(validateAllMap(aux_matriz,p1)){
                System.out.println(p1.getName() + " Ganaste!!!");
            }
            if(validateAllMap(aux_matriz,p2)){
                System.out.println(p2.getName() + " Ganaste!!!");
            }
            result = true;
        }

        return result;
    }

    public void setPieceInMap(int opt,char piece){
        switch (opt){
            case 1:
                this.cMap.setValueInMatriz(1,1,piece);
                break;
            case 2:
                this.cMap.setValueInMatriz(1,3,piece);
                break;
            case 3:
                this.cMap.setValueInMatriz(1,5,piece);
                break;
            case 4:
                this.cMap.setValueInMatriz(3,1,piece);
                break;
            case 5:
                this.cMap.setValueInMatriz(3,3,piece);
                break;
            case 6:
                this.cMap.setValueInMatriz(3,5,piece);
                break;
            case 7:
                this.cMap.setValueInMatriz(5,1,piece);
                break;
            case 8:
                this.cMap.setValueInMatriz(5,3,piece);
                break;
            case 9:
                this.cMap.setValueInMatriz(5,5,piece);
                break;
        }
    }
}

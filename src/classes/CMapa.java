package classes;


public class CMapa {
    private int width;
    private int height;

    private char matriz[][];

    public CMapa() {
        this.width = 7;
        this.height = 7;
        this.matriz = new char[this.height][this.width];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(char[][] matriz) {
        this.matriz = matriz;
    }

    public void setValueInMatriz(int fila, int columna, char c){
        this.matriz[fila][columna] = c;
    }

    public boolean validatePieceInMap(int opt,char piece){
        boolean result = false;
        for(int fila = 0; fila < this.height; fila++){
            for(int columna = 0; columna < this.width; columna++) {
                if(this.matriz[fila][columna] == (char) ('0' + opt)){
                    result = true;
                }

            }
        }
        return result;
    }

    public void startMap(){
        int cc = 1;
        for(int fila = 0; fila < this.height; fila++){
            for(int columna = 0; columna < this.width; columna++){
                if (fila == 0 || fila == this.height - 1 ||
                    columna == 0 || columna == this.width - 1){
                    this.matriz[fila][columna] = '0';
                }else if(fila % 2 ==0 || columna % 2 == 0){
                    this.matriz[fila][columna] = '0';
                }else{
                    this.matriz[fila][columna] = (char) ('0' + cc);
                    cc++;
                }
            }
        }
    }

    public void paintMap(){
        int cc = 1;
        for(int fila = 0; fila < this.height; fila++){
            for(int columna = 0; columna < this.width; columna++){
                switch (this.matriz[fila][columna]){
                    case '0':
                        System.out.printf("%c", 0x2588);
                        break;
                    case '1','2','3','4','5','6','7','8','9':
                        System.out.print("\u001B[34m" + this.matriz[fila][columna] + "\u001B[0m");
                        break;
                    default:
                        System.out.print("\u001B[32m" + this.matriz[fila][columna] + "\u001B[0m");
                        break;
                }
            }
            System.out.print("\n");
        }
    }
}

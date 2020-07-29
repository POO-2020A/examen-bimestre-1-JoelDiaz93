
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joel
 */
public class Plane {

    private Seat seats;
    private int rows, cols;
    private ArrayList<Seat> plane = new ArrayList();

    public Plane(int rowsPlane, int colsPlane) {
        if (rowsPlane <= 20) {
            this.rows = rowsPlane;
        }else{
            this.rows=20;
        }
        if (colsPlane <= 8) {
            this.cols = colsPlane;
        }else{
            this.cols=8;
        }
        
        String aux="";
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                switch(j){
                    case 0: aux="A";break;
                    case 1: aux="B";break;
                    case 2: aux="C";break;
                    case 3: aux="D";break;
                    case 4: aux="E";break;
                    case 5: aux="F";break;
                    case 6: aux="G";break;
                    case 7: aux="H";
                    default:break;
                }
                seats = new Seat(i,aux);
                plane.add(seats);
            }
            
        }
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public void setRows(int rowsPlane) {
        this.rows = rowsPlane;
    }
    
    public void setCols(int colsPlane) {
        this.cols = colsPlane;
    }
    
    
    @Override
    public String toString(){
        char col=0;
        for (int i = 0; i < this.cols; i++) {
            col = (char)('A'+i);
        }
        String aux = "";
        for(Seat seat:plane){
            if (seat.getCols().equals("A")) {
                aux+= (seat.getRows()+" ");
            }
            if (seat.getCols().equals(col+"")) {
                aux+=(seat.getCols()+"\n");
            }else{
                aux+=(seat.getCols()+" ");
            }
        }
        return aux;
    }

}

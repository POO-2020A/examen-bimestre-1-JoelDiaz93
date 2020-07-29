/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joel
 */
public class Seat {

    private int row;
    private String col;
    private Passenger passenger;

    public Seat(int rowPlane, String colPlane) {
        this.row = rowPlane;
        this.col = colPlane;
        this.passenger = null;
    }

    /*
    public boolean isFree(int row, String col) {
        
    }
     */
    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }

        if (!(compared instanceof Seat)) {
            return false;
        }

        Seat comparedSeat = (Seat) compared;
        if (this.row == comparedSeat.row
                && this.col.equals(comparedSeat.col)) {
            return true;
        }
        return false;
    }

    public int getRows() {
        return this.row;
    }

    public String getCols() {
        return this.col;
    }
    
    public Passenger getPassenger(){
        return this.passenger;
    }

    public void setPassenger(Passenger newPassenger) {
        this.passenger = newPassenger;
    }

    @Override
    public String toString() {
        String result="";
        if (this.passenger==null) {
            result = ("Asiento: " + this.row + this.col + ", libre");
        }else{
            result = ("Asiento: " + this.row + this.col + ", Ocupado. Pasajero: "+this.passenger.toString());
        }
        return result;
    }
}


import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joel
 */
public class UserInterface {

    private Scanner scanner;
    private ArrayList<Seat> seatPassenger = new ArrayList();
    private ArrayList<Passenger> listPassenger = new ArrayList();

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        
        System.out.println("Numero de filas:");
        int row = Integer.valueOf(scanner.nextLine());
        System.out.println("Numero de columnas:");
        int col = Integer.valueOf(scanner.nextLine());

        Plane plane = new Plane(row, col);
        while (true) {
            System.out.println("Este es el mapa del avion:");
            System.out.println(plane.toString());
            System.out.println("Que desea hacer?");
            System.out.println("1. Ingresar pasajero");
            System.out.println("2. Consultar asiento");
            System.out.println("3. Consultar pasajero");
            int option = Integer.valueOf(scanner.nextLine());
            switch (option) {
                case 1:{
                    System.out.println("Ingresar un pasajero:");
                    System.out.println("Ingrese el nombre del pasajero: ");
                    String name = scanner.nextLine();
                    System.out.println("Ingrese el apellido del pasejero: ");
                    String lastname = scanner.nextLine();
                    
                    Passenger passanger = new Passenger(name, lastname);
                    
                    System.out.println("Ingrese fila del asiento: ");
                    int rowPassenger = Integer.valueOf(scanner.nextLine());
                    System.out.println("Ingrese la columna del asiento: ");
                    String colPassenger = scanner.nextLine();
                    
                    Seat newPassenger = new Seat(rowPassenger, colPassenger);
                    if (seatPassenger.equals(newPassenger)) {
                        System.out.println("El asiento esta ocupado!");
                    }else{
                        newPassenger.setPassenger(passanger);
                        seatPassenger.add(newPassenger);
                        System.out.println("Pasajero ingresado!");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Consulta de asiento.");
                    System.out.println("Ingrese la fila del asiento: ");
                    int rowSearch = Integer.valueOf(scanner.nextLine());
                    System.out.println("Ingrese la columna del asiento: ");
                    String colSearch=scanner.nextLine();
                    String compared = rowSearch+colSearch;
                    String aux="";
                    boolean search = false;
                    for(Seat seatSearch: seatPassenger){
                        String seats =seatSearch.getRows()+seatSearch.getCols();
                        if (seats.equals(compared)); {
                            search=true;
                            aux=seatSearch.getPassenger().toString();
                            break;
                        }
                    }
                    if (search) {
                        System.out.println("Asiento ocupado. Pasajero: "+aux);
                    }else{
                        System.out.println("Asiento libre.");
                    }
                    
                    break;
                }
                case 3:{
                    System.out.println("Consulta de pasajero.");
                    System.out.println("Ingrese el nombre y apellido: ");
                    String nameComplete = scanner.nextLine();
                    String[] nameAndLastname = nameComplete.split(" ");
                    
                    Passenger passengerSearch = new Passenger(nameAndLastname[0], nameAndLastname[1]);
                    boolean search = false;
                    String searchSeat="";
                    for(Seat seats: seatPassenger){
                        String aux = seats.getPassenger().toString();
                        if (aux.equals(passengerSearch.toString())) {
                            search = true;
                            searchSeat+=seats.getRows()+seats.getCols();
                            break;
                        }
                    }
                    if (search == true) {
                        System.out.println("El pasajero se encuentra en el asiento: "+searchSeat);
                    }else{
                        System.out.println("El pasajero no se encuentra en el avión.");
                    }
                }
                default: break;
                    
            }
        }

    }

}

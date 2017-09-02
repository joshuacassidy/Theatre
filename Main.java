import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 9, 12);

        List<Theatre.Seat> seats = new ArrayList<>(theatre.getSeats());
        seats.add(theatre.new Seat("B00", 13.00));
        seats.add(theatre.new Seat("A00", 13.00));
        printList(seats);

        System.out.printf(theatre.reserveSeat("D12") ? "" : "Seat already reserved");

        System.out.printf(theatre.reserveSeat("D11") ? "" : "Seat already reserved");

        System.out.printf(theatre.reserveSeat("D10") ? "" : "Seat already reserved");
        theatre.cancelSeat("D10");
        List<Theatre.Seat> reserveSeats = new ArrayList<>(theatre.getReservedSeats());
        System.out.println("\nThe list of reserved seats is: ");
        printList(reserveSeats);






    }

    public static void printList(List<Theatre.Seat> list){
        Collections.sort(list);
        for(Theatre.Seat seat : list){
            System.out.println(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
    }



}

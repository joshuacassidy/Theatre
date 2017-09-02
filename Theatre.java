import java.util.*;

public class Theatre {
    public final String theatreName;
    private List<Seat> seats = new ArrayList<>();
    private List<Seat> reservedSeats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows -1 );
        System.out.println("Number code for A " + (int) 'A' + " Number code for amount of rows " + lastRow +  " Ascii code for number of rows " + (char) lastRow);
        for (char row = 'A'; row <=lastRow; row++){
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                double price = 12.00;

                if((row < 'D') && (seatNum >= 4 && seatNum <=9)){
                    price = 14.00;
                }
                else if ((row < 'F') && (seatNum >= 4 && seatNum <=9)){
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d",seatNum),price);
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
        if(foundSeat >= 0){
            reservedSeats.add(seats.get(foundSeat));
            return seats.get(foundSeat).reserve();
        }
        else{
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

    }

    public boolean cancelSeat(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats,requestedSeat,null);
        if(foundSeat >= 0){
            reservedSeats.remove(seats.get(foundSeat));
            return seats.get(foundSeat).cancel();
        }
        else{
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }

    public Collection<Seat> getSeats(){
        return seats;
    }

    public Collection<Seat> getReservedSeats(){
        return reservedSeats;
    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public boolean reserve(){
            if (!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            }
            else{
                return false;
            }
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            }
            else{
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }

}

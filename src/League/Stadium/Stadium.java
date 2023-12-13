package League.Stadium;

import League.Match.Match;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Stadium {
    public String name;
    public String location;
    public int capacity;
    public ArrayList<Match> matches;

    public Stadium(String name, String location, int capacity, ArrayList<Match> matches) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.matches = new ArrayList<>(matches);
    }

    public Stadium(String name, String location, int capacity) {
        this(name, location, capacity, null);
    }

    public Stadium(String name, String location) {
        this(name, location, 0);
    }

    public Stadium(String name) {
        this(name, "");
    }

    public Stadium() {
        this("");
    }

    public Stadium(Stadium Stadium) {
        try {
            this.name = Stadium.name;
            this.capacity = Stadium.capacity;
            this.location = Stadium.location;
            this.matches = new ArrayList<>(Stadium.matches);
        } catch (NullPointerException exp) {
            System.out.println("Null stadium");
        }
    }

    public String getStadiumName() {
        return name;
    }

    public void setStadiumName(String StadiumName) {
        this.name = StadiumName;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = new ArrayList<>(matches);
    }

    public String getStadiumLocation() {
        return location;
    }

    public void setStadiumLocation(String StadiumLocation) {
        this.location = StadiumLocation;
    }

    public int getStadiumCapacity() {
        return capacity;
    }

    public void setStadiumCapacity(int capacity) {
        this.capacity = capacity;
    }

    //user to input the date
    //function to be called
    public boolean CheckAvailability(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date checkDate = dateFormat.parse(date);
            Date datenow = new Date();
            for (Match match : matches) {
                if (match.matchdate.equals(checkDate)) {
                    System.out.println("Stadium won't be available");
                    return false;
                }
                if (datenow.before(checkDate)) {
                    System.out.println("Date should be upcoming date");
                    return false;
                }
            }
            return true;
        } catch (Throwable throwable) {
            System.out.println("Wrong input");
            return false;
        }

    }
}







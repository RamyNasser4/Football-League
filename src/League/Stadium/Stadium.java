package League.Stadium;

import League.Match.Match;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;

public class Stadium {
    public String name;
    public String location;
    public int capacity;
    protected int StadiumID;
    private static int noOfStadiums = 0;
    public ArrayList<Match> matches;

    public Stadium(String name, String location, int capacity, ArrayList<Match> matches) {
        ++noOfStadiums;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.StadiumID = noOfStadiums;
        this.matches = matches;
    }

    public Stadium(String name, String location, int capacity) {
        this(name, location, capacity, new ArrayList<>());
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
            this.matches = Stadium.matches;
            this.StadiumID = ++noOfStadiums;
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


    /**
     * This function compares date given by user to stored date in stadium
     * @param date date entered by user
     *
     * @return true if given date has no matches and false otherwise
     * @throws RuntimeException If user inputs invalid date
     */
    public boolean CheckAvailability(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date checkDate = dateFormat.parse(date);
            Date datenow = new Date();
            for (Match match : matches) {
                if (match.matchdate.equals(checkDate)) {
                    System.out.println("Stadium won't be available");
                    return false;
                }
            }
            return true;
        } catch (Throwable throwable) {
            System.out.println("Wrong input");
            return false;
        }

    }
    public String WriteStadium(){
        return name + "\t" + this.location + "\t" + this.capacity;
    }

    public int getStadiumID() {
        return StadiumID;
    }

    public void setStadiumID(int stadiumID) {
        StadiumID = stadiumID;
    }
    public void AddMatch(Match match){
        try {
            matches.add(match);
        }catch (NullPointerException exp){
            System.out.println("Invalid Match");
        }
    }
    public void deleteMatch(int MatchID){
        Iterator<Match> matchIterator = matches.iterator();
        while (matchIterator.hasNext()){
            Match match = matchIterator.next();
            if (match.getMatch_ID() == MatchID){
                matchIterator.remove();
            }
        }
    }
}







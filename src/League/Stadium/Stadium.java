package League.Stadium;
import League.Match.Match;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Stadium {
    public String name;
    public String location;
    public int capacity;
    private Match[] match;

    public Stadium(String name, String location, int capacity,Match match) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.match = new Match[0];
   }
    public Stadium(String name, int capacity, Match[] matches) {
        try {
            setStadiumName(name);
            setStadiumCapacity(capacity);
            setMatch(matches);
        } catch (IllegalArgumentException e) {
            System.err.println("Exception: " );
        }
    }
    public Stadium(String name, String location, int capacity) {this(name,location,capacity,null);}
    public Stadium(String name, String location) {this(name,location,0);}
    public Stadium(String name) {this(name,"");}
    public Stadium(){this("");}



    public Stadium(Stadium Stadium) {
        this.name = Stadium.name;
        this.capacity = Stadium.capacity;
        this.location = Stadium.location;
        this.match = new Match[Stadium.match.length];
        for (int i = 0; i < Stadium.match.length; i++) {
            this.match[i] = new Match(Stadium.match[i]);
        }
    }

    public String getStadiumName() {
        return name;
    }
    public Match[] getMatch() {return match;}
    public void setMatch(Match[] matches) {
        if (matches != null) {
            this.match= matches;
        } else {
            throw new IllegalArgumentException("Invalid match array");
        }
    }


    public void setStadiumName(String StadiumName) {
        this.name = StadiumName;
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
  /*  public boolean CheckAvailabilty(String date){
        match.StringtoDate(date);
        if (match.matchdate.equals(date))
        {
            return false;
        }
        else {
            return true;
        }
    }
*/
}







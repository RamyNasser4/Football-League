package Stadium;
import Match.Match;



public class Stadium {
    private String name;
    private String location;
    public int capacity;


    public Match match ;


    public Stadium(String name, String location, int capacity,Match match) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.match=match;
   }
    public Stadium(String name, String location, int capacity) {this(name,location,capacity,null);}
    public Stadium(String name, String location) {this(name,location,0);}
    public Stadium(String name) {this(name,"");}
    public Stadium(){this("");}



    public Stadium(Stadium Stadium) {
        this.name = Stadium.name;
        this.capacity = Stadium.capacity;
        this.location = Stadium.location;
    }

    public String getStadiumName() {
        return name;
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

}

 /*   public boolean Check_Available(String date ) {
       if (Date.equals(date)) {
           return false ;
       }
       else{
           return true;
       }
   }


   }*/




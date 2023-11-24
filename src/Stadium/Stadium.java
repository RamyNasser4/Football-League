package Stadium;


public class Stadium {
    private String name;
    private String location;
    public int capacity;
    public String Date;

    public Stadium(String name,String location,int capacity,String date){
        this.name=name;
        this.location=location;
        this.capacity=capacity;
        this. Date=date;

    }

    public String getStadiumName() {
        return name ;
    }

    public void setStadiumName(String StadiumName) {
        this.name = StadiumName;
    }
    public String getStadiumLocation() {
        return location ;
    }

    public void setStadiumLocation(String StadiumLocation) {
        this.location = StadiumLocation;
    }
    public String getDate() {
        return Date ;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    public int getStadiumCapacity() {
        return capacity;
    }

    public void setStadiumCapacity(int capacity) {
        this.capacity=capacity;
    }



    public boolean Check_Available(String date ) {
       if (Date.equals(date)) {
           return false ;
       }
       else{
           return true;
       }
   }


   }




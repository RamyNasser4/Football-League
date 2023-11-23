package player;

public class Defender extends Player {
    public Defender(){
        super();
    }
    protected int tackle;
    public int GetTackle() {
        return tackle;
    }
    public void SetTackle(int tackle){
        this.tackle=tackle;
    }

}

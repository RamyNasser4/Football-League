package player;

public class Forward extends Player {
    public Forward(){
        super();
    }
    protected int shots;
    public int GetShots() {
        return shots;
    }
    public void SetShots(int shots){
        this.shots=shots;
    }
}

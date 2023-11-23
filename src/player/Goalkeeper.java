package player;

public class Goalkeeper extends Player {
    public Goalkeeper(){
        super();
    }
   protected  int saves;
    protected int cleanSheets;
    public int GetSaves() {
        return saves;
    }
    public void SetSaves(int saves){
        this.saves=saves;
    }
    public int GetCleanSheets() {
        return cleanSheets;
    }
    public void GetCleanSheets(int cleanSheets){
        this.cleanSheets=cleanSheets;
    }
}

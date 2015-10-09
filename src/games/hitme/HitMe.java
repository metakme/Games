package games.hitme;

import engine.MainGameLoop;
import games.Game;

public class HitMe extends Game{
    public HitMe(){
        this.mloop = new MainGameLoop(new HitMeEngine());
        this.name = "Hit Me!";
    }
}

package games.batandball;

import engine.MainGameLoop;
import games.Game;

public class BatAndBall extends Game {

    
    public BatAndBall() {
        this.mloop = new MainGameLoop(new BatAndBallEngine());
        this.name = "Bat and Ball";
    }

}

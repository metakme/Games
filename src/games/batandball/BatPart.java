package games.batandball;

import com.googlecode.lanterna.terminal.Terminal.Color;

public class BatPart extends GameObject {

    int angleModifier;

    public BatPart(BatAndBallEngine engine,double posx,double posy, Color c) {
        super(engine);
        this.engine = engine;
        this.speed = 0.5;
        this.look = "=";
        this.bg = c;
        this.fg = Color.BLACK;
        this.posx = posx;
        this.posy = posy;
    }
}

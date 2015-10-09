package games.batandball;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal.Color;

public abstract class GameObject {

    double posx;
    double posy;
    double speed;
    String look;
    Color bg;
    Color fg;
    Screen toDrawOn;
    BatAndBallEngine engine;

    public GameObject(BatAndBallEngine engine) {
        this.toDrawOn = engine.getScreen();
        this.engine = engine;
    }

    public void draw() {
        toDrawOn.putString((int) posx, (int) posy, look, fg, bg);
    }

    public void update() {

    }
}

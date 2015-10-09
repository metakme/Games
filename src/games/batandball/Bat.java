package games.batandball;

import com.googlecode.lanterna.terminal.Terminal.Color;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class Bat extends GameObject {

    BatPart[] body = new BatPart[9];
    int oldposx;
    int newposx;
    public Bat(BatAndBallEngine engine) {
        super(engine);
        this.posx = engine.getWidth() / 2;
        this.posy = engine.getHeight() - 2;
        this.speed = 1.0;
            body[0] = new BatPart(engine, posx - 4, posy,Color.BLUE);
            body[1] = new BatPart(engine, posx - 3, posy,Color.MAGENTA);
            body[2] = new BatPart(engine, posx - 2, posy,Color.MAGENTA);
            body[3] = new BatPart(engine, posx - 1, posy,Color.RED);
            body[4] = new BatPart(engine, posx    , posy,Color.RED);
            body[5] = new BatPart(engine, posx + 1, posy,Color.RED);
            body[6] = new BatPart(engine, posx + 2, posy,Color.MAGENTA);
            body[7] = new BatPart(engine, posx + 3, posy,Color.MAGENTA);
            body[8] = new BatPart(engine, posx + 4, posy,Color.BLUE);
            engine.batparts.addAll(Arrays.asList(body));
        oldposx = (int) posx;

    }

    @Override
    public void update() {
        if (engine.isKeyPressed(KeyEvent.VK_LEFT)&&(body[0].posx>0)) {
            this.posx -= speed;
            newposx = (int) posx;
            if (oldposx != newposx) {
                oldposx = newposx;
                for (BatPart part : body) {
                    part.posx -= 1;
                }
            }
        }
        if (engine.isKeyPressed(KeyEvent.VK_RIGHT)&&(body[8].posx+1<engine.getWidth())) {
            this.posx += speed;
            newposx = (int) posx;
            if (oldposx != newposx) {
                oldposx = newposx;
                for (BatPart part : body) {
                    part.posx += 1;
                }
            }
        }
    }

    @Override
    public void draw() {
        for (BatPart part : body) {
            part.draw();
        }
    }
}

package games.batandball;

import com.googlecode.lanterna.terminal.Terminal;

public class Ball extends GameObject {

    double speedy;

    public Ball(BatAndBallEngine engine) {
        super(engine);
        this.engine = engine;
        this.speed = 0.8;
        this.speedy = 0.4;
        this.look = " ";
        this.bg = Terminal.Color.YELLOW;
        this.fg = Terminal.Color.YELLOW;
        this.posy = 1.0;
        this.posx = Math.random() * engine.getWidth();
        this.posx = 1;
    }

//    
    @Override
    public void update() {
        Collision();

        if (posx < 0 && speed < 0 || posx > engine.getWidth() && speed > 0) {
            speed *= -1;
        }
        posx += speed;

        if (posy < 1 && speedy < 0) {
            speedy *= -1;
        }
        if (posy > engine.getHeight() + 1 && speedy > 0) {
            posy = 0;
            engine.MissCountPP();
        }
        posy += speedy;

    }

    @Override
    public void draw() {
        toDrawOn.putString((int) posx, (int) posy, look, fg, bg);
    }

    void Collision() {
        if ((int)this.posy == (int)engine.getHeight() - 3 &&speedy>0) {
            if((int)engine.batparts.get(0).posx-1<(int)this.posx&&(int)engine.batparts.get(8).posx+1>(int)this.posx){
                this.speedy*=-1;
                return;
            }
//            for (BatPart bp : engine.batparts) {
//                if ((int) this.posx == (int)bp.posx) {
//                    this.speedy *= -1;
//                    return;
//                }
//                if (this.speed > 0) {
//                    if ((int)this.posx == (int)bp.posx-1) {
//                        this.speedy *= 1;
//                        return;
//                    }
//                }
//                if (this.speed < 0) {
//                    if ((int)this.posx == (int)bp.posx+1) {
//                        this.speedy *= 1;
//                        return;
//                    }
//                }
//            }
        }
    }
}

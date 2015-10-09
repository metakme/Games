package games.hitme;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Explosion extends GameObject {

    int posx;
    int posy;
    private static BufferedImage[] imageBody;
    int frame;
    int count;
    int i;
    
    public Explosion(HitMeScreen screen, int x, int y) {
        super(screen);
        posx = x - 24;
        posy = y - 24;
        i = 1;
        frame = 0;
        count = 0;
        imageBody = new BufferedImage[3];
        for (int i = 0; i < imageBody.length; i++) {
            try {
                imageBody[i] = ImageIO.read(new File("resources"+HitMeEngine.fileSepatator+"Explosion-"+i+".png"));
            } catch (IOException ex) {
                Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(imageBody[frame], (int) posx, (int) posy, null);

    }

    @Override
    public void update() {
        if(count<60){
        if(count%15==0){
            frame+= i;
            if(frame==2||frame==0)
                i *= -1;
        }
        count++;
        }else {
            screen.toRemove.add(this);
        }
    }

}

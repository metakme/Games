package games.hitme;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Bird extends GameObject{

    double posx;
    double posy;
    private static BufferedImage[] imageBody;
    int frame;
    int count;
    int i = 1;
    double speed;
    Rectangle hitbox;
    public Bird(HitMeScreen screen) {
        super(screen);
        width = 36;
        height = 13;
        posx = Math.random()*screen.getWidth();
        posy = Math.random()*100+50;
        hitbox = new Rectangle((int)posx, (int)posy+6, width, height);
        speed = Math.random()+0.1;
        frame = 0;
        count = 0;
        imageBody = new BufferedImage[4];
        for (int i = 0; i < imageBody.length; i++) {
            try {
                imageBody[i] = ImageIO.read(new File("resources"+HitMeEngine.fileSepatator+"Bird-"+i+".png"));
            } catch (IOException ex) {
                Logger.getLogger(Bird.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public Bird(HitMeScreen screen, int x){
        this(screen);
        posx = x;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(imageBody[frame], (int)posx, (int)posy, null);
    }

    @Override
    public void update() {
        if(count==15){
            count = 0;
            frame+= i;
            if(frame==3||frame==0)
                i *= -1;
        }
        count++;
        
        
        if(posx<-width){
            posx = screen.getWidth();
        }
        posx -= speed;

        hitbox.setLocation((int)posx, (int)posy+6);
    }
//    int getHitPosx(){
//        return (int)posx;
//    }
//    int getHitPosy(){
//        return (int)posy+6;
//    }
    public Rectangle getHitbox(){
        return hitbox;
    }
    
}

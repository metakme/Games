package games.hitme;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Projectile extends GameObject {

    double angle;
    double posx;
    double posy;
    double power;
    double speed;
    double basespeed;
    double gravity;
    private static BufferedImage imageBody;
    Point head;
    double radianAngle;

    public Projectile(HitMeScreen screen, int angle, double power, int x, int y) {
        super(screen);
        width = 28;
        height = 9;
        this.angle = angle;
        gravity = 0.002;
        basespeed = 2;
        speed = basespeed;
        this.power = power / 32;
        posx = x;
        posy = y;
        head = new Point((int)posx+51,(int)posy+8);
        try {
            imageBody = ImageIO.read(new File("resources"+HitMeEngine.fileSepatator+"Rocket-0.png"));
        } catch (IOException ex) {
            Logger.getLogger(Tank.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void draw(Graphics2D g2d) {
        Graphics2D g2dcopy = (Graphics2D) g2d.create();

        
        g2dcopy.rotate(Math.toRadians(-angle), posx, posy);
        g2dcopy.drawImage(imageBody, (int) posx - 16, (int) posy - 3, null);        
//        g2d.rotate(Math.toRadians(angle), posx, posy);
        
//        g2dcopy.setStroke(new BasicStroke(4));
//        g2dcopy.draw(new Rectangle(head));
    }

    @Override
    public void update() {
        radianAngle = Math.toRadians(angle);
        posx += (speed + (3 * power)) * (Math.cos(radianAngle));
        posy -= (speed + (3 * power)) * (Math.sin(radianAngle));
//        head.setLocation(posx, posy);
        head.setLocation(posx+(33*(Math.cos(radianAngle))), posy+5-(33*(Math.sin(radianAngle))));
        
        if (angle < 0) {
            speed = basespeed + Math.abs(angle) / 45;

        }

        if (angle > -90) {
            angle -= (1 - power) + gravity;
        }

        if (power > 0) {
            power -= gravity;
        }

        if (head.getY() > screen.getHeight() - 20) {
            screen.toRemove.add(this);
            screen.objects.add(new Explosion(screen, head.x, head.y));
        }
        checkCollision();
    }
    public Point getHeadPoint(){
        return head;
    }
    void checkCollision(){
        for(Bird o : screen.birds){
            if(o.getHitbox().contains(head)){
                screen.toRemove.add(o);
                screen.objects.add(new Explosion(screen, head.x, head.y));
            }
        }
    }

}

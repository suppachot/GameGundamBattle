package gundambattle;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;


public class MobileSuit1 {
    public ImageIcon MonsterSt = new ImageIcon(this.getClass().getResource("1.png"));
    public ImageIcon Monsterat = new ImageIcon(this.getClass().getResource("1b.png"));
    public int x = 400;
    public int y = 130;
    public int hp = 100;
    public int damage = 10;
    public boolean alive = true;
    public int count = 0;
    int distanceP;
    int hit;

    MobileSuit1(){
        
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,90,70));
	}
}

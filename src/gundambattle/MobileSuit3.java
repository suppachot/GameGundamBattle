package gundambattle;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
public class MobileSuit3 {
    public ImageIcon MonsterW = new ImageIcon(this.getClass().getResource("3.png"));
    public ImageIcon MonsterWb = new ImageIcon(this.getClass().getResource("3b.png"));
    public int x,y;
    public int count=0;
    public int hp = 180;
    public int damage = 15;
    public boolean alive = true;
    MobileSuit3(int m){
        if(m==1){
            x=700;
            y=55;
        }
        else if(m==2){           
            x=220;
            y=245;
        }
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,120,100));
    }
}

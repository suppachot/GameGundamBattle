package gundambattle;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
public class door {
    public ImageIcon dooropen = new ImageIcon(this.getClass().getResource("dooropen.png"));
    public ImageIcon doorclose = new ImageIcon(this.getClass().getResource("doorclose.png"));
    public int x;
    public int y;
    door(int m){
        if(m==1){
            x=1100;
            y=302;
        }
        else if(m==2){
            x=10;
            y=69;
        }
        else if(m==3){
            x=1100;
            y=84;
        }
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,45,45));
	}
          
}

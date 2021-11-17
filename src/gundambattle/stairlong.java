package gundambattle;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
public class stairlong {
    public ImageIcon stairlong = new ImageIcon(this.getClass().getResource("stair2.png"));
   
    public int x;
    public int y;
    stairlong(int m){
        if(m==1){
            x=200;
            y=142;
        }
        else if(m==2){
            
        }
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,44,410));
	}
    
}

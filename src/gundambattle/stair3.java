
package gundambattle;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
public class stair3 {
    public ImageIcon stair = new ImageIcon(this.getClass().getResource("stair1.png"));
    public int x;
    public int y;
    stair3(int m){
        if(m==1){
            x=900;
            y=370;
        }
        if(m==3){
            x = 470;
            y = 115;
        }
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,40,255));
    }
    public Rectangle2D getbound2(){
    	    return (new Rectangle2D.Double(x,y,40,205));
    }
    
}
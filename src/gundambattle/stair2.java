package gundambattle;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
public class stair2 {
    public ImageIcon stair = new ImageIcon(this.getClass().getResource("stair1.png"));
    public int x;
    public int y;
    public int w;
    public int h;
    stair2(int m){
        if(m==1){
            x=15;
            y=190;
            w=40;
            h=235;
        }
        else if(m==2){
            x=480;
            y=330;
            w=38;
            h=220;
        }
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,w,h));
	}
    
}

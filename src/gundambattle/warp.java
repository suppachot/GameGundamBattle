package gundambattle;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
public class warp {
    public ImageIcon doorwarp = new ImageIcon(this.getClass().getResource("doorwarp.png"));
    MobileSuit3 MW1 = new MobileSuit3(1);
    MobileSuit3 MW2 = new MobileSuit3(2);
    public int x;
    public int y;
    public int x2;
    public int y2;
    warp(int m){
        if(m==1){
            x = 100;
            y = 340;
            x2 = 370;
            y2 = 80;
        }
        else if(m==2){
            x = MW1.x;
            y = 80;
            x2 = 565;
            y2 = 425;
        }
         else if(m==3){
            x = MW2.x+20;
            y = 275;
            x2 = 1000;
            y2 = 115;
        }
    }
    public Rectangle2D warpin(){
    	return (new Rectangle2D.Double(x,y,40,40));
    }
    public Rectangle2D warpout(){
    	return (new Rectangle2D.Double(x2,y2,40,40));
    }
}

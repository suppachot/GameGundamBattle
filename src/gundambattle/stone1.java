package gundambattle;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
public class stone1 {
    int x,y;
    public ImageIcon stone1 = new ImageIcon(this.getClass().getResource("stonee.png"));
    public ImageIcon stonesmall1 = new ImageIcon(this.getClass().getResource("stonesmall1.png"));
    public ImageIcon stonesmall2 = new ImageIcon(this.getClass().getResource("stonesmall2.png"));
    stone1(int m){
        if(m==1){
            x=300;
            y=379;
        }
        else if(m==2){
            x=280;
            y=516;
        }
        else if(m==3){
            x=420;
            y=516;
        }
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,50,30));
    }
    public Rectangle2D getbound2(){
    	    return (new Rectangle2D.Double(x,y,50,30));
    }
}

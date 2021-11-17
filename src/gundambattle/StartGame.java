package gundambattle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StartGame extends JPanel {
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("ho.png"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("startb.png"));
    private ImageIcon namegame = new ImageIcon(this.getClass().getResource("lo.png"));
    private ImageIcon character = new ImageIcon(this.getClass().getResource("show.png"));
    private ImageIcon how = new ImageIcon(this.getClass().getResource("how.png"));
    public JButton StartGame = new JButton(starts);
    public JButton HowButton = new JButton(how);
    
    
    StartGame(){
        setLayout(null);
        StartGame.setBounds(450, 425, 300, 100);
        StartGame.setBorderPainted(false);
        StartGame.setBorder(null);
        StartGame.setOpaque(false);
        StartGame.setContentAreaFilled(false);
        add(StartGame);
        
        HowButton.setBounds(450, 525, 300, 100);
        HowButton.setBorderPainted(false);
        HowButton.setBorder(null);
        HowButton.setOpaque(false);
        HowButton.setContentAreaFilled(false);
        add(HowButton);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
         g.drawImage(wallpaper.getImage(), 0, 0, 1200, 665, this);
        g.drawImage(namegame.getImage(), 150, 0, 600, 330, this);
        g.drawImage(character.getImage(), 80, 280, 350, 300, this);
        /*g.drawImage(imageunder.getImage(), 0, -30, 1200, 710, this);
        g.drawImage(imagelogo.getImage(), 0, 0, 1200, 665, this);*/
    }
}

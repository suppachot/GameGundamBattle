package gundambattle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;
public class stage3 extends JPanel implements ActionListener{
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("v30.png"));
    private ImageIcon wallpapers = new ImageIcon(this.getClass().getResource("v301.jpg"));
    private ImageIcon closebutton = new ImageIcon(this.getClass().getResource("closebt.png"));
    private ImageIcon win = new ImageIcon(this.getClass().getResource("youwin.png"));
    private ImageIcon died = new ImageIcon(this.getClass().getResource("died.png"));
    private Timer timer = new Timer(100, new Listener());
    private Timer timercount = new Timer(1000, new Listener());
    
    Mygundam hc = new Mygundam(3);
    lever lever = new lever(3);
    door door = new door(3);
    stair3 stair = new stair3(3);
    MobileSuit3 MW1 = new  MobileSuit3(1);
    MobileSuit3 MW2 = new  MobileSuit3(2);
    warp w1 = new warp(1);
    warp w2 = new warp(2);
    warp w3 = new warp(3);
    public JButton closebt = new JButton(closebutton);
    //////////////////////////////////////////////////
    public boolean timestart = false;
    public int checkbacktofront = 0;
    public int checkattack =0;
    public int times;
    public int checklever = 0;
    public int checkdoor =0;
    public boolean nextstage = false;
    int count=0;
    boolean hit1 = false;
    boolean hit2 = false;
    
    //////////////////////////////////////////////////
    public int xx = hc.x;
    public int yy = hc.y;
    public int hpp = hc.hp;
    public int floors = hc.floor;
    public boolean doors = hc.door;
    
    Thread time = new Thread(new Runnable(){
        public void run(){
            int check=0;
            while(true){
                try{
                    if(Intersect(MW1.getbound(),hc.getbound())){
                        MW1.count=1; 
                    }
                    else{
                        if(MW1.alive == true){
                            if(MW1.x==700){
                                check = 0;
                                MW1.x+=5;
                            }
                            else if(MW1.x==800){
                                check = 1; 
                                MW1.x-=5;
                            }
                            else{
                                if(check==0){
                                  MW1.x+=5;  
                                }
                                else{
                                    MW1.x-=5;
                                }
                            }
                        }
                    }
                    if(Intersect(MW2.getbound(),hc.getbound())){
                        MW2.count=1; 
                    }
                    else{
                        if(MW2.alive == true){
                            if(MW2.x==220){
                                check = 0;
                                MW2.x+=5;
                            }
                            else if(MW2.x==320){
                                check = 1; 
                                MW2.x-=5;
                            }
                            else{
                                if(check==0){
                                  MW2.x+=5;  
                                }
                                else{
                                    MW2.x-=5;
                                }
                            }
                        }
                    }
                    Thread.sleep(100);  
                }catch(Exception e){
                 
                }
                if(timestart == false){
                    repaint();
                }
            }
        }
    });
    
    stage3(){
        timer.start();
        time.start();
        timercount.start();
        setFocusable(true);
        setLayout(null);
        hc.floor=1;
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
                if(a==KeyEvent.VK_RIGHT){
                    checkbacktofront = 0;
                    if(hc.floor==1){
                        if(hc.x>=100){
                            hc.x=100;
                            hc.count++;
                        }
                        else{
                            hc.x+=10;
                        }
                    }
                    else if(hc.floor==3){
                        if(hc.x>=830){
                            hc.x=830;
                            hc.count++;
                        }
                        else if(Intersect(stair.getbound2(),hc.getbound())){
                            if(hc.y<=55){
                                hc.x+=10;
                            }
                        }
                        else{
                            hc.x+=10;
                        }
                    }
                    else if(hc.floor==0){
                        if(hc.x>=680){
                            hc.x=680;
                            hc.count++;
                        }
                        else{
                            hc.x+=10;
                        }
                    }
                    else if(hc.floor==2){
                        if(hc.x>=480){
                            hc.x=480;
                            hc.count++;
                        }
                        else if(Intersect(stair.getbound2(),hc.getbound())){
                            if(hc.y<=245){
                                hc.x+=10;
                            }
                        }
                        else{
                            hc.x+=10;
                        }
                    }
                    else if(hc.floor==4){
                        if(hc.x>=1100){
                            hc.x=1100;
                            hc.count++;
                        }
                        else{
                            hc.x+=10;
                            hc.count++;
                        }
                    }
                }  
                else if(a==KeyEvent.VK_LEFT){
                    checkbacktofront = 1;
                    if(hc.floor==1){
                        if(hc.x<=0){
                            hc.x=0;
                            hc.count++;
                        }
                        else{
                            hc.x-=10;
                        }
                    }
                    else if(hc.floor==3){
                        if(hc.x<=320){
                            hc.x=320;
                            hc.count++;
                        }
                        else if(Intersect(stair.getbound2(),hc.getbound())){
                            if(hc.y<=55){
                                hc.x-=10;
                            }
                        }
                        else{
                            hc.x-=10;
                        }
                    }
                    else if(hc.floor==0){
                        if(hc.x<=565){
                            hc.x=565;
                            hc.count++;
                        }
                        else{
                            hc.x-=10;
                        }
                    }
                    else if(hc.floor==2){
                        if(hc.x<=220){
                            hc.x=220;
                            hc.count++;
                        }
                        else if(Intersect(stair.getbound2(),hc.getbound())){
                            if(hc.y>=245){
                                hc.x-=10;
                            }
                        }
                        else{
                            hc.x-=10;
                        }
                    }
                    else if(hc.floor==4){
                        if(hc.x<=990){
                            hc.x=990;
                            hc.count++;
                        }
                        else{
                            hc.x-=10;
                            hc.count++;
                        }
                    }
                }
                else if(a == KeyEvent.VK_SPACE){
                    if(checkattack == 0){
                        checkattack = 1;
                    }
                    if(Intersect(MW1.getbound(),hc.getbound())){
                        if(MW1.hp==0){
                            MW1.hp=0;
                        }
                        MW1.hp-=hc.damage;
                    }
                    if(Intersect(MW2.getbound(),hc.getbound())){
                        if(MW2.hp==0){
                            MW2.hp=0;
                        }
                        MW2.hp-=hc.damage;
                    }
                }
                else if(a == KeyEvent.VK_F){
                    
                    if(Intersect(w1.warpin(),hc.getbound())){
                        hc.x = 370;
                        hc.y = 55;
                        hc.floor = 3;
                    }
                    else if(Intersect(w1.warpout(),hc.getbound())){
                        hc.x = 60;
                        hc.y = 315;
                        hc.floor = 1;
                    }
                    if(MW1.alive==false){
                        if(Intersect(w2.warpin(),hc.getbound())){
                            hc.x = 565;
                            hc.y = 400;
                            hc.floor = 0;
                        }
                        else if(Intersect(w2.warpout(),hc.getbound())){
                            hc.x = 670;
                            hc.y = 55;
                            hc.floor = 3;
                        }
                    }
                    if(MW2.alive==false){
                        if(Intersect(w3.warpin(),hc.getbound())){
                            hc.x = 990;
                            hc.y = 97;
                            hc.floor = 4;
                        }
                        else if(Intersect(w3.warpout(),hc.getbound())){
                            hc.x = 225;
                            hc.y = 245;
                            hc.floor = 2;
                        }
                    }

                    if(Intersect(lever.getbound(),hc.getbound())){
                        checklever = 1;
                        checkdoor = 1;
                    }
                    if(Intersect(door.getbound(),hc.getbound())){
                        if(checkdoor == 1){
                            nextstage = true;
                        }
                        else nextstage = false;
                        
                    }
                    else nextstage = false;
                    
                    
                }
                else if(a==KeyEvent.VK_G){
                    nextstage = true;
                }

                else if(a==KeyEvent.VK_UP){
                    if(hc.floor==2){
                        if(Intersect(stair.getbound2(),hc.getbound())){
                            if(hc.y<=55){
                                hc.y=55;
                                hc.floor=3;
                            }
                            else{
                                hc.y-=10;
                            }
                        }
                    }
                }
                else if(a==KeyEvent.VK_DOWN){
                    if(hc.floor==3){
                        if(Intersect(stair.getbound2(),hc.getbound())){
                            if(hc.y>=245){
                                hc.y = 245;
                                hc.floor=2;
                            }
                            else{
                                hc.y+=10;
                            } 
                        }
                    }
                }  
                if(hc.count >= 2){
                        hc.count = 0;
                    }
            }
            public void keyReleased(KeyEvent e){
                hc.count=0;
            }
        });
        
    }
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == timercount){
                times--;
            }
            
            repaint();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {       
        this.repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 665, this);  
        g.drawImage(w1.doorwarp.getImage(), w1.x, w1.y, 40, 40, this);  
        g.drawImage(w1.doorwarp.getImage(), w1.x2, w1.y2, 40, 40, this); 
        g.drawImage(stair.stair.getImage(), stair.x, stair.y, 80, 205, this);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Fixedsys Regular",Font.HANGING_BASELINE,30));
        g.drawString("Score : "+ hc.score,900, 60);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 20));
        
        if(checklever==1){
            g.drawImage(lever.leverb.getImage(), lever.x, lever.y, 40, 45, this);
            g.drawImage(door.dooropen.getImage(), door.x+2, door.y, 82, 80, this);
        }
        else if(checklever==0){
            g.drawImage(lever.lever.getImage(), lever.x, lever.y, 40, 45, this);           
            g.drawImage(door.doorclose.getImage(), door.x, door.y, 86, 80, this);
        }
        if(checkbacktofront==0){           
            if(hc.count==0){
                if(checkattack == 1){
                    g.drawImage(hc.atkf.getImage(), hc.x+16, hc.y, 120, 100, this);
                    g.drawString("HP : "+hc.hp, hc.x, hc.y-15);
                    
                   
                        if(MW1.hp<=0){
                            MW1.alive = false;
                            hc.score+=100;
                            if(hc.score>=200){
                                hc.score=200;
                            }
                        }
                        if(MW2.hp<=0){
                            MW2.alive = false;
                            hc.score+=100;
                            if(hc.score>=200){
                                hc.score=200;
                            }
                        }
                        checkattack = 0;
                }
                else {
                    g.drawImage(hc.im.getImage(), hc.x, hc.y, 120, 100, this);
                    g.drawString("HP : "+hc.hp, hc.x, hc.y-15);
                }            
            }
            else {
                g.drawImage(hc.imk.getImage(), hc.x, hc.y, 120, 100, this);
                g.drawString("HP : "+hc.hp,hc.x, hc.y-15);
            }
            
        }
        else if(checkbacktofront==1){
            if(hc.count==0){
                if(checkattack == 1){
                    g.drawImage(hc.atkb.getImage(), hc.x-41, hc.y, 120, 100, this);
                    g.drawString("HP : "+hc.hp, hc.x, hc.y-15);
                    
                        if(MW1.hp<=0){
                            MW1.alive = false; 
                            hc.score+=100;
                            if(hc.score>=200){
                                hc.score=200;
                            }
                        }  
                        if(MW2.hp<=0){
                            MW2.alive = false;
                            hc.score+=100;
                            if(hc.score>=200){
                                hc.score=200;
                            }
                        }
                        checkattack = 0;
                }
                else {
                    g.drawImage(hc.imb.getImage(), hc.x, hc.y, 120, 100, this);
                    g.drawString("HP : "+hc.hp, hc.x, hc.y-15);
                }         
            }
            else{
                g.drawImage(hc.imbk.getImage(), hc.x, hc.y, 120, 100, this);
                g.drawString("HP : "+hc.hp, hc.x, hc.y-15);
            }
        }
        if(MW1.alive==false){
            g.drawImage(w2.doorwarp.getImage(), w2.x, w2.y, 40, 40, this);
            g.drawImage(w2.doorwarp.getImage(), w2.x2, w2.y2, 40, 40, this); 
        }
        if(MW2.alive==false){
            g.drawImage(w3.doorwarp.getImage(), w3.x, w3.y, 40, 40, this);
            g.drawImage(w3.doorwarp.getImage(), w3.x2, w3.y2, 40, 40, this); 
        }
        if(MW1.count == 1){ 
            if(MW1.alive == true){
               g.drawImage(MW1.MonsterW.getImage(), MW1.x, MW1.y-10, 120,100, this); 
               g.drawString("HPM : "+MW1.hp, MW1.x-10, MW1.y-15);
               MW1.count = 0;
               hit1 = true;
            }           
        }
        else {
            if(MW1.alive == true){
                g.drawImage(MW1.MonsterW.getImage(), MW1.x, MW1.y, 120,100, this);
                g.drawString("HPM : "+MW1.hp, MW1.x-10, MW1.y-15);
            }
            
            
        }
        if(MW2.count == 1){ 
            if(MW2.alive == true){
               g.drawImage(MW2.MonsterW.getImage(), MW2.x, MW2.y-10, 120,100, this); 
               g.drawString("HPM : "+MW2.hp, MW2.x-10, MW2.y-15);
               MW2.count = 0;
               hit2 = true;
            }           
        }
         else {
            if(MW2.alive == true)
            g.drawImage(MW2.MonsterW.getImage(), MW2.x, MW2.y, 120,100, this);
            g.drawString("HPM : "+MW2.hp, MW2.x-10, MW2.y-15);           
        }
        if(hit1==true){
            hc.hp-=MW1.damage;
            hit1=false;
        }
        if(hit2==true){
            hc.hp-=MW2.damage;
            hit2=false;
        }
       
        if(hc.hp <= 0){
            this.setLayout(null);
            g.setColor(Color.RED);
            g.drawImage(wallpapers.getImage(), 0, 0, 1200, 665, this);   
            g.drawImage(died.getImage(), 100,100, 1000, 200, this);  
            
            setLayout(null);
            closebt.setBounds(600, 450, 500, 120);
            closebt.setBorderPainted(false);
            closebt.setBorder(null);
            closebt.setOpaque(false);
            closebt.setContentAreaFilled(false);
            add(closebt);
            timer.stop();
            timercount.stop();
        }
        if(nextstage == true){
            this.setLayout(null);
            g.setColor(Color.YELLOW);
            g.drawImage(wallpapers.getImage(), 0, 0, 1200, 665, this);
            g.drawImage(win.getImage(), 100, 100, 1000, 400, this); //ชนะ
            
            hc.x = xx;
            hc.y = yy;
            hc.hp = hpp;
            hc.floor = floors;
            hc.door = doors;
            setLayout(null);
            closebt.setBounds(600, 450, 500, 120);
            closebt.setBorderPainted(false);
            closebt.setBorder(null);
            closebt.setOpaque(false);
            closebt.setContentAreaFilled(false);
            add(closebt);
            
            timer.stop();
            timercount.stop();
        }
    }
    public boolean Intersect(Rectangle2D a, Rectangle2D b){
	return (a.intersects(b));
    }
}

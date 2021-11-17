package gundambattle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;
public class stage2 extends JPanel implements ActionListener{
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("v22.png"));
    private ImageIcon wallpaper1 = new ImageIcon(this.getClass().getResource("v23.png"));
     private ImageIcon day = new ImageIcon(this.getClass().getResource("day.png"));
    private ImageIcon died = new ImageIcon(this.getClass().getResource("died.png"));
    private ImageIcon nextstagebutton = new ImageIcon(this.getClass().getResource("nextstage.png"));
    private ImageIcon closebutton = new ImageIcon(this.getClass().getResource("closebt.png")); 
    Mygundam hc = new Mygundam(2);
    stair1 stair1 = new stair1(2);
    stair2 stair2 = new stair2(2);
    stairlong stairlong = new stairlong(1);
    lever lever = new lever(2);
    lever lever2 = new lever(22);
    door door = new door(2);
    stone1 stone1 = new stone1(1); 
    stone1 stonesmall1 = new stone1(2); 
    stone1 stonesmall2 = new stone1(3); 
    MobileSuit2 MB1 = new MobileSuit2(1);
    MobileSuit2 MB2 = new MobileSuit2(2);
    public int xx = hc.x;
    public int yy = hc.y;
    public int hpp = hc.hp;
    public int floors = hc.floor;
    public boolean doors = hc.door;
    ///////////////////////////////////////////////////////////
    public int checkbacktofront = 0;
    public int checkattack =0;
    public int times;
    public boolean timestart = false;
    private Timer timer = new Timer(100, new Listener());
    private Timer timercount = new Timer(1000, new Listener());
    public JButton nextstagebt = new JButton(nextstagebutton);
    public JButton closebt = new JButton(closebutton);
    public int checklever = 0;
    public int checklever2 = 0;
    public int checkdoor =0;
    public boolean checklevers1 = false;
    public boolean checklevers2 = false;
    public boolean nextstage = false;
    int count=0;
    int doorr = 0;
    boolean hit1 = false;
    boolean hit2 = false;
    
    
    Thread time = new Thread(new Runnable(){
        public void run(){
            int check=0;
            while(true){
                try{
                    if(Intersect(MB1.getbound(),hc.getbound())){
                        MB1.count=1; 
                    }
                    else{
                        if(MB1.alive == true){
                            if(MB1.x==200){
                                check = 0;
                                MB1.x+=5;
                            }
                            else if(MB1.x==300){
                                check = 1; 
                                MB1.x-=5;
                            }
                            else{
                                if(check==0){
                                  MB1.x+=5;  
                                }
                                else{
                                    MB1.x-=5;
                                }
                            }
                        }
                    }
                    if(Intersect(MB2.getbound(),hc.getbound())){
                        MB2.count=1; 
                    }
                    else{
                        if(MB2.alive == true){
                            if(MB2.x==700){
                                check = 0;
                                MB2.x+=5;
                            }
                            else if(MB2.x==800){
                                check = 1; 
                                MB2.x-=5;
                            }
                            else{
                                if(check==0){
                                  MB2.x+=5;  
                                }
                                else{
                                    MB2.x-=5;
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
    
    stage2(){
        timer.start();
        time.start();
        timercount.start();
        setFocusable(true);
        setLayout(null);
        
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
                if(a==KeyEvent.VK_RIGHT){
                    checkbacktofront = 0;
                    if(checkbacktofront ==0){
                        if(hc.floor==3){
                            if(hc.x>=1100){
                                hc.x = 1100;
                                hc.count++;
                            }
                            else if(Intersect(stairlong.getbound(),hc.getbound())){   
                                if(hc.y<=80){
                                    hc.x+=10;
                                }
                            }
                            else if(Intersect(stair1.getbound(),hc.getbound())){   
                                if(hc.y<=80){
                                    hc.x+=10;
                                }
                            }
                            else{
                                hc.x+=10;
                                hc.count++;
                            }     
                        }
                        else if(hc.floor==0){
                            if(Intersect(stonesmall1.getbound(),hc.getbound())){
                                hc.x = 225;
                                hc.count++;
                            }
                            else if(hc.x>=1100){
                                hc.x = 1100;
                                hc.count++;
                            }
                            else if(Intersect(stairlong.getbound(),hc.getbound())){   
                                if(hc.y>=475){
                                    hc.x+=10;
                                }
                            }
                            else if(Intersect(stair2.getbound(),hc.getbound())){   
                                if(hc.y>=475){
                                    hc.x+=10;
                                }
                            }
                            else{
                                hc.x+=10;
                                hc.count++;
                            }
                        }
                        else if(hc.floor==2){
                            if(hc.x>=600){
                                hc.x=600;
                                hc.count++;
                            }
                            else if(Intersect(stair1.getbound(),hc.getbound())){
                                if(hc.y<=270){
                                    hc.x+=10;
                                }
                            }
                            else if(Intersect(stair2.getbound(),hc.getbound())){
                                if(hc.y<=270){
                                    hc.x+=10;
                                }
                            }
                            else if(Intersect(stair2.getbound(),hc.getbound())){
                                if(hc.y>=475){
                                    hc.x+=10;
                                }
                            }
                            else{
                                hc.x+=10;
                                hc.count++;
                            }  
                        }
                        
                    }
                             
                }
                
                else if(a==KeyEvent.VK_LEFT){
                    checkbacktofront = 1;
                    if(checkbacktofront == 1){
                        if(hc.floor==3){
                            if(hc.x<=0){
                                hc.x=0;
                                hc.count++;
                            }
                            else if(Intersect(stairlong.getbound(),hc.getbound())){
                                if(hc.y<=80){
                                    hc.x-=10;
                                }
                            }
                            else if(Intersect(stair1.getbound(),hc.getbound())){
                                if(hc.y<=80){
                                    hc.x-=10;
                                }
                            }
                            else{
                               hc.x-=10;
                               hc.count++;
                            } 
                        }
                        else if(hc.floor==0){
                            if(Intersect(stonesmall2.getbound(),hc.getbound())){
                                hc.x=455;
                                hc.count++;
                            } 
                            else if(hc.x<=0){
                                hc.x=0;
                                hc.count++;
                            }
                            else if(Intersect(stairlong.getbound(),hc.getbound())){
                                if(hc.y>=475){
                                    hc.x-=10;
                                }
                            }
                            else{
                               hc.x-=10;
                               hc.count++;
                            } 
                        }
                        else if(hc.floor==2){
                            if(hc.x<=440){
                                hc.x=440;
                                hc.count++;
                            }
                            else if(Intersect(stair2.getbound(),hc.getbound())){
                                if(hc.y<=270){
                                    hc.x-=10;
                                }
                            }
                            else{
                               hc.x-=10;
                               hc.count++;
                            }
                        }
                    }
                    } 
                else if(a == KeyEvent.VK_SPACE){
                    if(checkattack == 0){
                        checkattack = 1;
                    }
                    if(Intersect(MB1.getbound(),hc.getbound())){
                        
                        if(MB1.hp==0){
                            MB1.hp=0;
                        }
                        MB1.hp-=hc.damage;
                    }
                    if(Intersect(MB2.getbound(),hc.getbound())){
                        if(MB2.hp==0){
                            MB2.hp=0;
                        }
                        MB2.hp-=hc.damage;
                    }
                }
                else if(a == KeyEvent.VK_F){
                    if(Intersect(lever.getbound(),hc.getbound())){
                        checklevers1 = true;
                        if(checklever == 0){
                            checklever = 1;
                        }
                        else if(checklever == 1){
                            checklever = 2;
                        }
                    }
                    if(Intersect(lever2.getbound(),hc.getbound())){
                        checklevers2 = true;
                        if(checklever == 0){
                            checklever = 1;
                        }
                        else if(checklever == 1){
                            checklever = 2;
                        }
                        
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
                    if(hc.floor==0){
                        if(Intersect(stairlong.getbound(),hc.getbound())){
                            if(hc.y<=80){
                                hc.y=80;
                                hc.floor=3;
                            }
                            else{
                                hc.y-=10;
                            }
                        }
                        if(Intersect(stair2.getbound(),hc.getbound())){
                            if(hc.y<=270){
                                hc.y=270;
                                hc.floor=2;
                            }
                            else{
                                hc.y-=10;
                            }
                        }
                    }
                    else if(hc.floor==2){
                        if(Intersect(stair1.getbound(),hc.getbound())){
                            if(hc.y<=80){
                                hc.y=80;
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
                        if(Intersect(stairlong.getbound(),hc.getbound())){
                            if(hc.y>=475){
                                hc.y=475;
                                hc.floor=0;
                            }
                            else hc.y+=10;
                        }
                        else if(Intersect(stair1.getbound(),hc.getbound())){
                            if(hc.y>=270){
                                hc.y=270;
                                hc.floor=2;
                            }
                            else hc.y+=10;
                        }
                    } 
                    else if(hc.floor==2){
                        if(Intersect(stair2.getbound(),hc.getbound())){
                            if(hc.y>=475){
                                hc.y=475;
                                hc.floor=0;
                            }
                            else hc.y+=10;
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
    }//แสดง
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 665, this);  
        g.drawImage(stonesmall2.stonesmall2.getImage(), stonesmall2.x, stonesmall2.y,50,30, this);
        g.drawImage(stone1.stone1.getImage(), stone1.x, stone1.y,138 , 167, this); 
        g.drawImage(stonesmall1.stonesmall1.getImage(), stonesmall1.x, stonesmall1.y,50,30, this);  
        g.drawImage(stairlong.stairlong.getImage(), stairlong.x, stairlong.y,80 , 410, this); 
        g.drawImage(stair1.stair.getImage(), stair1.x, stair1.y,80 , 200, this);
        g.drawImage(stair2.stair.getImage(), stair2.x, stair2.y,80 , 220, this);
        
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Fixedsys Regular",Font.HANGING_BASELINE,30));
        g.drawString("Score : "+ hc.score,900, 60);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 20));      
        if(checklevers1 == true){
            g.drawImage(lever.leverb.getImage(), lever.x, lever.y, 40, 45, this);
        }
        else{
            g.drawImage(lever.lever.getImage(), lever.x, lever.y, 40, 45, this);
        }
        if(checklevers2 == true){
             g.drawImage(lever2.leverb.getImage(), lever2.x, lever2.y, 40, 45, this);
        }
        else{
            g.drawImage(lever2.lever.getImage(), lever2.x, lever2.y, 40, 45, this);
        }
        
        if(checklever==1){           
            g.drawImage(door.doorclose.getImage(), door.x, door.y, 86, 80, this);         
        }
        else if(checklever==0){
            g.drawImage(door.doorclose.getImage(), door.x, door.y, 86, 80, this);
        }
        else if(checklever==2){ 
            g.drawImage(door.dooropen.getImage(), door.x, door.y, 86, 80, this);
            checkdoor = 1;
        }
        
        if(checkbacktofront==0){           
            if(hc.count==0){
                if(checkattack == 1){
                    g.drawImage(hc.atkf.getImage(), hc.x+16, hc.y, 120, 100, this);
                    g.drawString("HP : "+hc.hp, hc.x, hc.y-15);
                    checkattack = 0;
                   
                        if(MB1.hp<=0){
                            MB1.alive = false;
                            hc.score+=100;
                            if(hc.score>=200){
                                hc.score=200;
                            }
                        }
                        if(MB2.hp<=0){
                            MB2.alive = false;
                            hc.score+=100;
                            if(hc.score>=200){
                                hc.score=200;
                            }
                        }
                }
                else {
                    g.drawImage(hc.im.getImage(), hc.x, hc.y, 120, 100, this);
                    g.drawString("HP : "+hc.hp, hc.x, hc.y-15);
                }            
            }
            else {
                g.drawImage(hc.imk.getImage(), hc.x, hc.y, 120, 100, this);
                g.drawString("HP : "+hc.hp, hc.x, hc.y-15);
            }
            
        }
        else if(checkbacktofront==1){
            if(hc.count==0){
                if(checkattack == 1){
                    g.drawImage(hc.atkb.getImage(), hc.x-41, hc.y, 120, 100, this);
                    g.drawString("HP : "+hc.hp,hc.x, hc.y-15);
                    checkattack = 0;
                        if(MB1.hp<=0){
                            MB1.alive = false; 
                            hc.score+=100;
                            if(hc.score>=200){
                                hc.score=200;
                            }
                        }  
                        if(MB2.hp<=0){
                            MB2.alive = false;
                            hc.score+=100;
                            if(hc.score>=200){
                                hc.score=200;
                            }
                        }
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
        if(MB1.count == 1){ 
            if(MB1.alive == true){
               g.drawImage(MB1.MonsterSkat.getImage(), MB1.x, MB1.y-10, 120, 100, this); 
               g.drawString("HPM : "+MB1.hp, MB1.x-10, MB1.y-15);
               MB1.count = 0;
               hit1 = true;
            }           
        }
        else {
            if(MB1.alive == true)
            g.drawImage(MB1.MonsterSk.getImage(), MB1.x, MB1.y, 120, 100, this);
            g.drawString("HPM : "+MB1.hp, MB1.x-10, MB1.y-15);
            
        }
        if(MB2.count == 1){ 
            if(MB2.alive == true){
               g.drawImage(MB2.MonsterSkat.getImage(), MB2.x, MB2.y-10, 120, 100, this); 
               g.drawString("HPM : "+MB2.hp, MB2.x-10, MB2.y-15);
               MB2.count = 0;
               hit2 = true;
            }           
        }
        else {
            if(MB2.alive == true){
                g.drawImage(MB2.MonsterSk.getImage(), MB2.x, MB2.y, 120, 100, this);
                g.drawString("HPM : "+MB2.hp, MB2.x-10, MB2.y-15);
            }
                       
        }
         if(hit1==true){
            hc.hp-=MB1.damage;
            hit1=false;
        }
        if(hit2==true){
            hc.hp-=MB2.damage;
            hit2=false;
        }
        if(hc.hp <= 0){
            this.setLayout(null);
            g.setColor(Color.RED);
            g.drawImage(wallpaper1.getImage(), 0, 0, 1200, 800, this);   
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
            g.drawImage(wallpaper1.getImage(), 0, 0, 1200, 800, this);
            g.drawImage(day.getImage(), 450, 40, 400, 220, this);  
            
            hc.x = xx;
            hc.y = yy;
            hc.hp = hpp;
            hc.floor = floors;
            hc.door = doors;
            
            setLayout(null);
            nextstagebt.setBounds(400, 400, 460, 70);
            nextstagebt.setBorderPainted(false);
            nextstagebt.setBorder(null);
            nextstagebt.setOpaque(false);
            nextstagebt.setContentAreaFilled(false);
            add(nextstagebt);
            
            timer.stop();
            timercount.stop();
        }
    }
    public boolean Intersect(Rectangle2D a, Rectangle2D b){
	return (a.intersects(b));
    }
}

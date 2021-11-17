package gundambattle;
import java.awt.event.*;
import javax.swing.*;
public class maingamegundam extends JFrame implements ActionListener {
    StartGame sg = new StartGame();
    stage1 state1 = new stage1(); 
    stage2 stage2 = new stage2();
    stage3 stage3 = new stage3();
    howtoplay htp = new howtoplay();                
    SoundEffect sound = new SoundEffect(); 
    
    public maingamegundam (){
        this.setSize(1200,700);
        this.add(sg);
       sound.FileName = "Blank.wav";         
        sound.sound();                                    
        sg.requestFocusInWindow();
        sg.StartGame.addActionListener(this);
        state1.closebt.addActionListener(this);
        stage2.closebt.addActionListener(this);
        stage3.closebt.addActionListener(this);
        state1.nextstagebt.addActionListener(this);
        stage2.nextstagebt.addActionListener(this);
        sg.HowButton.addActionListener(this);
        htp.backtoentergame.addActionListener(this);    
        
        
        
    }
    public static void main(String[] args) {
        JFrame kui = new maingamegundam();
        kui.setSize(1200,700);
        kui.setVisible(true);
        kui.setTitle("Gundam Battle");
        kui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        kui.setLocationRelativeTo(null);
        kui.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sg.StartGame){
            this.setLocationRelativeTo(null);
            this.remove(sg);
            this.setSize(1200,700);
            this.setTitle("Stage 1");
            this.add(state1);
            state1.requestFocusInWindow();
        }
        else if(e.getSource() == state1.nextstagebt){
            this.setLocationRelativeTo(null);
            this.remove(state1);
            this.setSize(1200,700);
            this.setTitle("Stage 2");
            this.add(stage2);
            stage2.requestFocusInWindow();
        }       
        else if(e.getSource() == stage2.nextstagebt){
            this.setLocationRelativeTo(null);
            this.remove(stage2);
            this.setSize(1200,700);
            this.setTitle("Stage 3");
            this.add(stage3);
            stage3.requestFocusInWindow();
        }
        else if(e.getSource() == sg.HowButton){      //*
            this.setLocationRelativeTo(null);
            this.remove(sg);
            this.setSize(1200,700);
            this.setTitle("How to play ");
            this.add(htp);
            htp.requestFocusInWindow();
        }   //คำสั่งกดย้อนกลับ
        else if(e.getSource() == htp.backtoentergame){
            this.setLocationRelativeTo(null);
            this.remove(htp);
            this.setSize(1200,700);
            this.setTitle("Dimond Miner");
            this.add(sg);
            sg.requestFocusInWindow();
        }
        
        else if(e.getSource()==stage2.closebt){
            System.exit(0);
        }
        else if(e.getSource()==stage3.closebt){
            System.exit(0);
        }
        else if(e.getSource() == state1.closebt){
            System.exit(0);
        }
        this.validate();
        this.repaint();
    }
    
}

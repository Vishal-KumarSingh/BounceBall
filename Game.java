import javax.swing.*;
import java.util.Timer; 
import java.util.TimerTask; 
import java.lang.Thread;
import java.awt.event.*;
public class Game {
    public static JFrame j;
    public static JLabel pad;
    public static JLabel score;
    public static int score_value;
    public static int  pad_position;
    public static void main(String []args){
            j=new JFrame("Bounce ball");
        pad= new JLabel("______________________");
        score=new JLabel("0");
            JButton left= new JButton("<");
            JButton right= new JButton(">");
   j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   j.setSize(500,500);
   j.setLayout(null);
   pad_position=0;
   score_value=0;
           score.setBounds(450,10,20,20);
          pad.setBounds(10,350,180,20);
          left.setBounds(0,400,250,50); 
          right.setBounds(250,400,250,50);

left.addActionListener(new LeftMover());
right.addActionListener(new RightMover());


          j.add(pad);
          j.add(left);
          j.add(right);
          j.add(score);
          Gameplay gp=new Gameplay();
        gp.start();
  j.setVisible(true);

    }
    
}
class Gameplay extends Thread {
    private int current_left_position;
    private int current_top_position;
    public Gameplay(){
        current_left_position=0;
        current_top_position=-20;
    }
public void run(){
    JLabel item= new JLabel("O");
    Game.j.add(item);
    while(true){
        current_top_position+=20;
item.setBounds(current_left_position,current_top_position,20,20);


if(current_top_position>=350){
   if(current_left_position-Game.pad_position>150||current_left_position<=Game.pad_position)
   {
       System.out.println("Game over");
       try{
       Thread.sleep(10000000);
       }
       catch(Exception e){
           System.out.println("Error occured");
       }
       //out code here
   }else{
       Game.score.setText(String.valueOf(Game.score_value++));
    current_top_position=0;
    current_left_position=(int)(Math.random()*500)+20;
   }


}







try{
Thread.sleep(400);
}catch(Exception e){
    System.out.println("Something went wrong");
}
    }

}

}










class LeftMover implements ActionListener {
public void actionPerformed(ActionEvent e){
    if(Game.pad_position>0){
        Game.pad_position-=20;
Game.pad.setBounds(Game.pad_position,350,180,20);
    }
}

}
class RightMover implements ActionListener {

public void actionPerformed(ActionEvent e){
if(Game.pad_position<350){
    Game.pad_position+=50;
    Game.pad.setBounds(Game.pad_position,350,180,20);
}
}

}
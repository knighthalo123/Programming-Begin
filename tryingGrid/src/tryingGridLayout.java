import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class tryingGridLayout extends JPanel {

  public tryingGridLayout(){
    super(new GridLayout(2,2));
    add(new JButton("w w w.j a v a 2 s . c o m"));
    add(new JButton("w w w.j a v a 2 s . com" ));
    add(new JButton("w w w.java2s.com" ));
    add(new JButton("www.j ava 2 s . c o m" ));
  }
  
  
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new tryingGridLayout());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200,200);
    frame.setVisible(true);
  }
}
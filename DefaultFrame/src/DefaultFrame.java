import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DefaultFrame extends JFrame{

 private static final long serialVersionUID = 8308158808990198933L;
 
 private MovingImage movingImage;
 private JButton startButton;
 
 public DefaultFrame(){
  movingImage = new MovingImage();
  movingImage.setStartCoordinate( 100,  100 );
  movingImage.setEndCoordinate( 300,  500 );
  getContentPane().add( movingImage );
  
  startButton = new JButton("start");
  getContentPane().add( startButton, BorderLayout.NORTH );
  startButton.addActionListener( new ActionListener(){
   public void actionPerformed( ActionEvent ae ){
    new Thread( movingImage ).start();
   }
  });
  
  
  
  
  setSize( 800, 800 );
  setVisible( true );
 }
 
 public static void main( String[] args ){
  new DefaultFrame();
 }

}

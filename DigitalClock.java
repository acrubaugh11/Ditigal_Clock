
package digitalclock;
import static digitalclock.ClockComponents.getDate;
import static digitalclock.ClockComponents.getTime;
import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


/** This class creates a Gui that presents to us a digital clock
 * 
 * @author Alexander Crubaugh
 * (this project was made solely by documentation provided by Oracle)
 */
public class DigitalClock implements Runnable {

    // identify the two JLables that we will be using and periodically updating
    public static JLabel date;
    public static JLabel time;
    public static JFrame frame;
    
    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createGui();
        
        //create a new instance obj of Digital Clock to run a new thread
        DigitalClock clock = new DigitalClock();
        
        //by implmeneting Runnable, we create a new thread with target as new obj clock
        Thread thread = new Thread(clock);
        
        //call the thread Run method
        thread.start();
      
    }

    /** This void method creates a simple Gui
     * 
     */
    public static void createGui(){
        frame = new JFrame("Digital clock");
        
        //close JFrame after hitting close button
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        frame.setSize(800, 600);
        
        frame.setResizable(false);
        
        frame.setLocation(350, 200);
        
        addComp(frame);
        
        frame.setBackground(Color.BLACK);
        
        frame.getContentPane().setBackground(Color.BLACK);
        

        
        frame.setVisible(true);
        
       
        
        
         
        
    }
    
    /** This method adds components to our GUI. These components are the two J-labels
     * that will store our date and our time
     * 
     * @param frame is the frame in which we will set our JLabels on
     */
    public static void addComp(JFrame frame){     
        date = new JLabel();
        date.setVerticalAlignment(SwingConstants.CENTER);
        date.setHorizontalAlignment(SwingConstants.CENTER);
        date.setFont(new Font("Technology", Font.BOLD, 40));
        date.setBounds((frame.getWidth() / 2) - 200, 100, 400, 100);
        date.setForeground(Color.red);
        frame.add(date);
        
        
        time = new JLabel();
        time.setVerticalAlignment(SwingConstants.CENTER);
        time.setHorizontalAlignment(SwingConstants.CENTER);
        time.setFont(new Font("Technology", Font.BOLD, 80));
        time.setBounds((frame.getWidth() / 2) - 100, 300, 200, 100);
        time.setForeground(Color.red);
        frame.add(time);  
        
//         Graphics gfx = frame.getContentPane().getGraphics().create();
//        gfx.drawImage(loadImage("/Users/acrubaugh/Desktop/DigitalClock/src/lib/snoopy.jpeg").getImage(), 0, 0, frame);
//        
        
    
    }   


    /** In this override thread method, as long as it is called it will continuously
     * run, each 1000 milliseconds it will update the JLabel time text and date
     * using setText method and update the time and date every second
     */
    @Override
    public void run() {
        
        while(true){
                        try {
                            sleep(1000);
                            time.setText(getTime());
                            date.setText(getDate());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            }
                    } 
    }
    
    
    
    public static ImageIcon loadImage(String resourcePath) {
        try{
            //read image file path
            BufferedImage image = ImageIO.read(new File(resourcePath));
            
            //return an imgae icon so component can render it
            return new ImageIcon(image);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        System.out.println("Could not find resource");
        return null;
    }    
    
    
    
    
    
}

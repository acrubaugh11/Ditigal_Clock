
package digitalclock;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;

/** This class gets the date and time
 * We instantiate variables that will be used throughout (J-label, SimpleDateFormat,
 * and String for the time)
 * @author Alexander Crubaugh
 */
public class ClockComponents{
    JLabel label;
    SimpleDateFormat dateFormat;
    public static String fTime;

 
    /** This method uses calendar to instantiate an instance with current date and
     * time. Then from date and time we specifically select filter out the date
     * by inputting datePattern and using date format to format our dateTime
     * 
     * @return returns date in string of format (day, month ,date year)
     */
    public static String getDate(){
        Calendar today = Calendar.getInstance();
        Date dateTime = today.getTime();
        
        String datePattern = "EEE , MMM d , yyyy";
        
        SimpleDateFormat df = new SimpleDateFormat(datePattern);

        fTime = df.format(dateTime);
        return fTime;
    }
    
    /** This method is the same as previously, however we change the string pattern
     * to only filter for hours, minutes, seconds and am/pm. Which gives us the time
     * 
     * @return returns a string in the form of hours, min, seconds, am/pm
     */
    public static String getTime(){
        Calendar today = Calendar.getInstance();
        Date dateTime = today.getTime();
        
        String timePattern = "hh : mm : ss aaa";
        
        SimpleDateFormat tf = new SimpleDateFormat(timePattern);
        fTime = tf.format(dateTime);
        return fTime;
    }
 
    
}

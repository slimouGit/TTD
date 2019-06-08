package golem;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Siegel {

    public boolean hatEnergie(){
        Calendar cal = new GregorianCalendar();
        cal.setTime( new Date() );
        int wochentag = cal.get(Calendar.DAY_OF_WEEK);
        if(wochentag != 6)
            return true;
        return false;
    }
    
}
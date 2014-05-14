
package assignment2;

import java.util.GregorianCalendar;

/**
 *
 * @author rsshethia
 */
public class RaceContestant extends Contestant {
    
    public static final RaceStatus DEFAULT_RACESTATUS = RaceStatus.NOT_STARTED;
    
    String mCategory[];
    GregorianCalendar mStartTime;
    GregorianCalendar mFinishTime;
    RaceStatus mRaceStatus;
    RaceCarnival mRaceCarnival;
    
    
    public RaceContestant(int id,
            String familyName,
            String givenName,
            GenderType gender,
            GregorianCalendar DOB,
            String email, 
            String category, 
            GregorianCalendar startTime, 
            GregorianCalendar finishTime){
        
        super(id, familyName, givenName, gender, DOB, email);
        //Category ?
        mStartTime = startTime;
        mFinishTime = finishTime;
        
        
        
        
    }
    
    public GregorianCalendar getStartTime(){
        return mStartTime;
    }
    
    public void setStartTime(){
        
    }
    
    public GregorianCalendar getFinishTime(){
        return mFinishTime;
    }
    
    public void setFinishTime(){
        
    }
    
    public double getTimeTaken(){
        double timeTaken = 0;
        
        return timeTaken;
    }
    
    public String getRaceStatus(){
        return mRaceStatus;
    }
    
    public void setRaceStatus(){
        
    }

    @Override
    public String getCategory() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean setCategory(String category) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

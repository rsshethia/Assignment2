package assignment2;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author rsshethia
 */
public class RaceContestant extends Contestant {

    public static final RaceStatus DEFAULT_RACESTATUS = RaceStatus.NOT_STARTED;
    private String mCategory;
    private GregorianCalendar mStartTime;
    private GregorianCalendar mFinishTime;
    private RaceStatus mRaceStatus;
    private RaceCarnival mRaceCarnival;
    //mPlacing?? 1st 2nd etc??

    public RaceContestant(int id,
            String familyName,
            String givenName,
            GenderType gender,
            GregorianCalendar DOB,
            String email,
            String category) {
        this(id, familyName, givenName, gender, DOB, email, category, null, null);
    }

    public RaceContestant(int id,
            String familyName,
            String givenName,
            GenderType gender,
            GregorianCalendar DOB,
            String email,
            String category,
            GregorianCalendar startTime,
            GregorianCalendar finishTime) {

        this(id, familyName, givenName, gender, DOB, email, category, null, null, null);

    }

    public RaceContestant(int id,
            String familyName,
            String givenName,
            GenderType gender,
            GregorianCalendar DOB,
            String email,
            String category,
            GregorianCalendar startTime,
            GregorianCalendar finishTime,
            RaceCarnival carnival) {

        super(id, familyName, givenName, gender, DOB, email);
        mCategory = category;
        mStartTime = startTime;
        mFinishTime = finishTime;
        mRaceStatus = DEFAULT_RACESTATUS;
        mRaceCarnival = carnival;

    }

    public RaceContestant(RaceContestant contestant) {
        this(contestant, contestant.getRaceCarnival());
    }
    
    public RaceContestant(RaceContestant contestant,RaceCarnival carnival) {
        this(contestant.getId(),
                contestant.getFamilyName(), contestant.getGivenName(),
                contestant.getGender(), contestant.getDOB(),
                contestant.getEMail(), contestant.getCategory(),
                contestant.getStartTime(), contestant.getFinishTime(),
                carnival);
    }

    public boolean setStartTime() {
        if (mRaceStatus.equals(DEFAULT_RACESTATUS)) {
            mStartTime = new GregorianCalendar();
            mRaceStatus = RaceStatus.RACING;
            return true;
        } else {
            return false;
        }
    }

    public GregorianCalendar getStartTime() {
        return mStartTime;
    }

    public boolean setFinishTime() {
        if (mRaceStatus.equals(RaceStatus.RACING)) {
            mFinishTime = new GregorianCalendar();
            mRaceStatus = RaceStatus.FINISHED;
            return true;
        } else {
            return false;
        }
    }

    public GregorianCalendar getFinishTime() {
        return mFinishTime;
    }

    public double getTimeTaken() {
        if (mRaceStatus.equals(RaceStatus.FINISHED)) {
            return mFinishTime.compareTo(mStartTime) / 1000.0;
        } else {
            return Double.NaN;
        }
    }

    public RaceStatus getRaceStatus() {
        return mRaceStatus;
    }

    @Override
    public String getCategory() {
        return mCategory;
    }

    @Override
    public boolean setCategory(String category) {
        if (mRaceCarnival == null) {
            mCategory = category;
            return true;
        } else {

            boolean validCategory = false;
            for (int i = 0; !validCategory && i < mRaceCarnival.getCategories().length; i++) {
                validCategory = mRaceCarnival.getCategories()[i].equals(category);
            }

            if (validCategory) {
                mCategory = category;
                return true;
            } else {
                return false;
            }
        }
    }

//?? Possible to only be accessed by RaceCarnival?????        
    public RaceCarnival getRaceCarnival() {
        return mRaceCarnival;
    }

    @Override
    public boolean equals(Object obj2) {
        RaceContestant contestant;
        boolean equal = false;

        if (obj2 != null && obj2.getClass() == this.getClass()) {
            contestant = (RaceContestant) obj2;
            if (super.equals(obj2)
                    && contestant.getCategory().equals(mCategory)
                    && contestant.getStartTime().equals(mStartTime)
                    && contestant.getFinishTime().equals(mFinishTime)
                    && contestant.getRaceStatus().equals(mRaceStatus)                    
                    && contestant.getRaceCarnival() == mRaceCarnival) {
                equal = true;
            }
        }
        return equal;
    }

    //CopyMethod
    //compareTo
    //Any More methods???
    @Override
    public String toString() {
        String result;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        //??test milliseconds not sure of format********     
        SimpleDateFormat dateFormat2 = new SimpleDateFormat(
                "hh:mm:ss.sss");

        result = getClass().getName() + ":\n";
        result += "Identification number = " + super.getId();
        result += "\nFamily name = " + super.getFamilyName();
        result += "\nGiven name = " + super.getGivenName();
        result += "\nGender = " + super.getGender();
        result += "\nDate of birth = " + dateFormat.format(super.getDOB());
        result += "\nEmail = " + super.getEMail();
        result += "\nEvent category = " + mCategory;
        result += "\nStart time = " + dateFormat2.format(mStartTime);
        result += "\nFinish time = " + dateFormat2.format(mFinishTime);
        result += "\nTime taken = " + getTimeTaken();
        result += "\nRace Status = " + mRaceStatus;
        //getClass().getName()??????????????????????????????      
        result += "\nRace Carnival" + mRaceCarnival;

        return result;
    }
}

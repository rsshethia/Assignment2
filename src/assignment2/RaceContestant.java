package assignment2;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


/**
 * Assignment 2 - CSE1IOO Semester 1, 2014.
 * @author Orien, Dean and Rushabh
 * @version 1.0
 * 
 * RaceContestant Class.
 * Race Contestant is special type of contestant who takes part in a race.
 * 
 */
 
public class RaceContestant extends Contestant {

    public static final RaceStatus DEFAULT_RACESTATUS = RaceStatus.NOT_STARTED; /*Default race status for contestant*/
    
    private String mCategory;              // Race catergory
    private GregorianCalendar mStartTime;  //Starting time of race contestant
    private GregorianCalendar mFinishTime; // Finishing time of race contestant
    private RaceStatus mRaceStatus;        // Status of race contestant in a race*/
    private RaceCarnival mRaceCarnival;    //Race Carnival
    //mPlacing?? 1st 2nd etc??


    /**
     * Constructor of RaceContestant Class
     * @param id               An unique id for each contestant
     * @param familyName       A String for contestant's Family Name
     * @param givenName        A String for contestant's Given Name
     * @param gender           A GenderType of contestant
     * @param DOB              A Date for contestant's date of birth
     * @param email            A String for contestant's email id
     * @param category         A String for contestant's race category
     */
    public RaceContestant(int id,
            String familyName,
            String givenName,
            GenderType gender,
            GregorianCalendar DOB,
            String email,
            String category) {
        this(id, familyName, givenName, gender, DOB, email, category, null, null);
    }

    /**
     * Constructor of RaceContestant Class 
     * @param id               An unique id for each contestant
     * @param familyName       A String for contestant's Family Name
     * @param givenName        A String for contestant's Given Name
     * @param gender           A GenderType of contestant
     * @param DOB              A Date for contestant's date of birth
     * @param email            A String for contestant's email id
     * @param category         A String for contestant's race category
     * @param startTime        Start time of contestant
     * @param finishTime       Finish time of contestant
     */
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

    /**
     * Constructor of RaceContestant Class
     * This initializes all data members and allows appropriate data members to be set.
     * @param id               An unique id for each contestant
     * @param familyName       A String for contestant's Family Name
     * @param givenName        A String for contestant's Given Name
     * @param gender           A GenderType of contestant
     * @param DOB              A Date for contestant's date of birth
     * @param email            A String for contestant's email id
     * @param category         A String for contestant's race category
     * @param startTime        Start time of contestant
     * @param finishTime       Finish time of contestant
     * @param carnival         Reference to RaceCarnival to which the contestant belongs
     */
     
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

    /**
     * Constructor of RaceContestant class
     * 
     * Copy constructor
     */
    public RaceContestant(RaceContestant contestant) {
        this(contestant, contestant.getRaceCarnival());
    }
    
    /**
     * Constructor of RaceContestant class
     * 
     * Copies contestant and initialises RaceCarnival
     */
    public RaceContestant(RaceContestant contestant,RaceCarnival carnival) {
        this(contestant.getId(),
                contestant.getFamilyName(), contestant.getGivenName(),
                contestant.getGender(), contestant.getDOB(),
                contestant.getEMail(), contestant.getCategory(),
                contestant.getStartTime(), contestant.getFinishTime(),
                carnival);
    }

    /**
     * Set contestant's start time
     */
    public boolean setStartTime() {
        if (mRaceStatus.equals(DEFAULT_RACESTATUS)) {
            mStartTime = new GregorianCalendar();
            mRaceStatus = RaceStatus.RACING;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get contestant's start time.
     * 
     * @return time, start time of contestant.
     */
    public GregorianCalendar getStartTime() {
        return mStartTime;
    }

    /**
     * Set contestant's finish time
     */
    public boolean setFinishTime() {
        if (mRaceStatus.equals(RaceStatus.RACING)) {
            mFinishTime = new GregorianCalendar();
            mRaceStatus = RaceStatus.FINISHED;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get contestant's finish time.
     * 
     * @return time, finsih time of contestant.
     */
    public GregorianCalendar getFinishTime() {
        return mFinishTime;
    }

    /**
     * Calculate time taken by race contestant with help of start and finish time.
     * It helps to determine the winner of the race.
    */
    public double getTimeTaken() {
        if (mRaceStatus.equals(RaceStatus.FINISHED)) {
            return mFinishTime.compareTo(mStartTime) / 1000.0;
        } else {
            return Double.NaN;
        }
    }

    /**
     * Get Status of the race contestant in a race
     * 
     * @return RaceStatus of race contestant.
     */
    public RaceStatus getRaceStatus() {
        return mRaceStatus;
    }

    /**
     * Get race category for the race carnival
     * 
     * @return mCategory, a race category
     */
    @Override
    public String getCategory() {
        return mCategory;
    }

    /**
     * Set race category for the race carnival
     *
     */
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

    /**
     * Get race carnival
     * 
     * @return mRaceCarnival.
     */
    public RaceCarnival getRaceCarnival() {
        return mRaceCarnival;
    }

    /**
     * Compare the specified object and this item for equality
     */
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

    /**
     * Gives a String representation of this item
     * 
     * @returns result, a String representation of this item including the name of the
     * class and data member names and values
     */
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

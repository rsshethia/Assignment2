package assignment2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * General contestant class for an event.
 *
 * e.g. Contestant in a swimming race, chess tournament, golf championship etc.
 *
 * The class is abstract because all contestants must have an event category,
 * however an appropriate event categories can only be defined in sub classes.
 *
 * Note: the data in this class is not validated.
 *
 * @author Tim Whitfort
 * @version 1.0
 */
public abstract class Contestant {

    private final int mId;  // Unique identifier for contestant e.g. 1234.
    private String mFamilyName;  // Family name of contestant e.g. Smith.
    private String mGivenName;  // Given name of contestant e.g. Mandy.
    private GenderType mGender;  // Gender of contestant. e.g. GenderType.FEMALE
    private GregorianCalendar mDOB;  // Date of birth of contestant.
    private String mEmail;  // Email address of contestant e.g. mandy.smith@gmail.com

    /**
     * The main constructor for a contestant.
     *
     * @param id an int for the id number of the contestant.
     * @param familyName a String for the family name of the contestant.
     * @param givenName a String for the given name of the contestant.
     * @param gender a GenderType for the gender of the contestant.
     * @param DOB a GregorianCalendar for the date of birth of the contestant.
     * @param email a String for the email address of the contestant.
     */
    public Contestant(int id,
            String familyName,
            String givenName,
            GenderType gender,
            GregorianCalendar DOB,
            String email) {
        mId = id;
        mFamilyName = familyName;
        mGivenName = givenName;
        mGender = gender;
        // Copy the date part only ignoring the time component.
        mDOB = new GregorianCalendar(DOB.get(Calendar.YEAR), DOB.get(Calendar.MONTH), DOB.get(Calendar.DAY_OF_MONTH));
        mEmail = email;
    }

    /**
     * Copy constructor for a Contestant.
     *
     * @param cont2 the contestant to copy.
     */
    public Contestant(Contestant cont2) {
        this(cont2.mId, cont2.mFamilyName, cont2.mGivenName, cont2.mGender, cont2.mDOB, cont2.mEmail);
    }

    /**
     * Get the contestants id number.
     *
     * @return the id number of the contestant.
     */
    public int getId() {
        return mId;
    }

    /**
     * Get the contestants family name (surname).
     *
     * @return the family name of the contestant.
     */
    public String getFamilyName() {
        return mFamilyName;
    }

    /**
     * Change the contestants family name (surname).
     *
     * @param familyName a String for the new family name of the contestant.
     */
    public void setFamilyName(String familyName) {
        mFamilyName = familyName;
    }

    /**
     * Get the contestants given name (first name).
     *
     * @return the given name of the contestant.
     */
    public String getGivenName() {
        return mGivenName;
    }

    /**
     * Change the contestants given name (first name).
     *
     * @param givenName a String for the new given name of the contestant.
     */
    public void setGivenName(String givenName) {
        mGivenName = givenName;
    }

    /**
     * Get the contestants gender.
     *
     * @return the gender of the contestant.
     */
    public GenderType getGender() {
        return mGender;
    }

    /**
     * Change the gender of the contestant.
     *
     * @param gender a GenderType for the new gender of the contestant.
     */
    public void setGender(GenderType gender) {
        mGender = gender;
    }

    /**
     * Get the contestants date of birth (DOB).
     *
     * @return the date of birth of the contestant.
     */
    public GregorianCalendar getDOB() {
        return (GregorianCalendar) mDOB.clone();
    }

    /**
     * Change the contestants date of birth.
     *
     * Only the date part of the GregorianCalendar is used, there is no time
     * component.
     *
     * @param DOB a GregorianCalendar for the date of birth of the contestant.
     */
    public void setDOB(GregorianCalendar DOB) {
        mDOB = new GregorianCalendar(DOB.get(Calendar.YEAR), DOB.get(Calendar.MONTH), DOB.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * Get the contestants email address.
     *
     * @return the email address of the contestant.
     */
    public String getEMail() {
        return mEmail;
    }

    /**
     * Change the contestants email address.
     *
     * @param email a String for the email address of the contestant.
     */
    public void setEMail(String email) {
        mEmail = email;
    }

    /**
     * Get the contestants category.
     *
     * @return the category of the contestant.
     */
    public abstract String getCategory();

    /**
     * Change the contestants event category.
     *
     * All contestants must have an event category e.g. Female 20-29 years, Open
     * Mens etc. The categories that are appropriate for a contestant depend on
     * the type of event that they are in which can only defined in a subclass.
     *
     * @param category a String for the event category the contestant is in.
     * @return whether the category was changed or not.
     */
    public abstract boolean setCategory(String category);

    /**
     * Is the current object equal to the object passed to the method?
     *
     * To be equal the objects must belong to the same class and all data
     * members must have the same value.
     *
     * @param obj2 the object to be compared with the current object.
     * @return whether the objects are equal or not.
     */
    @Override
    public boolean equals(Object obj2) {
        boolean equal;
        Contestant cont2;

        equal = false;
        if (obj2 != null && obj2.getClass() == this.getClass()) {
            cont2 = (Contestant) obj2;
            if (cont2.mId == mId
                    && cont2.mFamilyName.equals(mFamilyName)
                    && cont2.mGivenName.equals(mGivenName)
                    && cont2.mGender == mGender
                    && cont2.mDOB.equals(mDOB)
                    && cont2.mEmail.equals(mEmail)) {
                equal = true;
            }
        }

        return equal;
    }

    /**
     * Hashcode for a Contestant.
     *
     * @return a hashcode for the contestant.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.mId;
        hash = 37 * hash + Objects.hashCode(this.mFamilyName);
        hash = 37 * hash + Objects.hashCode(this.mGivenName);
        hash = 37 * hash + Objects.hashCode(this.mGender);
        hash = 37 * hash + Objects.hashCode(this.mDOB);
        hash = 37 * hash + Objects.hashCode(this.mEmail);
        return hash;
    }

    /**
     * A contestant represented a s a string.
     *
     * @return a string representing the contestant.
     */
    @Override
    public String toString() {
        String result;
        SimpleDateFormat dateFormat;

        dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        result = "id=" + mId
                + ", familyName=" + mFamilyName
                + ", givenName=" + mGivenName
                + ", gender=" + mGender.toString()
                + ", dateOfBirth=" + dateFormat.format(mDOB.getTime())
                + ", email=" + mEmail;

        return result;
    }

}
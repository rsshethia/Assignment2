package assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author rsshethia
 */
public class RaceCarnival {

    private TreeMap<Integer, RaceContestant> mIDCarnival;
    private TreeMap<String, RaceContestant> mNameCarnival;
    private String mName;
    private GregorianCalendar mDate;
    private String[] mCategories;

    public RaceCarnival(String name, GregorianCalendar date, String[] categories) {
        mIDCarnival = new TreeMap();
        mNameCarnival = new TreeMap();
        mName = name;
        mDate = date;
        mCategories = categories;
        if (name.equals("")) {
            throw new RaceCarnivalException("Carnival name must not be blank");
        }
        if (date.compareTo(new GregorianCalendar()) < 0) {
            throw new RaceCarnivalException("Date must not be in the past");
        }
    }

    //get/set/equals/compareTo
    public String[] getCategories() {
        return mCategories.clone();
    }

    public boolean addRaceContestant(RaceContestant contestant) {
        boolean add = false;
        boolean validCategory = false;
        for (int i = 0; !validCategory && i < mCategories.length; i++) {
            validCategory = mCategories[i].equals(contestant.getCategory());
        }
        if (!mIDCarnival.containsKey(contestant.getId())
                && contestant.getRaceCarnival().equals(null)
                && validCategory) {

            RaceContestant contestant2 = new RaceContestant(contestant,this);
            
            mNameCarnival.put(contestant2.getFamilyName()+","+contestant2.getGivenName()+","+contestant2.getId(), contestant2);
            mIDCarnival.put(contestant2.getId(), contestant2);
            add = true;
        }
        return add;
    }

    public RaceContestant getRaceContestant(int id) {
        RaceContestant contestant2 = new RaceContestant(mIDCarnival.get(id));
        return contestant2;
    }

    public RaceContestant modifyContestant(RaceContestant contestant) {
        RaceContestant modify = null;
        boolean validCategory = false;
        for (int i = 0; !validCategory && i < mCategories.length; i++) {
            validCategory = mCategories[i].equals(contestant.getCategory());
        }
        if (mIDCarnival.containsKey(contestant.getId())
//??Should be == ??*******************************************************                
                && contestant.getRaceCarnival().equals(this)
                && validCategory) {

            RaceContestant contestant2 = new RaceContestant(contestant,this);
            
            modify = mIDCarnival.put(contestant2.getId(), contestant2);
            mNameCarnival.put(contestant2.getFamilyName()+","+contestant2.getGivenName()+","+contestant2.getId(), contestant2);
        }
        return modify;
    }

    public RaceContestant deleteContestant(int id) {
        RaceContestant contestant= mIDCarnival.get(id);
        mNameCarnival.remove(contestant.getFamilyName()+","+contestant.getGivenName()+","+contestant.getId());
        return mIDCarnival.remove(id);
    }

    public boolean setStartTime(int id) {
        return mIDCarnival.get(id).setStartTime();
    }

    public boolean setFinishTime(int id) {
        return mIDCarnival.get(id).setFinishTime();
    }

    public double getTimeTaken(int id) {
        return mIDCarnival.get(id).getTimeTaken();
    }

    @Override
    public String toString() {
        String result;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

        result = getClass().getName() + ":\n";
        result += "Carnival name = " + mName;
        result += "\nCarnival date = " + dateFormat.format(mDate);

        result += "\nRace categories: ";
        for (String category : mCategories) {
            result += String.format("%n 18%s", category);
        }

        Iterator<RaceContestant> iter = mIDCarnival.values().iterator();
        while (iter.hasNext()) {
            result += "\n" + iter.next().toString();
        }
        return result;
    }

    public RaceContestant[] sortByTimeTaken() {
        ArrayList<RaceContestant> finishedAL = new ArrayList();

        Iterator<RaceContestant> iter = mIDCarnival.values().iterator();
        while (iter.hasNext()) {
            RaceContestant contestant = iter.next();
            if (contestant.getRaceStatus().equals(RaceStatus.FINISHED)) {
                finishedAL.add(new RaceContestant(contestant));
            }
        }

        RaceContestant[] finishedArray = finishedAL.toArray(new RaceContestant[finishedAL.size()]);

        SortOrder order = new SortOrder();
        Arrays.sort(finishedArray, order);
        return finishedArray;
    }

    /**
     * Specifies the order of a sort.
     */
    private class SortOrder implements Comparator {       

        @Override
        public int compare(Object obj1, Object obj2) {
            return (int) (((RaceContestant) obj1).getTimeTaken() - ((RaceContestant) obj2).getTimeTaken() * 1000);
        }
    }

    public RaceContestant winner() {
        RaceContestant winner = null;
        Iterator<RaceContestant> iter = mIDCarnival.values().iterator();
        while (iter.hasNext()) {
            RaceContestant contestant = iter.next();
            if (contestant != null && contestant.getRaceStatus().equals(RaceStatus.FINISHED)) {
                if (winner == null) {
                    winner = contestant;
                } else {
                    if (contestant.getTimeTaken() < winner.getTimeTaken()) {
                        winner = contestant;
                    }
                }
            }
        }
        return winner;
    }

//??Check requirements with Tim????    
    public boolean loadFile(String inFileName) {
        boolean noError=false;
        String lineOfText;
        BufferedReader inFile;
        String[] fields;
        int id;
        String familyName;
        String givenName;
        GenderType gender=null;
        GregorianCalendar DOB;
        String email;
        String category;
        GregorianCalendar startTime;
        GregorianCalendar finishTime;

        SimpleDateFormat dateFormat;
        SimpleDateFormat dateFormat2;
        RaceContestant contestant;

        dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        dateFormat2 = new SimpleDateFormat("hh:mm:ss.sss");
        dateFormat.setLenient(false);
        dateFormat2.setLenient(false);
        DOB = new GregorianCalendar();
        startTime = new GregorianCalendar();
        finishTime = new GregorianCalendar();
        try {
            inFile = new BufferedReader(new FileReader(inFileName));
            lineOfText = inFile.readLine();
    //??
            noError=true;
            while (lineOfText != null && noError) {
                fields = lineOfText.split(",[ \t]*");
                
                if (fields[3].trim().equals("M")) {
                        gender = GenderType.MALE;
                    }else if (fields[3].trim().equals("F")) {
                        gender = GenderType.FEMALE;
                    }

                if (isValidInt(fields[0].trim()) && isValidDate(fields[4].trim())&&isValidTime(fields[6].trim())&&isValidTime(fields[7].trim())&& gender!=null) {
                    id = Integer.parseInt(fields[0].trim());
                    familyName = fields[1].trim();
                    givenName = fields[2].trim();
                    
                    DOB.setTime(dateFormat.parse(fields[4].trim()));
                    email = fields[5].trim();
                    category = fields[6].trim();
                    startTime.setTime(dateFormat2.parse(fields[7].trim()));
                    finishTime.setTime(dateFormat2.parse(fields[8].trim()));

                    contestant = new RaceContestant(id, familyName, givenName, gender, DOB, email, category, startTime, finishTime);
                    addRaceContestant(contestant);

                } else {

                    noError=false;
                }
                lineOfText = inFile.readLine();
            }
            inFile.close();

        } catch (FileNotFoundException e) {
            noError=false;
        } catch (EOFException e) {
            noError=false;
        } catch (IOException e) {
            noError=false;
        } catch (ParseException e) {
            noError=false;
        } catch (NumberFormatException e) {
            noError=false;
        }
        return noError;
    }

    public static boolean isValidInt(String query) {
        boolean valid = false;
        try {
            Integer.parseInt(query);
            valid = true;
        } catch (RuntimeException e) {
            valid = false;
        }
        return valid;
    }

//Ok??    
    public static boolean isValidDate(String query) {
        boolean valid = false;
        try {
            SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd-MMM-yyyy");
            dateFormat3.setLenient(false);
            dateFormat3.parse(query);
            valid = true;
        } catch (ParseException e) {
            valid = false;
        }
        return valid;
    }

//Simple Date format Time????    
    public static boolean isValidTime(String query) {
        boolean valid = false;
        try {
            SimpleDateFormat dateFormat3 = new SimpleDateFormat("hh:mm:ss.sss");
            dateFormat3.setLenient(false);
            dateFormat3.parse(query);
            valid = true;
        } catch (ParseException e) {
            valid = false;
        }
        return valid;
    }
    
    public boolean saveFile(String outFileName) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("hh:mm:ss.sss");
        String lineOfText;
        BufferedWriter outFile;
        boolean created = false;
        Iterator<RaceContestant> iter = mIDCarnival.values().iterator();

        try {
            outFile = new BufferedWriter(new FileWriter(outFileName));
            while (iter.hasNext()) {
                RaceContestant contestant = iter.next();

                outFile.write(contestant.getId() + ","
                        + contestant.getFamilyName() + ","
                        + contestant.getGivenName() + ","
                        + contestant.getGender().toString() + ","
                        + dateFormat.format(contestant.getDOB())+","
                        + contestant.getEMail() + ","
                        + contestant.getCategory() + ","
                        + dateFormat2.format(contestant.getStartTime()) + ","
                        + dateFormat.format(contestant.setFinishTime()) + "\n");
            }
            outFile.close();
            created = true;
        } catch (IOException e) {
            created = false;
        }
        return created;
    }
    
    //Teams of 3 Only
    
    public RaceContestant[] nameSearch(String key){
        
        
        
        return null;
        
    }
    
}


package assignment2;

/**
 *
 * @author Tim Whitfort
 */
public enum GenderType {
    
  FEMALE("F"), MALE("M");
  
  private final String mGender;
  
  private GenderType(String gender){
      mGender = gender;
  }
  
  @Override
  public String toString(){
      return mGender;
  }
}
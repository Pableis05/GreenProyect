package model;

import java.util.Calendar;
/**
The Stage class represents a stage of a project, containing capsules with information about it.
It has attributes for start and end date of the stage, real start and end date, activity status,
an array of capsules and an auxiliary iteration counter for adding capsules.
*/
public class Stage{

    //attributes
    private Calendar startDateStage; 
    private Calendar endDateStage;
    private Calendar realStartDateStage;
    private Calendar realEndDateStage;
    private boolean activeStage;
    private Capsule capsules[];
    private TypeStage typeStage;
    private int auxIteration;

    /**
    Constructor for Stage class, initializes the start and end date of the stage,
    sets activity status to false, creates an array of capsules with 50 elements,
    initializes the array and the auxiliary iteration counter to 0.
    @param startDateStage The start date of the stage.
    @param endDateStage The end date of the stage.
    */
    public Stage(Calendar startDateStage, Calendar endDateStage){
        this.startDateStage = startDateStage;
        this.endDateStage = endDateStage;
        activeStage = false;
        capsules = new Capsule[50];
        startBasicCapsule();
        typeStage = TypeStage.START;
        auxIteration = 0;
    }
    /**
    Initializes the array of capsules with null values and -1 as type.
    */
    public void startBasicCapsule(){

        for (int i = 0; i < capsules.length; i++) {
            capsules[i] = new Capsule(null, -1, "", null, null);
        }

    }
    /**
    *Adds a capsule to the array of capsules of the stage.
    *@param situation The situation described in the capsule.
    *@param typeCapsule The type of capsule.
    *@param authorCapsule The author of the capsule.
    *@param positionAuthor The position of the author of the capsule.
    *@param lessonCapsule The lesson learned described in the capsule.
    */
    public void addCapsule(String situation, int typeCapsule, String authorCapsule, String positionAuthor, String lessonCapsule){
        
        capsules[auxIteration].setSituation(situation);
        capsules[auxIteration].setTypeCapsule(typeCapsule);
        capsules[auxIteration].setAuthorCapsule(authorCapsule);
        capsules[auxIteration].setPositionAuthor(positionAuthor);
        capsules[auxIteration].setLessonCapsule(lessonCapsule);
        capsules[auxIteration].obteinHashtagsLesson(lessonCapsule);
        capsules[auxIteration].obteinHashtagsSituation(situation);
        auxIteration++;
        
    }
    
    /**
    Sets the activity status of the stage.
    @param activeStage The activity status of the stage.
    */
    public void setActiveStage(boolean activeStage) {
        this.activeStage = activeStage;
    }
    /**
    Returns the activity status of the stage.
    @return The activity status of the stage.
    */
    public boolean getActiveStage(){

        return activeStage;
    }
    /**
    Returns a capsule of the array of capsules.
    @param capsule The position of the capsule in the array of capsules.
    @return The capsule at the position indicated.
    */
    public Capsule getCapsule(int capsule){

        return capsules[capsule];

    }
    /**
    Sets the start date of the stage.
    @param startDateStage The start date of the stage.
    */
    public void setStartDateStage(Calendar startDateStage) {
        this.startDateStage = startDateStage;
    }
    /**
    Sets the end date of the stage.
    @param endDateStage The start end of the stage.
    */
    public void setEndDateStage(Calendar endDateStage) {
        this.endDateStage = endDateStage;
    }
    /**
    * Returns the index of the last capsule added to the stage.
    * @return the index of the last capsule added to the stage.
    */
    public int getAuxIteration() {
        return auxIteration -1;
    }
    /**
    * Returns the real end date of the stage
    * @return the real end date of the stage
    */
    public Calendar getRealEndDateStage() {
        return realEndDateStage;
    }
    /**
    * Returns the hypothetical start date of the stage
    * @return the hypothetical start date of the stage
    */
    public Calendar getStartDateStage() {
        return startDateStage;
    }
    /**
    * Returns the hypothetical end date of the stage
    * @return the hypothetical end date of the stage
    */
    public Calendar getEndDateStage() {
        return endDateStage;
    }
    /**
    * Returns the real start date of the stage
    * @return the real start date of the stage
    */
    public Calendar getRealstartDateStage() {
        return realStartDateStage;
    }
    /**
    * Returns the boolean value (True or False) of the stage
    * @return the boolean value (True or False) of the stage
    */
    public boolean isActiveStage() {
        return activeStage;
    }
    /**
    Returns the type of stage that this object represents.
    @return the type of stage
    */
    public TypeStage getTypeStage() {
        return typeStage;
    }
    /**
    Sets the type of stage that this object represents.
    @param typeStage the new type of stage
    */
    public void setTypeStage(TypeStage typeStage) {
        this.typeStage = typeStage;
    }
    
    
    
}

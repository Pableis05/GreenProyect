package model;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
This class represents a capsule, which is a small piece of content that can be shared on a platform. It contains
information about its id, the situation in which it was created, its type, its author, the position of the author,
the lesson that it represents, its hashtags, whether it has been approved and published, and its unique URL.
*/
public class Capsule {

    //attributes

    private int idCapsule;
    private String situation;
    private TypeCapsule enumTypeCapsule;
    private int typeCapsule;
    private String authorCapsule;
    private String positionAuthor;
    private String lessonCapsule;
    private String hashtag[];
    private boolean approveCapsule;
    private boolean publishCapsule;
    private String url;
    private int auxHashtag = 0;

    /**
    *Constructs a Capsule object with a randomly generated id, a given situation, type, author, position of the
    *author, and lesson. Initializes its hashtags, approval status, publishing status, and unique URL.
    *@param situation a String representing the situation in which the Capsule was created
    *@param typeCapsule an int representing the type of the Capsule
    *@param authorCapsule a String representing the author of the Capsule
    *@param positionAuthor a String representing the position of the author of the Capsule
    *@param lessonCapsule a String representing the lesson that the Capsule represents
    */
    public Capsule(String situation, int typeCapsule, String authorCapsule, String positionAuthor, String lessonCapsule) {
        idCapsule = (int) ((Math.random()*900000)+100000); 
        this.situation = situation;
        this.typeCapsule = typeCapsule; 
        switch(typeCapsule){

            case 0: enumTypeCapsule = TypeCapsule.TECNIC;
            break;
            case 1: enumTypeCapsule = TypeCapsule.MANAGMENT;
            break;
            case 2: enumTypeCapsule = TypeCapsule.DOMAIN;
            break;
            case 3: enumTypeCapsule = TypeCapsule.EXPERIENCE;
            break;

        }
        this.authorCapsule = authorCapsule;
        this.positionAuthor = positionAuthor;
        this.lessonCapsule = lessonCapsule;
        hashtag = new String[10];
        startBasicHashtag(); 
        approveCapsule = false;
        publishCapsule = false;
        UUID urlBase = UUID.randomUUID();
        url = urlBase.toString();
        
    }
    /**
    Initializes the hashtags array to an empty String for all elements.
    */
    public void startBasicHashtag(){
        for (int i = 0; i < hashtag.length; i++) {
            hashtag[i] = "";
        }
    }

    /**
    *Extracts hashtags from the lesson parameter using a regular expression pattern. Updates the hashtags array
    *with the found hashtags.
    *@param lesson a String representing the lesson to extract hashtags from
    */
    public void obteinHashtagsLesson(String lesson){

            if (lesson == null) {
                return;
            }

            Pattern pattern = Pattern.compile("#([^#]+)#"); 
            Matcher matcher = pattern.matcher(lesson);
            while (matcher.find()) {
                String word = matcher.group(1); 
                if (word != null) {
                    hashtag[auxHashtag] = word;
                    auxHashtag++;
                }
            }
    }
    /**
    *Extracts hashtags from the situation parameter using a regular expression pattern. Updates the hashtags array
    *with the found hashtags.
    *@param situation a String representing the situation to extract hashtags from
    */
    public void obteinHashtagsSituation(String situation){

        if (situation == null) {
            return;
        }
    
        Pattern pattern = Pattern.compile("#([^#]+)#"); 
        Matcher matcher = pattern.matcher(situation);
        while (matcher.find()) {
            String word = matcher.group(1); 
            if (word != null) {
                hashtag[auxHashtag] = word;
                auxHashtag++;
            }
        }
    }
    /**
    Returns the ID of the capsule.
    @return ID of the capsule.
    */
    public int getIdCapsule() {
        return idCapsule;
    }
    /**
    Sets the approval status of the capsule.
    @param approveCapsule the approval state of the capsule.
    */
    public void setApproveCapsule(boolean approveCapsule) {
        this.approveCapsule = approveCapsule;
    }
    /**
    Returns the approval state of the capsule.
    @return the approval state of the capsule.
    */
    public boolean isApproveCapsule() {
        return approveCapsule;
    }
    /**
    Returns the URL of the capsule.
    @return the URL of the capsule.
    */
    public String getUrl() {
        return url;
    }
    /**
    *Returns the publishing state of the capsule.
    *@return the publishing state of the capsule.
    */
    public boolean getPublishCapsule(){

        return publishCapsule;
    }
    /**
    Returns the lesson of the capsule.
    @return the lesson of the capsule.
    */
    public String getLessonCapsule() {
        return lessonCapsule;
    }
    /**
    Returns the author of the capsule.
    @return the author of the capsule.
    */
    public String getAuthorCapsule() {
        return authorCapsule;
    }
    /**
    Sets the publishing state of the capsule.
    @param publishCapsule the publishing state of the capsule.
    */
    public void setPublishCapsule(boolean publishCapsule) {
        this.publishCapsule = publishCapsule;
    }
    /**
    Returns the hashtag at the specified index.
    @param i the index of the hashtag.
    @return the hashtag at the specified index.
    */
    public String getHashtag(int i) {
        return hashtag[i];
    }
    /**
    Returns the situation of the capsule.
    @return the situation of the capsule.
    */
    public String getSituation() {
        return situation;
    }
    /**
    Sets the situation of the capsule.
    @param situation the situation of the capsule.
    */
    public void setSituation(String situation) {
        this.situation = situation;
    }
    /**
    Sets the type of the capsule.
    @param typeCapsule the type of the capsule.
    */
    public void setTypeCapsule(int typeCapsule) {
        this.typeCapsule = typeCapsule;
    }
    /**
    Sets the author of the capsule.
    @param authorCapsule the author of the capsule.
    */
    public void setAuthorCapsule(String authorCapsule) {
        this.authorCapsule = authorCapsule;
    }
    /**
    Sets the position of the author of the capsule.
    @param positionAuthor the position of the author of the capsule.
    */
    public void setPositionAuthor(String positionAuthor) {
        this.positionAuthor = positionAuthor;
    }
    /**
    Sets the lesson of the capsule.
    @param lessonCapsule the lesson of the capsule.
    */
    public void setLessonCapsule(String lessonCapsule) {
        this.lessonCapsule = lessonCapsule;
    }
    /**
    *Returns the type of the capsule.
    *@return the type of the capsule.
    */
    public int getTypeCapsule() {
        return typeCapsule;
    }
    /**
    Returns the position of the author of the capsule.
    @return the position of the author of the capsule.
    */ 
    public String getPositionAuthor() {
        return positionAuthor;
    }
    /**
    Returns the array of hashtags of the capsule.
    @return the array of hashtags of the capsule.
    */
    public String[] getHashtag() {
        return hashtag;
    }
    /**
    Returns the value of the enum typeCapsule in the capsule.
    @return the value of the enum typeCapsule in the capsule.
    */
    public TypeCapsule getEnumTypeCapsule() {
        return enumTypeCapsule;
    }
    
    
}

package model;
/**
 * The Manager class is usefull to create managers to be assigned to a project.
 */
public class Manager {

    //attributes

    private String nameManager;
    private String phoneNumberManager;

    /**
     * Creates a new Manager object with the given name and phone number. 
     * @param nameManager The name of the manager object.
     * @param phoneNumberManager The phone number of the manager object.
     */
    public Manager(String nameManager, String phoneNumberManager) {
        this.nameManager = nameManager;
        this.phoneNumberManager = phoneNumberManager;
    }

    /**
    * Returns the name of the manager object
    * @return the name of the manager object
    */
    public String getName(){
        return nameManager;
    }

    /**
     * Sets the name of the manager.
     * @param nameManager The new manager name.
     */
    public void setName(String nameManager) {
        this.nameManager = nameManager;
    }

    /**
    * Returns the phone number of the manager.
    *
    *@return The phone number of the manager.
    */
    public String getPhoneNumber() {
        return phoneNumberManager;
    }

    /**
    * Sets the phone number of the manager.
    *
    * @param phoneNumberManager  The new phone number of the manager.
    */
    public void setPhoneNumber(String phoneNumberManager) {
        this.phoneNumberManager = phoneNumberManager;
    }
    
    
}

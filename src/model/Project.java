package model;
import java.util.Calendar;

/**
This class represents a Project.
It contains the name of the project, the start date, end date, budget,
the stages, the months per stage, and the managers.
*/
public class Project {

    //attributes
    private String nameProject;
    private Calendar startDateProject;
    private Calendar endDateProject;
    private double budget;
    private Stage stages[];
    private int monthsStage[];
    private Manager greenSQAManager;
    private Manager companyManager;
    private int auxiliarStage;
    private int auxiliarCollaborator;
    private Collaborator collaborators[];

    /**
    * Constructor method for a Project object.
    * @param nameProject Name of the project.
    * @param startDateProject Start date of the project.
    * @param endDateProject End date of the project.
    * @param budget Budget of the project.
    * @param monthsStage Array of integers representing the months for each stage.
    * @param greenSQAManagerName Name of the Green SQA Manager.
    * @param greenSQAManagerPhone Phone number of the Green SQA Manager.
    * @param companyManagerName Name of the Company Manager.
    * @param companyManagerPhone Phone number of the Company Manager.
    */
    public Project(String nameProject, Calendar startDateProject, Calendar endDateProject, double budget, int[] monthsStage,  String greenSQAManagerName,  String greenSQAManagerPhone, String companyManagerName, String companyManagerPhone){
        this.nameProject = nameProject;
        this.startDateProject = startDateProject;
        this.endDateProject = endDateProject;
        this.budget = budget;
        stages = new Stage[6];
        startBasicStage();
        this.monthsStage = monthsStage;
        collaborators = new Collaborator[10];
        startBasicCollaborators();
        auxiliarStage = 0;
        auxiliarCollaborator = 0;
        greenSQAManager = new Manager(greenSQAManagerName, greenSQAManagerPhone);
        companyManager = new Manager(companyManagerName, companyManagerPhone);
    }
    /**
    * Initializes the array of stages for the Project object.
    */
    public void startBasicStage(){

        for (int i = 0; i < stages.length; i++) {
            stages[i] = new Stage(null, null);
        }

    }
    /**
     * Inicializes the array of collaborators for the project.
     */
    public void startBasicCollaborators(){

        for (int i = 0; i < collaborators.length; i++) {
            collaborators[i] = new Collaborator("", "");
        }

    }
    /**
    * Adds a new stage to the project.
    * @param realStartDateStage Real start date of the stage.
    * @param realEndDateStage Real end date of the stage.
    */
    public void addStage(Calendar realStartDateStage, Calendar realEndDateStage){

        stages[auxiliarStage].setStartDateStage(realStartDateStage);
        stages[auxiliarStage].setEndDateStage(realEndDateStage);
        

        if(auxiliarStage == 0){
            stages[auxiliarStage].setActiveStage(true);
            
        }
        else{ 
            stages[auxiliarStage].setActiveStage(true);
            stages[auxiliarStage-1].setActiveStage(false);
           
        }
        
        switch(auxiliarStage){

            case 0: stages[auxiliarStage].setTypeStage(TypeStage.START); 
            break;
            case 1: stages[auxiliarStage].setTypeStage(TypeStage.ANALYSIS); 
            break;
            case 2: stages[auxiliarStage].setTypeStage(TypeStage.EJECUTION); 
            break;
            case 3: stages[auxiliarStage].setTypeStage(TypeStage.CLOSURE); 
            break;
            case 4: stages[auxiliarStage].setTypeStage(TypeStage.MONITOR); 
            break;
            case 5: stages[auxiliarStage].setTypeStage(TypeStage.CONTROL); 
            break;
            

        }
        
        auxiliarStage++;

    }
    /**
    * Adds managers to the project.
    * @param greenSQAManagerName Name of the Green SQA Manager.
    * @param greenSQAManagerPhone Phone number of the Green SQA Manager.
    * @param companyManagerName Name of the Company Manager.
    * @param companyManagerPhone Phone number of the Company Manager.
    */
    public void addManagers(String greenSQAManagerName,  String greenSQAManagerPhone, String companyManagerName, String companyManagerPhone){

        greenSQAManager.setName(greenSQAManagerName);
        greenSQAManager.setPhoneNumber(greenSQAManagerPhone);
        companyManager.setName(companyManagerName);
        companyManager.setPhoneNumber(companyManagerPhone);

    }
    /**
    Adds a new capsule to the active stage.
    @param situation The situation of the capsule.
    @param typeCapsule The type of capsule.
    @param authorCapsule The author of the capsule.
    @param positionAuthor The position of the author.
    @param lessonCapsule The lesson that the capsule teaches.
    */
    public void capsuleToStage(String situation, int typeCapsule, String authorCapsule, String positionAuthor, String lessonCapsule){

        stages[auxiliarStage-1].addCapsule(situation, typeCapsule, authorCapsule, positionAuthor, lessonCapsule);

    } 
    /**
    Adds a new collaborator to this project.
    @param name the name of the collaborator to be added.
    @param position the position of the collaborator in the company.
    */
    public void addCollaborator(String name, String position){

        collaborators[auxiliarCollaborator] = new Collaborator(name, position);
        auxiliarCollaborator++;

    }


    /**
    * Get the budget of the project.
    *
    * @return The budget of the project.
    */
    public double getBudget() {
        return budget;
    }
     /**
    * Get the amount of months for the given stage.
    * @param i the given stage searched.
    * @return the amount of months for the given stage.
    */
    public int getMonthsStage(int i) {

        return monthsStage[i];
    }
    /**
    * Get the given Stage of the project.
    * @param stage the stage searched.
    * @return The given stage of the project.
    */
    public Stage getStage(int stage){

        return stages[stage];

    }
    /**
    * Get the current stage of the project.
    *
    * @return The current stage of the project.
    */
    public int getAuxiliarstage(){

        return auxiliarStage -1;

    }
    /**
    * Get the name of the project.
    *
    * @return The name of the project.
    */
    public String getNameProject() {
        return nameProject;
    }
    /**
    * Set the name of the project.
    *
    * @param nameProject The name of the project.
    */
    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }
    /**
    * Set the start date of the project.
    *
    * @param startDateProject The start date of the project.
    */
    public void setStartDateProject(Calendar startDateProject) {
        this.startDateProject = startDateProject;
    }
    /**
    * Set the end date of the project.
    *
    * @param endDateProject The end date of the project.
    */
    public void setEndDateProject(Calendar endDateProject) {
        this.endDateProject = endDateProject;
    }
    /**
    * Set the budget of the project.
    *
    * @param budget The budget of the project.
    */
    public void setBudget(double budget) {
        this.budget = budget;
    }
    /**
    * Set the duration of each stage in the project.
    *
    * @param monthsStage An array containing the duration (in months) of each stage in the project.
    */
    public void setMonthsStage(int[] monthsStage) {
        this.monthsStage = monthsStage;
    }
    /**
    * Get the start date of the project.
    *
    * @return The start date of the project.
    */
    public Calendar getStartDateProject() {
        return startDateProject;
    }
    /**
    * Get the end date of the project.
    *
    * @return The end date of the project.
    */
    public Calendar getEndDateProject() {
        return endDateProject;
    }
    /**
    * Get the greenSQAManager of the project.
    *
    * @return The greenSQAManager of the project.
    */
    public Manager getGreenSQAManager() {
        return greenSQAManager;
    }
    /**
    * Get the companyManager of the project.
    *
    * @return The companyManager of the project.
    */
    public Manager getCompanyManager() {
        return companyManager;
    }
    /**
    * Get the given collaborator of the project.
    * @param position the collaborator position searched.
    * @return The given collaborator of the project.
    */
    public Collaborator getCollaborators(int position) {
        return collaborators[position];
    }
    /**
    * Get the current number of collaborator in the project.
    *
    * @return The current amount of collaborators in the project.
    */
    public int getAuxiliarCollaborator() {
        return auxiliarCollaborator-1;
    }
    /**
    Returns an array of Collaborator objects representing the collaborators involved in the project.
    @return an array of Collaborator objects representing the collaborators involved in the project.
    */
    public Collaborator[] getCollaborators() {
        return collaborators;
    }

    

}

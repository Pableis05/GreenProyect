package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
*The ControllerProjects class manages a collection of Project objects.
*It provides methods to add projects, add stages to projects, and add capsules to stages.
*/
public class ControllerProjects {

    private Project projects[];
    private int iteration;
    private int auxCalendar;
    
    /**
    * Creates a new instance of ControllerProjects and initializes the projects array with 10 Project objects.
    * Also calls the startBasicProjects method to initialize each project with default values.
    */ 
    public ControllerProjects(){

        projects = new Project[10];
        iteration = 0;
        auxCalendar = 0;
        startBasicProjects();
    } 
    /**
    *Initializes each project in the projects array with default values.
    */
    public void startBasicProjects(){

        for (int i = 0; i < projects.length; i++) {
            projects[i] = new Project(null, null, null, 0, null, null, null, null, null);
        }

    }
    /**
    * Adds a new Project object to the projects array with the given parameters.
    *
    * @param nameProject          The name of the project.
    * @param startDateProject     The start date of the project as a Calendar object.
    * @param endDateProject       The end date of the project as a Calendar object.
    * @param budget               The budget of the project.
    * @param monthStages          An array containing the number of months for each stage of the project.
    * @param greenSQAManagerName  The name of the Green SQA Manager.
    * @param greenSQAManagerPhone The phone number of the Green SQA Manager.
    * @param companyManagerName   The name of the Company Manager.
    * @param companyManagerPhone  The phone number of the Company Manager.
    */
    public void addProject(String nameProject, Calendar startDateProject, Calendar endDateProject, double budget, int[] monthStages,  String greenSQAManagerName,  String greenSQAManagerPhone, String companyManagerName, String companyManagerPhone){

        Calendar endFirstDateCalendar = Calendar.getInstance();
        endFirstDateCalendar.setTime(startDateProject.getTime());
        endFirstDateCalendar.add(Calendar.MONTH, monthStages[auxCalendar]);

        auxCalendar++;
    
        projects[iteration].setNameProject(nameProject);
        projects[iteration].setStartDateProject(startDateProject);
        projects[iteration].setEndDateProject(endDateProject);
        projects[iteration].setBudget(budget);
        projects[iteration].setMonthsStage(monthStages);

        projects[iteration].addManagers(greenSQAManagerName, greenSQAManagerPhone, companyManagerName, companyManagerPhone);
        projects[iteration].addStage(startDateProject, endFirstDateCalendar);
        iteration++;


    }
    /**
    * Calculates the end date of a stage and adds the stage to the specified project.
    * 
    * @param project           The index of the project in the projects array.
    * @param realStartNewStage The start date of the new stage as a Calendar object.
    * 
    * @return A Calendar object representing the end date of the new stage.
    */
    public Calendar culminateStage(int project, Calendar realStartNewStage){

        
        Calendar endnewStage = Calendar.getInstance();
        endnewStage.setTime( realStartNewStage.getTime());
        endnewStage.add(Calendar.MONTH, projects[project].getMonthsStage(auxCalendar));
        auxCalendar++;
        
        projects[project].addStage(realStartNewStage, endnewStage);
        
        return endnewStage;
    }

    /**
    * Converts a String object in the format "dd-MM-yyyy" to a Calendar object.
    * 
    * @param date A String object representing a date in the format "dd-MM-yyyy".
    * 
    * @return A Calendar object representing the date.
    * 
    * @throws ParseException If the String object cannot be parsed as a date.
    */
    public Calendar modifyStringToCalendar(String date) throws ParseException{

		SimpleDateFormat newDate = new SimpleDateFormat("dd-MM-yyyy");
		Calendar newDateCalendar = Calendar.getInstance();
		newDateCalendar.setTime(newDate.parse(date));

		return newDateCalendar;

	}
    /**
    * Returns the Project object at the specified index in the projects array.
    * 
    * @param project The index of the project in the projects array.
    * 
    * @return The Project object at the specified index in the projects array.
    */
    public Project getProject(int project){

        return projects[project];

    }
    /**
    * Returns the current iteration of the projects array
    * @return the current iteration of projects array
    */
    public int getIteration() {
        return iteration -1 ;
    }

    /**
    This method checks whether a collaborator with the given name exists in any of the projects. It iterates through all the projects and their collaborators, comparing the name with the one given as parameter.
    @param name the name of the collaborator to search for
    @return true if the collaborator is found in any project, false otherwise
    */

    public boolean checkCollaboratorExist(String name){
        boolean find = false;
        for (int i = 0; i < projects.length; i++) {
            for (int j = 0; j < 10; j++) {
                if(projects[i].getCollaborators(j).getNameCollaborator().equals(name)){
                    find = true;
                }
            }
        }
        return find;
    }

    /**
    This method checks whether a project with the given number exists. It verifies if the project name is not null in the projects array.
    @param project the number of the project to search for
    @return false if the project exists, true otherwise
    */
    public boolean checkProjectExist(int project){
        boolean free = true;
        if(projects[project] == null){
            free = false;
        }
        return free;
    }
    /**
    Checks if a collaborator with the given name is already assigned to any project.
    @param name the name of the collaborator to search for.
    @return true if a collaborator with the given name is found in any project, false otherwise.
    */
    public boolean checkNameCollaborator(String name){
        boolean find = false;
        for (int i = 0; i < projects.length; i++) {
            for (int j = 0; j < projects[i].getCollaborators().length; j++) {
                if(projects[i].getCollaborators(j).getNameCollaborator().equals(name)){
                    find = true;
                }
            }
        }
        return find;
    }

}   

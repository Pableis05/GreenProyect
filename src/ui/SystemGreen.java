package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import model.ControllerProjects;

/**

The SystemGreen class is the main class for the GreenSQA data system.
This class provides a menu to perform various operations related to project management.
*/
public class SystemGreen {
    // Scanner object to get user input
    private Scanner input;
    // ControllerProjects object to manage projects
    private ControllerProjects controller;
    /**

    Constructor for the SystemGreen class.
    Initializes the Scanner object and ControllerProjects object.
    */
    public SystemGreen(){
        input = new Scanner(System.in);
        controller = new ControllerProjects();
        
    }
    /**

    The main method for the SystemGreen class.
    Initializes a SystemGreen object and calls the menu method.
    @param args The command line arguments passed to the program.
    @throws ParseException If there is an error parsing the user input for dates.
    */
    public static void main(String[] args) throws ParseException {
        SystemGreen greenSQA = new SystemGreen();
        System.out.println("WELCOME TO GREENSQA DATA");
        greenSQA.menu();

        
    }

    /**
    The menu method provides a menu of options for the user to choose from.
    The user's selection determines which project management operation is performed.
    @throws ParseException If there is an error parsing the user input for dates.
    */
    public void menu() throws ParseException{
        int option = -1;
        boolean projectCreated = false;
        while(option != 0){ 
        System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n", "1. Create a project", "2. Culminate a project stage", "3. Register capsule", "4. Approve capsule", "5. Post capsule", "6. Amount capsule for capsule type", "7. Lessons for a stage", "8. Greator amount capsule project name", "9. Check if someone do a capsule", "10. Situtaions and lessons learned by the approve capsules", "0. EXIT");
        option = input.nextInt();
        switch(option){
                case 1:
                initProject();
                projectCreated = true;
                break;
                case 2: 
                if(projectCreated == false){
                    System.out.println("First create a project");
                }
                else{ 
                    culminateStage();
                }
                break;
                case 3: 
                if(projectCreated == false){
                    System.out.println("First create a project");
                }
                else{ 
                registerCapsule();
                }
                break;
                case 4: 
                if(projectCreated == false){
                    System.out.println("First create a project and a capsule");
                }
                else{ 
                    approveCapsule();
                }
                break;
                case 5:
                if(projectCreated == false){
                    System.out.println("First create a project and a capsule");
                }
                else{ 
                publishCapsule();
                }
                break;
                case 6: 
                if(projectCreated == false){
                    System.out.println("First create a project and a capsule");
                }
                else{ 
                    informCapsuleType();
                }
                break;
                case 7:
                if(projectCreated == false){
                    System.out.println("First create a project and a capsule");
                }
                else{ 
                    informLessonsForStage();
                }
                break;
                case 8:
                if(projectCreated == false){
                    System.out.println("First create a project and a capsule");
                }
                else{ 
                    projectNameMostCapsule();
                }
                break;
                case 9:
                if(projectCreated == false){
                    System.out.println("First create a project and a capsule");
                }
                else{ 
                    checkCapsulesSomeone();
                }
                break;
                case 10:
                if(projectCreated == false){
                    System.out.println("First create a project and a capsule");
                }
                else{ 
                    searchLessonsAndSituationsCapsules();
                }
                break;
                case 0:
                System.out.println("Thank you");
                break;
                default:
                System.out.println("Operation invalid");
            }
        }
    }

    /**
    * Initializes the project by asking for information such as project name, 
    * start and end dates, budget, names and phone numbers of GreenSQA and company managers, 
    * and the duration of each project stage in months.
    *@throws ParseException If there is an error in parsing the date inputs.
    */
    public void initProject() throws ParseException{
        String nameProject;
        Calendar startDateProject;
        Calendar endDateProject;
        String dateAux;
        double budget;
        String greenSQAManagerName;
        String greenSQAManagerPhone;
        String companyManagerName;
        String companyManagerPhone;
        int monthStages[];
        String creationProjectConfirmation;

        System.out.println("Enter the name of the project");
        input.nextLine();
        nameProject = input.nextLine();
        
        
		System.out.println("Enter the date to start the project (dd-MM-yyyy):");
        startDateProject = null;
        while(startDateProject == null){
            dateAux = input.nextLine().trim();
            try{
                startDateProject = controller.modifyStringToCalendar(dateAux);
            }
            catch(ParseException e){
                System.out.println("Error at date format");
            }
        }   

		System.out.println("Enter the date to end the project (dd-MM-yyyy):");
        endDateProject = null;
        while(endDateProject == null){
            dateAux= input.nextLine().trim();
            try{
                endDateProject = controller.modifyStringToCalendar(dateAux);
            }
            catch(ParseException e){
                System.out.println("Error at date format");
            }

        }

        System.out.println("Enter the budget of the project: $");
        do{ 
            budget = input.nextDouble();
        }while(budget <= 0);

        System.out.println("Enter the name of the GreenSQA manager");
        input.nextLine();
        greenSQAManagerName = input.nextLine();

        System.out.println("Enter the phone of the GreenSQA manager");
        do{
            greenSQAManagerPhone = input.nextLine();
        }while(!greenSQAManagerPhone.matches("^[0-9]+$"));

        System.out.println("Enter the name of the company manager");
        companyManagerName = input.nextLine();

        System.out.println("Enter the phone of the company manager");
        do{
            companyManagerPhone = input.nextLine();
        }while(!companyManagerPhone.matches("^[0-9]+$"));

        monthStages = new int[6];
        System.out.println("Enter the months of every stage:");
        System.out.println("Remember, the stages are 0. start, 1. analysis, 2. ejecution, 3. closure, 4. monitor, 5. control");
        for (int i = 0; i < 6; i++) {
            System.out.println("months for the "+(i)+ " stage.");
            do{ 
                monthStages[i] = input.nextInt();
            }while(monthStages[i] > -1);
        }


        controller.addProject(nameProject, startDateProject,endDateProject, budget, monthStages, greenSQAManagerName, greenSQAManagerPhone, companyManagerName, companyManagerPhone);
        creationProjectConfirmation = "The project "+ controller.getIteration() +"./9 has been created";
        System.out.println(creationProjectConfirmation);
        System.out.println("The Stage " + controller.getProject(controller.getIteration()).getAuxiliarstage() + "./5 has been created.");
    }

    /**
    Prompts the user to enter information about a new capsule and registers it in the system.
    */
    public void registerCapsule(){

        String situation;
        int typeCapsule;
        String authorCapsule;
        String positionAuthor;
        String lessonCapsule;
        int searchProject;
        String creationCapsuleConfirmation;

        System.out.println("Enter the project number:");
        do{ 
            searchProject = input.nextInt();
        }while(searchProject > 9 || searchProject < 0);
        input.nextLine();

        do {
            System.out.println("Enter the situation: (Remember that the situation have to contain 1-3 keywords between ##, Example: Hey #Hello world# How are #you# ?)");
            situation = input.nextLine();
        } while (!situation.matches("^.*#[^#]+#[^#]+.*$")); 

        System.out.println("Enter the type of the Capsule: \n0. tecnic \n1. management \n2. domain, \n3. experience");
        do{ 
            typeCapsule = input.nextInt();
        }while(typeCapsule > 3 || typeCapsule < 0);
        System.out.println("Enter your name:");
        authorCapsule = input.next();
        input.nextLine();
        System.out.println("Enter your position in the company:");
        positionAuthor = input.nextLine();

        do {
            System.out.println("Enter the lesson: (Remember that the lesson have to contain 1-3 keywords between ##, Example: Hey #Hello world# How are #you# ?)");
            lessonCapsule = input.nextLine();
        } while (!lessonCapsule.matches("^.*#[^#]+#[^#]+.*$"));

        controller.getProject(searchProject).getStage(controller.getProject(searchProject).getAuxiliarstage()).addCapsule(situation, typeCapsule, authorCapsule, positionAuthor, lessonCapsule);
        creationCapsuleConfirmation = "The capsule " + controller.getProject(searchProject).getStage(controller.getProject(searchProject).getAuxiliarstage()).getAuxIteration() +"/49 for the project "+ controller.getIteration() + " and the stage " +controller.getProject(searchProject).getAuxiliarstage() + " has been created.";
        System.out.println(creationCapsuleConfirmation);

    }

    /**
    Method to culminate a stage of a project.
    It prompts the user for the project number and the start date of the new stage,
    then calls the controller's culminateStage method to perform the action.
    It also displays information about the created stage and its expected end date.
    @throws ParseException if there is an error parsing the input date
    */
    public void culminateStage() throws ParseException{
        int searchProject;
        Calendar startNewStageReal;
        String auxStartStage;
        System.out.println("Enter the project number");
        do{ 
            searchProject = input.nextInt();
        }while(searchProject > 9 || searchProject < 0);
        System.out.println("Enter the date for start the real new time stage (dd-MM-yyyy)"); 
        startNewStageReal = null;
        while(startNewStageReal == null){
            auxStartStage = input.nextLine().trim();
            try{
                startNewStageReal = controller.modifyStringToCalendar(auxStartStage);
            }
            catch(ParseException e){
                System.out.println("Error at date format");
            }

        }

        String futureEndStage;

        Calendar aux = controller.culminateStage(searchProject, startNewStageReal);
        System.out.println("The Stage " + controller.getProject(searchProject).getAuxiliarstage() + "/5 has been created.");
        futureEndStage = new SimpleDateFormat("dd-MM-yyyy").format(aux.getTime());
        System.out.println("The end of this stage have to finish in this date: " + futureEndStage + " to achieve with the duration of the stages");

    }

    /**
    Approves a capsule in a specific project stage, setting its approval status to true and recording the approval date.
    */
    public void approveCapsule(){

        Calendar calendarTime;
        String timeStamp;
        int searchProject;
        int capsule;
        int stage;
        
        System.out.println("Enter the project number");
        do{ 
            searchProject = input.nextInt();
        }while(searchProject > 9 || searchProject < 0);
        
        System.out.println("enter the stage \n0. start \n1. analysis \n2. ejecution, \n3. closure \n4. monitor \n5. control");
        do{ 
            stage = input.nextInt();
        }while(stage > 5 || stage < 0);
        
        System.out.println("Enter the capsule number");
        do{ 
            capsule = input.nextInt();
        }while(searchProject > 49 || searchProject < 0);
        

        if(controller.getProject(searchProject).getStage(stage).getCapsule(capsule).getLessonCapsule() == null){
            System.out.println("The capsule are empty");
        }
        else{ 
            controller.getProject(searchProject).getStage(stage).getCapsule(capsule).setApproveCapsule(true);
            calendarTime = Calendar.getInstance();
            timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(calendarTime.getTime());
            System.out.println("The capsule has been aprroved in " + timeStamp);
        }
        

    }
    /**
    Publishes a capsule in a specific stage of a project.
    Prompts the user to enter the project number, the stage (0 to 5), and the capsule number.
    If the capsule has been approved for publishing, prints the URL for the HTML page and sets the "publishCapsule" flag to true.
    If the capsule has not been approved for publishing, prints a message indicating that it cannot be published.
    */
    public void publishCapsule(){

        int searchProject;
        int capsule;
        int stage;
        String URLpost;

        System.out.println("Enter the project number");
        do{ 
            searchProject = input.nextInt();
        }while(searchProject > 9 || searchProject < 0);
        
        System.out.println("enter the stage \n0. start \n1. analysis \n2. ejecution, \n3. closure \n4. monitor \n5. control");
        do{ 
            stage = input.nextInt();
        }while(stage > 5 || stage < 0);
        
        System.out.println("Enter the capsule number");
        do{ 
            capsule = input.nextInt();
        }while(searchProject > 49 || searchProject < 0);

        if(controller.getProject(searchProject).getStage(stage).getCapsule(capsule).isApproveCapsule() == true){

            System.out.println("The capsule has been published");
            URLpost =  "https://github.com/capsules/" + controller.getProject(searchProject).getStage(stage).getCapsule(capsule).getUrl();
            System.out.println("The URL fot the HTML is:" +URLpost);
            controller.getProject(searchProject).getStage(stage).getCapsule(capsule).setPublishCapsule(true);

        }
        else{

            System.out.println("The capsule is not verify to be published");

        }   
    }

    /**
    * Prints the number of capsules for each type (technical, management, domain, experience) in a given project.
    */
    public void informCapsuleType(){

        int project;

        System.out.println("Enter the project number to search");
        do{
            project = input.nextInt();
        }while(project < 0 || project > 9);

        int tecnicAmount = 0, managementAmount = 0, domainAmount = 0, experienceAmount = 0;

        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 50; j++) {
                switch(controller.getProject(project).getStage(i).getCapsule(j).getTypeCapsule()){

                    case 0: tecnicAmount++; 
                    break;
                    case 1: managementAmount++; 
                    break;
                    case 2: domainAmount++; 
                    break;
                    case 3: experienceAmount++; 
                    break;
                }
            }
        }

        System.out.println("The amount of tecnic capsules is: " + tecnicAmount +  ", The amount of management capsules is: " + managementAmount+  ", The amount of domain capsules is: " + domainAmount +", The amount of experience capsules is: " + experienceAmount);

    }

    /**
    This method prompts the user to enter a project and a stage, and then
    prints out the lessons for each capsule in that stage if they exist.
    */
    public void informLessonsForStage(){

        int project;
        int stage;
        boolean exist = false;

        System.out.println("Enter the project number");
        do{ 
            project = input.nextInt();
        }while(project > 9 || project < 0);
        
        System.out.println("enter the stage \n0. start \n1. analysis \n2. ejecution, \n3. closure \n4. monitor \n5. control");
        do{ 
            stage = input.nextInt();
        }while(stage > 5 || stage < 0);

        for (int i = 0; i < 50; i++) {
            if(controller.getProject(project).getStage(stage).getCapsule(i).getLessonCapsule() != null){ 
                exist = true;
                System.out.println("Lesson learn number "+(i+1) +": " + controller.getProject(project).getStage(stage).getCapsule(i).getLessonCapsule());
            }
        }
        if(exist == false){

            System.out.println("The lessons are empty");
        }
    }
    /**
    *This method determines which project has the most capsules and prints out
    * that project's name and the number of capsules it has.
    */
    public void projectNameMostCapsule(){

        int aux = 0;
        int amount[] = {0,0,0,0,0,0,0,0,0,0};
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++){
                for (int k = 0; k < 50; k++) {
                    if(controller.getProject(i).getStage(j).getCapsule(k).getTypeCapsule() != -1){

                        amount[i]++;
                            
                    }
                }
            }
        }
        
        for (int i = 0; i < 10; i++){
            if(amount[i] > aux){
                aux = amount[i];
            }
        }

        for (int i = 0; i < 10; i++) {
            if(amount[i] == aux){
                System.out.println("The project " +controller.getProject(i).getNameProject()+ " have the greator amount of capsules with " + aux + " capsules");
                
            }
        }

    }
    /**
    * This method prompts the user to enter a name and then checks all capsules
    * to see if that person has created a capsule. If so, it prints out the
    * project, stage, and capsule number for each capsule created by that person.
    */
    public void checkCapsulesSomeone(){

        String name;
        boolean personWrite = false;
        System.out.println("Enter the name of the person");
        name = input.next();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                for (int j2 = 0; j2 < 50; j2++) {
                    if (controller.getProject(i).getStage(j).getCapsule(j2).getAuthorCapsule() == null) {
                        return;
                    }
                    else if(controller.getProject(i).getStage(j).getCapsule(j2).getAuthorCapsule().equals(name) ==  true){
                        personWrite = true;
                        System.out.println(name + " has create a capsule in project " + i + ", stage " +j+ ", capsule number "+j2);
                        System.out.println("Saying in the lesson: " + controller.getProject(i).getStage(j).getCapsule(j2).getLessonCapsule());
                    }
                }
                
            }
            
        }

        if(personWrite == false){
            System.out.println(name + " doesn't create a capsule in any project");
        }

    }
    /** 
    * This method prompts the user to enter a hashtag and searches all capsules for
    * matches. If a match is found, it prints out the lesson and situation for the
    * capsule, but only if the capsule has been approved and published. If the capsule
    * has not been published, it prints out a message indicating that there is a match
    * but the capsule has not been published.
    */
    public void searchLessonsAndSituationsCapsules(){

        String searchHashtag;
        boolean find = false;
        int match = 1;
        System.out.println("Enter the Hashtag to search");
        input.nextLine();
        searchHashtag = input.nextLine();



        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 6; j++) {
                for (int j2 = 0; j2 < 50; j2++) {
                    for (int k = 0; k < 3; k++) {
                        if (controller.getProject(i).getStage(j).getCapsule(j2).getHashtag(k) == null) {
                            return;
                        }
                        if(controller.getProject(i).getStage(j).getCapsule(j2).getHashtag(k).contains(searchHashtag) == true){
                            if(controller.getProject(i).getStage(j).getCapsule(j2).isApproveCapsule() == true && controller.getProject(i).getStage(j).getCapsule(j2).getPublishCapsule() == true){ 
                                find = true;
                                System.out.println("Match " + match+ ": ");
                                match++;
                                System.out.println("The situtation for the match is: " + controller.getProject(i).getStage(j).getCapsule(j2).getSituation());
                                System.out.println("The lesson for the match is: " + controller.getProject(i).getStage(j).getCapsule(j2).getLessonCapsule());
                            }
                            else{
                                System.out.println("There is a match in the capsule " + controller.getProject(i).getStage(j).getCapsule(j2).getIdCapsule() +" but this one have not been published");
                                find = true;
                            }
                        }
                    }
                }
            }  
        }
        
        if(find == false){

            System.out.println("That hashtag search is not equal to other one in the bases");
        }

    }


}

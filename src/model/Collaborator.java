package model;

/**
The Collaborator class represents a person who collaborates in a project. It contains their name and position in the company.
*/
public class Collaborator{

    //atributtes
    private String nameCollaborator;
    private String positionCollaborator;

    /**
    Creates a new Collaborator with the given name and position.
    @param nameCollaborator the name of the collaborator
    @param positionCollaborator the position of the collaborator in the company
    */
    public Collaborator(String nameCollaborator, String positionCollaborator) {
        this.nameCollaborator = nameCollaborator;
        this.positionCollaborator = positionCollaborator;
    }

    /**
    Returns the name of the collaborator.
    @return the name of the collaborator
    */
    public String getNameCollaborator() {
        return nameCollaborator;
    }
    /**
    Sets the name of the collaborator.
    @param nameCollaborator the new name of the collaborator
    */
    public void setNameCollaborator(String nameCollaborator) {
        this.nameCollaborator = nameCollaborator;
    }
    /**
    Returns the position of the collaborator in the company.
    @return the position of the collaborator
    */
    public String getPositionCollaborator() {
        return positionCollaborator;
    }
    /**
    Sets the position of the collaborator in the company.
    @param positionCollaborator the new position of the collaborator
    */
    public void setPositionCollaborator(String positionCollaborator) {
        this.positionCollaborator = positionCollaborator;
    }

}
package model;

public class Collaborator{

    private String nameCollaborator;
    private String positionCollaborator;
    private String id;

    public Collaborator(String nameCollaborator, String positionCollaborator, String id) {
        this.nameCollaborator = nameCollaborator;
        this.positionCollaborator = positionCollaborator;
        this.id = id;
    }


    public String getNameCollaborator() {
        return nameCollaborator;
    }


    public void setNameCollaborator(String nameCollaborator) {
        this.nameCollaborator = nameCollaborator;
    }


    public String getPositionCollaborator() {
        return positionCollaborator;
    }


    public void setPositionCollaborator(String positionCollaborator) {
        this.positionCollaborator = positionCollaborator;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


}
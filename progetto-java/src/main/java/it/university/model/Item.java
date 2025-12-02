package it.university.model;

// CLASSE ASTRATTA PER RAPPRESENTARE GLI OGGETTI CON ATTRIBUTI IN COMUNE (id E name)
public abstract class Item {

    protected int id;
    protected String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package ua.training.model.entity;

import ua.training.model.types.Marks;

public class Feedback {
    private int id;
    private String commentary;
    private Marks mark;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCommentary() {
        return commentary;
    }
    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
    public Marks getMark() {
        return mark;
    }
    public void setMark(Marks mark) {
        this.mark = mark;
    }
}

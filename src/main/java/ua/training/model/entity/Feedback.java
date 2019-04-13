package ua.training.model.entity;

import ua.training.model.types.Marks;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(commentary, feedback.commentary) &&
                mark == feedback.mark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentary, mark);
    }
}

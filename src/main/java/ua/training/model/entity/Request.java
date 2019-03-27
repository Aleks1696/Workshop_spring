package ua.training.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Request {
    private long id;
    //TODO enums
    private String description;
    private LocalDate date;
    //TODO enum status
    private BigDecimal price;
    private String managerComment;
    private User customer;
    private User manager;
    private User master;
    private Feedback feedback;
}

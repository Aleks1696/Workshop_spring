package ua.training.model.entity;

import ua.training.model.types.ProductCategory;
import ua.training.model.types.RequestStatus;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Request {
    private int id;
    private ProductCategory productCategory;
    private String device;
    private String description;
    private LocalDate creationDate;
    private LocalDate closingDate;
    private RequestStatus status;
    private BigDecimal price;
    private String managerComment;
    private User customer;
    private User manager;
    private User master;
    private Feedback feedback;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ProductCategory getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
    public String getDevice() {
        return device;
    }
    public void setDevice(String device) {
        this.device = device;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public LocalDate getClosingDate() {
        return closingDate;
    }
    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }
    public RequestStatus getStatus() {
        return status;
    }
    public void setStatus(RequestStatus status) {
        this.status = status;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getManagerComment() {
        return managerComment;
    }
    public void setManagerComment(String managerComment) {
        this.managerComment = managerComment;
    }
    public User getCustomer() {
        return customer;
    }
    public void setCustomer(User customer) {
        this.customer = customer;
    }
    public User getManager() {
        return manager;
    }
    public void setManager(User manager) {
        this.manager = manager;
    }
    public User getMaster() {
        return master;
    }
    public void setMaster(User master) {
        this.master = master;
    }
    public Feedback getFeedback() {
        return feedback;
    }
    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}

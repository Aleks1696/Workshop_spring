package ua.training.model.dto;

import ua.training.model.types.ProductCategory;
import ua.training.model.types.RequestStatus;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RequestDto {
    private int id;
    private ProductCategory productCategory;
    private String device;
    private String description;
    private LocalDate creationDate;
    private RequestStatus status;
    private BigDecimal price;
    private String managerComment;
    private int customer_id;
    private int manager_id;
    private int master_id;
    private int feedback_id;

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
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public int getManager_id() {
        return manager_id;
    }
    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }
    public int getMaster_id() {
        return master_id;
    }
    public void setMaster_id(int master_id) {
        this.master_id = master_id;
    }
    public int getFeedback_id() {
        return feedback_id;
    }
    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }
}

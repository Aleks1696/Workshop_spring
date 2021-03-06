package ua.training.model.entity;

import ua.training.model.types.ProductCategory;
import ua.training.model.types.RequestStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Request {
    private int id;
    private ProductCategory productCategory;
    private String device;
    private String description;
    private LocalDate creationDate;
    private RequestStatus status;
    private BigDecimal price;
    private String managerComment;
    private Integer customer_id;
    private Integer manager_id;
    private Integer master_id;
    private Integer feedback_id;

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
    public Integer getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }
    public Integer getManager_id() {
        return manager_id;
    }
    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }
    public Integer getMaster_id() {
        return master_id;
    }
    public void setMaster_id(Integer master_id) {
        this.master_id = master_id;
    }
    public Integer getFeedback_id() {
        return feedback_id;
    }
    public void setFeedback_id(Integer feedback_id) {
        this.feedback_id = feedback_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return productCategory == request.productCategory &&
                Objects.equals(device, request.device) &&
                Objects.equals(description, request.description) &&
                Objects.equals(creationDate, request.creationDate) &&
                status == request.status &&
                Objects.equals(price, request.price) &&
                Objects.equals(managerComment, request.managerComment) &&
                Objects.equals(customer_id, request.customer_id) &&
                Objects.equals(manager_id, request.manager_id) &&
                Objects.equals(master_id, request.master_id) &&
                Objects.equals(feedback_id, request.feedback_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCategory, device, description, creationDate, status, price, managerComment, customer_id, manager_id, master_id, feedback_id);
    }
}

package ua.training.model.types;

public enum UserRole {
    CUSTOMER, MANAGER, MASTER;

    public static UserRole getRole(String role) {
        //TODO it might throw exception
        return UserRole.valueOf(role);
    }
}

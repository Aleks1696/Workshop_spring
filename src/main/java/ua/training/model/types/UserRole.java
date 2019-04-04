package ua.training.model.types;

public enum UserRole {
    CUSTOMER("/customer"), MANAGER("/manager"), MASTER("/master");

    private String allowedPath;

    UserRole(String path) {
        allowedPath = path;
    }

    public static UserRole getRole(String role) {
        //TODO it might throw exception
        return UserRole.valueOf(role);
    }

    public String getAllowedPath() {
        return allowedPath;
    }
}

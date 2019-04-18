package ua.training.model.types;

import ua.training.model.utils.URIBinder;

public enum UserRole {
    CUSTOMER("/customer", URIBinder.getProperty("path.customer.account")),
    MANAGER("/manager", URIBinder.getProperty("path.manager.account")),
    MASTER("/master", URIBinder.getProperty("path.master.account"));

    private String allowedPath;
    private String basePage;

    UserRole(String path, String page) {
        allowedPath = path;
        basePage = page;
    }

    public static UserRole getRole(String role) {
        return UserRole.valueOf(role);
    }

    public String getAllowedPath() {
        return allowedPath;
    }

    public String getBasePath() {
        return basePage;
    }
}

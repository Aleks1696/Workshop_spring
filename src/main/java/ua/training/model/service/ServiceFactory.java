package ua.training.model.service;

import ua.training.model.service.customer.CustomerService;
import ua.training.model.service.manager.ManagerService;
import ua.training.model.service.master.MasterService;
import ua.training.model.service.user.UserService;

public abstract class ServiceFactory {
    private static ServiceFactory serviceFactory;

    public abstract CustomerService createCustomerService();
    public abstract ManagerService createManagerService();
    public abstract MasterService createMasterService();
    public abstract UserService createUserService();

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            synchronized (ServiceFactory.class) {
                if (serviceFactory == null) {
                    serviceFactory = new ServiceFactoryImpl();
                }
            }
        }
        return serviceFactory;
    }
}

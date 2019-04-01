package ua.training.model.service;

import ua.training.model.service.customer.CustomerService;
import ua.training.model.service.manager.ManagerService;
import ua.training.model.service.master.MasterService;

public abstract class ServiceFactory {
    private static ServiceFactory serviceFactory;

    abstract CustomerService createCustomerService();
    abstract ManagerService createManagerService();
    abstract MasterService createMasterService();

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

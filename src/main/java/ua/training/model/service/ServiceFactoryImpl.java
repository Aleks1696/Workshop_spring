package ua.training.model.service;

import ua.training.model.service.customer.CustomerService;
import ua.training.model.service.customer.CustomerServiceImpl;
import ua.training.model.service.manager.ManagerService;
import ua.training.model.service.manager.ManagerServiceImpl;
import ua.training.model.service.master.MasterService;
import ua.training.model.service.master.MasterServiceImpl;

public class ServiceFactoryImpl extends ServiceFactory {

    @Override
    CustomerService createCustomerService() {
        return new CustomerServiceImpl();
    }

    @Override
    ManagerService createManagerService() {
        return new ManagerServiceImpl();
    }

    @Override
    MasterService createMasterService() {
        return new MasterServiceImpl();
    }
}

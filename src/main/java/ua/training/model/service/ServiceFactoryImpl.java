package ua.training.model.service;

import ua.training.model.service.customer.CustomerService;
import ua.training.model.service.customer.CustomerServiceImpl;
import ua.training.model.service.manager.ManagerService;
import ua.training.model.service.manager.ManagerServiceImpl;
import ua.training.model.service.master.MasterService;
import ua.training.model.service.master.MasterServiceImpl;
import ua.training.model.service.user.UserService;
import ua.training.model.service.user.UserServiceImpl;

public class ServiceFactoryImpl extends ServiceFactory {

    @Override
    public CustomerService createCustomerService() {
        return new CustomerServiceImpl();
    }

    @Override
    public ManagerService createManagerService() {
        return new ManagerServiceImpl();
    }

    @Override
    public MasterService createMasterService() {
        return new MasterServiceImpl();
    }

    @Override
    public UserService createUserService() {
        return new UserServiceImpl();
    }
}

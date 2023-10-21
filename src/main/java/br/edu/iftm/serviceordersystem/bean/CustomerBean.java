package br.edu.iftm.serviceordersystem.bean;

import br.edu.iftm.serviceordersystem.entity.Customer;
import br.edu.iftm.serviceordersystem.logic.CustomerLogic;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class CustomerBean extends GenericBean<Customer, CustomerLogic> {
     @Inject
    private CustomerLogic logic;
    
    @Override
    public CustomerLogic getLogic() {
        return logic;
    }

    @Override
    public Class<Customer> getClassEntity() {
        return Customer.class;
    }
}

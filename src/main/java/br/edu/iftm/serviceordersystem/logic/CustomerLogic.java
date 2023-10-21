package br.edu.iftm.serviceordersystem.logic;

import br.edu.iftm.serviceordersystem.entity.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerLogic implements GenericLogic<Customer> {

    private List<Customer> customers = new ArrayList<>();
    private Long id = 1L;

    @Override
    public Customer salvar(Customer entity) {
        entity.setId(id++);
        customers.add(entity);
        return entity;
    }

    @Override
    public void remover(Customer entity) {
        customers.remove(entity);
    }

    @Override
    public List<Customer> listar() {
        return customers;
    }

    @Override
    public Customer atualizar(Customer entity) {
        Customer updateEntity = new Customer();
        
        for (Customer customer : customers) {
            if (customer.equals(entity)) {
                customer.setName(entity.getName());
                customer.setEmail(entity.getEmail());
                customer.setBirthDate(entity.getBirthDate());
                customer.setCustomerRegistrationStatus(entity.getCustomerRegistrationStatus());
                customer.setLegalCustomerStatus(entity.getLegalCustomerStatus());
                customer.setPhoneNumber(entity.getPhoneNumber());
                customer.setObs(entity.getObs());
                updateEntity  = customer;
            }
        }
        
        return updateEntity;
    }
}

package br.edu.iftm.serviceordersystem.logic;

import br.edu.iftm.serviceordersystem.entity.Customer;
import br.edu.iftm.serviceordersystem.util.LegalEntityStatus;
import br.edu.iftm.serviceordersystem.util.RegistrationStatus;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;


public class CustomerLogic implements GenericLogic<Customer> {

    final public List<Customer> customers = new ArrayList<>();
    private Long id = 1L;

    @PostConstruct
    public void init() {
        initializeData();
        listar();
    }

    @Override
    public Customer salvar(Customer entity) {
        entity.setId(id++);
        customers.add(entity);
        return entity;
    }

    @Override
    public void remover(Customer entity) {
        if(entity != null) customers.remove(entity);
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
    
    public Customer buscarPorIdentificador(Long customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
    
    public void initializeData() {
        Customer customer1 = new Customer();
        customer1.setId(id++);
        customer1.setName("João Silva");
        customer1.setIdentificationNumber("12345678900"); // Exemplo de CPF
        customer1.setLegalCustomerStatus(LegalEntityStatus.FISICA);
        customer1.setCustomerRegistrationStatus(RegistrationStatus.ATIVO);
        customer1.setPhoneNumber("1122334455");
        customer1.setEmail("joao.silva@email.com");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(id++);
        customer2.setName("Empresa Exemplo LTDA");
        customer2.setIdentificationNumber("12345678000199"); // Exemplo de CNPJ
        customer2.setLegalCustomerStatus(LegalEntityStatus.JURIDICA);
        customer2.setCustomerRegistrationStatus(RegistrationStatus.INATIVO);
        customer2.setPhoneNumber("9988776655");
        customer2.setEmail("empresa.exemplo@email.com");
        customers.add(customer2);

        Customer customer3 = new Customer();
        customer3.setId(id++);
        customer3.setName("Maria Santos");
        customer3.setIdentificationNumber("98765432100"); // Exemplo de CPF
        customer3.setLegalCustomerStatus(LegalEntityStatus.FISICA);
        customer3.setCustomerRegistrationStatus(RegistrationStatus.ATIVO);
        customer3.setPhoneNumber("5544332211");
        customer3.setEmail("maria.santos@email.com");
        customers.add(customer3);

        Customer customer4 = new Customer();
        customer4.setId(id++);
        customer4.setName("Empresa ABC LTDA");
        customer4.setIdentificationNumber("98765432000188"); // Exemplo de CNPJ
        customer4.setLegalCustomerStatus(LegalEntityStatus.JURIDICA);
        customer4.setCustomerRegistrationStatus(RegistrationStatus.INATIVO);
        customer4.setPhoneNumber("6677889900");
        customer4.setEmail("empresa.abc@email.com");
        customers.add(customer4);

        Customer customer5 = new Customer();
        customer5.setId(id++);
        customer5.setName("José Almeida");
        customer5.setIdentificationNumber("56789012300"); // Exemplo de CPF
        customer5.setLegalCustomerStatus(LegalEntityStatus.FISICA);
        customer5.setCustomerRegistrationStatus(RegistrationStatus.INATIVO);
        customer5.setPhoneNumber("1122334455");
        customer5.setEmail("jose.almeida@email.com");
        customers.add(customer5);

        Customer customer6 = new Customer();
        customer6.setId(id++);
        customer6.setName("Empresa XYZ LTDA");
        customer6.setIdentificationNumber("76543210900177"); // Exemplo de CNPJ
        customer6.setLegalCustomerStatus(LegalEntityStatus.JURIDICA);
        customer6.setCustomerRegistrationStatus(RegistrationStatus.ATIVO);
        customer6.setPhoneNumber("9988776655");
        customer6.setEmail("empresa.xyz@email.com");
        customers.add(customer6);

        Customer customer7 = new Customer();
        customer7.setId(id++);
        customer7.setName("Laura Fernandes");
        customer7.setIdentificationNumber("34567890123"); // Exemplo de CPF
        customer7.setLegalCustomerStatus(LegalEntityStatus.FISICA);
        customer7.setCustomerRegistrationStatus(RegistrationStatus.ATIVO);
        customer7.setPhoneNumber("5544332211");
        customer7.setEmail("laura.fernandes@email.com");
        customers.add(customer7);

        Customer customer8 = new Customer();
        customer8.setId(id++);
        customer8.setName("Empresa 123 LTDA");
        customer8.setIdentificationNumber("65432109800111"); // Exemplo de CNPJ
        customer8.setLegalCustomerStatus(LegalEntityStatus.JURIDICA);
        customer8.setCustomerRegistrationStatus(RegistrationStatus.INATIVO);
        customer8.setPhoneNumber("6677889900");
        customer8.setEmail("empresa.123@email.com");
        customers.add(customer8);

        Customer customer9 = new Customer();
        customer9.setId(id++);
        customer9.setName("Rafaela Oliveira");
        customer9.setIdentificationNumber("21098765400"); // Exemplo de CPF
        customer9.setLegalCustomerStatus(LegalEntityStatus.FISICA);
        customer9.setCustomerRegistrationStatus(RegistrationStatus.INATIVO);
        customer9.setPhoneNumber("1122334455");
        customer9.setEmail("rafaela.oliveira@email.com");
        customers.add(customer9);

        Customer customer10 = new Customer();
        customer10.setId(id++);
        customer10.setName("Empresa Beta LTDA");
        customer10.setIdentificationNumber("78901234000155"); // Exemplo de CNPJ
        customer10.setLegalCustomerStatus(LegalEntityStatus.JURIDICA);
        customer10.setCustomerRegistrationStatus(RegistrationStatus.ATIVO);
        customer10.setPhoneNumber("9988776655");
        customer10.setEmail("empresa.beta@email.com");
        customers.add(customer10);
    }
}

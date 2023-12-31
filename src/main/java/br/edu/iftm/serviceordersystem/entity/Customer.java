package br.edu.iftm.serviceordersystem.entity;

import br.edu.iftm.serviceordersystem.entity.Address;
import br.edu.iftm.serviceordersystem.util.LegalEntityStatus;
import br.edu.iftm.serviceordersystem.util.RegistrationStatus;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer implements Serializable {
    
    @EqualsAndHashCode.Include
    private Long id;
    
    @EqualsAndHashCode.Include
    private String identificationNumber;
    
    private String name;
    private String email;
    private Date birthDate;
    private String phoneNumber;
//    private Address address;
    private String obs;
    
    private RegistrationStatus customerRegistrationStatus;
    private LegalEntityStatus legalCustomerStatus;
}

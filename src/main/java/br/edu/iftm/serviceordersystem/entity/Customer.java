package br.edu.iftm.serviceordersystem.entity;

import br.edu.iftm.serviceordersystem.util.LegalEntityStatus;
import br.edu.iftm.serviceordersystem.util.RegistrationStatus;
import br.edu.iftm.serviceordersystem.entity.Address;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer { // extends Address
    
    @EqualsAndHashCode.Include
    private Long id;
    
    @EqualsAndHashCode.Include
    private String cpf;
    
    private String name;
    private String email;
    private Date birthDate;
    
    private RegistrationStatus customerRegistrationStatus;
    private LegalEntityStatus legalCustomerStatus;
}

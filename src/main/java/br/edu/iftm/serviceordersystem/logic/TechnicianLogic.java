package br.edu.iftm.serviceordersystem.logic;

import br.edu.iftm.serviceordersystem.entity.Technician;
import br.edu.iftm.serviceordersystem.util.LegalEntityStatus;
import br.edu.iftm.serviceordersystem.util.RegistrationStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;

public class TechnicianLogic implements GenericLogic<Technician> {
    
    final private List<Technician> technicians = new ArrayList<>();
    private Long id = 1L;
    
    @PostConstruct
    public void init() {
        initializeData();
        
        long inicio = new Date().getTime() + 30;
        while (inicio > new Date().getTime()) {

        }
        listar();
    }
    
    @Override
    public Technician salvar(Technician entity) {
        entity.setId(id++);
        technicians.add(entity);
        return entity;
    }

    @Override
    public void remover(Technician entity) {
        technicians.remove(entity);
    }

    @Override
    public List<Technician> listar() {
        return technicians;
    }
    
    @Override
    public Technician atualizar(Technician entity) {
        Technician updateEntity = new Technician();
        
        for (Technician technician : technicians) {
            if (technician.equals(entity)) {
                
                technician.setName(entity.getName());
                technician.setEmail(entity.getEmail());
                technician.setPhoneNumber(entity.getPhoneNumber());
                
                technician.setTechnicianRegistrationStatus(entity.getTechnicianRegistrationStatus());
                technician.setLegalTechnicianStatus(entity.getLegalTechnicianStatus());
                
                technician.setObs(entity.getObs());
                
                updateEntity  = technician;
            }
        }
        
        return updateEntity;
    }
    
    // Teste (carga inicial)
    public void initializeData() {
        Technician technician1 = new Technician();
        technician1.setId(id++);
        technician1.setName("João da Silva");
        technician1.setIdentificationNumber("12345678900");
        technician1.setEmail("joao@example.com");
        technician1.setPhoneNumber("111111111");
        technician1.setSpecialization("Redes de Computadores");
        technician1.setObs("Especialista em infraestrutura de redes.");
        technician1.setLegalTechnicianStatus(LegalEntityStatus.FISICA);
        technician1.setTechnicianRegistrationStatus(RegistrationStatus.ATIVO);
        technicians.add(technician1);

        Technician technician2 = new Technician();
        technician2.setId(id++);
        technician2.setName("Empresa de Tecnologia LTDA");
        technician2.setIdentificationNumber("12345678000199"); // Exemplo de CNPJ
        technician2.setEmail("empresa@example.com");
        technician2.setPhoneNumber("222222222");
        technician2.setSpecialization("Desenvolvimento de Software");
        technician2.setObs("Fornecedora de soluções de software para empresas.");
        technician2.setLegalTechnicianStatus(LegalEntityStatus.JURIDICA);
        technician2.setTechnicianRegistrationStatus(RegistrationStatus.INATIVO);
        technicians.add(technician2);

        Technician technician3 = new Technician();
        technician3.setId(id++);
        technician3.setName("Maria Oliveira");
        technician3.setIdentificationNumber("98765432100");
        technician3.setEmail("maria@example.com");
        technician3.setPhoneNumber("333333333");
        technician3.setSpecialization("Suporte Técnico");
        technician3.setObs("Especialista em suporte a sistemas operacionais.");
        technician3.setLegalTechnicianStatus(LegalEntityStatus.FISICA);
        technician3.setTechnicianRegistrationStatus(RegistrationStatus.ATIVO);
        technicians.add(technician3);

        Technician technician4 = new Technician();
        technician4.setId(id++);
        technician4.setName("Empresa de Segurança LTDA");
        technician4.setIdentificationNumber("98765432000177");
        technician4.setEmail("seguranca@example.com");
        technician4.setPhoneNumber("444444444");
        technician4.setSpecialization("Segurança da Informação");
        technician4.setObs("Fornecedora de soluções de segurança cibernética.");
        technician4.setLegalTechnicianStatus(LegalEntityStatus.JURIDICA);
        technician4.setTechnicianRegistrationStatus(RegistrationStatus.INATIVO);
        technicians.add(technician4);

        Technician technician5 = new Technician();
        technician5.setId(id++);
        technician5.setName("Pedro Alves");
        technician5.setIdentificationNumber("23456789011");
        technician5.setEmail("pedro@example.com");
        technician5.setPhoneNumber("555555555");
        technician5.setSpecialization("Administração de Redes");
        technician5.setObs("Experiência em gerenciamento de redes empresariais.");
        technician5.setLegalTechnicianStatus(LegalEntityStatus.FISICA);
        technician5.setTechnicianRegistrationStatus(RegistrationStatus.ATIVO);
        technicians.add(technician5);

        Technician technician6 = new Technician();
        technician6.setId(id++);
        technician6.setName("Empresa de Consultoria LTDA");
        technician6.setIdentificationNumber("23456789000133");
        technician6.setEmail("consultoria@example.com");
        technician6.setPhoneNumber("666666666");
        technician6.setSpecialization("Consultoria em TI");
        technician6.setObs("Oferece serviços de consultoria em tecnologia.");
        technician6.setLegalTechnicianStatus(LegalEntityStatus.JURIDICA);
        technician6.setTechnicianRegistrationStatus(RegistrationStatus.INATIVO);
        technicians.add(technician6);
    }
}

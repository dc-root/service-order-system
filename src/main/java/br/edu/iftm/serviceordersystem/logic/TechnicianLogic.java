package br.edu.iftm.serviceordersystem.logic;

import br.edu.iftm.serviceordersystem.entity.Technician;
import java.util.ArrayList;
import java.util.List;

public class TechnicianLogic implements GenericLogic<Technician> {
    
    private List<Technician> technicians = new ArrayList<>();
    private Long id = 1L;
    
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
}

package br.edu.iftm.serviceordersystem.logic;

import br.edu.iftm.serviceordersystem.entity.ServiceOrder;
import br.edu.iftm.serviceordersystem.util.StatusOs;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceOrderLogic implements GenericLogic<ServiceOrder> {
    
    private List<ServiceOrder> serviceOrders = new ArrayList<>();
    private Long id = 1L;
    
    @Override
    public ServiceOrder salvar(ServiceOrder entity) {
        entity.setId(id++);
        entity.setOpeningDate(new Date());
        
        if(entity.getServiceOrderStatus().equals(StatusOs.CONCLUIDO)) {
            entity.setCompletionDate(new Date());
        }
        
        serviceOrders.add(entity);
        return entity;
    }

    @Override
    public void remover(ServiceOrder entity) {
        serviceOrders.remove(entity);
    }

    @Override
    public List<ServiceOrder> listar() {
        return serviceOrders;
    }
    
    @Override
    public ServiceOrder atualizar(ServiceOrder entity) {
        ServiceOrder updateEntity = new ServiceOrder();
        
        for (ServiceOrder serviceOrder : serviceOrders) {
            if (serviceOrder.equals(entity)) {
                
                serviceOrder.setServiceName(entity.getServiceName());
                serviceOrder.setRealCost(entity.getRealCost());
                
                // serviceOrder.setOpeningDate(entity.getOpeningDate()); // Talvez??
                serviceOrder.setCompletionDate(entity.getCompletionDate());
                
                serviceOrder.setResponsibleTechnician(entity.getResponsibleTechnician());
                serviceOrder.setAssociatedCustomer(entity.getAssociatedCustomer());
                
                serviceOrder.setServiceOrderStatus(entity.getServiceOrderStatus());
                serviceOrder.setPriority(entity.getPriority());
                
                if(entity.getServiceOrderStatus().equals(StatusOs.CONCLUIDO)) {
                    serviceOrder.setCompletionDate(new Date());
                }
                
                updateEntity  = serviceOrder;
            }
        }
        
        return updateEntity;
    }
}

package br.edu.iftm.serviceordersystem.bean;

import br.edu.iftm.serviceordersystem.entity.ServiceOrder;
import br.edu.iftm.serviceordersystem.logic.ServiceOrderLogic;
import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;

@Named
@SessionScoped
public class ServiceOrderBean extends GenericBean<ServiceOrder, ServiceOrderLogic> {    
    @Inject
    private ServiceOrderLogic logic;
    
    @Override
    public ServiceOrderLogic getLogic() {
        return logic;
    }

    @Override
    public Class<ServiceOrder> getClassEntity() {
        return ServiceOrder.class;
    }
    
    public UUID gerarUUID() {
        UUID code = UUID.randomUUID();
        return code;
    }
}

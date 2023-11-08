package br.edu.iftm.serviceordersystem.bean;

import br.edu.iftm.serviceordersystem.entity.Technician;
import br.edu.iftm.serviceordersystem.logic.TechnicianLogic;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class TechnicianBean extends GenericBean<Technician, TechnicianLogic> {
    @Inject
    private TechnicianLogic logic;
    
    @Override
    public TechnicianLogic getLogic() {
        return logic;
    }

    @Override
    public Class<Technician> getClassEntity() {
        return Technician.class;
    }
}

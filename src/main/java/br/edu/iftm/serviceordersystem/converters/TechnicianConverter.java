package br.edu.iftm.serviceordersystem.converters;

import br.edu.iftm.serviceordersystem.entity.Technician;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;

@FacesConverter(forClass = Technician.class, value = "technicianConverter")
public class TechnicianConverter implements Converter<Technician> {
    
    @Override
    public Technician getAsObject(FacesContext context, UIComponent component, String id) {
        Technician technician = (Technician) component.getAttributes().get("technician_"+id);
        return technician;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Technician technician) {
        if(technician != null) {
            component.getAttributes().put("technician_"+technician.getId(), technician);
            return technician.getId()+"";
        }
        return null;
    }
}

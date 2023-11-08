package br.edu.iftm.serviceordersystem.converters;

import br.edu.iftm.serviceordersystem.entity.Customer;
import br.edu.iftm.serviceordersystem.logic.CustomerLogic;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import javax.inject.Inject;

@FacesConverter("customerConverter")
public class CustomerConverter implements Converter {
    
    @Inject
    private CustomerLogic customerService;
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Customer) {
            Customer customer = (Customer) value;
            return String.valueOf(customer.getId());
        }
        return null;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            Long customerId = (Long) Long.parseLong(value);
            
            Customer customer = customerService.buscarPorIdentificador(customerId);
            return customer;
        }
        return null;
    }
}

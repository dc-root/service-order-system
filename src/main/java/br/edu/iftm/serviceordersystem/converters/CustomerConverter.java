package br.edu.iftm.serviceordersystem.converters;

import br.edu.iftm.serviceordersystem.entity.Customer;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;

@FacesConverter(forClass = Customer.class, value = "customerConverter")
public class CustomerConverter implements Converter<Customer> {
    
    @Override
    public Customer getAsObject(FacesContext context, UIComponent component, String id) {
        Customer customer = (Customer) component.getAttributes().get("customer_"+id);
        return customer;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Customer customer) {
        if(customer != null) {
            component.getAttributes().put("customer_"+customer.getId(), customer);
            return customer.getId()+"";
        }
        return null;
    }
}

package br.edu.iftm.serviceordersystem.converters;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class GenericConverter<T> implements Converter<T> {
    private final Class<T> entityClass;
    
    public GenericConverter(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    @Override
    public T getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        try {
            Constructor<T> constructor = entityClass.getConstructor();
            T entity = constructor.newInstance();

            Method fromStringMethod = entityClass.getMethod("fromString", String.class);
            return (T) fromStringMethod.invoke(entity, value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao converter a string de volta para o objeto", e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, T value) {
        if (value == null) {
            return null;
        }

        try {
            Method toStringMethod = entityClass.getMethod("toString");
            return (String) toStringMethod.invoke(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao converter o objeto para uma string", e);
        }
    }
}

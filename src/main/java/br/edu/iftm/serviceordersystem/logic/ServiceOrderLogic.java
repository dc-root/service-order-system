package br.edu.iftm.serviceordersystem.logic;

import br.edu.iftm.serviceordersystem.entity.ServiceOrder;
import br.edu.iftm.serviceordersystem.util.StatusOs;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceOrderLogic implements GenericLogic<ServiceOrder> {

    private List<ServiceOrder> serviceOrders = new ArrayList<>();
    private Long id = 1L;

    @Override
    public ServiceOrder salvar(ServiceOrder entity) {
        entity.setId(id++);
        entity.setOpeningDate(new Date());

        serviceOrders.add(entity);
        return entity;
    }

    @Override
    public void remover(ServiceOrder entity) {
        serviceOrders.remove(entity);
    }

    @Override
    public List<ServiceOrder> listar() {
        Collections.reverse(serviceOrders);
        return serviceOrders;
    }

    public List<ServiceOrder> listarPorStatus(StatusOs status) {
        return serviceOrders.stream()
                .filter(order -> order.getServiceOrderStatus().equals(status))
                .collect(Collectors.toList());
    }

    public List<ServiceOrder> listarPorMesAbertura(int mes) {
        return serviceOrders.stream()
                .filter(order -> {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(order.getOpeningDate());
                    int mesAbertura = calendar.get(Calendar.MONTH) + 1;
                    return mesAbertura == mes;
                })
                .collect(Collectors.toList());
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

                updateEntity = serviceOrder;
            }
        }

        return updateEntity;
    }
}

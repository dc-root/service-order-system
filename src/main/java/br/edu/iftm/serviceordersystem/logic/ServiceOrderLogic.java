package br.edu.iftm.serviceordersystem.logic;

import br.edu.iftm.serviceordersystem.entity.ServiceOrder;
import br.edu.iftm.serviceordersystem.util.ServicePriority;
import br.edu.iftm.serviceordersystem.util.StatusOs;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import java.util.UUID;
import javax.annotation.PostConstruct;

public class ServiceOrderLogic implements GenericLogic<ServiceOrder> {

    private List<ServiceOrder> serviceOrders = new ArrayList<>();
    private Long id = 1L;

    @PostConstruct
    public void init() {
        initializeData();
        listar();
    }

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

    // Teste
    public void initializeData() {
        Random random = new Random();

        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        for (int i = 0; i < 44; i++) {
            ServiceOrder serviceOrder = new ServiceOrder();
            serviceOrder.setId(id++);
            serviceOrder.setServiceName("Serviço " + i);
            serviceOrder.setServiceNumber(UUID.randomUUID());
            serviceOrder.setRealCost(100.00 * i);
            serviceOrder.setResponsibleTechnician(null);
            serviceOrder.setAssociatedCustomer(null);

            // Definindo aleatoriamente o Status da Ordem de Serviço
            StatusOs[] statusArray = StatusOs.values();
            StatusOs randomStatus = statusArray[random.nextInt(statusArray.length)];
            serviceOrder.setServiceOrderStatus(randomStatus);

            // Definindo aleatoriamente a Prioridade do Serviço
            ServicePriority[] priorityArray = ServicePriority.values();
            ServicePriority randomPriority = priorityArray[random.nextInt(priorityArray.length)];
            serviceOrder.setPriority(randomPriority);

            // Gerando datas aleatórias no ano corrente
            int randomMonth = random.nextInt(12); // Mês aleatório de 0 a 11
            int randomDay = random.nextInt(28) + 1; // Dia aleatório de 1 a 28 (considerando fevereiro)

            calendar.set(currentYear, randomMonth, randomDay);

            // Definindo aleatoriamente as datas de abertura e conclusão
            long randomOpeningDate = calendar.getTimeInMillis();
            long randomCompletionDate = randomOpeningDate + (random.nextInt(20) * 24L * 60 * 60 * 1000); // 20 dias depois da abertura
            serviceOrder.setOpeningDate(new Date(randomOpeningDate));
            serviceOrder.setCompletionDate(new Date(randomCompletionDate));

            serviceOrders.add(serviceOrder);
        }
    }
}

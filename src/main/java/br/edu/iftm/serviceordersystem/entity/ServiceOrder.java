package br.edu.iftm.serviceordersystem.entity;

import br.edu.iftm.serviceordersystem.util.ServicePriority;
import br.edu.iftm.serviceordersystem.util.StatusOs;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ServiceOrder implements Serializable {
    
    @EqualsAndHashCode.Include
    private Long id;
    
    @EqualsAndHashCode.Include
    private String serviceName;
    
    @EqualsAndHashCode.Include
    private UUID serviceNumber;
    
    private double realCost; // pode ser derivado de calculos entre o valor de mão de obra do Tecnico e os materiais utilizados
    
    private Date openingDate;
    private Date completionDate;
    
    private Technician responsibleTechnician;
    private Customer associatedCustomer;
//    private ArrayList<Material> materialsUsed;
    
    private StatusOs serviceOrderStatus;
    private ServicePriority priority;
}

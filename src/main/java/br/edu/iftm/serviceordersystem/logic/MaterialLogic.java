package br.edu.iftm.serviceordersystem.logic;

import br.edu.iftm.serviceordersystem.entity.Material;
import java.util.ArrayList;
import java.util.List;

public class MaterialLogic implements GenericLogic<Material> {
    
    private List<Material> materials = new ArrayList<>();
    private Long id = 1L;
    
    @Override
    public Material salvar(Material entity) {
        entity.setId(id++);
        materials.add(entity);
        return entity;
    }

    @Override
    public void remover(Material entity) {
        materials.remove(entity);
    }

    @Override
    public List<Material> listar() {
        return materials;
    }
    
    @Override
    public Material atualizar(Material entity) {
        Material updateEntity = new Material();
        
        for (Material material : materials) {
            if (material.equals(entity)) {
                
                material.setName(entity.getName());
                material.setQuantity(entity.getQuantity());
                material.setUnitCost(entity.getUnitCost());
                material.setSerialNumber(entity.getSerialNumber());
                material.setUnitOfMeasure(entity.getUnitOfMeasure());
                material.setAcquisitionDate(entity.getAcquisitionDate());
                material.setNote(entity.getNote());
                
                updateEntity  = material;
            }
        }
        
        return updateEntity;
    }
}

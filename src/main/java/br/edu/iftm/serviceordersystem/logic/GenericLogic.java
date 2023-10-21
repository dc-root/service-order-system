package br.edu.iftm.serviceordersystem.logic;

import br.edu.iftm.serviceordersystem.util.exception.ErrorBusinessException;
import br.edu.iftm.serviceordersystem.util.exception.ErrorSystemException;
import java.io.Serializable;
import java.util.List;

public interface GenericLogic<E> extends Serializable {
    
    public E salvar(E entity) throws ErrorBusinessException, ErrorSystemException;
    public void remover(E entity) throws ErrorBusinessException, ErrorSystemException;
    public List<E> listar() throws ErrorBusinessException, ErrorSystemException;
    public E atualizar(E entity) throws ErrorBusinessException, ErrorSystemException;
    
}

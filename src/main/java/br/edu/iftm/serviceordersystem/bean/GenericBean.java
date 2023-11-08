package br.edu.iftm.serviceordersystem.bean;

import java.lang.reflect.InvocationTargetException;
import br.edu.iftm.serviceordersystem.logic.GenericLogic;
import br.edu.iftm.serviceordersystem.util.BeanUtil;
import br.edu.iftm.serviceordersystem.util.exception.ErrorBusinessException;
import br.edu.iftm.serviceordersystem.util.exception.ErrorSystemException;
import lombok.Getter;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.List;
import java.util.Date;
import lombok.Setter;

public abstract class GenericBean<E, L extends GenericLogic<E>> extends BeanUtil {

    @Getter @Setter
    private E entity;

    @Getter @Setter
    private List<E> entitys;

    @Getter @Setter
    private Estado estado = Estado.PESQUISANDO;

    enum Estado {
        CRIANDO,
        EDITANDO,
        PESQUISANDO
    }

    public void newInstanceOfEntity() {
        try {
            entity = (E) getClassEntity().getConstructors()[0].newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(GenericBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void novo() {
        long inicio = new Date().getTime() + 30;
        while (inicio > new Date().getTime()) {

        }
        newInstanceOfEntity();
        setEstado(Estado.CRIANDO);
    }

    public void salvar() {
        try {
            getLogic().salvar(entity);
            addInfo("Salvo com sucesso.");
            listar();
        } catch (ErrorBusinessException ex) {
            addAviso(ex);
        } catch (ErrorSystemException ex) {
            addError(ex);
            Logger.getLogger(GenericBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            addError("Erro no sistema: " + ex.getMessage());
            Logger.getLogger(GenericBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listar() {
        try {
            setEstado(Estado.PESQUISANDO);
            setEntitys(getLogic().listar());
        } catch (ErrorBusinessException ex) {
            addAviso(ex);
        } catch (ErrorSystemException ex) {
            addError(ex);
            Logger.getLogger(GenericBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remover() {
        try {
            getLogic().remover(entity);
            addInfo("Removido com sucesso.");
        } catch (ErrorBusinessException ex) {
            addAviso(ex);
        } catch (ErrorSystemException ex) {
            addError(ex);
            Logger.getLogger(GenericBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar() {
        try {
            getLogic().atualizar(entity);
            addInfo("Atualizado com sucesso.");
            listar();
            setEstado(Estado.PESQUISANDO);
        } catch (ErrorBusinessException ex) {
            addAviso(ex);
        } catch (ErrorSystemException ex) {
            addError(ex);
            Logger.getLogger(GenericBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public abstract L getLogic();

    public abstract Class<E> getClassEntity();
}

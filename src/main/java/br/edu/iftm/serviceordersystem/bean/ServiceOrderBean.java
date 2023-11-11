package br.edu.iftm.serviceordersystem.bean;

import br.edu.iftm.serviceordersystem.entity.ServiceOrder;
import br.edu.iftm.serviceordersystem.logic.ServiceOrderLogic;
import br.edu.iftm.serviceordersystem.util.StatusOs;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;
import org.primefaces.model.charts.ChartData;

import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.primefaces.model.charts.donut.DonutChartOptions;

import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.primefaces.PrimeFaces;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;


@Named
@SessionScoped
public class ServiceOrderBean extends GenericBean<ServiceOrder, ServiceOrderLogic> {

    private DonutChartModel donutChartModelStatus;
    private LineChartModel lineModelOsAnnual;
    
    @PostConstruct
    public void init() {
        createDonutModel();
        createLineModel();
    }

    @Inject
    private ServiceOrderLogic logic;

    @Override
    public ServiceOrderLogic getLogic() {
        return logic;
    }

    @Override
    public Class<ServiceOrder> getClassEntity() {
        return ServiceOrder.class;
    }

    public UUID gerarUUID() {
        UUID code = UUID.randomUUID();
        return code;
    }

    public Date handleStatusChange(StatusOs status) { // á considerar (não funciona)
        if (status.equals("CONCLUIDO")) {
            return new Date();
        }
        return null;
    }
    
    public void createDonutModel() {
        donutChartModelStatus = new DonutChartModel();
        ChartData data = new ChartData();
        DonutChartOptions options = new DonutChartOptions();
        options.setMaintainAspectRatio(false);
        donutChartModelStatus.setOptions(options);
        
        int aberto = (int) logic.listarPorStatus(StatusOs.ABERTO).size();
        int emAndamento = (int) logic.listarPorStatus(StatusOs.EM_ANDAMENTO).size();
        int cancelado = (int) logic.listarPorStatus(StatusOs.CANCELADO).size();
        int concluido = (int) logic.listarPorStatus(StatusOs.CONCLUIDO).size();
        
        DonutChartDataSet dataSet = new DonutChartDataSet();
        List<Number> values = Arrays.asList(aberto, emAndamento, cancelado, concluido);
        dataSet.setData(values);

        List<String> bgColors = Arrays.asList("#eccfff", "#ffd8b2", "#ffcdd2", "#c8e6c9");
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = Arrays.asList("Aberto", "Em Andamento", "Cancelado", "Concluído");
        data.setLabels(labels);

        donutChartModelStatus.setData(data);
    }
    
    public void createLineModel() {
        lineModelOsAnnual = new LineChartModel();
        ChartData data = new ChartData();

        LineChartDataSet dataSet = new LineChartDataSet();
        List<Object> values = Arrays.asList(
            logic.listarPorMesDeAbertura(1).size(),
            logic.listarPorMesDeAbertura(2).size(),
            logic.listarPorMesDeAbertura(3).size(),
            logic.listarPorMesDeAbertura(4).size(),
            logic.listarPorMesDeAbertura(5).size(),
            logic.listarPorMesDeAbertura(6).size(),
            logic.listarPorMesDeAbertura(7).size(),
            logic.listarPorMesDeAbertura(8).size(),
            logic.listarPorMesDeAbertura(9).size(),
            logic.listarPorMesDeAbertura(10).size(),
            logic.listarPorMesDeAbertura(11).size(),
            logic.listarPorMesDeAbertura(12).size()
        );
        dataSet.setData(values);
        
        dataSet.setFill(false);
        dataSet.setLabel("Variação anual");
        dataSet.setBorderColor("#363b42");
        dataSet.setTension(0.1);
        data.addChartDataSet(dataSet);

        List<String> labels = Arrays.asList("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro");
        data.setLabels(labels);

        LineChartOptions options = new LineChartOptions();
        options.setMaintainAspectRatio(false);
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Ordem de serviço por ano");
        options.setTitle(title);

        lineModelOsAnnual.setOptions(options);
        lineModelOsAnnual.setData(data);
    }


    public DonutChartModel getDonutChartModelStatus() {
        if (donutChartModelStatus == null) {
            createDonutModel();
        }
        return donutChartModelStatus;
    }
    
    public LineChartModel getLineModelOsAnnual() {
        if(lineModelOsAnnual == null) {
            createLineModel();
        }
        
        return lineModelOsAnnual;
    }
    
    public void updateAllCharts() {
        createDonutModel();
        createLineModel();
        PrimeFaces.current().ajax().update("chartsPanel");
    }
}

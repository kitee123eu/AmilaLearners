/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.admin.backingbean;

import com.amilalearners.model.Stock;
import com.amilalearners.service.StockService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.DonutChartModel;

/**
 *
 * @author Toshiba
 */
@Named(value = "donutChartBacking")
@ViewScoped
public class DonutChartBacking {

    @EJB
    StockService stockService;

    private DonutChartModel model;

    public DonutChartModel getModel() {
        return model;
    }

    public String readStock() {
        model = new DonutChartModel();
        List<Stock> stockList = stockService.getAllStock();
        Map<String, Number> circle1 = new LinkedHashMap<String, Number>();
        for (Stock s : stockList) {
            circle1.put(s.getName(), s.getQuantity());
        }

        model.addCircle(circle1);
        model.setTitle("Donut Chart");
        model.setLegendPosition("w");
        model.setTitle("Custom Options");
        model.setLegendPosition("e");
        model.setSliceMargin(5);
        model.setShowDataLabels(true);
        model.setDataFormat("value");
        model.setShadow(false);
        return null;
    }

}

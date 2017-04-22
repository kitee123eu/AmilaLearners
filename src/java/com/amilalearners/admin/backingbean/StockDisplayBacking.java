/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amilalearners.admin.backingbean;

import com.amilalearners.model.Stock;
import com.amilalearners.service.StockService;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author Toshiba
 */
@Named(value = "stockDisplayBacking")
@ViewScoped
public class StockDisplayBacking {

    @EJB
    StockService stockService;

    private LineChartModel model;

    public LineChartModel getModel() {
        return model;
    }

    public String readStock() {
        model = new LineChartModel();
        ChartSeries items = new ChartSeries();
        List<Stock> stockList = stockService.getAllStock();
        items.setLabel("Vehicle");
        for (Stock s : stockList) {
            items.set(s.getName(), s.getQuantity());
        }

        model.addSeries(items);

        model.setTitle("Vehicle Stock");
        model.setLegendPosition("e");
        model.setShowPointLabels(true);
        model.getAxes().put(AxisType.X, new CategoryAxis("Type"));
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Quantity");
        yAxis.setMin(0);
        yAxis.setMax(200);
        return null;
    }

}

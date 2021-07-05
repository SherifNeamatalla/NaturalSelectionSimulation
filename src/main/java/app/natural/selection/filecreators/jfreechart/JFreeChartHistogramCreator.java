package app.natural.selection.filecreators.jfreechart;

import app.natural.selection.appcontroller.logger.AppLogger;
import app.natural.selection.appcontroller.model.Statistic;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JFreeChartHistogramCreator {

    public static void createHistogramForStatisticList(List<Statistic> statisticList) {

        Double[] energyDecayValues = new Double[statisticList.size()];
        energyDecayValues = statisticList.stream().map(entry -> entry.getEnergyDecayPerTickStatisticEntry().getAvgValue()).collect(Collectors.toList())
                .toArray(energyDecayValues);

        try {
            createSingleHistogram("Energy Decay(Avg)", energyDecayValues);

        } catch (Exception e) {
            AppLogger.logError(e);
        }

    }

    private static XYDataset createDataset(String label, Double[] values) {

        var series = new XYSeries("2016");
        for (int i = 0; i < values.length; i++) {
            series.add(i, values[i]);
        }

        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private static void createSingleHistogram(String label, Double[] values) throws IOException {

        XYDataset dataset = createDataset(label, values);
        JFreeChart chart = ChartFactory.createXYLineChart(
                label,
                "Ticks",
                label,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle(label,
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );


        ChartUtils.saveChartAsPNG(new File(label + ".png"), chart, 450, 400);
    }
}

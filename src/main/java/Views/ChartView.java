package Views;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.PlotOrientation;

import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.ITALIC;
import static java.awt.Font.SANS_SERIF;

public class ChartView extends JFrame {
    public ChartView(String title, double [] dataC, double averageC, double[] dataJ, double averageJ)
    {   this.setBounds(600, 100, 800, 700);
        JFreeChart lineChart = ChartFactory.createXYLineChart(
                title,
                "Number of run","Execution Time",
                createDatasetStatic(dataC,dataJ),
                PlotOrientation.VERTICAL,
                true,true,false);
        XYPlot plot=lineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.DARK_GRAY);
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.WHITE);
        renderer.setSeriesStroke(0, new BasicStroke(0.5f));
        renderer.setSeriesStroke(1, new BasicStroke(0.5f));
        plot.setRenderer(renderer);
        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 600 , 500 ) );
        TextTitle chartInfo = new TextTitle( "Averages:        C++: " +String.valueOf(averageC)+ "        Java: "+String.valueOf(averageJ),new Font(SANS_SERIF,ITALIC,16) );
        chartInfo.setPosition(RectangleEdge.BOTTOM);
        chartInfo.setHorizontalAlignment(HorizontalAlignment.CENTER);
        lineChart.addSubtitle(chartInfo);
        this.setContentPane( chartPanel );
        this.setVisible(true);
    }

    public ChartView(String title, double [] dataC, double averageC, double[] dataJ, double averageJ, double[] dataP, double averageP)
    {   this.setBounds(600, 100, 800, 700);
        JFreeChart lineChart = ChartFactory.createXYLineChart(
                title,
                "Number of run","Execution Time",
                createDataset(dataC,dataJ,dataP),
                PlotOrientation.VERTICAL,
                true,true,false);
        XYPlot plot=lineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.DARK_GRAY);
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.WHITE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesStroke(0, new BasicStroke(0.5f));
        renderer.setSeriesStroke(1, new BasicStroke(0.5f));
        renderer.setSeriesStroke(2, new BasicStroke(0.5f));
        plot.setRenderer(renderer);
        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 600 , 500 ) );
        TextTitle chartInfo = new TextTitle( "Averages:        C++: " +String.valueOf(averageC)+ "        Java: "+String.valueOf(averageJ)+ "        Python: "+String.valueOf(averageP),new Font(SANS_SERIF,ITALIC,16) );
        chartInfo.setPosition(RectangleEdge.BOTTOM);
        chartInfo.setHorizontalAlignment(HorizontalAlignment.CENTER);
        lineChart.addSubtitle(chartInfo);
        this.setContentPane( chartPanel );
        this.setVisible(true);
    }

    private XYDataset createDatasetStatic(double[] dataC, double[] dataJ) {
        XYSeriesCollection dataset = new XYSeriesCollection() {
        };
        final XYSeries seriesC = new XYSeries("C++");
        final XYSeries seriesJ = new XYSeries("Java");
        for(int i=0; i<100; i++) {
            seriesC.add(i+1,dataC[i]);
        }
        for(int i=0; i<100; i++) {
            seriesJ.add(i+1,dataJ[i]);
        }
        dataset.addSeries(seriesC);
        dataset.addSeries(seriesJ);
        return dataset;
    }

    private XYDataset createDataset(double[] dataC, double[] dataJ, double[] dataP) {
        XYSeriesCollection dataset = new XYSeriesCollection() {
        };
        final XYSeries seriesC = new XYSeries("C++");
        final XYSeries seriesJ = new XYSeries("Java");
        final XYSeries seriesP = new XYSeries("Python");
        for(int i=0; i<100; i++) {
            seriesC.add(i+1,dataC[i]);
        }
        for(int i=0; i<100; i++) {
            seriesJ.add(i+1,dataJ[i]);
        }
        for(int i=0; i<100; i++) {
            seriesP.add(i+1,dataP[i]);
        }
        dataset.addSeries(seriesC);
        dataset.addSeries(seriesJ);
        dataset.addSeries(seriesP);
        return dataset;
    }

}

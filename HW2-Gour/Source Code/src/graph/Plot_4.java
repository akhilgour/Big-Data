package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Plot_4 extends ApplicationFrame {

	public Plot_4(String applicationTitle, String chartTitle)
			throws NumberFormatException, IOException {
		super(applicationTitle);
		JFreeChart barChart = ChartFactory.createBarChart(chartTitle, "Year",
				"# of Conferences", createDataset(),
				PlotOrientation.HORIZONTAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chartPanel);
	}

	private CategoryDataset createDataset() throws NumberFormatException,
			IOException {

		ArrayList<String> cities = new ArrayList<String>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		File file = new File(
				"/home/cloudera/Downloads/db/Assgn2/finalOutput/4/part-r-00000");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;

		while ((line = br.readLine()) != null) {
			if ((line.contains("2015") || line.contains("2016")
					|| line.contains("2017") || line.contains("2018"))
					&& (line.startsWith("B") || (line.startsWith("S")))) {
				cities.add(line.split("\t")[0]);
				count.add(Integer.valueOf(line.split("\t")[1]));
			}

		}
		br.close();

		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < cities.size() && i < count.size(); i++) {
			dataset.addValue(count.get(i),
					cities.get(i).substring(0, cities.get(i).length() - 4),
					cities.get(i).substring(cities.get(i).length() - 4));
		}
		return dataset;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Plot_4 chart = new Plot_4(
				"Conference per city per year", "City with maximum #");
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}
}

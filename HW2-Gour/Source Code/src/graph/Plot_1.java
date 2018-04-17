package graph;

import java.io.BufferedReader;
import java.io.File;
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

public class Plot_1 extends ApplicationFrame {

	public Plot_1(String applicationTitle, String chartTitle)
			throws NumberFormatException, IOException {
		super(applicationTitle);
		JFreeChart bChart = ChartFactory.createBarChart(chartTitle, "City", "Conferences", createDataset(), PlotOrientation.HORIZONTAL, true, true, false);
		ChartPanel chart = new ChartPanel(bChart);
		chart.setPreferredSize(new java.awt.Dimension(560, 367));
		setContentPane(chart);
	}

	private CategoryDataset createDataset() throws NumberFormatException,
			IOException {
		ArrayList<String> cities = new ArrayList<String>();
		ArrayList<Integer> cList = new ArrayList<Integer>();
		File file = new File(
				"/home/cloudera/Downloads/db/Assgn2/finalOutput/1/part-r-00000");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		int count = 0;
		while ((line = br.readLine()) != null && count < 10) {
			cities.add(line.split("\t")[0]);
			cList.add(Integer.valueOf(line.split("\t")[1]));
			count++;
		}
		br.close();
		final String city = "Cities";
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int idx = 2; idx < cities.size() && idx < cList.size(); idx++) {
			dataset.addValue(cList.get(idx), city, cities.get(idx));
		}
		return dataset;
	}

	public static void main(String[] args) throws NumberFormatException,
		IOException {
		Plot_1 chart = new Plot_1("# conferences", "City with the maximum");
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);

	}
}

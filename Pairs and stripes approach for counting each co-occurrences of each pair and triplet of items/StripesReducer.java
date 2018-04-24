package task1;

import java.io.IOException;
import java.util.HashMap;
import java.util.TreeSet;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StripesReducer extends Reducer<Text, Text, Text, Text> {
	int ctr = 0;
	double total = 0;

	public void reduce(Text key, Iterable<Text> value, Context context)
			throws IOException, InterruptedException {
		java.util.Map<String, Integer> stripe = new HashMap<>();
		for (Text v : value) {
			String[] stripes = v.toString().split(",");
			for (String termCountStr : stripes) {
				String[] termCount = termCountStr.split(":");
				String term = termCount[0];
				ctr = Integer.parseInt(termCount[1]);
				Integer countSum = stripe.get(term);
				stripe.put(term, (countSum == null ? 0 : countSum) + ctr);
				total += ctr;
			}
		}
		for (java.util.Map.Entry<String, Integer> entry : stripe.entrySet()) {
			context.write(new Text("[" + key + "," + entry.getKey() + "]" + ":"
					+ ctr),
					new Text(String.valueOf(entry.getValue() / total)));
		}
	}
}

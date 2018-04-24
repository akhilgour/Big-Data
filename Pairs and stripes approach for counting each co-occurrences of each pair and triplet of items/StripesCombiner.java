package task1;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

// to combine count of stripes
public class StripesCombiner extends Reducer<Text, Text, Text, Text> {
	@SuppressWarnings("rawtypes")
	public void reduce(Text key, Iterable<Text> value, Context context)
			throws IOException, InterruptedException {
		java.util.Map<String, Integer> stripe = new HashMap<>();
		for (Text v : value) {
			String[] strp = v.toString().split(",");
			for (String ctrString : strp) {
				String[] termCount = ctrString.split(":");
				String termStr = termCount[0];
				int count = Integer.parseInt(termCount[1]);
				Integer countSum = stripe.get(termStr);
				stripe.put(termStr, (countSum == null ? 0 : countSum) + count);
			}
		}
		StringBuilder str = new StringBuilder();
		for (java.util.Map.Entry entry : stripe.entrySet()) {
			str.append(entry.getKey()).append(":").append(entry.getValue())
					.append(",");
		}
		context.write(key, new Text(str.toString())); // to emit key and value
	}
}

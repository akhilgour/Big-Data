package task1;

import java.io.IOException;
import java.util.HashMap;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
//to match keys as pair,count and send them to the combiner and reducer
public class StripesMapper extends Mapper<LongWritable, Text, Text, Text> {
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] words = value.toString().split(" ");
        for (String word : words) {
            if (word.matches("^\\w+$")) {
                java.util.Map<String, Integer> stripe = new HashMap<>();

                for (String term : words) {
                    if (term.matches("^\\w+$") && !term.equals(word)) {
                        Integer count = stripe.get(term);
                        stripe.put(term, (count == null ? 0 : count) + 1);
                    }
                }				
                StringBuilder stripeStr = new StringBuilder();							//write all pair as stripe
                for (@SuppressWarnings("rawtypes") java.util.Map.Entry entry : stripe.entrySet()) {
                    stripeStr.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
                }
                if (!stripe.isEmpty()) {
                    context.write(new Text(word), new Text(stripeStr.toString()));		//write to context 
                }
            }
        }
    }
}

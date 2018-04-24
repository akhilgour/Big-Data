package task1;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class PairsCombiner extends Reducer<Pairs, Text, Pairs, Text> {
	
		//to combine key and count of keys
        public void reduce(Pairs key, Iterable<Text> values, Context context)
                throws IOException, InterruptedException {
            int count = 0;
            for (Text value : values) {
                count += Integer.parseInt(value.toString());
            }
            context.write(key, new Text(String.valueOf(count)));			//to emit keys and thir respective count
        }
    }

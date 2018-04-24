package task1;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PairsMapper extends Mapper<LongWritable, Text, Pairs, Text> {
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		//to match keys and send them to the combiner and reducer
		String[] words = value.toString().split(" ");
		for (String word : words) {
			if (word.matches("^\\w+$")) {
				int count = 0;
				for (String item : words) {
					if (item.matches("^\\w+$") && !item.equals(word)) {
						Pairs pair = new Pairs(word, item);
						context.write(pair, new Text("1"));
						count++;
					}
				}
				Pairs pair = new Pairs(word, "*");
				context.write(pair, new Text(String.valueOf(count)));		//to emit key with * and its count as 1
			}
		}
	}
}

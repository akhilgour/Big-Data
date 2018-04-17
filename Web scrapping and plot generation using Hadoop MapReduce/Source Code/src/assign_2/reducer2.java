package assign_2;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class reducer2 extends Reducer<Text, Text, Text, Text>

{
	Text value = new Text();
	public void reduce(Text city, Iterable<Text> values, Context con)
			throws IOException, InterruptedException {
		StringBuilder b = new StringBuilder();
		for (Text conf : values) {
			b.append(conf.toString());
			b.append(", ");
		}
		value.set(b.toString());
		con.write(city, new Text(value));

	}
}

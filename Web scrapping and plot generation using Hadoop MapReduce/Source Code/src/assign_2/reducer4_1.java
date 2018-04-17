package assign_2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class reducer4_1 extends Reducer<Text, Text, Text, Text>

{
	Text v = new Text();

	public void reduce(Text city, Iterable<Text> values, Context con) throws IOException, InterruptedException {

		StringBuilder b = new StringBuilder();
		for (Text text : values) {
			b.append(text.toString());
			b.append(";");
		}
		v.set(b.toString().trim());

		con.write(city, new Text(v));

	}

}

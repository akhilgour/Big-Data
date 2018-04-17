package assign_2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class reducer4_2 extends Reducer<Text, IntWritable, Text, IntWritable> {
	public void reduce(Text conference, Iterable<IntWritable> values,
			Context con) throws IOException, InterruptedException {

		int sum = 0;

		for (IntWritable value : values) {

			sum += value.get();

		}

		con.write(conference, new IntWritable(sum));

	}

}

package assign_2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class mapper1 extends Mapper<LongWritable, Text, Text, IntWritable> {

	public void map(LongWritable key, Text value, Context con)
			throws IOException, InterruptedException

	{
		String str = value.toString();
		String[] words = str.split("\t");

		// for (String city : words){
		Text outputKey = new Text(words[3].trim());

		IntWritable outputValue = new IntWritable(1);

		con.write(outputKey, outputValue);
	}
	// }

}

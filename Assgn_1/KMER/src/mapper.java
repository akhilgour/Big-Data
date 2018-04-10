package genome;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class mapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	public void map(LongWritable key, Text value, Context con)
			throws IOException, InterruptedException

	{
		String str = value.toString();
		for (int i=0; i < str.length()-9; i++){
			
		String substr = str.substring(i, i+9);
			Text outputKey = new Text(substr.trim());

			IntWritable outputValue = new IntWritable(1);

			con.write(outputKey, outputValue);
			}
		}
	
	
}

package assign_2;


import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class mapper4_1 extends Mapper<Object, Text, Text, Text> {

	public void map(Object key, Text value, Context con)
			throws IOException, InterruptedException

	{
		
		String str = value.toString();
		String[] words=str.split("\t");
		String event = words[0].trim().concat(words[1].trim());
		
		Text city = new Text(words[3].trim());

		//IntWritable outputValue = new IntWritable(1);

		con.write(city, new Text(event.trim()));

	}
}


package assign_2;


import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class mapper2 extends Mapper<LongWritable, Text, Text, Text> {

	public void map(LongWritable key, Text value, Context con)
			throws IOException, InterruptedException

	{
		String str = value.toString();
		String[] words=str.split("\t");
		
		Text outputKey = new Text(words[3].trim());

		Text outputValue = new Text(words[2].trim());

		con.write(outputKey, outputValue);
		}

	}



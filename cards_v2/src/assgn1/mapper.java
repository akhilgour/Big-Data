package assgn1;

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

		String[] deck = str.split(",");

		for (String cards : deck)

		{
			if (!(cards.contains("A")) && !(cards.contains("j")) && !(cards.contains("Q")) && !(cards.contains("K")) && !(cards.contains("J"))) {
					

			Text outputKey = new Text(cards.substring(0, 1).trim());

			IntWritable outputValue = new IntWritable(Integer.parseInt(cards.substring(1, cards.length())));

			con.write(outputKey, outputValue);
			}
		}

	}
}

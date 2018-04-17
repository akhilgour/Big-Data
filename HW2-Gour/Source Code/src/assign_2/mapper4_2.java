package assign_2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class mapper4_2 extends Mapper<Object, Text, Text, IntWritable> {
	public void map(Object key, Text value, Context con)
			throws IOException, InterruptedException {
	String str = value.toString();
	String input[] = str.split("\t");
	String city = input[0];
	String words[] = input[1].split(";");
	for (int i = 0; i < words.length; i++) {
		String y = words[i].substring(words[i].length() - 4, words[i].length());
		Text outputKey = new Text(city.concat(y));
		con.write(outputKey, new IntWritable(1));
	}
}
}

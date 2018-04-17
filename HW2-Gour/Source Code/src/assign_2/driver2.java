package assign_2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class driver2 {
	@SuppressWarnings("deprecation")
	public static int main(String[] args) throws Exception {
		String temp_path = "temp";
		Configuration conf = new Configuration();
	Job job4 = new Job(conf, "Conferences");
	job4.setJarByClass(driver1.class);
	job4.setMapperClass(mapper4_1.class);
	job4.setReducerClass(reducer4_1.class);
	job4.setMapOutputKeyClass(Text.class);
	job4.setMapOutputValueClass(Text.class);
	job4.setOutputKeyClass(Text.class);
	job4.setOutputValueClass(Text.class);
	FileInputFormat.addInputPath(job4, new Path(args[0]));
	FileOutputFormat.setOutputPath(job4, new Path(temp_path));
	job4.waitForCompletion(true);
	
	Job job5 = new Job(conf, "Conferences");
	job5.setJarByClass(driver1.class);
	job5.setMapperClass(mapper4_2.class);
	job5.setReducerClass(reducer4_2.class);
	job5.setMapOutputKeyClass(Text.class);
	job5.setMapOutputValueClass(IntWritable.class);
	job5.setOutputKeyClass(Text.class);
	job5.setOutputValueClass(IntWritable.class);
	FileInputFormat.addInputPath(job5, new Path(temp_path));
	FileOutputFormat.setOutputPath(job5, new Path(args[1]+"/4"));
	return (job5.waitForCompletion(true) ? 0 : 1);
}
}
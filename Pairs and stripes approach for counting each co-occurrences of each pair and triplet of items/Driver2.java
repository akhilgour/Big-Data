package task1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Driver2 {
	public static int main(String[] args) throws Exception {
		Configuration configuration3 = new Configuration();
		configuration3.setLong(FileInputFormat.SPLIT_MAXSIZE, (long) 1048576);
		Job job3 = new Job(configuration3);
		job3.setJarByClass(Driver2.class);
		job3.setNumReduceTasks(2);
		job3.setOutputKeyClass(Text.class);
		job3.setOutputValueClass(Text.class);
		job3.setMapperClass(TripletPairsMapper.class);
		job3.setCombinerClass(TripletPairsCombiner.class);
		job3.setReducerClass(TripletPairsReducer.class);
		job3.setPartitionerClass(PartitionerStripes.class);
		job3.setInputFormatClass(TextInputFormat.class);
		job3.setOutputFormatClass(TextOutputFormat.class);
		FileInputFormat.addInputPath(job3, new Path(args[0]));
		FileOutputFormat.setOutputPath(job3, new Path(args[1] + "/3"));
		job3.waitForCompletion(true);
		
		Configuration configuration4 = new Configuration();
		configuration4.setLong(FileInputFormat.SPLIT_MAXSIZE, (long) 1048576);
		Job job4 = new Job(configuration4);
		job4.setJarByClass(Driver2.class);
		job4.setNumReduceTasks(2);
		job4.setOutputKeyClass(Text.class);
		job4.setOutputValueClass(Text.class);
		job4.setMapperClass(TripletStripesMapper.class);
		job4.setCombinerClass(TripletStripesCombiner.class);
		job4.setReducerClass(TripletStripesReducer.class);
		job4.setPartitionerClass(PartitionerStripes.class);
		job4.setInputFormatClass(TextInputFormat.class);
		job4.setOutputFormatClass(TextOutputFormat.class);
		FileInputFormat.addInputPath(job4, new Path(args[0]));
		FileOutputFormat.setOutputPath(job4, new Path(args[1]+ "/4"));

		boolean success = job4.waitForCompletion(true);
		return success ? 0 : 1;
	}

}

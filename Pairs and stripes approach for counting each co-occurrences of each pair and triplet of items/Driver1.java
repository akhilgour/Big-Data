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

public class Driver1 {
	public static int main(String[] args) throws Exception {
		
		Configuration configuration1 = new Configuration();
		configuration1.setLong(FileInputFormat.SPLIT_MAXSIZE, (long) 1048576);	//for using 4 mappers; splitting the input file
		Job job1 = new Job(configuration1);
		job1.setJarByClass(Driver1.class);										//setting driver class
		job1.setNumReduceTasks(2);
		job1.setMapOutputKeyClass(Pairs.class);									//output key class for mapper; returning pairs object
		job1.setMapOutputValueClass(Text.class);								//output value class for mapper; returning text object
		job1.setOutputKeyClass(Pairs.class);									//output key class for reducer; returning pairs object
		job1.setOutputValueClass(Text.class);									//output value class for reducer; returning text object
		job1.setMapperClass(PairsMapper.class);									//specifying mapper class name
		job1.setCombinerClass(PairsCombiner.class);								//specifying combiner class name
		job1.setReducerClass(PairsReducer.class);								//specifying reducer class name
		job1.setPartitionerClass(PartitionerPairs.class);						//specifying reducer class name
		job1.setInputFormatClass(TextInputFormat.class);
		job1.setOutputFormatClass(TextOutputFormat.class);
		FileInputFormat.addInputPath(job1, new Path(args[0]));					//input to be taken from cmd line arguments
		FileOutputFormat.setOutputPath(job1, new Path(args[1] + "/1"));			//output path
		job1.waitForCompletion(true);
	
		
		Configuration configuration2 = new Configuration();
		configuration2.setLong(FileInputFormat.SPLIT_MAXSIZE, (long) 1048576);
		Job job2 = new Job(configuration2);
		job2.setJarByClass(Driver1.class);
		job2.setNumReduceTasks(2);
		job2.setOutputKeyClass(Text.class);
		job2.setOutputValueClass(Text.class);
		job2.setMapperClass(StripesMapper.class);
		job2.setCombinerClass(StripesCombiner.class);
		job2.setReducerClass(StripesReducer.class);
		job2.setPartitionerClass(PartitionerStripes.class);
		job2.setInputFormatClass(TextInputFormat.class);
		job2.setOutputFormatClass(TextOutputFormat.class);
		FileInputFormat.addInputPath(job2, new Path(args[0]));
		FileOutputFormat.setOutputPath(job2, new Path(args[1] + "/2"));
		
		boolean success = job2.waitForCompletion(true);
		return success ? 0 : 1;
	}

}

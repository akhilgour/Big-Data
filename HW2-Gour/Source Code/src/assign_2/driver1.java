package assign_2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class driver1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		String temp_path = "temp";
		Configuration conf = new Configuration();
		Job job1 = new Job(conf, "Conferences");
		job1.setJarByClass(driver1.class);
		job1.setMapperClass(mapper1.class);
		job1.setReducerClass(reducer1.class);
		job1.setMapOutputKeyClass(Text.class);
		job1.setMapOutputValueClass(IntWritable.class);
		job1.setOutputKeyClass(Text.class);
		job1.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job1, new Path(args[0]));
		FileOutputFormat.setOutputPath(job1, new Path(args[1]+"/1"));
		job1.waitForCompletion(true);
				
		Job job2 = new Job(conf, "Conferences");
		job2.setJarByClass(driver1.class);
		job2.setMapperClass(mapper2.class);
		job2.setReducerClass(reducer2.class);
		job2.setMapOutputKeyClass(Text.class);
		job2.setMapOutputValueClass(Text.class);
		job2.setOutputKeyClass(Text.class);
		job2.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job2, new Path(args[0]));
		FileOutputFormat.setOutputPath(job2, new Path(args[1]+"/2"));
		job2.waitForCompletion(true);
	

		Job job3 = new Job(conf, "Conferences");
		job3.setJarByClass(driver1.class);
		job3.setMapperClass(mapper3.class);
		job3.setReducerClass(reducer3.class);
		job3.setMapOutputKeyClass(Text.class);
		job3.setMapOutputValueClass(Text.class);
		job3.setOutputKeyClass(Text.class);
		job3.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job3, new Path(args[0]));
		FileOutputFormat.setOutputPath(job3, new Path(args[1]+"/3"));
		job3.waitForCompletion(true);
/*
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
		return (job5.waitForCompletion(true) ? 0 : 1);*/
	}
	
	
	}	


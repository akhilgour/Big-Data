package assign_2;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class reducer1 extends Reducer<Text, IntWritable, Text, IntWritable>

{

public void reduce(Text word, Iterable<IntWritable> values, Context con) throws IOException, InterruptedException

{
	int count = 0;

	   for(IntWritable value : values)

	   {

	   count += value.get();

	   }

	   con.write(word, new IntWritable(count));

	}

}

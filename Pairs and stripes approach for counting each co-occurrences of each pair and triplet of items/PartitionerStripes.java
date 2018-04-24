package task1;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class PartitionerStripes extends Partitioner<Text, Text> {
//to partition based on range of key and then send it to correct reducer
	@Override
	public int getPartition(Text args0, Text args1, int args2) {
		int value = Integer.valueOf(String.valueOf(args0).split(",")[0].replace("[","").trim());
		if (value < 7000) {
			return 0;
		} 
		return 1;
	}
}

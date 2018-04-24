package task1;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;
// this class will partition send range of key to correct reducer
public class PartitionerPairs extends Partitioner<Pairs, Text> {
	@Override
	public int getPartition(Pairs arg0, Text arg1, int arg2) {
		int ctr = Integer.valueOf(arg0.getKey());
		if (ctr < 7000) {
			return 0;
		}
		return 1;
	}
}

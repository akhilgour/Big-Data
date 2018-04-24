package task1;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeSet;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PairsReducer extends Reducer<Pairs, Text, Pairs, Text> {
	//TreeSet<Pair> priorityQueue = new TreeSet<>();
	HashMap<String,Integer> hash=new HashMap<String, Integer>();

	public void reduce(Pairs key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		
		
		if(key.getValue().equals("*")){
			//System.err.println("reduce"+key.getKey()+key.getValue()+":"+Integer.valueOf(values.iterator().next().toString()));
			hash.put(key.getKey(), Integer.valueOf(values.iterator().next().toString()));
		}
		else{
			int count=Integer.valueOf(values.iterator().next().toString());
			context.write(key, new Text(String.valueOf(count)+":"+(double)count/hash.get(key.getKey())));
		}

		/*if (keyStr.matches(".*\\*")) {
			totalCount = count;
		} 
		//else {
			
			//String[] pair = keyStr.split(",");
			//priorityQueue.add(new Pair(count / totalCount, pair[0], pair[1],count));
		System.err.println("reducer"+"["+key.getKey()+","+key.getValue()+"]"+":"+count);
			//context.write(key, new Text(String.valueOf(count / totalCount)));
		context.write(key, new Text(String.valueOf(count)));
		//}
*/	}

	/*protected void cleanup(Context context) throws IOException,
			InterruptedException {
		while (!priorityQueue.isEmpty()) {
			Pair pair = priorityQueue.pollLast();
			context.write(new Text("["+pair.key+","+pair.value+"]"+":"+pair.count), new Text(String.valueOf(pair.relativeFrequency)));
		}
	}*/

}
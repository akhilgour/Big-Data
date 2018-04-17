package assign_2;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class reducer3 extends Reducer<Text, Text, Text, Text>{
Text v=new Text();
public void reduce(Text conference, Iterable<Text> values, Context con) throws IOException, InterruptedException {
	StringBuilder b=new StringBuilder();
	for(Text text:values){
		b.append(text.toString());
		b.append(", ");
	}
	b.setLength(b.length()-1);
	v.set(b.toString());
	con.write(conference, new Text(v));
	}
}

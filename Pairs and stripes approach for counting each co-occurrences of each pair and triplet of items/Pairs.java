package task1;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;


//class to compare keys of pairs
class Pairs implements Writable,WritableComparable<Pairs> {
	
			String key;
            String value;
            Pairs(){												//default constructor
            	this.key=new String();
            	this.value=new String();
            }
            Pairs( String key, String value) {						//copy constructor
              
                this.key = key;
                this.value = value;
               
            }
            public static int comp(Pairs p1,Pairs p2) {							//checking keys of 2 pair objects and comparing
                return p1.getKey().compareTo(p2.getKey());
                   
            }
            public void setKey(String key) {
				this.key = key;
			}
			public void setValue(String value) {
				this.value = value;
			}
			
			
			public static Pairs read(DataInput arg0) throws IOException {
				Pairs pair=new Pairs();
				pair.readFields(arg0);
		        return pair;
				
			}
			
            
            @Override
			public void readFields(DataInput arg0) throws IOException {
				key=WritableUtils.readString(arg0);
				value=WritableUtils.readString(arg0);
				
			}

			
		
			
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((key == null) ? 0 : key.hashCode());
				result = prime * result
						+ ((value == null) ? 0 : value.hashCode());
				return result;
			}
			
			
			public String getValue() {
				return value;
			}
			
			@Override
            public int compareTo(Pairs pair) {									//compare to pair objects
            	int value=this.getKey().compareTo(pair.getKey());
            	 if(value==0){
            		 value=this.getValue().compareTo(pair.getValue());
            	 }
            	return value;
                   
            }
            
			
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Pairs other = (Pairs) obj;
				if (key == null) {
					if (other.key != null)
						return false;
				} else if (!key.equals(other.key))
					return false;
				if (value == null) {
					if (other.value != null)
						return false;
				} else if (!value.equals(other.value))
					return false;
				return true;
				
				
			}
			
			
			public String getKey() {
				return key;
			}
			
			
			
			@Override
			public void write(DataOutput arg0) throws IOException {
				WritableUtils.writeString(arg0,key);
				WritableUtils.writeString(arg0,value);
				
			}
			
			
			@Override
		    public String toString() {
		        return "["+key+","+value+"]";
		    }
			
        }
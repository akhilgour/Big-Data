package task1;

class Triplet implements Comparable<Triplet> {
	
			int count;
           
            String triplet;
            String pair;

            Triplet(String triplet, String pair, int count) {
                
                this.triplet = triplet;
                this.pair = pair;
                this.count=count;
            }

			@Override
			public int compareTo(Triplet o) {
				// TODO Auto-generated method stub
				return 0;
			}

           
        }
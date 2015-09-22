/*
 * Sum integers from a text file. One int per line.
 */
public static void sumFile(String fileName){
	int total = 0;
	try{
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		for(String s = in.readLine(); s != null; s = in.readLine()){
			total += Integer.parseInt(s);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	return total;
}
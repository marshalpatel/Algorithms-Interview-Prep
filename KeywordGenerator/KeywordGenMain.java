package marshalp.keywordgen.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.json.simple.parser.ParseException;

public class KeywordGenMain {

	
	public static CharArraySet swset;
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub

		 swset = createStopWordsList();

		 
		 HashMap<String,String> map;
		 
		 jsonParser jp = new jsonParser();
		 //map = jp.readJson("rt_space_removed.json");
		 map = jp.readJson("random_reviews_13000.json");
		 
		 writeCSV(map);
		 
	}
	
	
	private static void writeCSV(HashMap<String,String> m) throws IOException{
		
		
		Iterator<Map.Entry<String, String>> itr = m.entrySet().iterator();
		
		FileWriter fw = new FileWriter("reviews_processed.csv");
		
		BufferedWriter bw = new BufferedWriter(fw);
		
		while(itr.hasNext()){
			
			Map.Entry<String, String> entry = itr.next();
			
			String id = entry.getKey();
			String text = entry.getValue();
			
			String e = id+",\""+text.trim()+"\"\n";
			
			bw.write(e);
			//System.exit(0);
		}
		
		bw.close();
		
	}

	private static CharArraySet createStopWordsList() throws IOException {

		String[] list = null;

		FileReader fr = new FileReader("stop_words_list.txt");

		BufferedReader br = new BufferedReader(fr);

		String s = "", temp = "";

		while ((temp = br.readLine()) != null) {

			s += temp + ",";
		}

		list = s.split(",");

		// return list;

		CharArraySet set = new CharArraySet(list.length, true);

		for (String str : list) {
			set.add(str);
		}

		return set;
	}
}

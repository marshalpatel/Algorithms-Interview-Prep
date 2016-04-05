package marshalp.keywordgen.com;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.json.simple.JSONArray;

public class jsonParser {
	
	
	
	
	public HashMap<String,String> readJson(String filename) throws FileNotFoundException, IOException, ParseException{
		
		HashMap<String,String> map = new HashMap<String, String>();
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader(filename));
		
		JSONArray reviewList = (JSONArray) obj;
		//JSONArray reviewList = (JSONArray)parser.
	//	System.out.println(reviewList.size());
       Iterator<JSONObject> itr = reviewList.iterator();
        //String review_text = getProcessedText(text);
        int c = 0;
       while(itr.hasNext()){
    	   
    	  JSONObject jobj = itr.next();
    	  
    	  String s = (String)jobj.get("text");
    	  
    	  s = getProcessedText(s);
    	  
    	 // System.out.println(s);
    	  
    	  map.put((String)jobj.get("review_id"), s);
    	  c++;
    	  
       }
        
        System.out.println(c);
        return map;
        
	}
	
	private String getProcessedText(String review) throws IOException{
		
		String result = "";
		
		StandardAnalyzer std = new StandardAnalyzer(KeywordGenMain.swset);

		// StandardAnalyzer std = new StandardAnalyzer();

		TokenStream tokenStream = std.tokenStream("content", new StringReader(
				review));

		CharTermAttribute charTermAttribute = tokenStream
				.addAttribute(CharTermAttribute.class);

		tokenStream.reset();

		//String term = "";

		int count = 0;

		while (tokenStream.incrementToken()) {
			// int startOffset = offsetAttribute.startOffset();
			// int endOffset = offsetAttribute.endOffset();
			result += charTermAttribute.toString() + " ";
			//count++;

			//System.out.println(result);
		}

		
		
		return result;
		
	}

}

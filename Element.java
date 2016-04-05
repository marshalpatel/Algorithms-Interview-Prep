package marshal.practice.com;

public class Element implements Comparable<Element> {
	
	public int value;
	public int row;
	public int column;
	
	public Element(int v,int r,int c){
		value = v;
		row = r;
		column = c;
	}
	
	@Override
	public int compareTo(Element e){
		
		if(this.value>e.value)
			return 1;
		else if(this.value < e.value)
			return -1;
		else
			return 0;
		
	}

}

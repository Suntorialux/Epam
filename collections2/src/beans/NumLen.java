package beans;

public class NumLen implements Comparable<NumLen>{
	
	private final int len; 
	private int num; 

	public NumLen(int len) { 
		this.len = len; 
		num = 1; 
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getLen() {
		return len;
	}
	
	public void incNum() { 
		num++;
	} 

	public int compareTo(NumLen numLen) { 
		return len - numLen.len;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return len + ";" + num;
	}
	
	
	

}

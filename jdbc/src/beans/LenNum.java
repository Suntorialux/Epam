package beans;

public class LenNum {
	
	private final int len; 
	private final int num; 

	public LenNum(int len, int num) { 
		this.len = len; 
		this.num = num; 
	}
	
	public int getLen() {
		return len;
	}

	public int getNum() {
		return num;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return len + ";" + num;
	}

}

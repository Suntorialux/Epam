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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + len;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof NumLen))
			return false;
		final NumLen other = (NumLen) obj;
		if (len != other.len)
			return false;
		other.num++;
		return true;
	}
	
	
	
	

}

package Comparators;

import java.util.Comparator;

import beans.NumLen;

public class Comparators {

	public static class ComparatorForNum implements Comparator<NumLen> {
	
		@Override
		public int compare(NumLen o1, NumLen o2) {
			// TODO Auto-generated method stub
			return o2.getNum()-o1.getNum();
		}

	}	

}

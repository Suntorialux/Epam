package by.gsu.epamlab;

import java.sql.Date;

public class ResultFactory {
	
	  private static enum ResultKind {
	        
	        HALF_RESULT {
	        	Result getResult(String login, String test, Date date, String stringMark) {
	        		int mark = (int)Double.parseDouble(stringMark)*2;
	        		return new HalfResult(login, test, date, mark); 	
	        	}
	        },
	        RESULT {
	        	Result getResult(String login, String test, Date date, String stringMark) {
	        		int mark = Integer.parseInt(stringMark)*2;
	        		return new HalfResult(login, test, date, mark); 	
	        	}
	        };
		  	
	    	abstract Result getResult(String login, String test, Date date, String stringMark); 
	        	
	        }
	  public static Result getResultFromFactory(String login, String test, Date date, String mark) {
		  String id;
		  if(mark.contains(".")) {
			  id = ResultKind.HALF_RESULT.name();
		  } else {
	   		  id = ResultKind.RESULT.name();
	      }
	      ResultKind kind = ResultKind.valueOf(id); 
	      return kind.getResult(login, test, date, mark);
	  }
	
}

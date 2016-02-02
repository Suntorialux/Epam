/**
 * 
 */
package by.gsu.epamlab.model.beans;

import java.text.ParseException;
import java.util.Date;

/**
 * @author Andrei Yahorau
 *
 */
public class Play {
	
	private String title;
	private String description;
	private Date date;
	
	/**
	 * 
	 */
	public Play() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param description
	 * @param date
	 */
	public Play(String title, String description, Date date) {
		this.title = title;
		this.description = description;
		this.date = date;
	}
	
	/**
	 * @param title
	 * @param description
	 * @param date
	 */
	public Play(String title, String description, String date) {
		this.title=title;
		this.description = description;
		setDate(date);
	}
	
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		try {
			this.date = Constants.INPUT_DATE_FORMAT.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	

}

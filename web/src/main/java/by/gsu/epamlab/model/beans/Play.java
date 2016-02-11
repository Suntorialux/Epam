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

	/** The id. */
	private int id;

	/** The title. */
	private String title;

	/** The description. */
	private String description;

	/** The date. */
	private Date date;

	/**
	 * Instantiates a new play.
	 */
	public Play() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new play.
	 * 
	 * @param id
	 *            the id
	 * @param title
	 *            the title
	 * @param description
	 *            the description
	 * @param date
	 *            the date
	 */
	public Play(int id, String title, String description, Date date) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
	}

	/**
	 * Instantiates a new play.
	 * 
	 * @param id
	 *            the id
	 * @param title
	 *            the title
	 * @param description
	 *            the description
	 * @param date
	 *            the date
	 */
	public Play(int id, String title, String description, String date) {
		this.title = title;
		this.description = description;
		setDate(date);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
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
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return Constants.OUTPUT_DATE_FORMAT.format(date);
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @param date
	 *            the date to set
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

/**
 * 
 */
package by.gsu.epamlab.model.beans;


import java.io.Serializable;
import java.sql.Date;

import by.gsu.epamlab.model.constants.Constants;

/**
 * @author Andrei Yahorau
 *
 */
public class Play implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6729160721354415365L;

	/** The id. */
	private final int id;

	/** The title. */
	private String title;

	/** The description. */
	private String description;

	/** The date. */
	private Date date;

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
	 * @param title
	 *            the title
	 * @param description
	 *            the description
	 * @param date
	 *            the date
	 */
	public Play(String title, String description, Date date) {
		this.id = 0;
		this.title = title;
		this.description = description;
		this.date = date;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
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
	public String getStringDate() {
		return Constants.OUTPUT_DATE_FORMAT.format(date);
	}
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Play other = (Play) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	
}

/**
 * 
 */
package by.gsu.epamlab.model.beans;

/**
 * @author Andrei Yahorau
 *
 */
public class Place {

	private String nameSector;
	private int numberRow;
	private int numberPlace;
	private int price;

	/**
	 * 
	 */
	public Place() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nameSector
	 *            is name Sector
	 * @param numberRow
	 *            is Number Row
	 * @param numberPlace
	 *            is Number Place
	 * @param price
	 *            is Price
	 */

	public Place(String nameSector, int numberRow, int numberPlace, int price) {
		this.nameSector = nameSector;
		this.numberRow = numberRow;
		this.numberPlace = numberPlace;
		this.price = price;
	}

	/**
	 * @return the nameSector
	 */
	public String getNameSector() {
		return nameSector;
	}

	/**
	 * @param nameSector
	 *            the nameSector to set
	 */
	public void setNameSector(String nameSector) {
		this.nameSector = nameSector;
	}

	/**
	 * @return the numberRow
	 */
	public int getNumberRow() {
		return numberRow;
	}

	/**
	 * @param numberRow
	 *            the numberRow to set
	 */
	public void setNumberRow(int numberRow) {
		this.numberRow = numberRow;
	}

	/**
	 * @return the numberPlace
	 */
	public int getNumberPlace() {
		return numberPlace;
	}

	/**
	 * @param numberPlace
	 *            the numberPlace to set
	 */
	public void setNumberPlace(int numberPlace) {
		this.numberPlace = numberPlace;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameSector == null) ? 0 : nameSector.hashCode());
		result = prime * result + numberPlace;
		result = prime * result + numberRow;
		result = prime * result + price;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Place other = (Place) obj;
		if (nameSector == null) {
			if (other.nameSector != null)
				return false;
		} else if (!nameSector.equals(other.nameSector))
			return false;
		if (numberPlace != other.numberPlace)
			return false;
		if (numberRow != other.numberRow)
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Place [nameSector=" + nameSector + ", numberRow=" + numberRow + ", numberPlace=" + numberPlace
				+ ", price=" + price + "]";
	}
	
	

}

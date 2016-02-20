/**
 * 
 */
package by.gsu.epamlab.model.beans;

/**
 * @author Andrei Yahorau
 *
 */
public class Booking {

	private int idPlay;
	private String nameSector;
	private int row;
	private int place;
	private int price;
	private String status;

	/**
	 * 
	 */
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param idPlay is idPlay
	 * @param nameSector is nameSector
	 * @param row is row
	 * @param place is place
	 * @param price is price
	 * @param status is status
	 */
	public Booking(int idPlay, String nameSector, int row, int place, int price, String status) {
		super();
		this.idPlay = idPlay;
		this.nameSector = nameSector;
		this.row = row;
		this.place = place;
		this.price = price;
		this.status = status;
	}
	
	/**
	 * @param nameSector
	 * @param row
	 * @param place
	 * @param price
	 * @param status
	 */
	public Booking(String nameSector, int row, int place, int price, String status) {
		super();
		this.nameSector = nameSector;
		this.row = row;
		this.place = place;
		this.price = price;
		this.status = status;
	}


	/**
	 * @return the idPlay
	 */
	public int getIdPlay() {
		return idPlay;
	}


	/**
	 * @param idPlay the idPlay to set
	 */
	public void setIdPlay(int idPlay) {
		this.idPlay = idPlay;
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
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row
	 *            the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the place
	 */
	public int getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	public void setPlace(int place) {
		this.place = place;
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

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameSector == null) ? 0 : nameSector.hashCode());
		result = prime * result + place;
		result = prime * result + price;
		result = prime * result + row;
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
		Booking other = (Booking) obj;
		if (nameSector == null) {
			if (other.nameSector != null)
				return false;
		} else if (!nameSector.equals(other.nameSector))
			return false;
		if (place != other.place)
			return false;
		if (price != other.price)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
}

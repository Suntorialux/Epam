/**
 * 
 */
package by.gsu.epamlab.model.beans;

/**
 * @author Andrei
 *
 */
public class Booking {

	private Place place;
	private int idPlay;
	private String status;
	
	/**
	 * 
	 */
	public Booking() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param place is place
	 * @param idPlay is id play
	 * @param status is status
	 */
	public Booking(Place place, int idPlay, String status) {
		super();
		this.place = place;
		this.idPlay = idPlay;
		this.status = status;
	}

	/**
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(Place place) {
		this.place = place;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
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
		result = prime * result + idPlay;
		result = prime * result + ((place == null) ? 0 : place.hashCode());
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
		if (idPlay != other.idPlay)
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		return true;
	}
	
		
}

package framework.model;

public class Address {
	private String street;
	private String city;
	private String zipcode;
	private String state;

	@Override
	public String toString() {
		return "Address{" +
				"street='" + street + '\'' +
				", city='" + city + '\'' +
				", zipcode='" + zipcode + '\'' +
				", state='" + state + '\'' +
				'}';
	}

	public Address(String street, String city, String state, String zipcode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		Address guest = (Address) obj;
		return (street == guest.street || (street != null && street.equals(guest.getStreet())))
				&& (city == guest.city || (city != null && city.equals(guest.getCity())))
				&& (zipcode == guest.zipcode || (zipcode != null && zipcode.equals(guest.getZipcode())))
				&& (zipcode == guest.zipcode || (state != null && state.equals(guest.getState())));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}
}

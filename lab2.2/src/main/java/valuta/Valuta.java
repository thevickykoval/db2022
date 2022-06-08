package valuta;

import java.io.Serializable;

public class Valuta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String valuta, country;
	double count;

	public Valuta(String valuta, double count, String country) {
		super();
		this.valuta = valuta;
		this.count = count;
		this.country = country;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "{\"valuta\":\""+valuta+"\", \"count\":"+ count+", \"country\":\"" + country + "\"}";
	}
}

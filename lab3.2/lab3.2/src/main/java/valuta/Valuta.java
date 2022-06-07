package valuta;

import java.io.Serializable;

public class Valuta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String valuta, country;
	private double count;
	private int id;

	public Valuta(int id, String valuta, double count, String country) {
		super();
		this.id = id;
		this.valuta = valuta;
		this.count = count;
		this.country = country;
	}

	public Valuta() {
		super();// TODO Auto-generated constructor stub
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "{\"id\": " + id + ", \"valuta\": \""+valuta+"\", \"count\": "+ count+", \"country\": \"" + country + "\"}";
	}
}

package crud;

import fileIO.FileIO;
import fileIO.FileIOInteface;
import valuta.Valuta;

public class FileCrud implements Lab2Crud {
	
	FileIOInteface fio;
	
	

	public FileCrud() {
		this.fio = new FileIO();
	}

	@Override
	public Valuta readValuta() {
		
		return (Valuta) fio.loadFromFile();
	}

	@Override
	public void updateValuta(Valuta valuta) {
		fio.saveToFile(valuta);

	}

}

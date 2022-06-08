package servlet;

import crud.FileCrud;
import crud.Lab2Crud;

public class ServletConfig implements ServletConfigInterface {

	Lab2Crud l2c;

	

	public ServletConfig() {
		this.l2c = new FileCrud();
	}



	public void setL2c(Lab2Crud l2c) {
		this.l2c = l2c;
	}



	@Override
	public Lab2Crud getCrud() {
		// TODO Auto-generated method stub
		return new FileCrud();
	}

}

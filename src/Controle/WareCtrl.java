package Controle;

import java.sql.SQLException;
import java.util.ArrayList;

import ModelLayer.*;
import DBLayer.*;

public class WareCtrl {

	private DBWare DBware;
	
	public WareCtrl(){
		DBware = new DBWare();
	}
	
	public ArrayList<Ware> findByList(List list) throws SQLException{
		return DBware.findByList(list);
	}
	
	public ArrayList<Ware> findBySerial(String serialnumber) throws SQLException{
		return DBware.findBySerial(serialnumber);
	}
	
	public ArrayList<Ware> findBySignature(String signature) throws SQLException{
		return DBware.findBySignature(signature);
	}
	
	public ArrayList<Ware> findByStatus(String status) throws SQLException{
		return DBware.findByStatus(status);
	}
	
	public void createWare(Ware ware) throws SQLException{
		DBware.insert(ware, null);
	}
	
	public void updateWare(Ware ware) throws SQLException{
		DBware.update(ware);
	}
	
	public void deleteWare(Ware ware) throws SQLException{
		DBware.delete(ware);
	}
}

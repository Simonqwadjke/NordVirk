package Controle;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import DBLayer.*;
import ModelLayer.*;

import org.junit.Before;
import org.junit.Test;

public class zTester {

	@Before
	public void setUp() throws Exception {
	}

//	@Test
	public void test() {
		Supplier sup = new Supplier();
		sup.addContact(new Contact(1,"sup", "ypu","bugger","overthere",sup));
		assertNotNull("not found", sup.search.byID(1));
		assertNull("found?", sup.search.byID(11));
	}

	@Test
	public void EnployeeTest(){
		ArrayList<Employee> emps = null;
		DBEmployee demp = new DBEmployee();
		Employee emp = new Employee(1, "knud", "90909090", "over there", "mymail@mymail.com", 4);
		try{
			demp.insert(emp);
		}
		catch(SQLException e){
			System.out.println("nope: " + e.getMessage());
			fail();
		}
		try {
			emps = demp.findByName("knud");
			System.out.println("number of knuds: " + emps.size());
		}
		catch (SQLException e) {
			fail(e.getMessage());
		}
		try{
			emp = emps.get(emps.size() - 1);
			emp.setAdress("neeej");
			demp.update(emp);
		}
		catch (SQLException e){
			fail(e.getMessage());
		}
		try{
			emps = demp.findByName("knud");
			System.out.println("Updated: " + emps.get(emps.size()-1).getAddress());
		}
		catch(SQLException e){
			fail(e.getMessage());
		}
		try{
			demp.delete(emp);
		}
		catch(SQLException e){
			fail(e.getMessage());
		}
	}

	@Test
	public void ContactTest(){
		ArrayList<Contact> emps = null;
		DBContact eemp = new DBContact();
		Contact emp = new Contact(1, "knud", "90909090", "over there", "mymail@mymail.com", new Supplier(1, 0, null, null, null));
		try{
			eemp.insert(emp);
		}
		catch(SQLException e){
			System.out.println("nope: " + e.getMessage());
			fail();
		}
		try {
			emps = eemp.findByName("knud");
			System.out.println("number of knuds: " + emps.size());
		}
		catch (SQLException e) {
			fail(e.getMessage());
		}
		try{
			emp = emps.get(emps.size() - 1);
			emp.setAdress("neeej");
			eemp.update(emp);
		}
		catch (SQLException e){
			fail(e.getMessage());
		}
		try{
			emps = eemp.findByName("knud");
			System.out.println("Updated: " + emps.get(emps.size()-1).getAddress());
		}
		catch(SQLException e){
			fail(e.getMessage());
		}
		try{
			eemp.delete(emp);
		}
		catch(SQLException e){
			fail(e.getMessage());
		}
	}

	@Test
	public void WareTest(){
		ArrayList<Ware> emps = null;
		DBWare wemp = new DBWare();
		Ware emp = new Ware(1, "knud", "constructing", "MEEE", "QB");
		try{
			wemp.insert(emp,new List(1, null, null, null, null, null));
		}
		catch(SQLException e){
			System.out.println("nope: " + e.getMessage());
			fail();
		}
		try {
			emps = wemp.findBySerial("QB");
			System.out.println("number of knuds: " + emps.size());
		}
		catch (SQLException e) {
			fail(e.getMessage());
		}
		try{
			emp = emps.get(emps.size() - 1);
			emp.setStatus("neeej");
			wemp.update(emp);
		}
		catch (SQLException e){
			fail(e.getMessage());
		}
		try{
			emps = wemp.findBySerial("QB");
			System.out.println("Updated: " + emps.get(emps.size()-1).getSignature());
		}
		catch(SQLException e){
			fail(e.getMessage());
		}
		try{
			wemp.delete(emp);
		}
		catch(SQLException e){
			fail(e.getMessage());
		}
	}
	
//	@Test
	public void ListTest(){
		ArrayList<List> emps = null;
		DBList db = new DBList();
		ArrayList<Ware> wares = getWares();
		List emp = new List(1, "now", wares, new Employee(1, null, null, null, null, 0), new Supplier(1, 0, null, null, null), "got it");
		try{
			db.insert(emp);
		}
		catch(SQLException e){
			System.out.println("nope: " + e.getMessage());
			fail();
		}
		try {
			emps = db.findByName("now");
			System.out.println("number of knuds: " + emps.size());
		}
		catch (SQLException e) {
			fail(e.getMessage());
		}
		try{
			emp = emps.get(emps.size() - 1);
			emp.setAcquasitionType("neeej");
			db.update(emp);
		}
		catch (SQLException e){
			fail(e.getMessage());
		}
		try{
			emps = db.findByName("now");
			System.out.println("Updated: " + emps.get(emps.size()-1).getAcquasitionType());
		}
		catch(SQLException e){
			fail(e.getMessage());
		}
		try{
			db.delete(emp);
		}
		catch(SQLException e){
			fail(e.getMessage());
		}
	}
	
	private ArrayList<Ware> getWares(){
		ArrayList<Ware> wares = new ArrayList<Ware>();
		Ware ware1 = new Ware(1, "1", "working.", "you", "ANR");
		Ware ware2 = new Ware(2, "2", "doing", "me", "Serial");
		Ware ware3 = new Ware(3, "3", "working..", "right", "Nine");
		Ware ware4 = new Ware(4, "4", "working...", "there", "Tails");
		wares.add(ware1);
		wares.add(ware2);
		wares.add(ware3);
		wares.add(ware4);
		return wares;
	}
}

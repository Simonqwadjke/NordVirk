package Controle;
import ModelLayer.Person;

public interface PersonCtrl {
	public void insert(Person person);
	public void findByName(String name);
	public void findByPhoneNumber(String phoneNr);
	public void findByEmail(String email);
	public void create(Person person);
	public void delete(Person person);
}

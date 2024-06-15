package personDao;

import java.util.List;

import com.person.Person;


public interface PersonDao {
	int save(Person person);
	List<Person> getAll();
	Person getById(int id);
	int remove(int id);
}

package persondaoimpl;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

import com.person.Person;

import personDao.PersonDao;
import utility.SqlUtil;

public class PersonDaoImpl implements PersonDao{

	@Override
	public int save(Person person) {
		int result = -1;
		try {
			SqlUtil.connectDB();
			String qryString = "insert into person values('"+person.getId()+"','"+person.getName()+"','"+person.getDobDate()+"')";
			result = SqlUtil.insert(qryString);
			SqlUtil.close();
		} catch (Exception e) {
			
		}
		
		return result;
	}

	@Override
	public List<Person> getAll() {
		List<Person> persons = null;
		try {
			SqlUtil.connectDB();
			String qryString = "select * from person";
			ResultSet resultSet = SqlUtil.fetch(qryString);
			
			while( resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Date dob = resultSet.getDate("dob");
				
				Person p = new Person(id, name, dob);
				persons.add(p);
			}
			
			SqlUtil.close();
		} catch (Exception e) {
			
		}
		
		return persons;
	}

	@Override
	public Person getById(int id) {

		Person person = null;
		try {
			SqlUtil.connectDB();
			
			String qryString = "SELECT * FROM person WHERE id="+id;
			ResultSet resultSet = SqlUtil.fetch(qryString);
			if(resultSet!=null) {
				if(resultSet.next()) {
					person = new Person();
					person.setId(resultSet.getInt("id"));
					person.setName(resultSet.getString("name"));
					person.setDobDate(resultSet.getDate("dob"));
				}					
			}
			
			SqlUtil.close();
		} catch (Exception e) {
			
		}
		
		return person;
	}

	@Override
	public int remove(int id) {
		int result =-1;
		try {
			SqlUtil.connectDB();
			
			String qryString = "DELETE FROM person WHERE id = "+id;
			result = SqlUtil.delete(qryString);
			
			SqlUtil.close();
		} catch (Exception e) {
			
		}
		
		return result;
	}

}

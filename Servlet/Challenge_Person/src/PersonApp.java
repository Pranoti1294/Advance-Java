import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.person.Person;
import persondaoimpl.PersonDaoImpl;

public class PersonApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int ch = 0;
        Person person;
        PersonDaoImpl personDaoImpl = new PersonDaoImpl();
        int id;
        Date dob;
        String name;
        int result;

        do {
            System.out.println("1.Insert  2.Update  3.Delete  4.Fetch All  5.Fetch by id   6.Exit");
            System.out.println("Enter choice: ");
            ch = scanner.nextInt();

            switch (ch) {
                case 1:
                    id = getInputInt("Enter id: ");
                    name = getInputString("Enter name: ");
                    dob = getInputDate("Enter date of birth (yyyy-mm-dd): ");

                    person = new Person(id, name, dob);

                    result = personDaoImpl.save(person);
                    if (result > 0) {
                        System.out.println(result + " record inserted successfully :)\n");
                    } else {
                        System.out.println("Something went wrong\n");
                    }

                    break;
                case 2:
//                    id = getInputInt("Enter id: ");
//                    name = getInputString("Enter name: ");
//                    dob = getInputDate("Enter date of birth (yyyy-mm-dd): ");
//
//                    person = new Person(id, name, dob);
//
//                    result = personDaoImpl.update(id, person);
//                    if (result > 0) {
//                        System.out.println(result + " record updated successfully :)\n");
//                    } else {
//                        System.out.println("Something went wrong\n");
//                    }
                    break;

                case 3:
                    id = getInputInt("Enter id: ");

                    result = personDaoImpl.remove(id);

                    if (result > 0) {
                        System.out.println(result + " record deleted successfully :)\n");
                    } else {
                        System.out.println("Something went wrong\n");
                    }
                    break;

                case 4:
                    List<Person> personList = personDaoImpl.getAll();
                    Iterator<Person> personIterator = personList.iterator();
                    System.out.println("id\tname\t\t\tdob");
                    System.out.println("------------------------------------------------------");
                    while (personIterator.hasNext()) {
                        Person persons = personIterator.next();
                        System.out.println(persons);
                    }
                    System.out.println();
                    break;

                case 5:
                    id = getInputInt("Enter id: ");
                    System.out.println("id\tname\t\t\tdob");
                    System.out.println("-------------------------------------------------------");
                    Person persons = personDaoImpl.getById(id);
                    System.out.println(persons);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (ch != 6);

        scanner.close();
    }

    private static int getInputInt(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

    private static String getInputString(String prompt) {
        System.out.println(prompt);
        scanner.nextLine(); 
        return scanner.nextLine();
    }

    private static Date getInputDate(String prompt) {
        System.out.println(prompt);
        String dateStr = scanner.next();
        return Date.valueOf(dateStr); 
    }
}

//Nathan Nelson
import java.util.LinkedList;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class PersonList {
    private LinkedList<Person> list;

    // Constructor
    public PersonList() {
        list = new LinkedList<>();
    }

    // Method to store Person objects from an input stream into the linked list
    public void store(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(",");
            if (data.length == 3) {
                String firstName = data[0].trim();
                String lastName = data[1].trim();
                String id = data[2].trim();
                list.add(new Person(firstName, lastName, id));
            }
        }
        scanner.close();
    }

    // Method to display Person objects from the linked list to an output stream
    public void display(OutputStream outputStream) {
        PrintWriter writer = new PrintWriter(outputStream);
        for (Person person : list) {
            writer.println(person.toString());
        }
        writer.flush();
    }

    // Method to find a Person by id in the linked list
    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }
}

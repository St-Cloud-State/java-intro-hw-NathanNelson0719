//Nathan Nelson
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain {

    // Method to store Person objects from an input stream into a linked list
    public static void store(InputStream inputStream, LinkedList<Person> list) {
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

    // Method to display Person objects from a linked list to an output stream
    public static void display(OutputStream outputStream, LinkedList<Person> list) {
        PrintWriter writer = new PrintWriter(outputStream);
        for (Person person : list) {
            writer.println(person.toString());
        }
        writer.flush();
    }

    // Method to find a Person by id in the linked list
    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }

    // Main method
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<Person> list = new LinkedList<>();

        // Read data from a file and store in linked list
        FileInputStream fis = new FileInputStream("persons.txt");
        store(fis, list);

        // Display the content of the linked list
        display(System.out, list);

        // Find and display the index of a person with a specific id
        String searchId = "101";
        int index = find(searchId, list);
        if (index != -1) {
            System.out.println("Person with ID " + searchId + " found at index " + index);
        } else {
            System.out.println("Person with ID " + searchId + " not found.");
        }

        // Invoke the find method a few more times with different IDs
        searchId = "102";
        index = find(searchId, list);
        System.out.println((index != -1) ? "Person with ID " + searchId + " found at index " + index
                : "Person with ID " + searchId + " not found.");
        searchId = "103";
        index = find(searchId, list);
        System.out.println((index != -1) ? "Person with ID " + searchId + " found at index " + index
                : "Person with ID " + searchId + " not found.");
    }
}

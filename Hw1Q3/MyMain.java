import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MyMain {
    public static void main(String[] args) throws FileNotFoundException {
        PersonList personList = new PersonList();

        // Read data from a file and store in the PersonList
        FileInputStream fis = new FileInputStream("persons.txt");
        personList.store(fis);

        // Display the content of the PersonList
        personList.display(System.out);

        // Find and display the index of a person with a specific id
        String searchId = "101";
        int index = personList.find(searchId);
        if (index != -1) {
            System.out.println("Person with ID " + searchId + " found at index " + index);
        } else {
            System.out.println("Person with ID " + searchId + " not found.");
        }

        // Invoke the find method a few more times with different IDs
        searchId = "102";
        index = personList.find(searchId);
        System.out.println((index != -1) ? "Person with ID " + searchId + " found at index " + index
                : "Person with ID " + searchId + " not found.");

        searchId = "103";
        index = personList.find(searchId);
        System.out.println((index != -1) ? "Person with ID " + searchId + " found at index " + index
                : "Person with ID " + searchId + " not found.");
    }
}

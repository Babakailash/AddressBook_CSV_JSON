
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AddressBookFileIO {

    static  String FILE_NAME = "C:\\Users\\BABA\\AddressBook_CSV_JSON\\src\\main\\resources\\AddressBook_Data.txt";
    //DATA TEXT
    public void writeDataToFile(List<PersonDetails> personDetails) {
        StringBuffer buffer = new StringBuffer();
        personDetails.forEach(details -> {
            String personDetailsString = details.toString().concat("\n");
            buffer.append(personDetailsString);
        });
        try {
            Files.write(Paths.get(FILE_NAME), buffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try {
            Files.lines(new File(FILE_NAME).toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long listCount() {
        long count = 0;
        try {
            count = Files.lines(new File(FILE_NAME).toPath())
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Count is  :" + count);
        return count;
    }
}
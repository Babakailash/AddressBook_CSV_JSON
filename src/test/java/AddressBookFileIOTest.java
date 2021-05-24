import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;


public class AddressBookFileIOTest {
    @Test
    public void given3AddressBookText_DataWhenWrittenToFileShuldMatchCount() {
        PersonDetails[] arrayOfData = {
                new PersonDetails("Kailash", "Ayodhya", "Ayodhya", "UP", "42001", "9794445197", "baba@111"),
                new PersonDetails("Moun10", "Meme", "New Ashok", "New Delhi", "42585", "993658568", "rip@567"),
                new PersonDetails("King", "World", "Nagar", "New Delhi", "110096", "9205267464", "gip@789")
        };
        AddressBookFileIO addressBookFileIO = new AddressBookFileIO();
        addressBookFileIO.writeDataToFile(Arrays.asList(arrayOfData));
        addressBookFileIO.readData();
        long count = addressBookFileIO.listCount();
        Assertions.assertEquals(3, count);
    }
}
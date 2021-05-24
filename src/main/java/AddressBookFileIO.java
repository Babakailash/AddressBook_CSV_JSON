
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AddressBookFileIO {

    static  String FILE_NAME = "C:\\Users\\BABA\\AddressBook_CSV_JSON\\src\\main\\resources\\AddressBook_Data.txt";
    public static String CSV_FILE_NAME = "C:\\Users\\BABA\\AddressBook_CSV_JSON\\src\\main\\resources\\AddressBook_CSV.csv";
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
    //CSV
    public void writeDataToCSVfile(List<PersonDetails> personDetails) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(CSV_FILE_NAME));
        ) {
            StatefulBeanToCsv<PersonDetails> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            beanToCsv.write(personDetails);
        } catch ( IOException e){
            e.printStackTrace();
        }
    }

    public void readCsvData() {
        try {
            Files.lines(new File(CSV_FILE_NAME).toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long CsvlistCount() {
        long count = 0;
        try {
            count = Files.lines(new File(CSV_FILE_NAME).toPath())
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Count is:" +count);
        return count;
    }
}
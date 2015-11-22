package ua.epam.task_2.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Concrete implementation for DataSource interface.
 * This data source uses text file to read
 *
 * It reads file: /texts/1.txt
 *
 * @author Dennis
 *
 * on 11/17/2015.
 */
public class DataSourceFile implements DataSource {
    @Override
    public String getText() {

        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader("texts/1.txt"))) {
            String temp;

            while ((temp = reader.readLine()) != null) {
                result.append(temp);
                if (!temp.isEmpty()) {
                    result.append(" ");
                }
            }

        } catch (FileNotFoundException f) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Something goes wrong");
        }

        return result.toString();
    }
}

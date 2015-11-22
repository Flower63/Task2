package ua.epam.task_2.app;

/**
 * Created by Dennis
 *
 * on 11/21/2015.
 */
public class View {
    private static View instance;

    public void print(String message) {
        System.out.println(message);
    }

    public static View getInstance() {
        if (instance == null) {
            instance = new View();
        }

        return instance;
    }
}

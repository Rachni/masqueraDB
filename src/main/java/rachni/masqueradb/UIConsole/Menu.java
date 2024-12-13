package rachni.masqueradb.UIConsole;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements Operation {
    private ArrayList<String> tags;
    private ArrayList<Operation> operations;

    public Menu() {
        this.tags = new ArrayList<>();
        this.operations = new ArrayList<>();
    }

    public void addOption(String tag, Operation operation) {
        this.tags.add(tag);
        this.operations.add(operation);
    }

    public void execute() {
        int option;
        do {
            System.out.println("################################");
            int count = 1;
            for (String tag : this.tags) {
                System.out.println(count++ + ") " + tag);
            }
            System.out.println("0) exit this menu");
            String userOption = new Scanner(System.in).nextLine();
            try {
                option = Integer.parseInt(userOption);
                if (option == 0) return;
                if (option > this.operations.size()) {
                    System.out.println("Choose a valid option.");
                } else {
                    this.operations.get(option - 1).execute();
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect option");
            } catch (Exception e) {
                System.out.println("error " + e.getMessage());
            }
        } while (true);
    }
}

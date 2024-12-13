package rachni.masqueradb.UIConsole.Chronicles;

import rachni.masqueradb.backend.chronicles.delete.ChronicleDeleteService;
import rachni.masqueradb.UIConsole.Operation;

import java.util.Scanner;

public class UIChronicleDelete implements Operation {
    private ChronicleDeleteService service;

    public UIChronicleDelete(ChronicleDeleteService service) {
        this.service = service;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Insert the ID of the chronicle you wish to delete: ");
        if (this.service.chronicleDelete(new Scanner(System.in).nextInt())) {
            System.out.println("Chronicle deleted.");
        }
    }
}
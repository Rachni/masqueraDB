package rachni.masqueradb.UIConsole.Chronicles;

import rachni.masqueradb.UIConsole.Operation;
import rachni.masqueradb.backend.chronicles.ChronicleEntity;
import rachni.masqueradb.backend.chronicles.update.ChronicleUpdateService;

import java.util.Scanner;

public class UIChronicleUpdate implements Operation {
    private ChronicleUpdateService service;

    public UIChronicleUpdate(ChronicleUpdateService service) {
        this.service = service;
    }

    @Override
    public void execute() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert ID of the chronicle you wish to modify: ");
        int id = scanner.nextInt();
        System.out.println("Insert chronicle name: ");
        String name = scanner.nextLine();
        if (this.service.chronicleUpdate(new ChronicleEntity(0, name))) {
            System.out.println("Chronicle updated successfully.");
        }
    }
}

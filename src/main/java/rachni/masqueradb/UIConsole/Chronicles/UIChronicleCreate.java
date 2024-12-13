package rachni.masqueradb.UIConsole.Chronicles;

import rachni.masqueradb.UIConsole.Operation;
import rachni.masqueradb.backend.chronicles.ChronicleEntity;
import rachni.masqueradb.backend.chronicles.create.ChronicleCreateService;

import java.util.Scanner;

public class UIChronicleCreate implements Operation {
    private ChronicleCreateService service;

    public UIChronicleCreate(ChronicleCreateService service) {
        this.service = service;
    }

    @Override
    public void execute() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert chronicle name: ");
        String name = scanner.nextLine();
        int id = this.service.chronicleCreate(new ChronicleEntity(0, name));
    }
}
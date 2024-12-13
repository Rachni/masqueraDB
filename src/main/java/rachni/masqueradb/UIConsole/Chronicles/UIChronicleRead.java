package rachni.masqueradb.UIConsole.Chronicles;

import rachni.masqueradb.UIConsole.Operation;
import rachni.masqueradb.backend.chronicles.read.ChronicleReadService;

import java.util.Scanner;

public class UIChronicleRead implements Operation {
    private ChronicleReadService service;

    public UIChronicleRead(ChronicleReadService service) {
        this.service = service;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Insert ID of the chronicle you wish to search: ");
        System.out.println(this.service.findChronicleByID(new Scanner(System.in).nextInt()));
    }
}

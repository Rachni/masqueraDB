package rachni.masqueradb.UIConsole.Characters;

import rachni.masqueradb.backend.characters.read.CharacterReadService;
import rachni.masqueradb.UIConsole.Operation;
import java.util.Scanner;

public class UICharacterRead implements Operation {
    private CharacterReadService service;

    public UICharacterRead(CharacterReadService service) {
        this.service = service;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Insert the ID of the character you wish to find: ");
        System.out.println(this.service.findCharacter(new Scanner(System.in).nextInt()));
    }
}

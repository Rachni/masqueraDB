package rachni.masqueradb.UIConsole.Characters;

import rachni.masqueradb.UIConsole.Operation;
import rachni.masqueradb.backend.characters.delete.CharacterDeleteService;

import java.util.Scanner;

public class UICharacterDelete implements Operation {
    private CharacterDeleteService service;

    public UICharacterDelete(CharacterDeleteService service) {
        this.service = service;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Insert the ID of the character you wish to delete: ");
        if (this.service.deleteCharacter(new Scanner(System.in).nextInt())){
            System.out.println("Character deleted.");
        }
    }
}
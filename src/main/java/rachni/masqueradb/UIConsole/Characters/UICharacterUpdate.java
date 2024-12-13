package rachni.masqueradb.UIConsole.Characters;


import rachni.masqueradb.backend.characters.CharacterEntity;
import rachni.masqueradb.backend.characters.update.CharacterUpdateService;
import rachni.masqueradb.backend.chronicles.read.ChronicleReadService;
import rachni.masqueradb.UIConsole.Operation;

import java.util.Scanner;

public class UICharacterUpdate implements Operation {
    private CharacterUpdateService service;
    private ChronicleReadService chronicleService;

    public UICharacterUpdate(CharacterUpdateService service) {
        this.service = service;
    }

    @Override
    public void execute() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the ID for the character you wish to modify: ");
        int characterid = scanner.nextInt();
        ///esto ke
        String name;
        do {
            System.out.println("Insert character's name: ");
            name = scanner.next();
            if (name.isBlank() || name.length() < 2) {
                System.out.println("Name must be at least two characters long.");
                continue;
            }
            break;
        } while (true);

        System.out.println("Insert character's description: ");
        String description = scanner.next();

        System.out.println("Insert character's sire: ");
        String sire = scanner.next();

        System.out.println("Insert character's predator: ");
        String predator = scanner.next();

        String clan;
        do {
            System.out.println("Insert character's clan:");
            clan = scanner.next();
            if (clan.isBlank() || clan.length() < 2) {
                System.out.println("Insert a valid clan.");
                continue;
            }
            break;
        } while (true);

        System.out.println("Insert character's concept: ");
        String concept = scanner.next();

        System.out.println("Insert character's ambition: ");
        String ambition = scanner.next();

        System.out.println("Insert character's desire: ");
        String desire = scanner.next();

        System.out.println("Insert character's generation: ");
        String generation = scanner.next();

        System.out.println("Insert character's chronicle name: ");
        String chronicleName = scanner.next();

        int chronicle_id = chronicleService.findChronicleByName(chronicleName);
        if (this.service.characterUpdate(new CharacterEntity(name, description, sire, predator, clan, concept, ambition, desire, generation, chronicle_id))) {
            System.out.println("Character successfully updated.");
        }
    }
}
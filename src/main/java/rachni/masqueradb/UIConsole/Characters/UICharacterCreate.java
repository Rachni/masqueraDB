package rachni.masqueradb.UIConsole.Characters;

import rachni.masqueradb.backend.characters.CharacterEntity;
import rachni.masqueradb.backend.characters.create.CharacterCreateService;
import rachni.masqueradb.UIConsole.Operation;
import rachni.masqueradb.backend.chronicles.read.ChronicleReadService;

import java.util.Scanner;

public class UICharacterCreate implements Operation {
    private CharacterCreateService service;
    private ChronicleReadService chronicleService;

    public UICharacterCreate(CharacterCreateService service, ChronicleReadService chronicleService) {
        this.service = service;
        this.chronicleService = chronicleService;
    }

    @Override
    public void execute() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String name;
        do {
            System.out.println("Insert character's name: ");
            name = scanner.nextLine();
            if (name.isBlank() || name.length() < 2) {
                System.out.println("Name must be at least two characters long.");
                continue;
            }
            break;
        } while (true);

        System.out.println("Insert character's description: ");
        String description = scanner.nextLine();

        System.out.println("Insert character's sire: ");
        String sire = scanner.nextLine();

        System.out.println("Insert character's predator: ");
        String predator = scanner.nextLine();

        String clan;
        do {
            System.out.println("Insert character's clan:");
            clan = scanner.nextLine();
            if (clan.isBlank() || clan.length() < 2) {
                System.out.println("Insert a valid clan.");
                continue;
            }
            break;
        } while (true);

        System.out.println("Insert character's concept: ");
        String concept = scanner.nextLine();

        System.out.println("Insert character's ambition: ");
        String ambition = scanner.nextLine();

        System.out.println("Insert character's desire: ");
        String desire = scanner.nextLine();

        System.out.println("Insert character's generation: ");
        String generation = scanner.nextLine();

        System.out.println("Insert character's chronicle name: ");
        String chronicle_name = scanner.nextLine();
        int chronicle_id = chronicleService.findChronicleByName(chronicle_name);
        int id = this.service.createCharacter(new CharacterEntity(name, description, sire, predator, clan, concept, ambition, desire, generation, chronicle_id));
        System.out.println("Character created. ID = " + id);
    }
}
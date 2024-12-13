package rachni.masqueradb.UIConsole;

import java.sql.Connection;

import rachni.masqueradb.UIConsole.Characters.UICharacterCreate;
import rachni.masqueradb.UIConsole.Characters.UICharacterDelete;
import rachni.masqueradb.UIConsole.Characters.UICharacterRead;
import rachni.masqueradb.UIConsole.Characters.UICharacterUpdate;
import rachni.masqueradb.UIConsole.Chronicles.UIChronicleCreate;
import rachni.masqueradb.UIConsole.Chronicles.UIChronicleDelete;
import rachni.masqueradb.UIConsole.Chronicles.UIChronicleRead;
import rachni.masqueradb.UIConsole.Chronicles.UIChronicleUpdate;
import rachni.masqueradb.UIConsole.Users.UIUserDelete;
import rachni.masqueradb.UIConsole.Users.UIUserRead;
import rachni.masqueradb.UIConsole.Users.UIUserSignUp;
import rachni.masqueradb.UIConsole.Users.UIUserUpdate;
import rachni.masqueradb.backend.characters.create.CharacterCreateRepository;
import rachni.masqueradb.backend.characters.create.CharacterCreateService;
import rachni.masqueradb.backend.characters.delete.CharacterDeleteRepository;
import rachni.masqueradb.backend.characters.delete.CharacterDeleteService;
import rachni.masqueradb.backend.characters.read.CharacterReadRepository;
import rachni.masqueradb.backend.characters.read.CharacterReadService;
import rachni.masqueradb.backend.characters.update.CharacterUpdateRepository;
import rachni.masqueradb.backend.characters.update.CharacterUpdateService;
import rachni.masqueradb.backend.chronicles.create.ChronicleCreateRepository;
import rachni.masqueradb.backend.chronicles.create.ChronicleCreateService;
import rachni.masqueradb.backend.chronicles.delete.ChronicleDeleteRepository;
import rachni.masqueradb.backend.chronicles.delete.ChronicleDeleteService;
import rachni.masqueradb.backend.chronicles.read.ChronicleReadRepository;
import rachni.masqueradb.backend.chronicles.read.ChronicleReadService;
import rachni.masqueradb.backend.chronicles.update.ChronicleUpdateRepository;
import rachni.masqueradb.backend.chronicles.update.ChronicleUpdateService;
import rachni.masqueradb.backend.users.delete.UserDeleteRepository;
import rachni.masqueradb.backend.users.delete.UserDeleteService;
import rachni.masqueradb.backend.users.read.UserReadRepository;
import rachni.masqueradb.backend.users.read.UserReadService;
import rachni.masqueradb.backend.users.signup.UserSignupRepository;
import rachni.masqueradb.backend.users.signup.UserSignupService;
import rachni.masqueradb.backend.users.update.UserUpdateRepository;
import rachni.masqueradb.backend.users.update.UserUpdateService;

public class MenuBuilder {
    public Menu build(Connection connection) {

        Menu userSubmenu = new Menu();
        userSubmenu.addOption("Create User", new UIUserSignUp(new UserSignupService(new UserSignupRepository(connection))));
        userSubmenu.addOption("Search User", new UIUserRead(new UserReadService(new UserReadRepository(connection))));
        userSubmenu.addOption("Delete User", new UIUserDelete(new UserDeleteService(new UserDeleteRepository(connection))));
        userSubmenu.addOption("Update User", new UIUserUpdate(new UserUpdateService(new UserUpdateRepository(connection))));

        Menu chronicleSubmenu = new Menu();
        chronicleSubmenu.addOption("Create Chronicle", new UIChronicleCreate(new ChronicleCreateService(new ChronicleCreateRepository(connection))));
        chronicleSubmenu.addOption("Search Chronicle", new UIChronicleRead(new ChronicleReadService(new ChronicleReadRepository(connection))));
        chronicleSubmenu.addOption("Delete Chronicle", new UIChronicleDelete(new ChronicleDeleteService(new ChronicleDeleteRepository(connection))));
        chronicleSubmenu.addOption("Update Chronicle", new UIChronicleUpdate(new ChronicleUpdateService(new ChronicleUpdateRepository(connection))));

        Menu characterSubmenu = new Menu();
        characterSubmenu.addOption("Create Character", new UICharacterCreate(new CharacterCreateService(new CharacterCreateRepository(connection)), new ChronicleReadService(new ChronicleReadRepository(connection))));
        characterSubmenu.addOption("Search Character", new UICharacterRead(new CharacterReadService(new CharacterReadRepository(connection))));
        characterSubmenu.addOption("Delete Character", new UICharacterDelete(new CharacterDeleteService(new CharacterDeleteRepository(connection))));
        characterSubmenu.addOption("Update Character", new UICharacterUpdate(new CharacterUpdateService(new CharacterUpdateRepository(connection))));

        Menu mainMenu = new Menu();
        mainMenu.addOption("Users", userSubmenu);
        mainMenu.addOption("Chronicles", chronicleSubmenu);
        mainMenu.addOption("Characters", characterSubmenu);

        return mainMenu;
    }
}

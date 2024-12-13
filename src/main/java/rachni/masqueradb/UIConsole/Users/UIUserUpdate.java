package rachni.masqueradb.UIConsole.Users;

import rachni.masqueradb.UIConsole.Operation;
import rachni.masqueradb.backend.users.UserEntity;
import rachni.masqueradb.backend.users.update.UserUpdateService;

import java.util.Scanner;

public class UIUserUpdate implements Operation {
    private UserUpdateService service;

    public UIUserUpdate(UserUpdateService service) {
        this.service = service;
    }

    @Override
    public void execute() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert ID of the user you wish to modify: ");
        int user_id = scanner.nextInt();
        System.out.println("Insert username: ");
        String username = scanner.next();
        System.out.println("Insert password: ");
        String password = scanner.next();
        System.out.println("Insert email: ");
        String email = scanner.next();

        if (this.service.userUpdate(new UserEntity(username, password, email))) {
            System.out.println("User updated successfully");
        }

    }
}

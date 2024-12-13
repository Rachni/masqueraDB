package rachni.masqueradb.UIConsole.Users;

import rachni.masqueradb.UIConsole.Operation;
import rachni.masqueradb.backend.users.UserEntity;
import rachni.masqueradb.backend.users.signup.UserSignupService;

import java.util.Scanner;

public class UIUserSignUp implements Operation {
    private UserSignupService service;

    public UIUserSignUp(UserSignupService service) {
        this.service = service;
    }

    @Override
    public void execute() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert username: ");
        String username = scanner.next();
        System.out.println("Insert password: ");
        String password = scanner.next();

        System.out.println("Insert email: ");
        String email = scanner.next();
        int id = this.service.userSignUp(new UserEntity(username, password, email));
        System.out.println("User created with ID " + id);
    }
}

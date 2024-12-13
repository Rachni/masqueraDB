package rachni.masqueradb.UIConsole.Users;

import rachni.masqueradb.UIConsole.Operation;
import rachni.masqueradb.backend.users.delete.UserDeleteService;

import java.util.Scanner;

public class UIUserDelete implements Operation {
    private UserDeleteService service;

    public UIUserDelete(UserDeleteService service) {
        this.service = service;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Insert id of the user you want to delete: ");
        if (this.service.userDelete(new Scanner(System.in).nextInt())) {
            System.out.println("User deleted.");
        }
    }
}

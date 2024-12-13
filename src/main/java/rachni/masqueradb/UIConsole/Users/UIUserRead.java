package rachni.masqueradb.UIConsole.Users;

import rachni.masqueradb.backend.users.read.UserReadService;
import rachni.masqueradb.UIConsole.Operation;

import java.util.Scanner;

public class UIUserRead implements Operation {
   private UserReadService service;

    public UIUserRead(UserReadService service) {
        this.service = service;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Insert the User ID you wish to search: ");
        System.out.println(this.service.findUser(new Scanner(System.in).nextInt()));
    }
}

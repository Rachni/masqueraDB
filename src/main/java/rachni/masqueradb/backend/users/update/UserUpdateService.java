package rachni.masqueradb.backend.users.update;
import rachni.masqueradb.backend.users.UserEntity;

import java.util.regex.Pattern;

public class UserUpdateService implements IUserUpdateService {
    UserUpdateRepository userUpdateRepository;

    public UserUpdateService(UserUpdateRepository userUpdateRepository) {
        this.userUpdateRepository = userUpdateRepository;
    }

    @Override
    public boolean userUpdate(UserEntity userEntity) throws Exception {
        if (userEntity == null
                || userEntity.getUsername() == null
                || userEntity.getUsername().isBlank()
                || userEntity.getPassword() == null
                || userEntity.getPassword().isBlank()) {
            throw new Exception("You must insert a username and a password.");
        }
        if (!isEmailValid(userEntity.getEmail())) {
            throw new Exception("Invalid email format.");
        }
        if (userEntity.getPassword().length() < 8) {
            throw new Exception("Password must be at least 8 characters long.");
        }
        if (userUpdateRepository.userExists(userEntity.getUsername())) {
            throw new Exception("Username is already taken.");
        }
        if (userUpdateRepository.emailExists(userEntity.getEmail())) {
            throw new Exception("This email already has an account.");
        }

        //todo: BCrypt/similar

        return userUpdateRepository.userUpdate(userEntity);
    }
    private static boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
package rachni.masqueradb.backend.users.signup;

import rachni.masqueradb.backend.users.UserEntity;

import java.util.regex.Pattern;

public class UserSignupService implements IUserSignupService {

    UserSignupRepository userSignupRepository;

    public UserSignupService(UserSignupRepository userSignupRepository) {
        this.userSignupRepository = userSignupRepository;
    }

    @Override
    public int userSignUp(UserEntity userEntity) throws Exception {
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
        if (userSignupRepository.userExists(userEntity.getUsername())) {
            throw new Exception("Username is already taken.");
        }
        if (userSignupRepository.emailExists(userEntity.getEmail())) {
            throw new Exception("This email already has an account.");
        }

        //todo: BCrypt/similar

        return userSignupRepository.userSignUp(userEntity);
    }

    private static boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
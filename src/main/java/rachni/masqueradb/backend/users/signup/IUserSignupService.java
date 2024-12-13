package rachni.masqueradb.backend.users.signup;

import rachni.masqueradb.backend.users.UserEntity;

public interface IUserSignupService {
    int userSignUp(UserEntity userEntity) throws Exception;
}

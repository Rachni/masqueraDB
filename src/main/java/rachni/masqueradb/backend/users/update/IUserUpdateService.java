package rachni.masqueradb.backend.users.update;

import rachni.masqueradb.backend.users.UserEntity;

public interface IUserUpdateService {
    boolean userUpdate(UserEntity userEntity) throws Exception;
}

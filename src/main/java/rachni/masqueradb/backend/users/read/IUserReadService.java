package rachni.masqueradb.backend.users.read;

import rachni.masqueradb.backend.users.UserEntity;

public interface IUserReadService {
    UserEntity findUser(int id) throws Exception;
}

package rachni.masqueradb.backend.users.delete;

import rachni.masqueradb.backend.users.UserEntity;

public interface IUserDeleteService {
    boolean userDelete(int id) throws Exception;
}

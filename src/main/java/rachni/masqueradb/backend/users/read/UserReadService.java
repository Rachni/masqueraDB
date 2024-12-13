package rachni.masqueradb.backend.users.read;

import rachni.masqueradb.backend.users.UserEntity;

public class UserReadService implements IUserReadService {
    UserReadRepository userReadRepository;

    public UserReadService(UserReadRepository userReadRepository) {
        this.userReadRepository = userReadRepository;
    }

    @Override
    public UserEntity findUser(int id) throws Exception {
        if (id < 1) {
            throw new Exception("ID can't be 0 or less");
        }
        return this.userReadRepository.findUser(id);
    }
}

package rachni.masqueradb.backend.users.delete;

import rachni.masqueradb.backend.users.UserEntity;

public class UserDeleteService implements IUserDeleteService {
    UserDeleteRepository userDeleteRepository;

    public UserDeleteService(UserDeleteRepository userDeleteRepository) {
        this.userDeleteRepository = userDeleteRepository;
    }

    @Override
    public boolean userDelete(int id) throws Exception{
        return this.userDeleteRepository.userDelete(id);
    }
}
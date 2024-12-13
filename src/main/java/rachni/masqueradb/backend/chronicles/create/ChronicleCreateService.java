package rachni.masqueradb.backend.chronicles.create;

import rachni.masqueradb.backend.chronicles.ChronicleEntity;

public class ChronicleCreateService implements IChronicleCreateService {
    ChronicleCreateRepository chronicleCreateRepository;

    public ChronicleCreateService(ChronicleCreateRepository chronicleCreateRepository) {
        this.chronicleCreateRepository = chronicleCreateRepository;
    }

    @Override
    public int chronicleCreate(ChronicleEntity chronicleEntity) throws Exception {
        if (chronicleEntity.getName().isBlank() || chronicleEntity.getName() == null) {
            throw new Exception("Chronicle name field must not be empty.");
        }
        return this.chronicleCreateRepository.ChronicleCreate(chronicleEntity);
    }
}

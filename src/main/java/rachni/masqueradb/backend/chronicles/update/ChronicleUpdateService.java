package rachni.masqueradb.backend.chronicles.update;

import rachni.masqueradb.backend.chronicles.ChronicleEntity;

public class ChronicleUpdateService implements IChronicleUpdateService {
    ChronicleUpdateRepository chronicleUpdateRepository;

    public ChronicleUpdateService(ChronicleUpdateRepository chronicleUpdateRepository) {
        this.chronicleUpdateRepository = chronicleUpdateRepository;
    }

    @Override
    public boolean chronicleUpdate(ChronicleEntity chronicleEntity) throws Exception {
        if (chronicleEntity == null) {
            throw new Exception("Chronicle can't be null.");
        }
        if (chronicleEntity.getName() == null || chronicleEntity.getName().isBlank()) {
            throw new Exception("Chronicle name field can't be empty.");
        }
        return this.chronicleUpdateRepository.chronicleUpdate(chronicleEntity);
    }
}

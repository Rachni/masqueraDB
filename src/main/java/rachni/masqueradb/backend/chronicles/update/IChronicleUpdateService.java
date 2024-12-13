package rachni.masqueradb.backend.chronicles.update;

import rachni.masqueradb.backend.chronicles.ChronicleEntity;

public interface IChronicleUpdateService {
    boolean chronicleUpdate(ChronicleEntity chronicleEntity) throws Exception;
}

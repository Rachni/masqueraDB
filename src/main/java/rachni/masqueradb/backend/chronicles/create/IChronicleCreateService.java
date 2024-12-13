package rachni.masqueradb.backend.chronicles.create;

import rachni.masqueradb.backend.chronicles.ChronicleEntity;

public interface IChronicleCreateService {
    int chronicleCreate(ChronicleEntity chronicleEntity) throws Exception;

}

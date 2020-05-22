package LabAssiAsseProjectV01MV.repository;

import LabAssiAsseProjectV01MV.domain.Tema;
import LabAssiAsseProjectV01MV.validation.*;

public class TemaRepository extends AbstractCRUDRepository<String, Tema> {
    public TemaRepository(Validator<Tema> validator) {
        super(validator);
    }
}


package LabAssiAsseProjectV01MV.repository;

import LabAssiAsseProjectV01MV.domain.*;
import LabAssiAsseProjectV01MV.validation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NotaRepository extends AbstractCRUDRepository<Pair<String, String>, Nota> {
    public NotaRepository(Validator<Nota> validator) {
        super(validator);
    }
}

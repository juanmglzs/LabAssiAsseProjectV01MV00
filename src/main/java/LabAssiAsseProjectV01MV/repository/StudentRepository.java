package LabAssiAsseProjectV01MV.repository;

import LabAssiAsseProjectV01MV.domain.Student;
import LabAssiAsseProjectV01MV.validation.*;

public class StudentRepository extends AbstractCRUDRepository<String, Student> {
    public StudentRepository(Validator<Student> validator) {
        super(validator);
    }
}


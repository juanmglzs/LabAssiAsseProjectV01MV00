package LabAssiAsseProjectV01MV;

import LabAssiAsseProjectV01MV.domain.Nota;
import LabAssiAsseProjectV01MV.domain.Student;
import LabAssiAsseProjectV01MV.domain.Tema;
import LabAssiAsseProjectV01MV.repository.NotaXMLRepository;
import LabAssiAsseProjectV01MV.repository.StudentXMLRepository;
import LabAssiAsseProjectV01MV.repository.TemaXMLRepository;
import LabAssiAsseProjectV01MV.service.Service;
import LabAssiAsseProjectV01MV.validation.NotaValidator;
import LabAssiAsseProjectV01MV.validation.StudentValidator;
import LabAssiAsseProjectV01MV.validation.TemaValidator;
import LabAssiAsseProjectV01MV.validation.Validator;
import junit.framework.TestCase;

public class Integration extends TestCase {

    private Service service;

    /**
     * This test executes the conditions when a new student its added
     *
     */
    public void testAddStudentSuccessful() {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        int result = service.saveStudent("8", "Messi", 222);
        assertEquals(0, result);


    }


    /**
     * This test executes the conditions when service.SaveNota() returns 0 and an Assignment is added.
     *
     */
    public void testAddAssignmentSuccessful() {

        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        int result = service.saveNota("1","1",10,7,"testPassedSuccessful" );
        assertEquals(0, result);

    }

    /**
     * This test executes the conditions when service.SaveTema() returns 0 and an grade is added.
     *
     */
    public void testAddGradeSuccessful() {

        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        int result = service.saveTema("1", "testing", 10, 5);
        assertEquals(0, result);

    }

    public void testBigBangIntegration() {

        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        int result1 = service.saveStudent("8", "Messi", 222);
        assertEquals(0, result1);
        int result2 = service.saveNota("1","1",10,7,"testPassedSuccessful" );
        assertEquals(0, result2);
        int result3 = service.saveTema("1", "testing", 10, 5);
        assertEquals(0, result3);

    }
}

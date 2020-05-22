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

/**
 * Unit test for simple App.
 */
public class Incremental extends TestCase
{

    private Service service;

    /**
     * This test executes the conditions when a new student its added
     *
     */
    public void testAddStudentSuccess() {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        int result = service.saveStudent("8", "Messi", 222);

        assertEquals(1, result);

    }

    /**
     * This test executes the conditions when a new student cannot be added because of an error
     *
     */

    public void testAddStudentFailed() {

    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

    int result = service.saveStudent("9", "Messi", 222);

    assertEquals(1, result);

    int result2 = service.saveStudent("9", "Messi", 222);

    assertEquals(0, result2);

}

    public void testAddStudentWrongID() {
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

    int result = service.saveStudent(null, "Messi", 222);

    assertEquals(1, result);
}

    public void testAddStudentWrongGroup() {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        int result = service.saveStudent("11", "Messi", -1);

        assertEquals(1, result);
    }
    }

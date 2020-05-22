package LabAssiAsseProjectV01MV;

/**
 * Hello world!
 *
 */

import LabAssiAsseProjectV01MV.repository.*;
import LabAssiAsseProjectV01MV.domain.*;
import LabAssiAsseProjectV01MV.validation.*;
import LabAssiAsseProjectV01MV.service.*;
import LabAssiAsseProjectV01MV.console.*;


public class App 
{
    public static void main( String[] args )
    {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        UI consola = new UI(service);
        consola.run();

        //PENTRU GUI
        // de avut un check: daca profesorul introduce sau nu saptamana la timp
        // daca se introduce nota la timp, se preia saptamana din sistem
        // altfel, se introduce de la tastatura
    }
}

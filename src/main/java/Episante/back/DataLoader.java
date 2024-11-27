package Episante.back;

import Episante.back.DAO.IPatientDao;
import Episante.back.Entity.Patient;
import Episante.back.Entity.Sexe;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final IPatientDao patientDao;
    public DataLoader(IPatientDao patientDao) {
        this.patientDao = patientDao;
    }


    @Override
    public void run(String... args) throws Exception {
        if (patientDao.count() == 0) { // Check if data already exists

            Patient patient1 = new Patient();
            patient1.setNom("Smith");
            patient1.setPrenom("John");
            patient1.setAge(30);
            patient1.setPoids(75.5);
            patient1.setSexe(Sexe.HOMME);

            Patient patient2 = new Patient();
            patient2.setNom("Nana");
            patient2.setPrenom("Jane");
            patient2.setAge(28);
            patient2.setPoids(60.0);
            patient2.setSexe(Sexe.FEMME);

            Patient patient3 = new Patient();
            patient1.setNom("EL-Mahjouby");
            patient1.setPrenom("Ayoub");
            patient1.setAge(21);
            patient1.setPoids(57.9);
            patient1.setSexe(Sexe.HOMME);

            Patient patient4 = new Patient();
            patient2.setNom("EL Hammi");
            patient2.setPrenom("Ikram");
            patient2.setAge(21);
            patient2.setPoids(65.0);
            patient2.setSexe(Sexe.FEMME);

            patientDao.save(patient1);
            patientDao.save(patient2);
            patientDao.save(patient3);
            patientDao.save(patient4);

            System.out.println("Patient data loaded successfully");
        }else {
            System.out.println("This Data is already loaded");
        }
    }
}

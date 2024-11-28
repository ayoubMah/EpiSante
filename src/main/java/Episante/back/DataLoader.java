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

            Patient patient3 = new Patient();
            patient3.setNom("Abou");
            patient3.setNom("EL-Mahjouby");
            patient3.setAge(21);
            patient3.setPoids(57.9);
            patient3.setSexe(Sexe.HOMME);

            Patient patient1 = new Patient();
            patient1.setNom("Abou");
            patient1.setPrenom("Yassine");
            patient1.setAge(21);
            patient1.setPoids(68);
            patient1.setSexe(Sexe.HOMME);

            Patient patient2 = new Patient();
            patient2.setNom("Sharapova");
            patient2.setPrenom("Maria");
            patient2.setAge(37);
            patient2.setPoids(78.6);
            patient2.setSexe(Sexe.FEMME);

            patientDao.save(patient1);
            patientDao.save(patient2);
            patientDao.save(patient3);

            System.out.println("Patient data loaded successfully");
        }else {
            System.out.println("This Data is already loaded");
        }
    }
}

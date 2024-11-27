package Episante.back.Controller;

import Episante.back.DAO.IPatientDao;
import Episante.back.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private IPatientDao patientDao;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientDao.findAll();
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientDao.save(patient);
    }

    @PutMapping
    public Patient updatePatient( @PathVariable Long id , @RequestBody Patient patientDetails) {
        Patient patient = patientDao.findById(id).orElseThrow();

        patient.setNom(patientDetails.getNom());
        patient.setPrenom(patientDetails.getPrenom());
        patient.setAge(patientDetails.getAge());
        patient.setPoids(patientDetails.getPoids());
        patient.setSexe(patientDetails.getSexe());

        return patientDao.save(patient);
    }

    @DeleteMapping
    public void deletePatient(@PathVariable Long id) {
        patientDao.deleteById(id);
    }


}

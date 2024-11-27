package Episante.back.DAO;

import Episante.back.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientDao extends JpaRepository<Patient, Long> {
}

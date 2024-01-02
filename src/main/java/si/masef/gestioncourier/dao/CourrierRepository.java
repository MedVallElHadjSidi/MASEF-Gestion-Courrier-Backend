package si.masef.gestioncourier.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import si.masef.gestioncourier.entity.Courrier;

@CrossOrigin("*")
@Repository
public interface CourrierRepository extends JpaRepository<Courrier, Long> {
    List<Courrier> findByDestination(String destination);
    List<Courrier> findAllByOrderByIdDesc();
    List<Courrier> findByTelContainingIgnoreCaseOrNniContainingIgnoreCaseOrNumberInscription(String tel,String nni, Integer numberInscription);
    List<Courrier> findByDestinationAndTelContainingIgnoreCaseOrNniContainingIgnoreCaseOrNumberInscription(String destination,String tel,String nni, Integer numberInscription);
    int countByDestination(String destination);
    int countByDestinationAndStatus(String destination , boolean status);


}

package si.masef.gestioncourier.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import si.masef.gestioncourier.entity.Courrier;

@CrossOrigin(origins = "*")
@Repository
public interface CourrierRepository extends JpaRepository<Courrier, Long> {
    List<Courrier> findByDestination(String destination);

    List<Courrier> findAllByOrderByIdDesc();

    List<Courrier> findByTelContainingIgnoreCaseOrNniContainingIgnoreCaseOrNumberInscription(String tel, String nni,
            Integer numberInscription);

    List<Courrier> findByDestinationAndTelContainingIgnoreCaseOrNniContainingIgnoreCaseOrNumberInscription(
            String destination, String tel, String nni, Integer numberInscription);

    int countByDestination(String destination);

    int countByDestinationAndStatus(String destination, boolean status);

    Courrier findByNumberInscriptionAndDestination(int numberInscription, String destination);

    // trouver le top (premier) enregistrement trié par ordre décroissant de la
    // destination :
    @Query("SELECT COALESCE(MAX(c.numberInscription), 0) FROM Courrier c WHERE c.destination = :destination")
    int findMaxIdByDestination(@Param("destination") String destination);


}

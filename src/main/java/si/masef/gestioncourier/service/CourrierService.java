package si.masef.gestioncourier.service;

import java.util.List;

import si.masef.gestioncourier.entity.Courrier;

public interface CourrierService {
    List<Courrier> AllCourriers();
    List<Courrier> findByDestination(String destination);
    List<Courrier> findByTelOrNniOrNumberInscription(String searchTerm);
    List<Courrier> findByDestinationTelOrNniOrNumberInscription(String destination,String searchTerm);
    int countByDestination(String destination);
    int countByDestinationAndStatus(String destination , Boolean status);

    
}

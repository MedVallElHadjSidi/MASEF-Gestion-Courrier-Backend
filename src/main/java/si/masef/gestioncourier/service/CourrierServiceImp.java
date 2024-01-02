package si.masef.gestioncourier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import si.masef.gestioncourier.dao.CourrierRepository;
import si.masef.gestioncourier.entity.Courrier;

@Service
public class CourrierServiceImp implements CourrierService {
    @Autowired(required = true)
    private CourrierRepository courrierRepository;

    @Override
    public List<Courrier> AllCourriers() {
        return courrierRepository.findAllByOrderByIdDesc();
    }

    @Override
    public List<Courrier> findByDestination(String destination) {
        return courrierRepository.findByDestination(destination);
    }

    @Override
    public int countByDestination(String destination) {
        // TODO Auto-generated method stub }
        return courrierRepository.countByDestination(destination);

    }

    @Override
    public int countByDestinationAndStatus(String destination, Boolean status) {
        // TODO Auto-generated method stub
        return courrierRepository.countByDestinationAndStatus(destination, status);
    }

    @Override
    public List<Courrier> findByTelOrNniOrNumberInscription(String searchTerm) {
        // TODO Auto-generated method stub
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            return courrierRepository.findByTelContainingIgnoreCaseOrNniContainingIgnoreCaseOrNumberInscription(
                    searchTerm, searchTerm,
                    Integer.parseInt(searchTerm));
        }
        return courrierRepository.findAll();

    }

    @Override
    public List<Courrier> findByDestinationTelOrNniOrNumberInscription(String destination,String searchTerm) {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            return courrierRepository.findByDestinationAndTelContainingIgnoreCaseOrNniContainingIgnoreCaseOrNumberInscription(
                    destination,searchTerm, searchTerm,
                    Integer.parseInt(searchTerm));
        }
        return courrierRepository.findByDestination(destination); 
    
    }

}

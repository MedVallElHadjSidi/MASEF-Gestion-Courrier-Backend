package si.masef.gestioncourier.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si.masef.gestioncourier.entity.Courrier;
import si.masef.gestioncourier.service.CourrierService;

@CrossOrigin("*")
@RestController
@RequestMapping("cr/")
public class CourrierRestController {
    @Autowired(required = true)
    private CourrierService courrierService;

    @GetMapping("findByDestination/{destination}")
    public ResponseEntity<List<Courrier>> findByDestination(@PathVariable String destination) {
        List<Courrier> courriers = courrierService.findByDestination(destination);
        return new ResponseEntity<>(courriers, HttpStatus.OK);
    }

    @GetMapping("courriers")
    public ResponseEntity<List<Courrier>> allCourriers() {
        List<Courrier> courriers = courrierService.AllCourriers();
        return new ResponseEntity<>(courriers, HttpStatus.OK);
    }

    @GetMapping("statistiques")
    public ResponseEntity<Map<String, Map<String, Object>>> statistique() {
        Map<String, Map<String, Object>> result = new HashMap<>();

        // Example data for "dpsh"
        Map<String, Object> dpshData = new HashMap<>();
        dpshData.put("nom", "DPSH");
        dpshData.put("nbre_dpsh", courrierService.countByDestination("DPSH"));
        dpshData.put("nbreDpsh_instance", courrierService.countByDestinationAndStatus("DPSH", false));
        dpshData.put("nbreDpsh_delivre", courrierService.countByDestinationAndStatus("DPSH", true));
        result.put("dpsh", dpshData);

        // Example data for "dassn"
        Map<String, Object> dassnData = new HashMap<>();
        dassnData.put("nom", "DASSN");
        dassnData.put("nbre_dassn", courrierService.countByDestination("DASSN"));
        dassnData.put("nbreDassn_instance", courrierService.countByDestinationAndStatus("DASSN", false));
        dassnData.put("nbreDassn_delivre", courrierService.countByDestinationAndStatus("DASSN", true));
        result.put("dassn", dassnData);

        // Example data for "autre"
        Map<String, Object> autreData = new HashMap<>();
        autreData.put("nom", "Autre");
        autreData.put("nbreautre", courrierService.countByDestination("Autre"));
        autreData.put("nbreautre_instance", courrierService.countByDestinationAndStatus("Autre", false));
        autreData.put("nbreautre_livre", courrierService.countByDestinationAndStatus("Autre", true));
        result.put("autre", autreData);

        // Return the result in the ResponseEntity
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("searchTerm/{searchTerm}")
    public ResponseEntity<List<Courrier>> findByTelOrNniOrNumberInscription(@PathVariable String searchTerm) {
        List<Courrier> courriers = courrierService.findByTelOrNniOrNumberInscription(searchTerm);
        return new ResponseEntity<>(courriers, HttpStatus.OK);
    }
    @GetMapping("searchTerm/{destination}/{searchTerm}")
    public ResponseEntity<List<Courrier>> findByDestinationTelOrNniOrNumberInscription(@PathVariable String destination,@PathVariable String searchTerm) {
        List<Courrier> courriers = courrierService.findByDestinationTelOrNniOrNumberInscription(destination,searchTerm);
        return new ResponseEntity<>(courriers, HttpStatus.OK);
    }
}

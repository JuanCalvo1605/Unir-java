package Buses.Buses_Microservice.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Buses.Buses_Microservice.DTO.conductorDTO;

@Service
public class conductoresService {
    @Autowired
    RestTemplate restTemplate;

    public List<conductorDTO> getConductor(){
        ResponseEntity<conductorDTO[]> response = restTemplate.getForEntity("http://localhost:8081/api/v1/conductores", conductorDTO[].class);
        conductorDTO[] ConductorDTO = response.getBody();
        List<conductorDTO> m = Arrays.asList(ConductorDTO);
        return m;
    }
}

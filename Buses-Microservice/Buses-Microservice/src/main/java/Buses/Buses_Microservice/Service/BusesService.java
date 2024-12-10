package Buses.Buses_Microservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Buses.Buses_Microservice.entity.Buses;
import Buses.Buses_Microservice.repository.busesRepository;

@Service
public class BusesService {
    @Autowired
    busesRepository busesRep;
    //Lista todos los buses
    public List<Buses> findAll(){
        return (List<Buses>)  busesRep.findAll();
    }
    //Buscar por id
    public Buses getById(Long valor){
        return busesRep.findById(valor).get();
    }
    //crea un nuevo bus
    public Buses createBus(Buses bus){
        return busesRep.save(bus);
    }
    //elimnina bus
    public Boolean deleteBusId(Long id){
        try{
            busesRep.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public Buses findByType(String tipo){
        return busesRep.findByTipo(tipo);
    }
    

}

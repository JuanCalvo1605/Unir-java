package Conductor.conductor_microservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Conductor.conductor_microservice.Entity.Conductor;
import Conductor.conductor_microservice.Repository.ConductorRepository;

@Service
public class conductorService {
    @Autowired
    ConductorRepository conductorRep;

    public List<Conductor> findAll(){
        return (List<Conductor>) conductorRep.findAll();
    }

    public Conductor guardaConductor(Conductor conductor){
        return conductorRep.save(conductor);
    }
    public Conductor buscaId(Long cc){
        return conductorRep.findById(cc).get();
    }

    public Boolean eliminaConductor(Long cc){
        try{
            conductorRep.deleteById(cc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Conductor buscaPorEdad(Long edad){
        return conductorRep.findByEdad(edad);
    }
    public Conductor buscaPorCedula(Long cedula){
        return conductorRep.findByCedula(cedula);
    }
}

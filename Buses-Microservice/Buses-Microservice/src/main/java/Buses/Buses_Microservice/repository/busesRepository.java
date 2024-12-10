package Buses.Buses_Microservice.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Buses.Buses_Microservice.entity.Buses;
@Repository
public interface busesRepository extends CrudRepository<Buses, Long>{
    public Buses findByTipo(String tipo);
}

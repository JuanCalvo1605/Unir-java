package Conductor.conductor_microservice.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import Conductor.conductor_microservice.Entity.Conductor;

@Repository
public interface ConductorRepository extends JpaRepository <Conductor, Long>{
    public Conductor findByEdad(Long edad);
    public Conductor findByCedula(Long cedula);
}

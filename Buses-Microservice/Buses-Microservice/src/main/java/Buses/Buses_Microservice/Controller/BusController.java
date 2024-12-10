package Buses.Buses_Microservice.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Buses.Buses_Microservice.DTO.conductorDTO;
import Buses.Buses_Microservice.Service.BusesService;
import Buses.Buses_Microservice.Service.conductoresService;
import Buses.Buses_Microservice.entity.Buses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PutMapping;







@RestController
@RequestMapping("/api/v1/buses")
@CrossOrigin("*")
public class BusController {
    @Autowired
    private BusesService busesService;

    @Autowired
    conductoresService conductoresService;
    //verifica que el servicio este arriba
    @GetMapping("/saluda")
    public String saluda() {
        return "Hola";
    }
    //lista todos los buses
    @GetMapping()
    public ResponseEntity<List<Buses>> getAllBuses() {
        List<Buses> buses = busesService.findAll();
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }
    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Buses> getById(@PathVariable Long id) {
        Buses bus = busesService.getById(id);
        if(bus != null){
            return new ResponseEntity<>(bus, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //crea un nuevo bus
    @PostMapping("/Create")
    public ResponseEntity<Buses> createBus(@RequestBody Buses bus) {
        Buses creaBus = busesService.createBus(bus);
        return new ResponseEntity<>(creaBus, HttpStatus.CREATED);
        
    }
    //Actualiza bus
    @PutMapping("/{id}")
    public ResponseEntity<Buses> updateBus(@PathVariable Long id, @RequestBody Buses Bus) {
        Bus.setId(id);
        Buses updatBus = busesService.createBus(Bus);
        if (updatBus != null){
            return new ResponseEntity<>(updatBus, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //Elimina Bus
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long id){
        Boolean elimniado = busesService.deleteBusId(id);
        if (elimniado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //busca por tipo
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<Object> finType(@PathVariable("tipo") String tipo) {
        if (busesService.findByType(tipo) == null) {
            return new ResponseEntity<>("{\"status\":404,\"message\":\"Bus no encontrado\"}",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(busesService.findByType(tipo), HttpStatus.OK);
    }
    
    //busca todos los conductores
    @GetMapping("/conductor")
    public List<conductorDTO> conductores() {
        return conductoresService.getConductor();
    }
    
    
}

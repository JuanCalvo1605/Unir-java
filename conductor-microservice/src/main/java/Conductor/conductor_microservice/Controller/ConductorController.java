package Conductor.conductor_microservice.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Conductor.conductor_microservice.Entity.Conductor;
import Conductor.conductor_microservice.Service.conductorService;

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
@RequestMapping("/api/v1/conductores")
@CrossOrigin("*")
public class ConductorController {
    //Llamar a las funciones del microservicio
    @Autowired
    private conductorService conductorService;
    //comprobar que el servicio este arriba
    @GetMapping("/Saluda")
    public String saluda() {
        return "Servicio Arriba";
    }
    @GetMapping()
    public ResponseEntity <List<Conductor>> getAllBuses() {
        List<Conductor> conductor = conductorService.findAll(); 
        return new ResponseEntity<>(conductor, HttpStatus.OK);

    }
    @PostMapping()
    public ResponseEntity<Conductor> guardaConductor(@RequestBody Conductor conductor) {
        Conductor conductorCreado = conductorService.guardaConductor(conductor);
        return new ResponseEntity<>(conductorCreado, HttpStatus.OK);
    }
    @PutMapping("/{cc}")
    public ResponseEntity<Conductor> putMethodName(@PathVariable Long cc, @RequestBody Conductor conductor) {
        conductor.setIdConductor(cc);
        Conductor actualizaConductor = conductorService.guardaConductor(conductor);
        if (actualizaConductor != null) {
            return new ResponseEntity<>(actualizaConductor, HttpStatus.OK);
        }
        return new ResponseEntity<>(actualizaConductor, HttpStatus.NOT_FOUND);
        
    }
    @DeleteMapping("/{cc}")
    public ResponseEntity<String> eliminaUsuario(@PathVariable Long cc){
        Boolean eliminado = conductorService.eliminaConductor(cc);
        if (eliminado) {
            return ResponseEntity.ok("Conductor con la cédula" + cc + " eliminado con éxito.");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("El conductor con la cédula " + cc + " no pudo ser eliminado.");
    }
    
    @GetMapping("/Edad/{edad}")
    public ResponseEntity<Conductor> findEdad(@PathVariable("edad") Long edad){
        Conductor buscaConductor = conductorService.buscaPorEdad(edad);
        if (buscaConductor != null) {
            return new  ResponseEntity<>(buscaConductor, HttpStatus.OK);
        }
        return new  ResponseEntity<>(buscaConductor, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/Cedula/{cc}")
    public ResponseEntity<Conductor> findByCedula(@PathVariable("cc") Long cc){
        Conductor buscaConductor = conductorService.buscaPorCedula(cc);
        if (buscaConductor != null) {
            return new  ResponseEntity<>(buscaConductor, HttpStatus.OK);
        }
        return new  ResponseEntity<>(buscaConductor, HttpStatus.NOT_FOUND);
    }
}
    


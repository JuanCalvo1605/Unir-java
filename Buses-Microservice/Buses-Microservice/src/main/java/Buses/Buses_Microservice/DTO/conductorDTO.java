package Buses.Buses_Microservice.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class conductorDTO {
    @Column(name = "idConductor")
    private Long idConductor;
    @Column(name = "Cedula")
    private Long Cedula;
    @Column(name = "Nombre")
    private String Nombre;
    @Column(name = "edad")
    private Long edad;
    @Column(name = "paisOrigen")
    private String PaisOrigen;
}

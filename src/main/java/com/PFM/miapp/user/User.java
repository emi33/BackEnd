package com.PFM.miapp.user;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
   
    private Integer id;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String password;
    
    
}

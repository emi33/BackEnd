/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PFM.miapp.Controller;

import com.PFM.miapp.Interface.IPersonaService;
import com.PFM.miapp.Model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    
    @Autowired
    private IPersonaService iPersona;
    
    @GetMapping("/traer")
    public List<Persona> getPersonas(){
        return iPersona.getPersonas();
    }
    
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        iPersona.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        iPersona.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping("/editar")
    public void edit(@RequestBody Persona persona){
        iPersona.editPersona(persona);
    }
    
    @GetMapping("/traer/{id}")
    public ResponseEntity<Persona> detail(@PathVariable("id") Long id){
        return ResponseEntity.ok(iPersona.findPersona(id));
    }       
}

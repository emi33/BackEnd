/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PFM.miapp.Controller;

import com.PFM.miapp.Interface.IExperienciaService;
import com.PFM.miapp.Model.Experiencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/experiencias")
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService iExperiencia;
    
    @GetMapping("/traer")
    public List<Experiencia> getExperiencias(){
        return iExperiencia.getExperiencias();
    }
    
    @PostMapping("/crear")
    public String createExperiencia(@RequestBody Experiencia experiencia){
        iExperiencia.saveExperiencia(experiencia);
        return "La Experiencia fue creada correctamente";
    }
     
   //lista de experiencias por id de persona
    @GetMapping ("/persona/{id}/lista")
    public List <Experiencia> listaPer(@PathVariable Long id){
        return iExperiencia.findByPersonaId(id);    
        }
    
    
    @DeleteMapping("/borrar/{id}")
    public String deleteExperiencia(@PathVariable Long id){
        iExperiencia.deleteExperiencia(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping("/editar/{id}")
    public Experiencia editExperiencia(@PathVariable Long id,
                               @RequestParam ("empresa") String nuevaEmpresa,
                               @RequestParam ("cargo") String nuevoCargo,
                               @RequestParam ("fecha") int nuevaFecha,
                               @RequestParam ("descripcion") String nuevaDescripcion){
        Experiencia experiencia = iExperiencia.findExperiencia(id);
        
        experiencia.setEmpresa(nuevaEmpresa);
        experiencia.setCargo(nuevoCargo);
        experiencia.setFecha(nuevaFecha);
        experiencia.setDescripcion(nuevaDescripcion);
        
        iExperiencia.saveExperiencia(experiencia);
        
        return experiencia;
    }
}

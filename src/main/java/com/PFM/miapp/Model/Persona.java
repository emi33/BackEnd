/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PFM.miapp.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_generator")
    private Long id;

    @NotNull
    @Column(name = "nombre")
    private String nombre;
    @NotNull
    @Column(name = "apellido")
    private String apellido;
    @NotNull
    @Column(name = "edad")
    private int edad;
    @NotNull
    @Size(max = 4000)
    @Column(name = "acercade")
    private String acercade;
    @NotNull
    @Column(name = "ocupacion")
    private String ocupacion;
    @NotNull
    @Size(max = 500)
    @Column(name = "imagen")
    private String imagen;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Experiencia> experiencias;
    
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Educacion> estudios;
    
     @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Proyecto> proyectos;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, String acercade, String ocupacion, String imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.acercade = acercade;
        this.ocupacion = ocupacion;
        this.imagen = imagen;
    }

    public String getAcercade() {
        return acercade;
    }

    public void setAcercade(String acercade) {
        this.acercade = acercade;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Educacion> getEstudios() {
        return estudios;
    }

    public void setEstudios(List<Educacion> estudios) {
        this.estudios = estudios;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
    
    

}

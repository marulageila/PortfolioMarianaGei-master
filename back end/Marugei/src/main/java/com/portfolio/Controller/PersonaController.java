
package com.portfolio.Controller;

import com.portfolio.Entidad.Persona;
import com.portfolio.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@CrossOrigin(origins = "http://localhost4200")
public class PersonaController {
    @Autowired IPersonaService IPersonaService;
    
  
    @GetMapping(path ="personas/traer") 
    public List<Persona> getPersona(){
        return IPersonaService.getPersona();
    }
    @PostMapping(path ="/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        IPersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    @DeleteMapping(path ="/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        IPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    @PutMapping(path ="/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevoImg) {
       
        Persona persona = IPersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        IPersonaService.savePersona(persona);
        return persona; 
    }
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
 return IPersonaService.findPersona((long)1);
    }
}


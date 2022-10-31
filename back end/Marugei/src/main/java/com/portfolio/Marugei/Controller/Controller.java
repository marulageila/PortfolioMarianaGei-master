
package com.portfolio.Marugei.Controller;

import com.portfolio.Marugei.model.Persona;
import com.portfolio.Marugei.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
   @Autowired    
   private IPersonaService PersoServ;
           
   @PostMapping ("/crear/persona")
   public void agregarPersona(@RequestBody Persona pers){
     PersoServ.crearPersona(pers);
   }
   
    @GetMapping ("/ver/personas")  
    @ResponseBody
    public List<Persona> verPersona(){
     return PersoServ.verPersonas();
             }
    @DeleteMapping ("/borrar/{id}")
    public void borrarPersona(@PathVariable Long id){
        PersoServ.borrarPersona(id);
        
    }
    
}
  


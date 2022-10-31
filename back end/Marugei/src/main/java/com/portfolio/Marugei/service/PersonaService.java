
package com.portfolio.Marugei.service;

import com.portfolio.Marugei.model.Persona;
import com.portfolio.Marugei.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {
@Autowired
 public PersonaRepository PersoRepo;
    @Override
    public List<Persona> verPersonas() {
     return PersoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona pers) {
     PersoRepo.save(pers);
    }

    @Override
    public void borrarPersona(Long id) {
     PersoRepo.deleteById( id);    
    }

    @Override
    public Persona buscarPersona(Long id) {
      return PersoRepo.findById(id).orElse(null);
    }
    
}

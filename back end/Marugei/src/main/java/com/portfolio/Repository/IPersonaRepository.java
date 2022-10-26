
package com.portfolio.Repository;

import com.portfolio.Entidad.Persona;
import java.util.List;

public interface IPersonaRepository {

    public List<Persona> findAll();


    public void save(Persona persona);

    public void deleteById(Long id);

    public Object findById(Long id);
    
}

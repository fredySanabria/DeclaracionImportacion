package com.mincomercio.propuesta.servicios;

import com.mincomercio.propuesta.dominio.Pais;
import com.mincomercio.propuesta.excepciones.PaisNoEncontradoExcepcion;
import com.mincomercio.propuesta.repositorios.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPais {

    @Autowired
    PaisRepositorio paisRepo;

    /**
     * Este metodo ayuda a configurar paises, asi mismo modificar los existentes
     * en caso de veto.
     * @param pais
     * @return
     */
    public Pais crearModificarPais(Pais pais){
        return paisRepo.save(pais);
    }

    /**
     * Obtiene la lista completa de paises configurados
     * @return
     */
    public List<Pais> obtenerPaises(){
        return paisRepo.findAll();
    }

    /**
     * Busca un pais especifico dado un código de pais
     * lanzará una excepcion si el pais no existe
     * @param codigo
     * @return
     */

    public Pais buscarPais(int codigo){
        return paisRepo.findById(codigo)
                .orElseThrow(() -> new PaisNoEncontradoExcepcion("Pais no existe"));
    }
}

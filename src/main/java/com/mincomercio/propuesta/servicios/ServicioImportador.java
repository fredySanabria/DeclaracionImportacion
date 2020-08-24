package com.mincomercio.propuesta.servicios;

import com.mincomercio.propuesta.dominio.Importador;
import com.mincomercio.propuesta.excepciones.ImportadorNoEncontradoExcepcion;
import com.mincomercio.propuesta.repositorios.ImportadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioImportador {

    @Autowired
    ImportadorRepositorio importadorRepo;

    /**
     * Este metodo ayuda a configurar Importadores
     * @param Importador
     * @return
     */
    public Importador crearModificarImportador(Importador Importador){
        return importadorRepo.save(Importador);
    }

    /**
     * Obtiene la lista completa de Importadores configurados
     * @return
     */
    public List<Importador> obtenerImportadores(){
        return importadorRepo.findAll();
    }

    /**
     * Busca un Importador especifico dado un nit de Importador
     * lanzará una excepcion si el Importador no existe
     * @param nit
     * @return
     */

    public Importador buscarImportador(String nit){
        return importadorRepo.findById(nit)
                .orElseThrow(() -> new ImportadorNoEncontradoExcepcion("Importador no existe"));
    }
}

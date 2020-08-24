package com.mincomercio.propuesta.servicios;

import com.mincomercio.propuesta.dominio.Categoria;
import com.mincomercio.propuesta.excepciones.CategoriaNoEncontradaExcepcion;
import com.mincomercio.propuesta.repositorios.CategoriaRepositorio;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServicioCategoriaTest {
    @Mock
    CategoriaRepositorio repositorioMock;

    @InjectMocks
    ServicioCategoria servicio;

    private Categoria categoriaTest;
    private List<Categoria> listaCategorias;

    @Before
    public void init(){
        categoriaTest = Categoria
                .builder()
                .id(1)
                .nombre("Nombre Categoria Test")
                .arancel(10)
                .build();
        listaCategorias = new ArrayList<>();
        listaCategorias.add(categoriaTest);
    }


    @Test
    public void crearUnaCategoriaSatisfactoriamente(){
        when(repositorioMock.save(any(Categoria.class))).thenReturn(categoriaTest);
        Categoria resultado = servicio.crearModificarCategoria(categoriaTest);
        assertThat(resultado.getNombre()).isEqualTo("Nombre Categoria Test");
    }

    @Test
    public void obtenerUnaCategoriaSatisfactoriamente(){
        when(repositorioMock.findById(anyInt())).thenReturn(Optional.of(categoriaTest));
        Categoria resultado = servicio.buscarCategoria(1);
        assertThat(resultado.getId()).isEqualTo(1);
    }

    @Test(expected = CategoriaNoEncontradaExcepcion.class)
    public void lanzarExcepcionCuandoNoExistaCategoria(){
        when(repositorioMock.findById(anyInt())).thenReturn(Optional.empty());
        Categoria resultado = servicio.buscarCategoria(1);
    }

    @Test
    public void obtenerListaCategoriaesSatisfactoriamente(){
        when(repositorioMock.findAll()).thenReturn(listaCategorias);
        List<Categoria> resultado = servicio.obtenerCategorias();
        assertThat(resultado.size()).isEqualTo(1);
    }
}

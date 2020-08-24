package com.mincomercio.propuesta.servicios;

import com.mincomercio.propuesta.dominio.Pais;
import com.mincomercio.propuesta.excepciones.PaisNoEncontradoExcepcion;
import com.mincomercio.propuesta.repositorios.PaisRepositorio;
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
public class ServicioPaisTest {
    @Mock
    PaisRepositorio repositorioMock;

    @InjectMocks
    ServicioPais servicio;

    private Pais paisTest;
    private List<Pais> listaPaises;

    @Before
    public void init(){
        paisTest = Pais
                .builder()
                .id(1)
                .nombre("Nombre Test")
                .isVetado(false)
                .build();
        listaPaises = new ArrayList<>();
        listaPaises.add(paisTest);
    }


    @Test
    public void crearUnPaisSatisfactoriamente(){
        when(repositorioMock.save(any(Pais.class))).thenReturn(paisTest);
        Pais resultado = servicio.crearModificarPais(paisTest);
        assertThat(resultado.getNombre()).isEqualTo("Nombre Test");
    }

    @Test
    public void obtenerUnPaisSatisfactoriamente(){
        when(repositorioMock.findById(anyInt())).thenReturn(Optional.of(paisTest));
        Pais resultado = servicio.buscarPais(1);
        assertThat(resultado.getId()).isEqualTo(1);
    }

    @Test(expected = PaisNoEncontradoExcepcion.class)
    public void lanzarExcepcionCuandoNoExistaPais(){
        when(repositorioMock.findById(anyInt())).thenReturn(Optional.empty());
        Pais resultado = servicio.buscarPais(1);
    }

    @Test
    public void obtenerListaPaisesSatisfactoriamente(){
        when(repositorioMock.findAll()).thenReturn(listaPaises);
        List<Pais> resultado = servicio.obtenerPaises();
        assertThat(resultado.size()).isEqualTo(1);
    }
}

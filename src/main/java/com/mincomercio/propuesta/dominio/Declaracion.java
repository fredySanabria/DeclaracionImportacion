package com.mincomercio.propuesta.dominio;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@Entity
public class Declaracion {
    @Id
    @GeneratedValue
    @Column(name = "idDeclaracion")
    private long id;
    @JoinColumn(name = "FK_IMPORTADOR", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Importador empresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "declaracion")
    private List<Producto> productos;
    private LocalDateTime fechaDeclaracion;

    public static double obtenerTotalDeclaracion(List<Producto> productos) {
        return productos.stream()
                .mapToDouble(producto -> producto.getValorDeclarado() * producto.getCantidad())
                .sum();
    }

    public static double obtenerTotalArancel(List<Producto> productos) {
        return productos.stream()
                .mapToDouble(Producto::calcularArancelProducto)
                .sum();
    }
}

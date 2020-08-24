	function getId(){
		var url = window.location.href;
		var captured = /id=([^&]+)/.exec(url)[1];
		return captured ? captured : '4';}

	function llenarDataTable() {
        $.ajax({
            url: "http://localhost:8081/productos/{id}?id="+getId(),
            success: function (data) {
            $('#datatable tbody').empty();
            var html="";
                for (i in data) {
                html += "<tr>"+
                        "	<td>"+
                        "			<span class='custom-checkbox'>"+
                        "				<input type='checkbox' id='checkbox1' name='options[]' value='1'>"+
                        "				<label for='checkbox'"+i+"></label>"+
                        "			</span>"+
                        "	</td>"+
                        "	<td>"+data[i]["cantidad"]+"</td>"+
                        "	<td>"+data[i]["nombre"]+"</td>"+
                        "	<td>"+data[i]["origen"]+"</td>"+
                        "	<td>"+data[i]["embarque"]+"</td>"+
                        "	<td>"+data[i]["valorUnitario"]+"</td>"+
                        "	<td>"+data[i]["valorArancel"]+"</td>"+
                        "	<td>"+data[i]["valorTotal"]+"</td>"+
                        "	<td>"+
                        "		<a href='#editEmployeeModal' class='edit' data-toggle='modal'><i class='material-icons'"+
                        "																		 data-toggle='tooltip'"+
                        "																		 title='Edit'>&#xE254;</i></a>"+
                        "		<a href='#deleteEmployeeModal' class='delete' data-toggle='modal'><i class='material-icons'"+
                        "																			 data-toggle='tooltip'"+
                        "																			 title='Delete'>&#xE872;</i></a>"+
                        "	</td>"+
                        "</tr>";

                }
                $("#datatable tbody").append(html);
            }
        })
	}
    function llenarEncabezadoEmpresa(){
        $('#encabezado').empty();
        $('#valorTotal').empty();
        $.ajax({
            url: "http://localhost:8081/declaraciones/"+getId(),
            success: function (data) {
                var html = "<span class='badge badge-pill badge-primary'>"+data["nombreEmpresa"]+"</span><br>";
                html += "<span class='badge badge-pill badge-primary'>"+data["nit"]+"</span><br>";
		        $("#encabezado").append(html);
                var valorTotal = "Valor total de la declaracion es de : "+data["totalDeclaracion"];
                $("#valorTotal").append(valorTotal);
            }
        })
    }
   function llenarListaPais(){
   $.ajax({
        url: "http://localhost:8081/paises/",
         success: function(data) {
             var selectOrigen = $("#listaPaisOrigen");
             var selectEmbarque = $("#listaPaisEmbarque");
             selectOrigen.children().remove();
             selectEmbarque.children().remove();
             if (data) {
                 $(data).each(function(index, item) {
                     selectOrigen.append($("<option>").val(item.id).text(item.nombre));
                     selectEmbarque.append($("<option>").val(item.id).text(item.nombre));
                 });
             }
         }
        })
    }
   function llenarListaCategoria(){
   $.ajax({
        url: "http://localhost:8081/categorias/",
         success: function(data) {
             var selectCategoria = $("#listaCategoria");
             selectCategoria.children().remove();
             if (data) {
                 $(data).each(function(index, item) {
                     selectCategoria.append($("<option>").val(item.id).text(item.nombre));
                 });
             }
         }
        })
    }

    function crearProducto() {
        $.ajax({
            url: "http://localhost:8081/productos/",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json',
            type: 'POST',
            data: JSON.stringify({
                      cantidad: $('#modalCrearCantidad').val(),
                      codigoCategoria: $('#listaCategoria').val(),
                      codigoPaisEmbarque: $('#listaPaisEmbarque').val(),
                      codigoPaisOrigen: $('#listaPaisOrigen').val(),
                      declaracion: getId(),
                      nombre: $('#modalCrearNombre').val(),
                      valorUnitario: $('#modalCrearValorUnitario').val()
                          }),
            success: function (result) {
                    alert('Se ha creado el producto ' + result.id);
                    llenarEncabezadoEmpresa();
                    llenarDataTable();
                }
        });
    }
	$(document).ready(
			function() {
			    $("#error-container").hide();
			    llenarEncabezadoEmpresa();
                llenarDataTable();
                llenarListaPais();
                llenarListaCategoria();
			});
$(document).ready(function () {

    $("tr #btnDelete").click(function () {
        var id = $(this).parent().find("#id").val();
        Swal.fire({
            title: 'Estas seguro de Eliminar?',
            text: "Lo puedes agregar nuevamente!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Si, Eliminar!'
        }).then((result) => {
            if (result.isConfirmed) {
                eliminar(id);
                Swal.fire(
                        'Calzado eliminado!',
                        'Exitosamente!'
                        ).then((result) => {

                    if (result.isConfirmed) {
                        parent.location.href = "comprascontroller?a=carrito";
                    }
                });
            } else {

                Swal.fire('Calzado no eliminado!');
            }
        })

    });
    
    function eliminar(id) {
        var url = "comprascontroller?a=eliminarItemCarrito";
        $.ajax({
            type: 'POST',
            url: url,
            data: "id=" + id,
            success: function (data, textStatus, jqXHR) {

            }
        });
    }

    $("tr #Cantidad").click(function () {
        var idp=$(this).parent().find("#idpro").val();
        var cantidad = $(this).parent().find("#Cantidad").val();
        var url = "comprascontroller?a=actualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp="+ idp +"&Cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR) {
              
            }         
        });
    });
});


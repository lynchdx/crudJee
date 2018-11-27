$(function(){
    
    
    $('tr #btn-eliminar').click(function(e){
        e.preventDefault(); //para que no te reenvíe a ninguna parte.
        var opcion = confirm("Desea eliminar Producto");
        if (opcion) {
            
            //primer parent, de th (fila de cabezera). segundo parten td para columna
            var fila = $(this).parent().parent();  
            
            var var_idProducto = fila.find('#id_producto').text(); //captura el id
              //alert(idProducto);
                 //  alert();

               //var data guarda el id del producto rescatardo de la tabla.
               var data = {idProducto:var_idProducto}; //el nombre que se le dará; el valor que almacena
               //se usará el servlet, deleteProducto = deleteProductoServlet
               $.post("deleteProducto", data, function(res, est, jqXHR){
                   alert(res);
                   fila.remove();
               });
        }
    });    
    
    
    
    
    $('#btn_modificar_producto').click(function (e){
        e.preventDefault();
        var data = $('#form_modificar').serialize();
        //console.log(data);
        //alert(); uptadeproducto es el servlet
      $.post("updateProducto", data, function(res, est, jqXHR){
          alert(res);
      });
    });




});




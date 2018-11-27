/*
así se prueba si cargó la página bien en js

$(function(){
    alert();
    });
*/

$(function(){
    
    function validarCampos(nombre, descripcion, precio, categoria, detalles, reviews, size, color){
        if (nombre.length > 1 && nombre.length <= 20){
          if(descripcion.length > 1 && descripcion.length < 100){
              if(precio.length >0){
                  if($.isNumeric(precio)){
                      if(categoria.length > 1 && categoria.length <= 20){
                        if(detalles.length > 1 && detalles.length <= 20){
                          if(reviews.length > 1 && reviews.length <= 20){
                              if(size.length >= 1 && reviews.length <= 20){
                                   if(size != "Seleccione un número"){
                                       if (color.length > 1 && color.length <= 20) {
                                                
                                                //validar campo file (fotos) archivos es id del campo de img
                                                var archivos = document.getElementById('file_archivo').files;
                                                if (archivos.length == 5) {
                                                    for(var i=0; i<archivos.length; i++){
                                                   var name = archivos[i].name;
                                                   var ext = name.substring(name.lastIndexOf('.') + 1).toLowerCase();
                                                   if(ext != 'jpg' && ext != "png"){
                                                     alert("Foto "+name+"Sólo imagenes con formato JPG");
                                                     return false;
                                                   }
                                               }
                                               return true;
                                                }else{alert("Debe subir 5 fotos");} 
                                                
                                        }else{alert("El Color debe tener entre 1 y 20 caracteres");}
                                   }else{alert("Debe seleccionar un tamaño");}
                            }else{alert("El tamaño tener entre 1 y 10 caracteres");}
                            }else{alert("El riview debe tener entre 1 y 20 caracteres");}
                        }else{alert("El detalle debe tener entre 1 y 20 caracteres");}
                      }else{alert("La categoría debe tener entre 1 y 20 caracteres");}
                  }else{alert("Debe Ingresar un número válido");}
              }else{alert("El campo precio se encuentra Vacío");}
          }else{alert("Escriba una descripción Correcta");}
      }else{alert("Escriba un Nombre Correcto");}
      return false;
          
    }
    
    //rescata los valores de los txt
    $('#btn_crear_producto').click(function(e){
        e.preventDefault();
        var nombre = $('#txt_nombre').val();
        var descripcion = $('#txa_descripcion').val();
        var precio = $('#txt_precio').val();
        var categoria = $('#txt_categoria').val();
        var detalles = $('#txa_detalle').val();
        var reviews = $('#txa_reviews').val();
        var size = $('#cbo_size').val();
        var color = $('#txt_color').val();
        
        //si la validación es true (todos campos buenos)
       if(validarCampos(nombre, descripcion, precio, categoria, detalles, reviews, size, color)){
           var data = new FormData($('#form_crear')[0]); //usa id de form
           $.ajax({
               url : "crearproducto", //es el action (nombre nuevo de servlet).
               type : "post",
               data : data,
               contentType : false,
               processData: false,
               success : function(data){
                   alert(data); //se hacen cambios en el servlet del producto
               }
           });
       }
    });
    
});

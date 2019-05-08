# Api Activos fijos
API en Spring MVC

## Descripción
Los activos de fijos de una empresa son los bienes materiales, son necesarios para el funcionamiento 
de la empresa y no se destinan para la venta, ejemplos de estos son: bienes inmuebles, maquinaria, 
material de oficina, etc. 
 
Estos activos fijos tienen características comunes entre todas como son: nombre, descripción, tipo, 
serial, numero interno de inventario, peso, alto, ancho, largo, valor compra, fecha de compra, fecha 
de baja, estado actual (activo, dado de baja, en reparación, disponible, asignado), color. 
 
Los activos se pueden asignar a un área o persona, si es a un área esta se encuentra en una ciudad 
(diferentes áreas se encuentran en diferentes ciudades). 
 
API REST que permite administrar los activos, esta debería permitir: 
 
 -  Buscar por todos los activos. 
 -  Buscar los activos por: tipo, fecha de compra, serial. 
 - Crear nuevos activos. 
 -  Actualizar activos. 
 -  Permite cambiar el serial interno y fecha de baja. 
 -  Listar las áreas o personas. 
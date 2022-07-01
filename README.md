# Prueba Técnica Mercado Libre

# Arquitectura

El proyecto se diseña bajo la arquitectura MVVM, dado que es simple de mantener y su funcionalidad puede modificarse con el tiempo sin necesidad de hacer referencia directamente a la vista.

# Estructura del Proyecto

VISTA: 
El proyecto cuenta con una única actividad y 4 fragmentos: MainFragment, quien es la vista principal al momento de ingresar a la aplicación, SearchFragment, quien muestra las últimas búsquedas y permite al usuario ingresar un nuevo término para buscar, PLPFragment donde se muestra la lista de resultados de la búsqueda y PDPFragment donde se muestra el detalle de un producto en particular. La navegación es realizada mediante el uso de Navigation, propio del paquete de Jetpack.

VIEWMODEL: 
Realiza la comunicación entre las vistas y los casos de uso. Para este caso, se crea un viewmodel para cada fragmento.

MODELO: 
Se encuentra distribuida en carpetas, siendo api, la colección de clases que son utilizadas para serializar la respuesta que viene del servicio, y las clases PdpDetail y PlpItem que resumen las propiedades de las que se hace uso en las vistas de detalle de producto y listado de productos respectivamente.

CASOS DE USO: 
Realizan la comunicación entre los repositorios y viewModels. Básicamente, obtienen las respuestas de los servicios ( el consumo se encuentra incluido en los repositorios) y se realiza el mapeo hacia los modelos requeridos para la visualización del PLP y el PDP

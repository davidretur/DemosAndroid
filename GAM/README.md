# Sanimex Gam
<img src="assets/logo.png" align="left" width="180" hspace="10" vspace="10" />

**Gam** Es una aplicación móvil desarrollada en Kotlin y Jetpack Compose, diseñada para facilitar la gestión de pedidos y la interacción con el catálogo de productos de Sanimex. Permite a los usuarios explorar el catálogo, buscar productos, gestionar un carrito de compras, acceder a información de clientes, visualizar ubicaciones y consultar históricos de cotizaciones, adaptándose a diferentes roles de usuario dentro de la empresa.

Disponible en Google Play.

<a href="https://play.google.com/store/apps/details?id=com.app.sanimex">
  <img
    alt="En Google Play"
    height="80"
    src="https://storage.googleapis.com/pe-portal-consumer-prod-wagtail-static/images/visual-identity_logos_880x572.max-1920x1070.format-webp.webp?X-Goog-Algorithm=GOOG4-RSA-SHA256&X-Goog-Credential=wagtail%40pe-portal-consumer-prod.iam.gserviceaccount.com%2F20250505%2Fauto%2Fstorage%2Fgoog4_request&X-Goog-Date=20250505T201821Z&X-Goog-Expires=86400&X-Goog-SignedHeaders=host&X-Goog-Signature=987bad9d4aaf6f82e5622cd34f38b6526b806579942f1335abaf048b9d069d3880ebd8533e15f92e6a7b56b47a788fcbf98de7ac1c9c73d70b7f3fe73a7b0abd65901b94f8068b8db34f290ba5ff9b2b111e13f8b7a5b0c406f6c770e3634214e86b9828f0ee60e46bf8a87ae055a4c5b1948405927b5979f9fd1fcf2b2db9998f990842c0b094267c69fdaa5ba3ea643e155ff5b1ca8fa9fdab78e43b08b9053ea41667816d03daabd4074cb3de247e0b564e1ec5a2956386af931f2424e4f760366cf714d92f4357e3fcdeab8a3897b602509db2cad8e3bec56236c6b68b3efe945a923030bc45e48226e46c6a15a7fa862ecdf554a198b13b9fa2c99281c9"/>
</a>

## Screenshots

<div>
   <img src="assets/1.jpeg" width="150" alt="Captura de pantalla 1">
   <img src="assets/2.jpeg" width="150" alt="Captura de pantalla 2">
   <img src="assets/3.jpeg" width="150" alt="Captura de pantalla 3">
    <img src="assets/4.jpeg" width="150" alt="Captura de pantalla 4">
    <img src="assets/5.jpeg" width="150" alt="Captura de pantalla 5">
  <img src="assets/6.jpeg" width="150" alt="Captura de pantalla 6">
  <img src="assets/7.jpeg" width="150" alt="Captura de pantalla 7">
  <img src="assets/8.jpeg" width="150" alt="Captura de pantalla 8">
  <img src="assets/9.jpeg" width="150" alt="Captura de pantalla 9">
  <img src="assets/10.jpeg" width="150" alt="Captura de pantalla 10">
    <img src="assets/11.jpeg" width="150" alt="Captura de pantalla 11">
      <img src="assets/12.jpeg" width="150" alt="Captura de pantalla 12">
        <img src="assets/13.jpeg" width="150" alt="Captura de pantalla 13">
          <img src="assets/14.jpeg" width="150" alt="Captura de pantalla 14">
            <img src="assets/15.jpeg" width="150" alt="Captura de pantalla 15">
              <img src="assets/16.jpeg" width="150" alt="Captura de pantalla 16">
                <img src="assets/17.jpeg" width="150" alt="Captura de pantalla 17">
</div>

### 🧑🏻‍💻 Tecnologías Utilizadas


* **Kotlin:** Lenguaje de programación principal [Kotlin](https://kotlinlang.org).
* **Jetpack Compose:** Framework moderno para construir interfaces de usuario nativas en Android [Jetpack Compose](https://developer.android.com/jetpack/compose).
* **Android DataStore:** Solución de almacenamiento de datos persistente y segura [DataStore](https://developer.android.com/topic/libraries/architecture/datastore).
* **Hilt:** Librería de inyección de dependencias para Android [Hilt](https://dagger.dev/hilt/).
* **Retrofit:** Librería para realizar llamadas a la API RESTful [Retrofit](https://square.github.io/retrofit/).
* **Kotlin Coroutines y Flows:** Para la gestión de tareas asíncronas y flujos de datos [Coroutines](https://kotlin.github.io/kotlinx.coroutines/).

### Características Principales ✨

* **Autenticación de Usuarios:** Permite a los usuarios iniciar sesión de forma segura para acceder a las funcionalidades personalizadas de la aplicación.
* **Exploración y Búsqueda de Productos:** Los usuarios pueden navegar por el catálogo de productos y utilizar la función de búsqueda para encontrar artículos específicos.
* **Gestión del Carrito de Compras:** Permite agregar, eliminar y modificar la cantidad de productos en el carrito de compras.
* **Información del Cliente:** Los usuarios pueden acceder a información detallada de clientes mayoristas.
* **Información de Productos Detallada:** Muestra información completa de los productos, incluyendo detalles específicos para clientes.
* **Gestión de Ubicaciones:** Permite agregar y visualizar ubicaciones, posiblemente relacionadas con sucursales o clientes.
* **Histórico de Cotizaciones:** Los usuarios pueden consultar el historial de cotizaciones, con detalles a nivel de gerente y por visitador.
* **Interfaz de Usuario Moderna:** Desarrollada con Jetpack Compose, ofrece una interfaz de usuario nativa, reactiva y visualmente atractiva.
* **Navegación Intuitiva:** Utiliza una barra de navegación inferior para facilitar el acceso a las diferentes secciones de la aplicación, adaptándose al rol del usuario.
* **Carga de Imágenes Asíncrona:** Implementa la carga eficiente de imágenes desde la red utilizando la librería Coil, con soporte para placeholders y manejo de errores.
* **Indicadores de Carga:** Incorpora un efecto de shimmer animado y animaciones de Lottie para proporcionar una experiencia de usuario fluida durante las operaciones de carga.
* **Persistencia de Datos:** Utiliza DataStore para almacenar de forma segura datos clave de la aplicación, como el estado de inicio de sesión y el token del usuario.
* **Inyección de Dependencias:** Emplea Hilt para una gestión eficiente y organizada de las dependencias en toda la aplicación.
* **Manejo de Estados con Flows y Recursos:** Utiliza Kotlin Flows y una clase de Recurso para gestionar el estado de las operaciones de red y la presentación de datos.
* **SplashScreen Personalizada:** Implementa una pantalla de presentación para mejorar la experiencia de inicio de la aplicación.


### 🧑🏻‍💻 Documentación de la Aplicación

La documentación del código fuente de la aplicación ha sido generada utilizando **Dokka**, la herramienta de documentación para Kotlin de JetBrains. Esta documentación proporciona una visión detallada de las clases, interfaces, funciones y propiedades del proyecto, incluyendo explicaciones sobre su propósito, parámetros y valores de retorno.

**Ruta de la Documentación:** [`/docs/dokka`](./docs/dokka/index.html)

Para acceder a la documentación, navegue a la carpeta `docs/dokka` en este repositorio y abra el archivo `index.html` en su navegador web.



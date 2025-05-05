# Sanimex Gam
<img src="assets/LOGO.png" align="left" width="180" hspace="10" vspace="10" />

**Gam** Es una aplicación móvil desarrollada en Kotlin y Jetpack Compose, diseñada para facilitar la gestión de pedidos y la interacción con el catálogo de productos de Sanimex. Permite a los usuarios explorar el catálogo, buscar productos, gestionar un carrito de compras, acceder a información de clientes, visualizar ubicaciones y consultar históricos de cotizaciones, adaptándose a diferentes roles de usuario dentro de la empresa.

Disponible en Google Play.

<a href="https://play.google.com/store/apps/details?id=com.app.sanimex">
  <img
    alt="En Google Play"
    height="80"
    src="https://storage.googleapis.com/pe-portal-consumer-prod-wagtail-static/images/visual-identity_badges_880x57.max-1920x1070.format-webp.webp?X-Goog-Algorithm=GOOG4-RSA-SHA256&X-Goog-Credential=wagtail%40pe-portal-consumer-prod.iam.gserviceaccount.com%2F20250505%2Fauto%2Fstorage%2Fgoog4_request&X-Goog-Date=20250505T201825Z&X-Goog-Expires=86400&X-Goog-SignedHeaders=host&X-Goog-Signature=ab55f940738d974e37714e57382451e8e6770690e0d41d982c848248ba00d43e935ee2a60d9cc8494f3b55dfa47a73967be06d3e4f427890ca2c6807ad0f29aefbbadece7084758dfca3383263429f6fecf800431e7317de9c509210de2b501916568134a5352a80f3dc7f093b04127388faf302255e9ac95eafd9f248f4f2dfc6a9b5ba9fef9c382e3e3fd0cd7e1b5d7ec3593a48a1a09f9f4b6d2ba3d4c44a0c129841724d6182bfe5528a43e3dd4c64733261854fd9652c46caf55e22d87eda441d5ab63667840d8235beb15f563eab5ccf922d01410b31ce5a8d85e890a08a86d8f65d61618b4151ed73737c4c00b1eb0b11526b7111c75f05a62f3c219b"/>
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

### 🧑🏻‍💻 Documentación de la Aplicación

La documentación del código fuente de la aplicación ha sido generada utilizando **Dokka**, la herramienta de documentación para Kotlin de JetBrains. Esta documentación proporciona una visión detallada de las clases, interfaces, funciones y propiedades del proyecto, incluyendo explicaciones sobre su propósito, parámetros y valores de retorno.

**Ruta de la Documentación:** [`GAM/dokka/html`](dokka/html)

Para acceder a la documentación, navegue https://davidretur.github.io/DocumentacionGam.github.io/ en su navegador web.

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






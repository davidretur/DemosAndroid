# Sanimex Gam
<img src="assets/icon.webp" align="left" width="180" hspace="10" vspace="10" />

**Gam** Es una aplicación móvil desarrollada en Kotlin y Jetpack Compose, diseñada para facilitar la gestión de pedidos y la interacción con el catálogo de productos de Sanimex. Permite a los usuarios explorar el catálogo, buscar productos, gestionar un carrito de compras, acceder a información de clientes, visualizar ubicaciones y consultar históricos de cotizaciones, adaptándose a diferentes roles de usuario dentro de la empresa.

Disponible en Google Play.

<a href="https://play.google.com/store/apps/details?id=com.app.sanimex">
  <img
    alt="En Google Play"
    height="80"
    src="https://storage.googleapis.com/pe-portal-consumer-prod-wagtail-static/images/visual-identity_badges_880x57.max-1920x1070.format-webp.webp?X-Goog-Algorithm=GOOG4-RSA-SHA256&X-Goog-Credential=wagtail%40pe-portal-consumer-prod.iam.gserviceaccount.com%2F20250505%2Fauto%2Fstorage%2Fgoog4_request&X-Goog-Date=20250505T184657Z&X-Goog-Expires=86400&X-Goog-SignedHeaders=host&X-Goog-Signature=55e4bcaed3f2f65088d7e2f88a85c54198ee4131f4f22919e0fae7df300a5a5cd62a9949b4c399533ceee914f40d497e530332037ff0da8a34dcecc0a3b781f4cef5d829b650aeef3b6899c83242484e6ccf2b4462c86ad3f7a9623a606fc68f6eb3caa97466bf7bdcf862120d423e0c9ff9c7b5f67001ecc5a37d64724c509ccc3da5b1563191f3e3b7daeedd802cc00e78a57ee9e5a5591b0b3a6a50b28e1103682963d6cc9498373627de54202cadfd9d1920aec7b1c0a5acd9474162756141091395fc6afa03cab523016395320a2652b7e81e9db5cdf1da9a01ef6726a0b50539968b48ba9ef6b3588eddef23ccd64bab30cd3e3862e2301961698f9a25"/>
</a>

## Screenshots

<div>
   <img src="assets/1.jpg" width="150" alt="Captura de pantalla 1">
   <img src="assets/2.jpg" width="150" alt="Captura de pantalla 2">
   <img src="assets/3.jpg" width="150" alt="Captura de pantalla 3">
    <img src="assets/4.jpg" width="150" alt="Captura de pantalla 4">
    <img src="assets/5.jpg" width="150" alt="Captura de pantalla 5">
  <img src="assets/6.jpg" width="150" alt="Captura de pantalla 6">
  <img src="assets/7.jpg" width="150" alt="Captura de pantalla 7">
  <img src="assets/8.jpg" width="150" alt="Captura de pantalla 8">
  <img src="assets/9.jpg" width="150" alt="Captura de pantalla 9">
  <img src="assets/10.jpg" width="150" alt="Captura de pantalla 10">
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



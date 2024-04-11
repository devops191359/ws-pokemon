# ws-pokemon
Service Soap for consume pokemon data


Para poder ejecutar este código primero deberá clonar en su pc el repositorio con el siguiente comando:

#git clone https://github.com/devops191359/ws-pokemon.git

Para compilar y ejecutar dicho web service deberá instalar el java jdk 17

Una vez clonado o descargado el código en su PC deberá importar el proyecto o servuicio web en un entorno de desarrollo Eclipse o Spring Tool Siute versión 4 en adelante o puede ejecutar el web service usando el siguiente comando desde el cmd estando sobre la carpeta del proyecto: 

#mvn spring-boot:run


Se debe de agregar esta variable de entorno a la PC 

![image](https://github.com/devops191359/ws-pokemon/assets/16689291/5dc9adcd-e087-45e2-a2ae-df75e0af1bfc)


Una vez cumplido con lo anterior debera importar el archivo pokemon.wsdl a la herramienta SoapUi para realizar el consumo del web service

![image](https://github.com/devops191359/ws-pokemon/assets/16689291/f960f5eb-9e42-455e-b0a3-6fffcb6d202a)


Nota: El archivo pokemon.wsdl se encuentra a nivel de  la  carpeta del proyecto.


##EJEMPLO PRUEBA DE CONSUMO CON HERRAMIENTA SOAP UI

Para todos los métodos siempre te pedirá el nombre del pokemon por lo cual te comparto un ejemplo de como consumir el web service desde soap ui

![image](https://github.com/devops191359/ws-pokemon/assets/16689291/d50c57d0-cb91-4300-a2a2-fe24e133f0f5)


##VERIFICAR TRABAILIDAD DE BITACORA EN BASE DE DATOS H2

Para verificar la trazabilidad o bitácora de las transacciones desde la BD de H2 deberás acceder a la liga http://localhost:8080/h2-console/login.jsp?jsessionid=d392b4350f826e765a87d9c801bf0ba8 en la cual deberás ingresar las siguientes cedenciales y cadena de conexión coimo se muestra a continuación:

##Datasource

url: jdbc:h2:mem:pokemon

username: sa

password: password

![image](https://github.com/devops191359/ws-pokemon/assets/16689291/8cdaa4fb-ba9a-4e29-98c9-ae1640d24474)

Una vez que realices la conexion te aparecerá una pantalla en donde podrás realizar las instrucciones sql de coonsulta para validar que en la tabla  TA_BITACORA valides que se muestre la información de la bitácora como se muestran en las figuras :

![image](https://github.com/devops191359/ws-pokemon/assets/16689291/e4af2036-af4c-467f-ae4c-5b9c0a56569d)


![image](https://github.com/devops191359/ws-pokemon/assets/16689291/fcccb903-7092-4a46-85ec-525510d85779)












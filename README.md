@brief Este proyecto lleva a cabo la gestión de un sistema de empleados, contiene multiples funcionalidades que se integran ya en el programa principal además de incluir librerías que nos ayudaran en el desarrollo de la aplicación.
Contemplando la estructura del código, nos topamos con una elegante pantalla al inicio de la aplicación, la cual nos reedirigira a lo que sera la ventana en la que el usuario tendra que ingresar sus credenciales para proseguir con el funcionamiento de la aplicaión.
Una verificado que los datos del usuario son los correctos, se le reedirigira a la ventana principal para llevar la gestión de los empleados.

src/employee.management.system 🗂️
Archivos anezados en la carpeta. Nota: Seguir la documentación.

src/libraries 📚
1. jcalendar-tz-1.3.3-4.jar. Esta lirbería nos proporciona la función para cuando ingresamos el formato de la fecha de nacimiento, añadiendole un toque más elegante y clásico.
2. mysql-connector-java-8.0.28.jar. Librería para conectar nuestra base de datos de MySQL con nuestra aplicación.
3. ResultSet2xml.jar. Esta librería implementa la función para imprimir la lista de los empleados. (opcional)
   
src/icons 🖼️
Los iconos representan un papel fundamental para el diseño y estética de nuestra aplicación.

Consola MySQL. 
show databases;
use employeemanagementsystem;
create table login(username varchar(32), password varchar(32));
select * from login;
insert into login values('root', '12345678');
create table employee(name varchar(32), lname varchar(32), dob varchar(32), salary varchar(32), address varchar(64), phone varchar(16), email varchar(32), education varchar(32), designation varchar(32), curp varchar(32), empID varchar(16));
select * from employee;


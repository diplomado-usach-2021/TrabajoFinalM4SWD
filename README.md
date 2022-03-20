# Getting Started

## Window
### Compile Code
* ./mvnw.cmd clean compile 

### Test Code
* ./mvnw.cmd clean test 

### Jar Code
* ./mvnw.cmd clean package 


## Linux

### Compile Code
* ./mvnw clean compile 

### Test Code
* ./mvnw clean test 

### Jar Code
* ./mvnw clean package 


### Jar Code URL Microservicio
*  localhost:8080/rest/msdxc/dxc
*  parametros del form data : sueldo y ahorro 

### Calculo impuesto
* si la suma del 10% + el sueldo es menor que 4 millones no se cobra impuesto y si es mayor o igual se cobra un 10% al retiro.
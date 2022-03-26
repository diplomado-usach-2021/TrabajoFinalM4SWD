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
*  localhost:8081/rest/msdxc/dxc
*  parametros del form data : sueldo y ahorro 

Ejemplo:  
```
curl -X GET -F sueldo=2000000 -F ahorro=40000000 localhost:8081/rest/msdxc/dxc
```


### Calculo impuesto
* si la suma del 10% + el sueldo es menor que 4 millones no se cobra impuesto y si es mayor o igual se cobra un 10% al retiro mas el 10 % sueldo.

# Using Docker to test this app.
⚠️ **Is mandatory to use Powershell in Windows**
## Docker in Windows
```bash
### Compile Code
docker run -it --rm -v ${pwd}:/code --workdir /code maven mvn clean compile

### Test Code
docker run -it --rm -v ${pwd}:/code --workdir /code maven mvn clean test

### Jar Code
docker run -it --rm -v ${pwd}:/code --workdir /code maven mvn clean package

### Run Jar
docker run -it --rm -p 8081:8081 -v ${pwd}:/code --workdir /code maven mvn spring-boot:run
```
## Docker in Linux
```bash
### Compile Code
docker run -it --rm -v $(pwd):/code --workdir /code maven mvn clean compile

### Test Code
docker run -it --rm -v $(pwd):/code --workdir /code maven mvn clean test

### Jar Code
docker run -it --rm -v $(pwd):/code --workdir /code maven mvn clean package

### Run Jar
docker run -it --rm -p 8081:8081  -v $(pwd):/code --workdir /code maven mvn spring-boot:run
```
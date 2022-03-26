# Getting Started
Requisitos Previos:
- Tener instalado docker en la maquina
- Si es con Docker, tener la capacidad de correr docker dentro del jenkins-container y montar el mismo path de jenkins home (`-v /var/jenkins_home/:/var/jenkins_home/`)  

## Correr pipeline en Jenkins
Crear un pipeline JOB y en la seccion de Pipeline configurar:
1. Pipeline script from SCM
2. SCM -> Git -> Repository URL=`https://github.com/diplomado-usach-2021/TrabajoFinalM4SWD.git`
3. Branches to build = main
## Jar Code URL Microservicio
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
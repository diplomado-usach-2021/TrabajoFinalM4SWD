pipeline {
    agent any

    stages {
        stage('git clone') {
            steps {
                sh 'echo "cleaning workspace" && rm -rf $(pwd)/* && git clone https://github.com/diplomado-usach-2021/TrabajoFinalM4SWD.git . '
            }
        }

        stage('Compile') {
            steps {
                sh "./mvnw clean compile"
            }
        }

        stage('test') {
            steps {
                sh "./mvnw clean test"
            }
        }

        stage('Package') {
            steps {
                sh "./mvnw clean package"
            }
        }

        stage('Run & Newman testing') {
            steps {
                sh '''
                    nohup ./mvnw spring-boot:run && /
                    newman run dxc.postman_collection.json && /
                    echo "Newman test OK, killing the java proccess" && /
                    kill -9 `jps | grep "DevopsApplication" | cut -d " " -f 1`
                '''
            }
        }
        
        stage('Test Selenium') {
            steps {
                sh "echo 'Aca van los selenium test'"
            }
        }
    }
}
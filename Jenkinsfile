pipeline {
    agent any

    stages {

        stage('Compile') {
            steps {
                sh "./mvnw -Dmaven.repo.local=.m2 clean compile"
            }
        }

        stage('test') {
            steps {
                sh "./mvnw -Dmaven.repo.local=.m2 clean test"
            }
        }

        stage('Package') {
            steps {
                sh "./mvnw -Dmaven.repo.local=.m2 clean package"
            }
        }

        stage('Run & Newman testing') {
            steps {
                sh '''
                    nohup ./mvnw -Dmaven.repo.local=.m2 spring-boot:run &
                    sleep 30
                    newman run dxc.postman_collection.json || kill -9 `jps | grep "DevopsApplication" | cut -d " " -f 1` && exit 1
                    echo "Newman tests OK"
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
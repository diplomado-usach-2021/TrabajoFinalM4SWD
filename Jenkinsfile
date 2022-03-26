pipeline {
    agent any

    stages {

        stage('Build API') {
            steps {
                sh 'docker build -f Dockerfile-api -t finalm4-api .'
            }
        }

        stage('Build Frontend') {
            steps {
                sh 'docker build -f Dockerfile-frontend -t finalm4-frontend .'
            }
        }

        stage('Run API & Front') {
            steps {
                sh '''
                    docker network create --driver bridge app_running || true
                    docker run --rm -d --network app_running --name api-running -p 8081:8081 finalm4-api
                    sleep 10
                    docker run --rm -d --name frontend-running -p 3000:3000 finalm4-frontend
                '''
            }
        }

        stage('Newman testing') {
            steps {
                script {
                    try {
                        sh '''
                            docker run --network=host --rm -v $(pwd):/code --workdir /code postman/newman run dxc.postman_collection.json
                            echo "Newman test OK"
                        '''
                    }
                    catch (all) {
                        echo "Fallaron los newman-test, deteniendo los contenedores"
                        sh '''
                            docker stop api-running || echo "No esta corriendo api-running"
                            docker stop frontend-running || echo "No esta corriendo frontend-running"
                            exit 1
                        '''
                    }
                }
                
            }
        }

        stage('UnitTest && Selenium') {
            steps {
                echo "Levantando selenium chrome-driver in docker"
                sh 'docker run -d -p 4444:4444 --shm-size="2g" --name chromedriver selenium/standalone-chrome:4.1.2-20220317'
                echo "Comenzando Selenium test"
                script {
                    try {
                        sh '''
                            docker run --network=host --rm finalm4-api mvn clean test
                            echo "Test OK, deteniendo chromedriver"
                            docker rm -f chromedriver | echo "No esta corriendo chromedriver"
                        '''
                    }
                    catch (all) {
                        echo "Fallaron los newman-test, deteniendo los contenedores"
                        sh '''
                            docker rm -f chromedriver | echo "No esta corriendo chromedriver"
                            exit 1
                        '''
                    }
                }
            }
        }

        stage('Stop API & Front') {
            steps {
                sh '''
                    docker stop api-running || echo "No esta corriendo api-running"
                    docker stop frontend-running || echo "No esta corriendo frontend-running"
                    docker network rm app_running || true
                '''
            }
        }
    }
}
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './mvnw clean build -Pansible'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
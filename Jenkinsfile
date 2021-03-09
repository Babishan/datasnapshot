pipeline {
    agent any
    stages {
        stage('Clean') {
            steps {
                sh './mvnw clean -Pansible'
            }
        }
        stage('Build') {
            steps {
                sh './mvnw package -Pansible'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                sh './mvnw deploy -Pansible'
            }
        }
    }
}
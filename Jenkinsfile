pipeline {
    agent any
    stages {
        stage('Clean') {
            steps {
                sh './mvnw clean -Pansible'
                echo 'Clean'
            }
        }
        stage('Build') {
            steps {
                sh './mvnw compile -Pansible'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw test -Pansible'
            }
        }
        stage('Deploy') {
            steps {
              sh './mvnw test -Pansible'
            }
        }
    }
}

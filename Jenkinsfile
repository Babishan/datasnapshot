pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './mvnw clean package -Pansible'
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
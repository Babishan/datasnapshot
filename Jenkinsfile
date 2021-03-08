pipeline {
    agent any

    tools {
    maven 'Maven 3.8'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean build -Pansible'
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
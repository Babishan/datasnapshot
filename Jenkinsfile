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
                 echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
               echo 'Deploying..'
            }
        }
    }
}
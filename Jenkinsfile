pipeline {
    agent any
    stages {
        stage('prepare') {
            steps {
                sh './mvnw clean -Pansible'
                echo $JAVA_HOME
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
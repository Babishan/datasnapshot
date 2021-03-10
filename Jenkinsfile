pipeline {
    agent any
    environment {
        JAVA_HOME='/usr/lib/jvm/default-java'
    }
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
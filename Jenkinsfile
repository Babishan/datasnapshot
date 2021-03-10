pipeline {
    agent any
    stages {
        def JAVA_HOME='/usr/lib/jvm/default-java'
        def ANSIBLE_DIR=$GITHUB_WORKSPACE/ansible
        stage('prepare') {
            steps {
                sh './mvnw clean -Pansible'
                echo $ANSIBLE_DIR
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

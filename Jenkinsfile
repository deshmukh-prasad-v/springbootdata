pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }

        stage('Deploy') {
            steps {
                bat """
                copy /Y target\\*.jar C:\\deployments\\app.jar
                """
            }
        }
    }
}

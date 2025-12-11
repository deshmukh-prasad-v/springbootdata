pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }

        stage('Deploy') {
            steps {
                sshagent(['ssh-cred-id']) {
                    sh '''
                        scp target/*.jar user@server:/opt/app/app.jar
                        ssh user@server "systemctl restart myapp"
                    '''
                }
            }
        }
    }
}

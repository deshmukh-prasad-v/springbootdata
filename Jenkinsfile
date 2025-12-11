pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/deshmukh-prasad-v/springbootdata.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
                bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                bat 'mvn test'
            }
        }
        stage('Archive') {
            steps {
                echo 'Archiving...'
                archiveArtifacts artifacts: 'target\\*.jar', fingerprint: true
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
    post {
        always {
            echo 'Pipeline finished'
        }
    }
}
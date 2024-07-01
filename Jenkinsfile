/* Requires the Docker Pipeline plugin */
pipeline {
    agent { label { image 'maven:3.9.8-eclipse-temurin-21-alpine' } }
    stages {
        stage('build') {
            steps {
                sh 'java -version'
                sh 'echo I made a second step!'
            }
        }
    }
}
pipeline {
    agent any
    tools {
        maven 'Maven 3.8.1' // Adjust to your Maven version
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build and Test') {
            steps {
                sh 'mvn clean verify'
            }
        }
        stage('Code Coverage') {
            steps {
                jacoco execPattern: '**/target/jacoco.exec',
                       classPattern: '**/target/classes',
                       sourcePattern: '**/src/main/java',
                       exclusionPattern: ''
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
        success {
            script {
                def currentCoverage = jacoco().instructionCoverage
                def previousCoverage = currentBuild.previousBuild?.getAction(hudson.plugins.jacoco.JacocoBuildAction)?.instructionCoverage ?: 0
                if (currentCoverage <= previousCoverage) {
                    error "Code coverage did not improve! Current: ${currentCoverage}%, Previous: ${previousCoverage}%"
                }
            }
        }
    }
}
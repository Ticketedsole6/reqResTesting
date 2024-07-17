pipeline {
    agent any

    stages {
        stage('Run Tests') {
            steps {
                withMaven(maven: 'maven3.9.7') {
                    bat "mvn clean verify"
                }
            }
        }
        stage('Publish Reports') {
            steps {
                script {
                    if (currentBuild.currentResult == 'SUCCESS') {
                        currentBuild.result = "SUCCESS"
                    } else {
                        currentBuild.result = "FAILED"
                        }
                    publishReport()
                }
            }
        }
    }
}

def publishReport() {
    publishHTML(target: [
        reportName: 'SerenityReport',
        reportDir: 'target/site/serenity',
        reportFiles: 'index.html',
        keepAll: true,
        alwaysLinkToLastBuild: true,
        allowMissing: false
    ])
}
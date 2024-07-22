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

    post {
        always {
            cleanWs()
        }
    }
}

def publishReport() {
    publishHTML(target: [
        reportName: 'Serenity Report',
        reportDir: 'target/site/serenity',
        reportFiles: 'index.html',
        keepAll: true,
        alwaysLinkToLastBuild: true,
        allowMissing: false
    ])
}

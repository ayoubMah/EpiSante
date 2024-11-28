pipeline {
    agent { label 'Back-agent' }
    tools {
        maven 'maven'
        jdk 'jdk21'
    }
    environment {
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-amd64'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/Anir-sadiqui/Sirius-back.git/'
            }
        }
        stage('Install') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Build') {
            steps {
                sh 'pwd && mvn package'
            }
        }
        stage('Deploy to Prod') {
            steps {
                sh 'echo m6 | sudo -S systemctl restart runBack.service'
            }
        }
       stage('Deploy to Server') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'ssh-credentials-id', passwordVariable: 'PASSWORD', usernameVariable: 'USER')]) {
                        sh '''
                        sshpass -p "$PASSWORD" ssh -o StrictHostKeyChecking=no $USER@172.31.250.60
                        '''
                    }
        }
    }
    }
    }
}
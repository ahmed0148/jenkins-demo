pipeline {
    agent any

    stages {
        stage ('Compile Stage') {
stage('Test') {
    steps {
        sh "chmod +x -R ${env.WORKSPACE}"
        sh './jenkins/test.sh'
    }
            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn deploy'
                }
            }
        }
    }
}
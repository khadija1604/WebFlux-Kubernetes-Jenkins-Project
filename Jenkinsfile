pipeline {
  agent any
  stages {

    stage('Mvn package') {
      // Define maven home and build project
      steps {
      script{
                 def mvnHome = tool name: 'Maven',
        type: 'maven'
        withEnv(["MVN_HOME=$mvnHome"]) {
          sh '"$MVN_HOME/bin/mvn" clean package -DskipTests'
        } 
      }
      }
    }

    stage('Create docker image') {
      steps {
        sh 'docker build -t khadijadev/flowers-app:v1.0.0 .'
      }

    }

    stage('Push docker image') {
      steps {
        withCredentials([string(credentialsId: 'docker-p', variable: 'dockerpwd')]) {
          sh "docker login -u khadijadev -p ${dockerpwd}"
          sh 'docker push khadijadev/flowers-app:v1.0.0'
        }
      }

    }

    stage('Deploy on kubernetes') {
      steps {
        script {
              withCredentials([string(credentialsId: 'token', variable: 'k8s_jenkins-token')]) {
                           try {
                                  sh "kubectl create -f *.yml --token $k8s_jenkins-token"
                           } catch(error) {
                                  sh "kubectl apply -f *.yml --token $k8s_jenkins-token"
                           }
               }


        }

      }

    }

  }
}
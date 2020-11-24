pipeline {
    stages {
    
        stage('Mvn package'){
      // Define maven home and build project
        steps{
               def mvnHome = tool name: 'Maven', type: 'maven'
           withEnv(["MVN_HOME=$mvnHome"]) {
                sh '"$MVN_HOME/bin/mvn" clean package' 
           }

        }
        }
        
        stage('Create docker image'){
          steps{
          sh 'docker build -t khadijadev/flowers-app:v1.0.0 .'
           }
            
        }
        
        stage('Push docker image'){
          steps{
             withCredentials([string(credentialsId: 'docker-p', variable: 'dockerpwd')]) {
              sh "docker login -u khadijadev -p ${dockerpwd}"
              sh 'docker push khadijadev/flowers-app:v1.0.0'
              }
            }
           
        }
        
        stage('Deploy on kubernetes'){
        steps{
           script{
              try{
                 sh 'kubectl create -f *.yml' 
              }catch(error){
                  sh 'kubectl apply -f *.yml' 
              }

           }
 
        }

        }

    }
    }

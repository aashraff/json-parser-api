pipeline {
  agent any

  environment {
    CI = 'jenkins'
    DOCKER_COMPOSE_PROJECT_NAME = sh(returnStdout: true, script: "git rev-parse --verify HEAD").trim()
  }

  stages {
    stage('Build') {
      steps {
        echo "Compiling..."
        sh "${tool name: 'sbt', type:'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt clean compile"
      }
    }
    stage('Unit Test') {
      steps {
        echo "Testing..."
        sh "${tool name: 'sbt', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt test"
        sh "${tool name: 'sbt', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt scalastyle"
      }
    }
    stage('Docker Publish') {
      steps {
        echo "Publishing docker image..."
        sh "${tool name: 'sbt', type: 'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt docker:publishLocal"
      }
    }
    stage('Docker Test') {
      steps {
        echo "Testing Docker image"
        sh "./docker-tests.sh $PWD"
      }
    }    
  }
}



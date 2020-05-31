node {
    stage("Build & test") {
        def mvnHome = tool 'MAVEN_HOME'
        git 'https://github.com/vicsmr/jenkins-test.git'
        sh "'${mvnHome}/bin/mvn' clean package"
        sh "'${mvnHome}/bin/mvn' verify sonar:sonar"
    }
    stage('Post') {
        archive 'target/*.jar'
        junit 'target/surefire-reports/*.xml'
    }
}
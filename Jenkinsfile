node {
    stage("Build & test") {
        def mvnHome = tool 'MAVEN_HOME'
        sh "'${mvnHome}/bin/mvn' clean package"
    }
    stage('Post') {
        archive 'target/*.jar'
        junit 'target/surefire-reports/*.xml'
    }
}
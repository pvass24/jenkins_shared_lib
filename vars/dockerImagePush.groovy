// def call(String project, String ImageTag, String hubUser){
//     withCredentials([usernamePassword(
//             credentialsId: "docker",
//             usernameVariable: "USER",
//             passwordVariable: "PASS"
//     )]) {
//         sh "docker login -u '$USER' -p '$PASS'"
//     }
//     sh "docker image push ${hubUser}/${project}:${ImageTag}"
//     sh "docker image push ${hubUser}/${project}:latest"   
// }


// def call(String aws_account_id, String region, String ecr_repoName){
//    
//    sh """
//     aws ecr get-login-password --region ${region} | docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
//     docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
//    """
// }

def call(String aws_account_id, String region, String ecr_repoName) {
    def awsEcrLoginCommand = "aws ecr get-login-password --region ${region}"
    def dockerLoginCommand = "docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com"

    def dockerPushCommand = "docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest"

    def awsEcrLoginOutput = sh(script: awsEcrLoginCommand, returnStdout: true).trim()
    sh(script: "echo '${awsEcrLoginOutput}' | ${dockerLoginCommand}", returnStatus: true)

    sh(script: dockerPushCommand, returnStatus: true)
}


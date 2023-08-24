 def call(String aws_account_id, String region, String ecr_repoName) {
    withAWS('region': region) {

    def awsEcrLoginCommand = "aws ecr get-login-password --region ${region}"
    def dockerLoginCommand = "docker login --username AWS --password-stdin ${aws_account_id}.dkr.ecr.${region}.amazonaws.com"

    def dockerPushCommand = "docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest"

    def awsEcrLoginOutput = sh(script: awsEcrLoginCommand, returnStdout: true).trim()
    sh(script: "echo '${awsEcrLoginOutput}' | ${dockerLoginCommand}", returnStatus: true)

    sh(script: dockerPushCommand, returnStatus: true)
         
    }
}

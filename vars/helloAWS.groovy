def call(String myRole, String region, String aws_account_id, Integer myDuration  ){
    def myRole = "valid AWS role name" <- last part of valid AWS Arn
    def region = "valid AWS region" <- useful for other AWS functions but not needed for role assumption
    def aws_account_id = "valid AWS account number"
    def myDuration = 3600 <- limit to 1 hour
    withAWS(role: ${myRole}, region: ${region}, roleAccount: ${aws_account_id}, duration: ${myDuration} ) {
         sh 'aws s3 ls'
    }
}

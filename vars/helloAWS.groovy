def call(String myRole, String region, String aws_account_id, Integer myDuration) {
    withAWS(role: myRole, 'region': region, roleAccount: aws_account_id, duration: myDuration) {
         sh 'aws s3 ls'
    }
}

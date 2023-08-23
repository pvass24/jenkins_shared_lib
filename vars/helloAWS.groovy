def call(String region){
    withAWS('region':region) {
         sh 'aws s3 ls'
    }
}


myRole = "valid AWS role name" <- last part of valid AWS Arn
myRegion = "valid AWS region" <- useful for other AWS functions but not needed for role assumption
myRoleAccount = "valid AWS account number"
myExternalId = "if role has externalId set, include it here"
myDuration = 3600 <- limit to 1 hour

WithAWS(role: myRole, region: myRegion, roleAccount: myRoleAccount, externalId: myExternalId, duration: myDuration ){
  some groovy code
}

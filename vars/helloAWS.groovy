def call(String region){
    withAWS('region':region) {
         sh 'aws s3 ls'
    }
}

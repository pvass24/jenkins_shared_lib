def call(){
    
withAWS(region: 'us-east-1') {
    sh 'aws s3 ls'
}

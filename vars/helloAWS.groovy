def call(){

    withAWS(region:region) {
         sh 'aws s3 ls'
    }
}

FROM payara/micro:5.184
COPY ./target/testing.war $DEPLOY_DIR

echo 'Run java web application'

BASE_PATH=/var/www/book-aws-study
BUILD_PATH=$(ls $BASE_PATH/build/libs/*.jar)
JAR_NAME=$(basename "$BUILD_PATH")
echo "> build 파일명: $JAR_NAME"
nohup java -jar "$BUILD_PATH" > $BASE_PATH/nohup.out 2>&1 &

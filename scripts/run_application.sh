echo 'Run java web application'

BASE_PATH=/var/www/book-aws-study
BUILD_PATH=$(ls $BASE_PATH/build/libs/*.jar)

nohup java -jar "$BUILD_PATH" $BASE_PATH/nohup.out  /dev/null 2> /dev/null < /dev/null &

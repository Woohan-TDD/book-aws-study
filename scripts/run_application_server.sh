echo '======================'
echo 'Running restart_server'
echo '======================'

BASE_PATH=/var/www/aws-exercise-a
BUILD_PATH=$(ls $BASE_PATH/build/libs/*.jar)
JAR_NAME=$(basename "$BUILD_PATH")
echo "> build 파일명: $JAR_NAME"
nohup java -jar "$BUILD_PATH" > $BASE_PATH/nohup.out 2>&1 &
echo '============================'
echo 'Running install_dependencies'
echo '============================'

source /home/ec2-user/.bash_profile
cd /var/www/aws-exercise-a
./gradlew clean build
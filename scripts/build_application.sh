echo 'Build java web application'

source /home/ubuntu/.bash_profile
cd /var/www/book-aws-study
./gradlew clean build

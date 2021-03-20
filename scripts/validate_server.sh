echo '======================='
echo 'Running validate_server'
echo '======================='

for retry_count in {1..10}
do
  response=$(curl -s http://localhost/health)
  ok_count=$(echo "$response" | grep 'ok' | wc -l)

  if [ "$ok_count" -ge 1 ]
  then
      echo "> Health check 성공"
      break
  else
      echo "> Health check의 응답을 알 수 없거나 혹은 status가 OK가 아닙니다."
      echo "> Health check: ${response}"
  fi

  if [ $retry_count -eq 10 ]
  then
    echo "> Health check 실패. "
    echo "> 배포를 종료합니다."
    exit 1
  fi

  echo "> Health check 연결 실패. 재시도..."
  sleep 10
done
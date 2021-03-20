echo 'Check Application health'

result=$(curl -s -o /dev/null -w "%{http_code}" http://localhost/health)

echo Check http://127.0.0.1/health
echo $result

if [[ "$result" =~ "200" ]]; then
  exit 0
else
  exit 1
fi

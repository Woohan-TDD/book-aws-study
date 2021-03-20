echo '======================'
echo 'Running restart_server'
echo '======================'

service nginx restart
IDLE_PID=$(pgrep -f around)
kill -15 "$IDLE_PID"
sleep 5
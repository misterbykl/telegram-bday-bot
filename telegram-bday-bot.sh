#!/usr/bin/env bash
case $1 in
	    start)
        	    echo "Telegram bday bot is starting..."
                nohup target/telegram-bday-bot  1>/srv/telegram-bday-bot/InfoLog.log 2>/srv/telegram-bday-bot/ErrorLog.log &
                echo $! > BDay.pid
                ;;
        stop)
                echo "Stopping..."
                PID=`cat BDay.pid`
                kill $PID
                ;;
        restart)
                echo "Restarting..."
                $0 stop
                sleep 1
                $0 start
                ;;
        *)
                echo "Use: $0 <start|stop|restart>"
                exit 1
 esac
#!/bin/bash
rootPath=$1
nginxVersion=1.19

# Check nginx config
docker run --rm -t -a stdout --name reverse -v ${rootPath}/config/:/etc/nginx/:ro nginx:$nginxVersion nginx -c /etc/nginx/nginx.conf -t && nginx -v

if [ $? -ne 0 ]; then
    echo NGINX tests FAILED
    exit 1
else
    echo NGINX tests PASS
    exit 0
fi


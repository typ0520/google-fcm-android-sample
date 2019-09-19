#!/usr/bin/env sh

curl -X POST \
  https://fcm.googleapis.com/fcm/send \
  -H 'Authorization: key=AIzaSyDdjjtv-VKe-LRDoFb4l50uHY1iQq2ESMc' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 13c23a37-a92d-4ebd-9840-f68968e9653d' \
  -H 'cache-control: no-cache' \
  -d '{
    "to":"eaaBy7iq3A4:APA91bFETHN8g6OfeV0euU1FAyRtF3ifiDWOrb7j0btTktcdW4E9-3P7L2jWzNMqDY2-wAECosvbI9y44r08jxef6vqUGiIjNeRXt6HY9l_b3azvTU9iGBV9kJNGRr8fZHvffcQmhoZb",
    "notification":{
      "title":"666",
      "body":"great match!",
      "click_action":"UBX_OPEN_ACTIVITY_ROUTER"
    },
    "data" : {
	  "isFromPush" : true,
	  "payload" : "http://www.ubuu.top"
    }
}'
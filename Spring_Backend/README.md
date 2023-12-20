
# DMRS backend

the project is using:
- Spring Boot
- MongoDB
- MailDev (to test the sending mails)


## Installation

you need:
- intellij
- docker
- postman (just if you want to test the endpoints)
- node (if you have it, or you can use docker instead)

#### Install MailDev for sending mails

if you have node installed:
```bash
  npm install -g maildev
```

if you don't have node you can use docker:

```
 $ docker run -p 1080:1080 -p 1025:1025 maildev/maildev
```
## Run Locally


#### Start the Mail server
you just need to run this command after installation in any cmd

```bash
  maildev
```

#### Start the MongoDB docker image 
the image is existing in this directory in the name of "docker-compose.yaml"

to start it you just open the cmd in this directory and run:
```
docker-compose.yaml up -d
```

if it doesn't work you can start it from intellij, but you have to install the docker plugin as following:
from File -> Settings -> Plugins -> Marketplace then search for docker. then you can open the file on intellij, and the green run arrow will appear, and you can start the database.

you can then run the Mongo Express on any explorer run:
```
http://localhost:8081
```
username: root 
>password: pass



#### Run the application from intellij
simply run the app. but NOTE that the app is running on port 8082 NOT 8080





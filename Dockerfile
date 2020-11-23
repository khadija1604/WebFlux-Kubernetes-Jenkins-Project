FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/flowers.jar flowers-app.jar
ENTRYPOINT [ "java","-jar" , "flowers-app.jar"]
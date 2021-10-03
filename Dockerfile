FROM openjdk:8
EXPOSE 8080
ADD target/address-book.jar address-book.jar
ENTRYPOINT ["java","-jar","/address-book.jar"]
# bankingAPP


http://spingboothelloword-env.eba-pnpiwrah.us-east-2.elasticbeanstalk.com/
 
 ##########################################################################
 To start up the server, execute ./mvnw spring-boot:run
 To run the test, execute ./mvnw clean test

 ##########################################################################
 This API contains two endpoint: /enquire(GET) and /sendMoney(POST):
 
 1)Enquire:
 http://spingboothelloword-env.eba-pnpiwrah.us-east-2.elasticbeanstalk.com/enquire
 
 Sample request:
          Headers = [Content-Type:"application/json;charset=UTF-8", Content-Length:"15"]
             Body = {"accountId":1}

Sample Response:
        Headers = [Content-Type:"application/json"]
             Body = {"account":{"id":1,"name":"Nelson Chan","balance":123.00},"transactions":[],"responseCode":"000"}

 
 2)SendMoney:
 http://spingboothelloword-env.eba-pnpiwrah.us-east-2.elasticbeanstalk.com/sendMoney
 
 Sample Request:
          Headers = [Content-Type:"application/json;charset=UTF-8", Content-Length:"44"]
             Body = {"senderId":2,"amount":300.3,"receiverId":1}
             
 Sample Response:
           Headers = [Content-Type:"application/json"]
            Body = {"senderId":2,"receiverId":1,"amount":300.3,"responseCode":"000"}
 
 
 
 
 
 
 

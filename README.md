# SimpleRESTAPI


http://spingboothelloword-env.eba-pnpiwrah.us-east-2.elasticbeanstalk.com/
 
Sample Endpoint
 This API contains different endpoint
 
 1)Enquire(GET):
 
 Enquire the account balance and list all related transactions
 
 http://spingboothelloword-env.eba-pnpiwrah.us-east-2.elasticbeanstalk.com/enquire
 or
 http://spingboothelloword-env.eba-pnpiwrah.us-east-2.elasticbeanstalk.com/enquire/{id}
 
 Sample request:
          Headers = [Content-Type:"application/json;charset=UTF-8", Content-Length:"15"]
             Body = {"accountId":1}

Sample Response:
        Headers = [Content-Type:"application/json"]
             Body = {"account":{"id":1,"name":"Nelson Chan","balance":123.00},"transactions":[],"responseCode":"000"}

 
 2)SendMoney(POST): Send money from one account to another
 
 http://spingboothelloword-env.eba-pnpiwrah.us-east-2.elasticbeanstalk.com/sendMoney
 
 Sample Request:
          Headers = [Content-Type:"application/json;charset=UTF-8", Content-Length:"44"]
             Body = {"senderId":2,"amount":300.3,"receiverId":1}
             
 Sample Response:
           Headers = [Content-Type:"application/json"]
            Body = {"senderId":2,"receiverId":1,"amount":300.3,"responseCode":"000"}
 
 
 3) Create(POST)
      http://spingboothelloword-env.eba-pnpiwrah.us-east-2.elasticbeanstalk.com/create
      name and balance as attribute.
      used by simple request client
      http://sendrequestclient.us-east-2.elasticbeanstalk.com/create.html
      
 4) Get(GET)
  similiar to enquire but using url param
 http://spingboothelloword-env.eba-pnpiwrah.us-east-2.elasticbeanstalk.com/get?id=1
 
 5) getAll(GET)
  get All account details
  http://spingboothelloword-env.eba-pnpiwrah.us-east-2.elasticbeanstalk.com/getALL
 
 
 
 

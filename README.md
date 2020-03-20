# SpringBoot
Spring Boot applications - A Sample application implemented in Spring Boot using Spring Initilizr.

Run
 Right click on BankRestApiApplication - click on Run 'BankRestApiAppli...main()'

Postman
  1. To get all bank details
  GET: http://localhost:8080/bankDetails/
  
  2. To get a particular bank details
  GET: http://localhost:8080/bankDetails/HDFC
  
  3. To add bank deatils
  POST: http://localhost:8080/bankDetails/
     * Body:
     * {
            "bankName": "SBI",
            "branch": "Gachibowli Branch",
            "ifscCode": "SBIN001234",
            "address": "Gachibowli, Hyderabad"
        }
     * Headers:
     *  Key: Content-Type, Value: application/json
       
  4. To update if bank already exists, or create a new one if bank not available
  PUT: http://localhost:8080/bankDetails/SBI
     * Body:
     * {
            "bankName": "SBI",
            "branch": "Gachibowli Branch",
            "ifscCode": "SBIN001234",
            "address": "Waverock, Gachibowli, Hyderabad"
        }
     * Headers:
     *  Key: Content-Type, Value: application/json
     
  5. To delete a particular bank details
  DELETE: http://localhost:8080/bankDetails/SBI
  
  

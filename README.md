How Did You Run the Code?
1. Cloned the Repository:
   git clone git@github.com:farhan8626/machinetest.git

2. open that clone project using any IDE
3. download maven
4. Create a MySQL database having name is machinetest
    update the application.property file as per your user_name & password
5. Go to MachinetestApplication class run that file.

6. open POSTMAN for Api Testing
7. give the POST REQUEST  HAVING BODY json "category":"furniture"
      http://localhost:8080/api/Categories

8.GET All CATEGORIES DATA
 GIVE GET REQUEST 
     http://localhost:8080/api/Categories

     
9.ADD Products Data

  give the POST REQUEST  HAVING BODY json {"name":"sofa",
  "price":"10000",
    "category":{
        "id":1}
  }


  8.GET All PRODUCTS DATA
 GIVE GET REQUEST 
     (http://localhost:8080/api/products)




  
  

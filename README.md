A spring framework demo for basic tutorial

---

# spring-demo

The project is architected in Spring Framwork 5.2.x, and uses Hibernate 5.x to manage persistence layer. 
To follow up this guideline, you can aspect the architecture step by step. <Br/>

# Runtime environment

* Oracle database 11g (or latter version)
* Apache Tomcat 8.5 (or latter version)


# Initialize

1. Install <a href="https://www.oracle.com/tw/database/technologies/112010-win64soft.html">__Oracle Database 11g__</a> first,
website of installation guide <a href="http://dog0416.blogspot.com/2013/12/databasewindow-oracle-11g.html">__here__</a><Br/>

2. After installing the oracle DB, you must: <Br/>
	2-1. Execute the script __"src/main/resources/SQL_FOR_DEMO.sql"__ in the DB<Br/>
	2-2. Change the __user__ name and __password__ (also your __JDBC url__ if needed) of your database connection in __"src/main/resources/jdbc.properties"__<Br/>


# Sequence to follow

The steps that is suggested to be followed in sequence:

1. Configurations in __"conf"__ package<Br/>
	1-1. __"spring"__ package, there are some basic settings of Spring Framework<Br/>
	1-2. __"db"__ package<Br/>
	1-3. __"aop"__ package<Br/>
	
2. Basic MVC architecture<Br/>
	2-1. __"controller"__<Br/>
	2-2. __'service"__<Br/>
	2-3. __"dao"__<Br/>
	2-4. __"model"__<Br/>



# Scaffold

```txt

spring-demo/
  └─ src/main/
    └─ java/
      └─ com/demo/
    	└─ conf/
    	└─ controller/
    	└─ dao/
    	└─ service/
    	└─ model/
    	└─ utils/
      └─ resources/
  
```


# Author's contact info
Email: k19631966@gmail.com

LinkedIn: https://www.linkedin.com/in/kai-yi-l-4aa70b194

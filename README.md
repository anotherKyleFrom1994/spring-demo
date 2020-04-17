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
	2-1. Execute the script "src/main/resources/SQL_FOR_DEMO.sql" in the DB<Br/>
	2-2. Change the user name and password (also your JDBC url if needed) of your database connection in "src/main/resources/jdbc.properties"<Br/>


# Sequence to follow

The steps that is suggested to be followed in sequence:

1. Configurations in __conf__ package<Br/>
	1-1. __spring__ package, there are some basic settings of Spring Framework<Br/>
	1-2. __db__ package<Br/>
	1-3. __aop__ package<Br/>
	
2. Basic MVC architecture<Br/>
	2-1. __controller__<Br/>
	2-2. __service__<Br/>
	2-3. __dao__<Br/>
	2-4. __model__<Br/>



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

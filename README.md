A spring framework demo for basic tutorial

---

# spring-demo

The project is architected in Spring Framwork 5.2.x, and uses Hibernate 5.x to interpret JPA. 
To follow up this guideline, you can aspect the architecture step by step. <Br/>

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
      └─ vmt/demo/
    	└─ conf/
    	└─ controller/
    	└─ dao/
    	└─ service/
    	└─ model/
    	└─ utils/
      └─ resources/
  
```

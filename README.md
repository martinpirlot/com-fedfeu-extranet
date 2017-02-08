# TrafficLightApp
Web application to manage members, clubs & cups of non-profit organization Fedfeu.


## Set up
Set JVM argument for tomcat: -Djava.security.auth.login.config=$CATALINA_BASE/conf/jaas-fedfeu.config

jaas-fedfeu.config:

```
FedfeuLogin {
    com.fedfeu.jaas.FedfeuLoginModule required debug=true;
};
```

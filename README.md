# Jcomponent
1)Java swing application that used to book travel tickets and residency confirmation.
2)deploy project in intelliJ
3)connect to oracle with ojdbc8
4)use api's 
           i)JCalender-1.4.jar (http://www.java2s.com/Code/Jar/j/Downloadjcalendar14jar.htm)
           ii)Mail-1.4.7.jar (http://www.java2s.com/Code/Jar/j/Downloadjavaxmailapi147jar.htm)
           iii)acrivation.jar (http://www.java2s.com/Code/Jar/a/Downloadactivationjar.htm)
           iv)ojdbc8.jar
           and add them in the project structure
5)create following database tables on oracle

Creating new Account:

create table SIGNUP
(
 FIRSTNAME VARCHAR2(20) not null,
 LASTNAME VARCHAR2(20) not null,
 USERNAME CHAR (30) default NULL not null,
 PASSWORD CHAR(15) not null,
 GENDER VARCHAR2(6) default NULL not null,
 DOB VARCHAR2(10) default NULL not null
);

Login: -

create table LOGIN
(
 USERNAME VARCHAR2(20) not null,
 PASSWORD CHAR(20) not null
);

Travels: -

create table TRAVELDATA
(
 TRAVELS VARCHAR2(20) not null,
 TIMING VARCHAR2(5) not null,
 "Available seats" NUMBER(2) not null,
 PRICE FLOAT(7) not null,
 FROM1 VARCHAR2(20) default NULL not null,
 TO1 VARCHAR2(20) default NULL not null
);

Residency: -

create table RESIDENCY
(
 NAME VARCHAR2(20) not null,
 ROOMTYPE VARCHAR2(6) not null,
 PEOPLE NUMBER not null,
 "date of availability" VARCHAR2(10) default NULL not null,
 RATING NUMBER not null,
 FARE NUMBER default NULL not null,
 PLACE VARCHAR2(20) default NULL not null
);


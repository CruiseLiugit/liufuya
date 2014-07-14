#测试基本的   Vaadin 增删改查功能的表
#联系人表
CREATE TABLE person (
       id INT NOT NULL AUTO_INCREMENT
     , version INT
     , firstName CHAR(30)
     , lastName VARCHAR(50)
     , email VARCHAR(50)
     , phoneNumber VARCHAR(50)
     , streetAddress VARCHAR(50)
     , postalCode VARCHAR(50)
     , city VARCHAR(50)
     , PRIMARY KEY (id)
);

#用户
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'刘','强东','liu@32.com','18933726648','北京市海淀区中山路113号','11092','北京');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'王','宝强','wangbq@163.com','15099239948','北京市朝阳区xx路132号','11092','北京');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'李','强东','liu@32.com','18933726648','北京市海淀区中山路113号','11092','苏州');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'章','强东','liu@32.com','18933726648','北京市海淀区中山路113号','11092','武汉');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'张','强东','liu@32.com','18933726648','北京市海淀区中山路113号','11092','南京');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'张','强东','liu@32.com','18933726648','北京市海淀区中山路113号','11092','郑州');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'杨','强东','liu@32.com','18933726648','北京市海淀区中山路113号','11092','杭州');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'柳','强东','liu@32.com','18933726648','北京市海淀区中山路113号','11092','襄阳');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'余','强东','liu@32.com','18933726648','北京市海淀区中山路113号','11092','宜昌');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'郑','杰','liu@32.com','18933726648','北京市海淀区中山路113号','11092','保定');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'钱','强东','liu@32.com','18933726648','北京市海淀区中山路113号','11092','哈尔滨');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'陈','钱','liu@32.com','18933726648','北京市海淀区中山路113号','11092','大连');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'黎','东','liu@32.com','18933726648','北京市海淀区中山路113号','11092','青岛');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'田','亮','liu@32.com','18933726648','北京市海淀区中山路113号','11092','扬州');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'孙','源','88736222@qq.com','1893254473','上海市黄浦区河南路329号','11092','上海');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'董','嫣嫣','liu@32.com','18933726648','北京市海淀区中山路113号','11092','广州');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'赵','强东','liu@32.com','18933726648','北京市海淀区中山路113号','11092','深圳');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'朱','强东','liu@32.com','18933726648','北京市海淀区中山路113号','11092','南昌');
insert into person(version,firstName,lastName,email,phoneNumber,streetAddress,postalCode,city) values(11,'邹','强东','liu@32.com','18933726648','北京市海淀区中山路113号','11092','昆明');




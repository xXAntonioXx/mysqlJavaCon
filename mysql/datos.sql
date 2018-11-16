INSERT INTO Cliente VALUES(1,'Sherlock Holmes','221b baker street','6621010203'),
(2,'Tyrion Lannister','221b baker street','6621010203'),
(3,'Antoine Sain-Exupery','221b baker street','6621010203'),
(4,'William Willson','221b baker street','6621010203'),
(5,'Golden Caulfield','221b baker street','6621010203');

INSERT INTO Procuradores VALUES(1,'Johnathan Hamish Watson','221b baker street','6621010203','correo@gmail.com'),
(2,'Tyler Durden','221b baker street','6621010203','correo@gmail.com'),
(3,'Baron Grunner','221b baker street','6621010203','correo@gmail.com'),
(4,'Samwise the wise','221b baker street','6621010203','correo@gmail.com'),
(5,'Bran Stoker','221b baker street','6621010203','correo@gmail.com');

INSERT INTO Asunto VALUES(1,'2018-07-11',NULL,'en proceso',1),
(2,'2018-07-12','2019-07-13','concluido',2),
(3,'2018-07-13','2019-07-20','concluido',3),
(4,'2018-07-12',NULL,'en proceso',4),
(5,'2018-07-12','2019-07-13','concluido',5);

INSERT INTO Asunto_Procurador VALUES(1,5,1),
(2,4,3),
(3,3,5),
(4,2,4),
(5,1,2);

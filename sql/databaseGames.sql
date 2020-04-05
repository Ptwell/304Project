drop table Platform cascade constraints;
drop table Game cascade constraints;
drop table GName;
drop table Distributor cascade constraints;
drop table Offered;
drop table PVP;
drop table PVE;
drop table SupportedOn;
drop table DLC;
drop table Company cascade constraints;
drop table MadeBy;
drop table Person cascade constraints;
drop table TeamWorksAt;
drop table Position;
drop table Consume;
drop table ProfileHas;
drop table Account cascade constraints;
drop table Supply;


create table Platform(
    Brand CHAR(20) NOT NULL, 
    Hardware_DeviceType CHAR(20) NOT NULL, 
    controls CHAR(20),
    PRIMARY KEY(Brand, Hardware_DeviceType)
);

create table Game(
    GameID INTEGER NOT NULL, /*originally INTEGER(20)*/
    GName CHAR(20), 
    PRIMARY KEY(GameID)
);

create table GName(
    GName CHAR(20) NOT NULL, 
    Year NUMBER(4), /*originally INTEGER(20)*/
    Genre CHAR(20),
    PRIMARY KEY (GName),
    FOREIGN KEY(GName) REFERENCES Game(GName) ON DELETE CASCADE 
);

create table Distributor(
    DiName CHAR(20) NOT NULL, 
    PaymentMethod CHAR (20), 
    PRIMARY KEY(DiName)
);

create table Offered(
    GameID INTEGER NOT NULL, 
    DiName CHAR(20) NOT NULL, 
    Price_Given INTEGER, 
    publisher CHAR(20),
    PRIMARY KEY(GameID, DiName),
    FOREIGN KEY(GameID) REFERENCES Game(GameID) ON DELETE CASCADE,
    FOREIGN KEY(DiName) REFERENCES Distributor(DiName) ON DELETE CASCADE
);

create table PVP(
    GameID INTEGER NOT NULL, 
    Numplayer INTEGER, 
    PRIMARY KEY(GameID), 
    FOREIGN KEY(GameID) REFERENCES Game(GameID) ON DELETE CASCADE
);

create table PVE(
    GameID INTEGER NOT NULL, 
    Numplayer INTEGER, 
    Difficulty CHAR(20), 
    Competitive_Casual CHAR(20), 
    PRIMARY KEY(GameID), 
    FOREIGN KEY (GameID) REFERENCES Game(GameID) ON DELETE CASCADE
); 

create table SupportedOn(
    Brand CHAR(20) NOT NULL, 
    Hardware_DeviceType CHAR(20) NOT NULL, 
    GameID INTEGER NOT NULL,
    PRIMARY KEY (Brand, Hardware_DeviceType, GameID), 
    FOREIGN KEY(Brand, Hardware_DeviceType) REFERENCES Platform(Brand, Hardware_DeviceType) ON DELETE CASCADE, 
    FOREIGN KEY (GameID) REFERENCES Game(GameID) ON DELETE CASCADE
);

create table DLC(
    DName CHAR(20) NOT NULL, 
    GameID INTEGER NOT NULL, 
    price_dlc INTEGER, 
    PRIMARY KEY(DName, GameID), 
    FOREIGN KEY (GameID) REFERENCES Game(GameID) ON DELETE CASCADE
);

create table Company(
    Cname CHAR(20) NOT NULL, 
    Location CHAR(20), 
    PRIMARY KEY(Cname)
);

create table MadeBy(
    CName CHAR(20) NOT NULL, 
    GameID INTEGER NOT NULL, 
    PRIMARY KEY (CName, GameID),
    FOREIGN KEY(CName) REFERENCES Company(CName) ON DELETE CASCADE,
    FOREIGN KEY (GameID) REFERENCES Game(GameID) ON DELETE CASCADE
);

/* Should we just use SIN as Primary Key here?*/
create table Person(
    PName CHAR(20) NOT NULL, 
    SIN INTEGER NOT NULL, 
    Email CHAR(20) NOT NULL, 
    PRIMARY KEY (PName, SIN)
);

create table TeamWorksAt(
    TID INTEGER NOT NULL, 
    Position CHAR(20), 
    CName CHAR(20) NOT NULL, 
    PRIMARY KEY(TID), 
    FOREIGN KEY (CName) REFERENCES Company(CName) ON DELETE CASCADE
);

create table Position(
    Position CHAR(20) NOT NULL, 
    Salary INTEGER,
    PRIMARY KEY(Position)
);

create table Consume(
    PName CHAR(20) NOT NULL, 
    SIN INTEGER NOT NULL, 
    GameID INTEGER NOT NULL, 
    PRIMARY KEY (PName, SIN, GameID), 
    FOREIGN KEY (PName, SIN) REFERENCES Person(PName, SIN) ON DELETE CASCADE, 
    FOREIGN KEY (GameID) REFERENCES Game(GameID) ON DELETE CASCADE
);

create table Account( 
    Username CHAR(20) NOT NULL, 
    password CHAR(20) NOT NULL, 
    Email CHAR(20) NOT NULL , 
    PName CHAR(20) NOT NULL,
    SIN INTEGER NOT NULL, 
    PRIMARY KEY(Username), 
    FOREIGN KEY(Pname, SIN) REFERENCES Person(Pname, SIN) ON DELETE CASCADE
);

create table ProfileHas (
    ProfileID INTEGER NOT NULL, 
    Gametime INTEGER, 
    DateCreated DATE, 
    Name CHAR(20), 
    Username CHAR(20) NOT NULL, 
    PRIMARY KEY (ProfileID), 
    FOREIGN KEY (Username) REFERENCES Account(Username) ON DELETE CASCADE 
);


create table Supply(
    Username CHAR(20) NOT NULL, 
    Cname CHAR(20) NOT NULL, 
    PRIMARY KEY(Username, Cname),
    FOREIGN KEY (Username) REFERENCES Account(Username) ON DELETE CASCADE,
    FOREIGN KEY (Cname) REFERENCES Company(CName) ON DELETE CASCADE
);

INSERT INTO Platform VALUES ('Mojang', 'PC', 'Keyboard');


INSERT INTO Game VALUES (1, 'Minecraft');

INSERT INTO GName VALUES ('Minecraft', 2009, 'Adventure');

INSERT INTO Distributor VALUES ('Mojang', 'Online');

/* Is FREE == NULL? */
INSERT INTO Offered VALUES (1, 'Mojang', 25, 'Mojang');

INSERT INTO PVP VALUES (1, 10);

INSERT INTO PVE VALUES (1, 1, 'Normal', 'Casual');

INSERT INTO SupportedOn VALUES ('Mojang','PC', 1);

INSERT INTO DLC VALUES ('WOW: Burning Crusade', 1, 40);


INSERT INTO Company VALUES ('Mojang', 'Sweden');


INSERT INTO MadeBy VALUES ('Mojang', 1);

INSERT INTO Person VALUES ('Peter', 123456789, 'peter@gmail.com');

INSERT INTO TeamWorksAt VALUES (2, 'Marketing', 'Mojang');

INSERT INTO Position VALUES ('Manager', 100000);

INSERT INTO Consume VALUES ('Peter', 123456789, 1);

INSERT INTO Account VALUES ('Peter001', 'password123', 'peter@gmail.com', 'Peter', 123456789);


INSERT INTO ProfileHas VALUES (123, 10, TO_DATE('2011-10-24','YYYY-MM-DD'), 'UserPeter', 'Peter001');


INSERT INTO Supply VALUES ('Peter001', 'Mojang');





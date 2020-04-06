INSERT INTO Platform VALUES ('Mojang', 'PC', 'Keyboard');
INSERT INTO Platform VALUES ('Valve', 'PC', 'Keyboard');
INSERT INTO Platform VALUES ('Bluehole', 'PC', 'Keyboard');
INSERT INTO Platform VALUES ('Blizzard', 'PC', 'Keyboard');
INSERT INTO Platform VALUES ('Nintendo', 'Switch', 'Joycon');
INSERT INTO Platform VALUES ('EA', 'PC', 'Keyboard');
INSERT INTO Platform VALUES ('Capcom', 'PC', 'Keyboard');
INSERT INTO Platform VALUES ('Riot', 'PC', 'Keyboard');

INSERT INTO Game VALUES (1, 'Minecraft');
INSERT INTO Game VALUES (2, 'League of Legends');
INSERT INTO Game VALUES (3, 'DOTA2');
INSERT INTO Game VALUES (4, 'PUBG');
INSERT INTO Game VALUES (5, 'WOW');
INSERT INTO Game VALUES (6, 'Overwatch');
INSERT INTO Game VALUES (7, 'Breadth of the Wild');
INSERT INTO Game VALUES (8, 'Plants vs Zombies');
INSERT INTO Game VALUES (9, 'CSGO');
INSERT INTO Game VALUES (10, 'Monster Hunter');

INSERT INTO GName VALUES ('Minecraft', 2009, 'Adventure');
INSERT INTO GName VALUES ('League of Legends', 2009, 'MOBA');
INSERT INTO GName VALUES ('DOTA2', 2011, 'MOBA');
INSERT INTO GName VALUES ('PUBG', 2016, 'BATTLE ROYALE');
INSERT INTO GName VALUES ('WOW', 2000, 'MMO RPG');
INSERT INTO GName VALUES ('Overwatch', 2017, 'FPS');
INSERT INTO GName VALUES ('Breadth of the Wild', 2018, 'ADVENTURE');
INSERT INTO GName VALUES ('Plants vs Zombies', 2009, 'TOWER DEFENCE');
INSERT INTO GName VALUES ('CSGO', 2012, 'FPS');
INSERT INTO GName VALUES ('Monster Hunter', 2019, 'RPG');

INSERT INTO Distributor VALUES ('Mojang', 'Online');
INSERT INTO Distributor VALUES ('Riot Games', 'Online');
INSERT INTO Distributor VALUES ('Valve', 'Online');
INSERT INTO Distributor VALUES ('Steam', 'Online');
INSERT INTO Distributor VALUES ('Battlenet', 'Online');

/*
INSERT INTO Distributor VALUES ('Sony', 'Online');
INSERT INTO Distributor VALUES ('Riot Games', 'Online');
INSERT INTO Distributor VALUES ('e-shop', 'Online');
*/

/* Is FREE == NULL? */
INSERT INTO Offered VALUES (1, 'Mojang', 25, 'Mojang');
INSERT INTO Offered VALUES (2, 'Riot Games', NULL, 'Riot Games');
INSERT INTO Offered VALUES (3, 'Valve', NULL, 'Valve');
INSERT INTO Offered VALUES (4, 'Steam', 49.99, 'Bluehole');
INSERT INTO Offered VALUES (5, 'Battlenet', NULL, 'Blizzard');

INSERT INTO PVP VALUES (2, 10);
INSERT INTO PVP VALUES (3, 10);
INSERT INTO PVP VALUES (4, 99);
INSERT INTO PVP VALUES (6, 12);
INSERT INTO PVP VALUES (9, 10);

INSERT INTO PVE VALUES (1, 1, 'Normal', 'Casual');
INSERT INTO PVE VALUES (5, 40, 'Hard', 'Competitive');
INSERT INTO PVE VALUES (7, 1, 'Normal', 'Casual');
INSERT INTO PVE VALUES (8, 1, 'Easy', 'Casual');
INSERT INTO PVE VALUES (10, 4, 'Normal', 'Competitive');

INSERT INTO SupportedOn VALUES ('Mojang','PC', 1);
INSERT INTO SupportedOn VALUES ('Valve', 'PC', 2);
INSERT INTO SupportedOn VALUES ('Bluehole', 'PC', 3);
INSERT INTO SupportedOn VALUES ('Blizzard', 'PC', 4);
INSERT INTO SupportedOn VALUES ('Nintendo', 'Switch', 5);

INSERT INTO DLC VALUES ('WOW: Burning Crusade', 5, 40);
INSERT INTO DLC VALUES ('WOW: Wrath of the Lich King', 5, 40);
INSERT INTO DLC VALUES ('WOW: Catalysm', 5, 40);
INSERT INTO DLC VALUES ('WOW: Mists of Pandaria', 5, 40);
INSERT INTO DLC VALUES ('WOW: Warlords of Draenor', 5, 40);

INSERT INTO Company VALUES ('Mojang', 'Sweden');
INSERT INTO Company VALUES ('Riot Games', 'USA');
INSERT INTO Company VALUES ('Valve', 'USA');
INSERT INTO Company VALUES ('Bluehole', 'Korea');
INSERT INTO Company VALUES ('Blizzard', 'USA');

INSERT INTO MadeBy VALUES ('Mojang', 1);
INSERT INTO MadeBy VALUES ('Riot Games', 2);
INSERT INTO MadeBy VALUES ('Valve', 3);
INSERT INTO MadeBy VALUES ('Bluehole', 4);
INSERT INTO MadeBy VALUES ('Blizzard', 5);

INSERT INTO Person VALUES ('Peter', 123456789, 'peter@gmail.com');
INSERT INTO Person VALUES ('Jillian', 234567890, 'jillian@gmail.com');
INSERT INTO Person VALUES ('YinChen', 345678901, 'yinchen@gmail.com');
INSERT INTO Person VALUES ('Hazra', 456789012, 'hazra@gmail.com');
INSERT INTO Person VALUES ('Jessica', 567890123, 'jessica@gmail.com');

INSERT INTO TeamWorksAt VALUES (1, 'Manager', 'Mojang');
INSERT INTO TeamWorksAt VALUES (2, 'Marketing', 'Mojang');
INSERT INTO TeamWorksAt VALUES (3, 'Intern', 'Mojang');
INSERT INTO TeamWorksAt VALUES (4, 'Analyst', 'Mojang');
INSERT INTO TeamWorksAt VALUES (5, 'Assistant Manager', 'Mojang');

INSERT INTO Position VALUES ('Manager', 100000);
INSERT INTO Position VALUES ('Marketing', 80000);
INSERT INTO Position VALUES ('Intern', 30000);
INSERT INTO Position VALUES ('Analyst', 70000);
INSERT INTO Position VALUES ('Assistant Manager', 80000);

INSERT INTO Consume VALUES ('Peter', 123456789, 1);
INSERT INTO Consume VALUES ('Jillian', 234567890, 2);
INSERT INTO Consume VALUES ('YinChen', 345678901, 3);
INSERT INTO Consume VALUES ('Hazra', 456789012, 4);
INSERT INTO Consume VALUES ('Jessica', 567890123, 5);

INSERT INTO Account VALUES ('Peter001', 'password123', 'peter@gmail.com', 'Peter', 123456789);
INSERT INTO Account VALUES ('Jillian001', 'password124', 'jillian@gmail.com', 'Jillian', 234567890);
INSERT INTO Account VALUES ('YinChen001', 'password125', 'yinchen@gmail.com', 'YinChen', 345678901);
INSERT INTO Account VALUES ('Hazra001', 'password126', 'hazra@gmail.com', 'Hazra', 456789012);
INSERT INTO Account VALUES ('Jessica001', 'password127', 'jessica@gmail.com', 'Jessica', 567890123);

INSERT INTO ProfileHas VALUES (123, 10, TO_DATE('2011-10-24','YYYY-MM-DD'), 'UserPeter', 'Peter001');
INSERT INTO ProfileHas VALUES (234, 23, TO_DATE('2011-10-25', 'YYYY-MM-DD'),'UserJillian', 'Jillian001');
INSERT INTO ProfileHas VALUES (345, 34, TO_DATE('2011-10-26','YYYY-MM-DD'), 'UserYinChen', 'YinChen001');
INSERT INTO ProfileHas VALUES (456, 45, TO_DATE('2011-11-27','YYYY-MM-DD'), 'UserHazra', 'Hazra001');
INSERT INTO ProfileHas VALUES (567, 56, TO_DATE('2011-11-28','YYYY-MM-DD'), 'UserJessica', 'Jessica001');

INSERT INTO Supply VALUES ('Peter001', 'Mojang');
INSERT INTO Supply VALUES ('Jillian001', 'Riot Games');
INSERT INTO Supply VALUES ('YinChen001', 'Valve');
INSERT INTO Supply VALUES ('Hazra001', 'Riot Games');
INSERT INTO Supply VALUES ('Jessica001', 'Riot Games');

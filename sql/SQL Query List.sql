/* To see the change, reference the "To see the change:" and input before and after query. */ 


Insert Query:
SQL> INSERT INTO Game VALUES (11, 'Insert-Test');

/**
    To see the change:
    SQL> select * from Game;  shows the new entry.
*/

Delete Query;
SQL> DELETE FROM Game WHERE GameID = 1;

/**
 To see the change:
    SQL> select * from Game;
    SQL> select * from GName;
    SQL> select * from Offered;         Minecraft entries are all removed cascading down. Can call before and after
 */

Update Query;
SQL> UPDATE Offered SET PRICE_GIVEN = '59.99' WHERE DINAME = 'Valve';

/**
To see the change:
SQL> select * from Offered;
*/

Selection Query:
SQL> SELECT DINAME FROM Offered WHERE PRICE_GIVEN > 49.99;

/**
To see the change:
This query shows the result(s).
*/

Projection Query:
SQL> SELECT Email, PName FROM Account;

/**
To see the change:
This query shows the result(s).
*/

Join Query:
SQL> SELECT Account.PName, ProfileHas.Gametime FROM Account FULL JOIN ProfileHas ON Account.Username = ProfileHas.Username;

/**
To see the change:
This query shows the result(s).
*/

Aggregation Query;
SQL> SELECT MIN(Year) From GName;

/**
To see the change:
This query shows the result(s).
*/

Nested Aggregation with Group-By Query:
SELECT MAX(AVG(Salary)) FROM Position GROUP BY Salary;
/**
To see the change:
This query shows the Highest average salary of a position, grouped by salary.
*/

Division Query:
SELECT Game.GName FROM Game JOIN GName ON Game.GName = GName.GName JOIN SupportedOn ON Game.GameID = SupportedOn.GameID
MINUS
SELECT Game.GName FROM Game JOIN GName ON Game.GName = GName.GName JOIN SupportedOn ON Game.GameID = SupportedOn.GameID WHERE GName.Year > 2010 OR SupportedOn.Hardware_DeviceType <> 'PC';

/**
To see the change:
This query shows the result(s) for Game Names of games that are divided based on if they are released in a year before 2010 AND that it is supported on 'PC'.

The format is A = Game JOIN GName JOIN SupportedOn
              B = GName.Year < 2010 AND SupportedOn.Hardware_DeviceType = 'PC'

              So we query A/B = A1 - A2(where negated B)
*/
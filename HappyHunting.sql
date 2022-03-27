BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Special" (
	"Location"	int NOT NULL,
	"Start_Time"	float,
	"End_Time"	float,
	"Start_Day"	INTEGER,
	"End_Day"	INTEGER,
	"Special_Information"	varchar(100000),
	FOREIGN KEY("Location") REFERENCES "Bar"("Bar_ID") ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS "Bar" (
	"Bar_ID"	int NOT NULL,
	"Name"	varchar(1000) NOT NULL,
	"Address"	VARCHAR(1000),
	"Monday_Hours"	VARCHAR(100),
	"Tuesday_Hours"	VARCHAR(100),
	"Wednesday_Hours"	VARCHAR(100),
	"Thursday_Hours"	VARCHAR(100),
	"Friday_Hours"	VARCHAR(100),
	"Saturday_Hours"	VARCHAR(100),
	"Sunday_Hours"	VARCHAR(100),
	PRIMARY KEY("Bar_ID")
);
CREATE TABLE IF NOT EXISTS "User" (
	"User_ID"	int NOT NULL,
	"Username"	varchar(30) NOT NULL UNIQUE,
	"Password"	varchar(30) NOT NULL,
	"Uber_Account_ID"	int,
	"Lyft_Account_ID"	int,
	PRIMARY KEY("User_ID")
);
INSERT INTO "Special" VALUES (1,NULL,NULL,1,7,'16oz budweiser: $3\nPBR tallboy: $3\n16oz platform - haze jude: $4\npaper tiger draft: $3\nbomb special\n');
INSERT INTO "Special" VALUES (1,15.0,2.0,2,2,'half off all drinks');
INSERT INTO "Special" VALUES (1,15.0,19.0,3,7,'$2 off all drinks');
INSERT INTO "Special" VALUES (1,15.0,2.0,3,3,'half off pink whitney');
INSERT INTO "Special" VALUES (1,15.0,19.0,2,5,'half off all apps');
INSERT INTO "Special" VALUES (2,21.0,2.0,1,1,'$2 Wells\n$3 Hot Shots\n$4 Any Draft\n$5 32oz OG LIT Pitchers');
INSERT INTO "Special" VALUES (2,17.0,22.0,2,2,'$2 CHZBURGERS');
INSERT INTO "Special" VALUES (2,21.0,2.0,2,2,'$3 Wells\n$3 Hot Shots\n$3 Domestic Bottles');
INSERT INTO "Special" VALUES (2,21.0,2.0,3,3,'40¢ Wings\n$4 Double Wells\n$5 Large Domestic Drafts\n$6 Large Craft Drafts');
INSERT INTO "Special" VALUES (2,21.0,2.0,4,4,'$2 Double Wells\n$3 Domestic Bottles\n$3 Cherry or Grape Bombs\n$4 32oz. OG LIT Pitchers');
INSERT INTO "Special" VALUES (2,21.0,2.0,5,5,'$3 Double Wells\n$3 Tito''s\n$4 Domestic Bottles\n$8 32oz. OG LIT Pitchers');
INSERT INTO "Special" VALUES (2,21.0,2.0,6,6,'$4 Fireball\n$4 Cherry/Grape Bombs\n$6 Vodka Red Bulls\n$6 Vegas Bombs');
INSERT INTO "Special" VALUES (2,21.0,2.0,7,7,'$2 Mimosas\n$4 Double Wells\n$4 Calls\n$4 Large Domestic Drafts\n$5 Large Craft/Import Drafts');
INSERT INTO "Special" VALUES (3,21.0,2.0,3,3,'$5 DOUBLE REDBULL VODKA\n$3 PINK WHITNEYS');
INSERT INTO "Special" VALUES (3,20.0,2.0,4,4,'$1 WELLS FOR THE LADIES\n$2 PINK TEA\n$2 TITOS\n$5 MIDWAY MILK');
INSERT INTO "Special" VALUES (3,15.0,18.0,5,6,'$1 wells\n$1 bombs');
INSERT INTO "Special" VALUES (3,18.0,21.0,5,6,'$2 off everything');
INSERT INTO "Special" VALUES (4,12.0,16.0,2,4,'50% off drafts\n25% off Handhelds');
INSERT INTO "Special" VALUES (4,16.0,19.0,2,4,'50% off wells\n50% off drafts\n25% off Specialty Cocktails');
INSERT INTO "Special" VALUES (4,12.0,2.0,2,2,'$1 tacos\n$5 frozen margarita\n$10 margarita pitchers');
INSERT INTO "Special" VALUES (4,12.0,2.0,3,3,'25% off appetizers\n25% off shareable cocktails');
INSERT INTO "Special" VALUES (4,12.0,2.0,4,4,'$5 nachos\n$5 big tanks');
INSERT INTO "Special" VALUES (4,12.0,17.0,5,5,'DOMESTIC PITCHERS: $2 @ 12:00, $3 @ 1:00 $4 @ 2:00, $5 @ 3:00 $6 @ 4:00');
INSERT INTO "Special" VALUES (4,10.0,20.0,7,7,'$20 bottomless mimosas\n$4 irish breakfast shots');
INSERT INTO "Bar" VALUES (1,'Fourth Street Taproom & Kitchen','1810 N 4th St, Columbus, OH 43201','Closed','3PM - 2AM','3PM - 2AM','3PM - 2AM','12PM - 2 AM','11AM - 2AM','11AM - 2AM');
INSERT INTO "Bar" VALUES (2,'Brothers Bar & Grill','477 Park St, Columbus, OH 43215','3PM - 2AM','3PM - 2AM','3PM - 2AM','3PM - 2AM','3PM - 2AM','3PM - 2AM','Closed');
INSERT INTO "Bar" VALUES (3,'Midway','1728 N High St, Columbus, OH 43201','Closed','Closed','9PM - 2AM','8PM - 2AM','3PM - 2AM','3PM - 2AM','Closed');
INSERT INTO "Bar" VALUES (4,'Ethyl & Tank','19 E 13th Ave, Columbus, OH 43201','Closed','12PM - 2AM','12PM - 2AM','12PM - 2AM','12PM - 2AM','10AM - 2AM','10AM - 8PM');
INSERT INTO "Bar" VALUES (5,'Out-R-Inn','20 Frambes Ave, Columbus, OH 43201','Closed','4PM - 2:30AM','4PM - 2:30AM','4PM - 2:30AM','4PM - 2:30AM','4PM - 2:30AM','Closed');
INSERT INTO "Bar" VALUES (6,'The Library Bar','2169 N High St, Columbus, OH 43201','3PM - 2:30AM','3PM - 2:30AM','3PM - 2:30AM','3PM - 2:30AM','1PM - 2AM','1PM - 2AM','3PM - 2:30AM');
INSERT INTO "Bar" VALUES (7,'The Little Bar','2195 N High St, Columbus, OH 43201','4PM - 2AM','4PM - 2AM','4PM - 2AM','4PM - 2AM','3:30PM - 2AM','3:30PM - 2AM','3:30PM - 2AM');
INSERT INTO "Bar" VALUES (8,'Threes Above High','2203 N High St, Columbus, OH 43201','Closed','7PM - 2AM','7PM - 2AM','7PM - 2AM','7PM - 2AM','7PM - 2AM','Closed');
INSERT INTO "Bar" VALUES (9,'Ugly Tuna Saloona 2','195 Chittenden Ave, Columbus, OH 43201','4PM - 2AM','4PM - 2AM','4PM - 2AM','4PM - 2AM','4PM - 2AM','4PM - 2AM','4PM - 2AM');
INSERT INTO "Bar" VALUES (10,'Standard Hall','1100 N High St, Columbus, OH 43201','Closed','3PM - 2AM','3PM - 2AM','3PM - 2AM','3PM - 2AM','11AM - 2AM','11AM - 12AM');
INSERT INTO "Bar" VALUES (11,'Bodega','1044 N High St, Columbus, OH 43201','3PM - 12AM','3PM - 12AM','3PM - 12AM','3PM - 12AM','3PM - 2AM','11AM - 2AM','11AM - 9PM');
INSERT INTO "Bar" VALUES (12,'Bristol Republic','1124 N High St, Columbus, OH 43201','Closed','Closed','Closed','4PM - 12AM','4PM - 2:30AM','10AM - 2:30AM','10AM - 10PM');
INSERT INTO "Bar" VALUES (13,'Gaswerks','487 Park St, Columbus, OH 43215','Closed','Closed','5PM - 2AM','5PM - 2AM','5PM - 2AM','5PM - 2AM','Closed');
INSERT INTO "Bar" VALUES (14,'The Big Bang Dueling Piano Bar','1516 N High St, Columbus, OH 43201','Closed','Closed','Closed','7PM - 2AM','7PM - 2AM','7PM - 2AM','Closed');
INSERT INTO "Bar" VALUES (15,'Bier Stube','1479 N High St, Columbus, OH 43201','3PM - 2:30AM','3PM - 2:30AM','3PM - 2:30AM','3PM - 2:30AM','3PM - 2:30AM','3PM - 2:30AM','3PM - 2:30AM');
INSERT INTO "Bar" VALUES (16,'Plaza Mexican Grill & Bar','1644 N High St, Columbus, OH 43201','3PM - 11PM','3PM - 11PM','3PM - 11PM','3PM - 12AM','12PM - 12AM','12PM - 12AM','Closed');
INSERT INTO "Bar" VALUES (17,'Cazuelas Mexican Cantina','2321 N High St, Columbus, OH 43202','11AM - 12AM','11AM - 12AM','11AM - 1AM','11AM - 2AM','11AM - 2AM','11AM - 12AM','11AM - 12AM');
INSERT INTO "Bar" VALUES (18,'Leo''s on the Alley','25 Chittenden Ave, Columbus, OH 43201','5PM - 2AM','5PM - 2AM','5PM - 2AM','5PM - 2AM','5PM - 2AM','5PM - 2AM','Closed');
INSERT INTO "Bar" VALUES (19,'The Thirsty Scholar','2201 Neil Ave, Columbus, OH 43201','Closed','3PM - 2:30AM','3PM - 2:30AM','3PM - 2:30AM','3PM - 2:30AM','5PM - 2:30AM','Closed');
INSERT INTO "Bar" VALUES (20,'Bullwinkles Night Club/Bar','1770 N High St, Columbus, OH 43201','Closed','Closed','Closed','9PM - 2:30AM','9PM - 2:30AM','9PM - 2:30AM','Closed');
INSERT INTO "User" VALUES (1,'landenman','coolDude!',NULL,NULL);
INSERT INTO "User" VALUES (2,'noahs_account','Testing23',NULL,NULL);
INSERT INTO "User" VALUES (3,'mikaela-drinks','1LastDrink',NULL,NULL);
INSERT INTO "User" VALUES (4,'Ben10','Pach3co',NULL,NULL);
INSERT INTO "User" VALUES (5,'Glub-Glub','PleaseDontReadThis',NULL,NULL);
INSERT INTO "User" VALUES (6,'StinkB*g','P00ter',NULL,NULL);
INSERT INTO "User" VALUES (7,'KingJames','G0@t',NULL,NULL);
INSERT INTO "User" VALUES (8,'Badzikky','But_I''mNotARapper',NULL,NULL);
INSERT INTO "User" VALUES (9,'12AngryMen','Class!cMovie',NULL,NULL);
INSERT INTO "User" VALUES (10,'landenmantwo','evencoolerDude!',NULL,NULL);
INSERT INTO "User" VALUES (11,'uhimrunningout','plzhelp',NULL,NULL);
INSERT INTO "User" VALUES (12,'this!is!hard!','Cr_e@tivity',NULL,NULL);
INSERT INTO "User" VALUES (13,'BrutusBuckeye','Hang0nSl33py',NULL,NULL);
INSERT INTO "User" VALUES (14,'reference','nowlaugh',NULL,NULL);
INSERT INTO "User" VALUES (15,'BenKingsly','UhCool?',NULL,NULL);
INSERT INTO "User" VALUES (16,'ledZepplin','HeyHeyMamaSayTheWayYouMove',NULL,NULL);
INSERT INTO "User" VALUES (17,'jokepart2','GonnaMakeYouSweatGonnaMakeYouGrove',NULL,NULL);
INSERT INTO "User" VALUES (18,'wait1more','NahNahNahNahNahNahNahNahNahNahNahNahNahNahNahNahNah',NULL,NULL);
INSERT INTO "User" VALUES (19,'finishLine','AndHe''sPlacing2nd',NULL,NULL);
INSERT INTO "User" VALUES (20,'lastOne','watchmeWhipNaeNae',NULL,NULL);
COMMIT;

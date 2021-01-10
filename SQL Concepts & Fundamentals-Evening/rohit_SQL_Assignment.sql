create database cricket;
use cricket;

create table players ( 
	Match_number int not null,
    Player_team varchar(32) not null,
    Player_number int not null,
    Player_name varchar(64),
    Player_score int default 0,
    Wickets_taken int default 0,
    primary key (Match_number, Player_name)
    );
    
create table teams ( 
	Match_number int not null,
    Team_name varchar(32) not null,
    Team_score int not null,
    primary key (Match_number, Team_name)
    );
    
/* a) Create sample data in all the tables. */
    
insert into players (Match_number, Player_team, Player_number, Player_name, Player_score, Wickets_taken)
	values
		(1, 'India', 18, 'Virat Kohli', 80, 0),
		(1, 'India', 45, 'Rohit Sharma', 50, 0),
		(1, 'India', 27, 'Ajinkya Rahane', 70, 0),
		(1, 'India', 1, 'K. L. Rahul', 60, 0),
		(1, 'India', 8, 'Ravindra Jadeja', 30, 1),
		(1, 'India', 33, 'Hardik Pandya', 40, 0),
		(1, 'India', 41, 'Shreyas Iyer', 30, 0),
		(1, 'India', 99, 'Ravichandran Ashwin', 15, 2),
		(1, 'India', 96, 'Navdeep Saini', 0, 1),
		(1, 'India', 11, 'Mohammed Shami', 0, 3),
		(1, 'India', 93, 'Jasprit Bumrah', 0, 2),
		
		(1, 'Australia', 10, 'Steve Smith', 50, 0),
		(1, 'Australia', 20, 'Glenn Maxwell', 40, 0),
		(1, 'Australia', 25, 'Ricky Ponting', 50, 0),
		(1, 'Australia', 30, 'Adam Gilchrist', 30, 0),
		(1, 'Australia', 45, 'Shane Watson', 20, 0),
		(1, 'Australia', 15, 'David Warner', 60, 0),
		(1, 'Australia', 99, 'Glenn McGrath', 30, 2),
		(1, 'Australia', 65, 'Brett Lee', 10, 1),
		(1, 'Australia', 66, 'Shane Warne', 0, 3),
		(1, 'Australia', 88, 'Bob Massie', 0, 2),
		(1, 'Australia', 1, 'J. J. Ferris', 0, 1),
		
		(2, 'England', 3, 'Jason Roy', 16, 0),
		(2, 'England', 10, 'Jos Butler', 47, 0),
		(2, 'England', 7, 'David Malan', 49, 0),
		(2, 'England', 66, 'Jonny Bairstow', 30, 0),
		(2, 'England', 45, 'Eoin Morgan', 50, 0),
		(2, 'England', 90, 'Ben Stokes', 40, 0),
		(2, 'England', 20, 'Sam Curran', 20, 0),
		(2, 'England', 36, 'Chris Jordan', 10, 1),
		(2, 'England', 88, 'Tom Curran', 0, 2),
		(2, 'England', 47, 'Adil Rashid', 0, 1),
		(2, 'England', 123, 'Jofra Archer', 0, 3),
		
		(2, 'South Africa', 12, 'Dean Elgar', 30, 0),
		(2, 'South Africa', 33, 'Aiden Markram', 40, 0),
		(2, 'South Africa', 60, 'Rassie van der Dussen', 20, 0),
		(2, 'South Africa', 6, 'Faf du Plessis', 50, 0),
		(2, 'South Africa', 8, 'Quinto de Kock', 20, 0),
		(2, 'South Africa', 91, 'Temba Bavuma', 30, 0),
		(2, 'South Africa', 44, 'Wiaan Mulder', 10, 0),
		(2, 'South Africa', 74, 'Keshav Maharaj', 20, 2),
		(2, 'South Africa', 18, 'Anrich Nortje', 0, 2),
		(2, 'South Africa', 10, 'Lutho Sipaala', 0, 1),
		(2, 'South Africa', 78, 'Lungi Ngidi', 0, 3),
		
		(3, 'India', 18, 'Virat Kohli', 60, 0),
		(3, 'India', 45, 'Rohit Sharma', 40, 0),
		(3, 'India', 27, 'Ajinkya Rahane', 100, 0),
		(3, 'India', 1, 'K. L. Rahul', 40, 0),
		(3, 'India', 8, 'Ravindra Jadeja', 50, 1),
		(3, 'India', 33, 'Hardik Pandya', 30, 0),
		(3, 'India', 41, 'Shreyas Iyer', 30, 0),
		(3, 'India', 99, 'Ravichandran Ashwin', 20, 1),
		(3, 'India', 96, 'Navdeep Saini', 15, 1),
		(3, 'India', 11, 'Mohammed Shami', 0, 1),
		(3, 'India', 93, 'Jasprit Bumrah', 0, 2),
	
		(3, 'England', 3, 'Jason Roy', 16, 0),
		(3, 'England', 10, 'Jos Butler', 30, 0),
		(3, 'England', 7, 'David Malan', 45, 0),
		(3, 'England', 66, 'Jonny Bairstow', 50, 0),
		(3, 'England', 45, 'Eoin Morgan', 20, 0),
		(3, 'England', 90, 'Ben Stokes', 50, 0),
		(3, 'England', 20, 'Sam Curran', 30, 1),
		(3, 'England', 36, 'Chris Jordan', 10, 1),
		(3, 'England', 88, 'Tom Curran', 0, 2),
		(3, 'England', 47, 'Adil Rashid', 0, 1),
		(3, 'England', 123, 'Jofra Archer', 0, 3);
    
insert into teams (Match_number, Team_name, Team_score)
	values
		(1, 'India', 350),
        (1, 'Australia', 320),
        (2, 'England', 330),
        (2, 'South Africa', 300),
        (3, 'India', 340),
        (3, 'England', 290);

/* b) Fetch the top 5 batsmen who scored the maximum runs. */
select Player_name, sum(Player_score) from players group by Player_name order by sum(Player_score) desc limit 5;

/* c) Fetch the top 5 bowlers who has taken the maximum wickets. */
select Player_name, sum(Wickets_taken) from players group by Player_name order by sum(Wickets_taken) desc limit 5;

/* d) Fetch the average score scored by each team considering the matches played. */
select Team_name, sum(Team_score)/count(Team_name) as Average_score from teams group by Team_name;

/* To solve Error Code 1175 */
SET SQL_SAFE_UPDATES = 0;

/* e) Increase the scores of each batsmen in the team, which has the least average computed in Step d, by 10 runs. */
set @minAvgTeam = (select Team_name from teams group by Team_name order by sum(Team_score)/count(Team_name) limit 1);
update players set Player_score = Player_score + 10 where Player_team = (select @minAvgTeam);

/* f) Create a procedure which takes country as the input and gives the highest score of the country up to date, as output */
DELIMITER $$

drop procedure if exists maxScore $$
create procedure maxScore(team varchar(32), out result int)
begin
	select max(Team_score) into result from teams where Team_name = team;
end $$

DELIMITER ;

call maxScore('England', @result);
select @result;
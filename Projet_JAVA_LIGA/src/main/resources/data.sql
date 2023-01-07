--INSERT Into employe (firstname,lastname) VALUES ('Azedine', 'C');
--INSERT Into employe (firstname,lastname) VALUES ('Salma', 'K');
--INSERT Into employe (firstname,lastname) VALUES ('Ilias', 'C');
--INSERT Into employe (firstname,lastname) VALUES ('Younes', 'C');
--INSERT Into employe (firstname,lastname) VALUES ('Ismael', 'C');
--INSERT INTO student (name,firstname,mail,dateofbirth) VALUES ('Paul','Jack','paul.jack@hotmail.be','2000-11-06');
--INSERT INTO student (name,firstname,mail,dateofbirth) VALUES ('Paul','Jack','pierre.jack@hotmail.be','2001-05-06');
--INSERT INTO student (name,firstname,mail,dateofbirth) VALUES ('Jean','Jack','jean.jack@hotmail.be','2002-10-06');
--INSERT INTO student (name,firstname,mail,dateofbirth) VALUES ('Adrien','paul','adrien.paul@hotmail.be','2003-07-02');
--INSERT INTO student (name,firstname,mail,dateofbirth) VALUES ('Albert','Jack','albert.jack@hotmail.be','2001-03-14');--
--INSERT INTO student (name,firstname,mail,dateofbirth) VALUES ('Albert','Hein','albert.hein@hotmail.be','1999-10-21');
--INSERT INTO student (name,firstname,mail,dateofbirth) VALUES ('Simon','pierre','simon.pierre@hotmail.be','1996-04-18');
--INSERT INTO student (name,firstname,mail,dateofbirth) VALUES ('Ben','Farid','ben.farid@hotmail.be','2000-02-05');
--INSERT INTO student (name,firstname,mail,dateofbirth) VALUES ('Alfred','Joe','alfred.joe@hotmail.fr','2009-07-15');


INSERT INTO ligue(nomligue, nombreequipe, numjournee) VALUES ('Liga Santander', 20, 14);



INSERT INTO equipe(nomequipe, nbrtitres, nbrpoints, nbrbuts) VALUES ('Real Madrid', 92, 35, 19);
INSERT INTO equipe(nomequipe, nbrtitres, nbrpoints, nbrbuts) VALUES ('Fc Barcelone', 91, 37, 28);
INSERT INTO equipe(nomequipe, nbrtitres, nbrpoints, nbrbuts) VALUES ('Atletico Madrid', 33, 24, 7);

INSERT INTO entraineur(firstnameentraineur, lastnameentraineur, clubactuelleentraineur, ageentraineur, equipe_id_entraineur) VALUES ('Carlo', 'Ancelotti', 'Real Madrid', 63, 1);
INSERT INTO entraineur(firstnameentraineur, lastnameentraineur, clubactuelleentraineur, ageentraineur, equipe_id_entraineur) VALUES ('Hernandez', 'Xavi', 'Fc Barcelone', 45, 2);

INSERT INTO joueur(firstnamejoueur, lastnamejoueur, poste, clubactuellejoueur, nbrbuts, agejoueur, equipe_id) VALUES ('Karim', 'Benzema', 'Bu', 'Real Madrid',10, 34, 1);
INSERT INTO joueur(firstnamejoueur, lastnamejoueur, poste, clubactuellejoueur, nbrbuts, agejoueur, equipe_id) VALUES ('Robert', 'Lewandowski', 'Bu', 'Fc Barcelone',18, 34, 2);
INSERT INTO joueur(firstnamejoueur, lastnamejoueur, poste, clubactuellejoueur, nbrbuts, agejoueur, equipe_id) VALUES ('Antoine', 'Griezmann', 'AT', 'Atletico Madrid',6, 31, 3);






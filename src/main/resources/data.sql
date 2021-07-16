
INSERT INTO korisnik(id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
				VALUES(1, 'b.pavlovic992@gmail.com', 'bojan', '$2y$12$P4kiIxbNDZUtudtZWMXVu.i.c8oPNAGGEEP62jYblZwz.JJY0vEoq ', 'Bojan', 'Pavlovic', 'ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
             	 VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
              
INSERT INTO magacin (id, naziv, adresa) VALUES (1, 'Magacin1', 'Industrijska zona BB Novi Sad');
INSERT INTO magacin (id, naziv, adresa) VALUES (2, 'Magacin2', 'Bul Jurija Gagarina BB Beograd');

INSERT INTO artikal (id, naziv, pakovanje, jedinica_mere, kolicina, kalkulisana_cena, magacin_id)
			 VALUES (1, 'Coca-Cola', 0.5, 'l', 1, 50, 1);
INSERT INTO artikal (id, naziv, pakovanje, jedinica_mere, kolicina, kalkulisana_cena, magacin_id)
			 VALUES (2, 'Milka', 90, 'g', 0, 0, 1);
INSERT INTO artikal (id, naziv, pakovanje, jedinica_mere, kolicina, kalkulisana_cena, magacin_id)
			 VALUES (3, 'Brasno', 1, 'kg', 2, 110, 2);	
			 
INSERT INTO stavka_prijema(id, kolicina, jedinicna_cena, artikal_id) VALUES (1, 1, 50,1);	
INSERT INTO stavka_prijema(id, kolicina, jedinicna_cena, artikal_id) VALUES (2, 2, 110,3);	
			 
              
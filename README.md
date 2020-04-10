# MemeScreenShare
Doyebany plugin na sprawdzanie.

## Permisje
- uzywanie komendy /sprawdz: screenshare.check
- uzywanie komendy /setsprawdz (ustawianie lokalizacji sprawdzania): screenshare.setcheck

## Komendy
- /sprawdz check (nick) - sprawdza gracza  
Gracz nie moze miec permisji screenshare.check, oraz nie moze byc sprawdzany przez 2 osoby na raz.
- /sprawdz czysty (nick) - ustawia gracza na czystego.  
Po ustawieniu statusu czystego, gracz zostaje przeteleportowany na swoją poprzednią lokalizację.  
- /sprawdz cheater (nick) - ustawia status sprawdzanego gracza na cheatera  
Po 20 sekundach (podstawowa wartosc ustawiona w configu), gracz zostaje zbanowany za pomocą komendy ustawionej w configu.  
Czas i powód też jest dostępny do ustalenia w configu  
 - /setsprawdz - ustawia lokalizację sprawdzania  
Jeżeli miejsce sprawdzania nie jest ustawione, gracz nie zostanie przeteleportowany.  
- /przyznajesie - przyznanie sie do posiadania niedozwolonych modyfikacji    
Komenda jest dostepna tylko dla graczy, którzy są sprawdzani.   
Po 20 sekundach (tak jak wyżej), gracz zostaje zbanowany.  

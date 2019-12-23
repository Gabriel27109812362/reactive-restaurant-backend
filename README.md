Reactive Restaurant - warstwa backend

Instrukcja odpalenia projektu

1. otwórz w terminalu folder z projektem
2. uruchom "npm i" żeby zainstalować zależności
3. w głównym folderze projektu stwórz plik ze zmiennymi środowiskowymi .env
4. dodaj w nim takie zmienne:

    APP_PORT
    API_KEY
    AUTH_DOMAIN
    DB_URL
    PROJECT_ID
    STORE_BUCKET
    MESS_SEND_ID
    APP_ID
    MEASURMENT_ID
    
5. Pod zmienną APP_PORT przypisz wolny port na którym ma nasłuchiwać aplikacja (port >= 3000, jeśli inna aplikacja nasłuchuje na porcie 3000 to port >3000) w następujący sposób:

    APP_PORT=3000
6. Pod resztę zmiennych przypisz odpowiednio prywatną konfigurację firebase którą znajdziesz w konsoli firebase w następujący sposób:

        API_KEY="***********"
        AUTH_DOMAIN="***********"
        DB_URL="***********"
        PROJECT_ID="***********"
        STORE_BUCKET="***********"
        MESS_SEND_ID="***********"
        APP_ID="***********"
        MEASURMENT_ID="***********"
        
 W razie wątpliwości zajżyj do pliku src/services/firebaseService.js

7. Po tych krokach należy uruchomić komendę "npm run postinstall" w celu zmapowania aliasów do ścieżek
    Komendę tą wystarczy uruchomić raz chyba że chcemy dodać nowy alias do jakiegoś folderu:
    
    Wtedu dodajemy alias w pliku package.json - dla środowiska developerskiego, w webpack.config.js dla środowiska produkcyjnego
    
    i uruchamiamy ponownie "npm run postinstal"
    
8. Następnie uruchamiamy projekt za pomocą polecenia "npm start" lub "npm run start"

    
     
 
        
  


# Setup
- nvm ( wget -qO- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.3/install.sh | bash )

Konsole neustarten

- nvm install 16.14.2
### in /frontend
- npm i
- npm run start-dev
### Projekt-Settings
- eventuell java installieren
- Projekt opem module settings java version auswählen (SDK hinterlegen)
- POM rechtscklick as Maven projekt
- View>Appearence>Toolbar
- (Edit configuartions npm start-dev)
### Docker
- sudo apt install docker.io
- docker run --name some-mongo -v /home/linus/db:/data/db -d -p 127.0.0.1:27017:27017 mongo:latest
- stop mongo with docker stop some-mongo
- start with docker start some-mongo
### Git
- cat /home/user/.ssh/id_rsa.pub wenn leer mit ssh keygen genrieren  
- Key in Git tkopieren
- sudo apt install git
- git commands

## To-Do
- [ ] Anmelde Form stylen
- [x] Upload Funktion ↓
- [ ] Upload Funktion mit User Abfrage, damit nur eingeloggte User hochladen können
- [ ] Suchleiste + Backend für Suche
- [ ] Like Button mit User Abfrage
- [ ] Bilder in Datenbank, API um Bilder zu skalieren, dann direkt laden
- [ ] Kommentare zu Code hinzufügen
- [x] README.md

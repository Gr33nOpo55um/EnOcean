# EnOcean

## Projektdokumentation

### Kurzbeschreibung
In diesem Projekt haben wir mit der Entwiklung einer Auswertungsumgebung für EnOcean Telegramme gestartet. Die Umgebung basiert auf Systemen. Das Kernstück bildet ein RaspberryPi Model 3 mit Arch Linux. Als zweitets System ist ein Dockercontainer mit Splunk im einsatz.

Am RaspberryPi wir der EnOcean USB300 Dongle verwendet um die Telegramme aufzuzeichen. Dazu haben wir eine Java Aplikation geschrieben welche unteranderem die enjlib (Javalibrary von EnOcean), sqlite-jdbc (Library für die Anbindung von SQLite Datenbanken) und log4j2 (Logging Library von Apache) verwenden. Zusätzlich wurden noch einige Librarys für die serielle Schnittstelle oder Persitierung verwendet. Die Java Aplikation emfängt und verarbeitet die Telegramme. Die Telegramme werden nach Packettyp in die einzelnen Felder aufgeteilt. Das ganze Telegramm und die zugehörigen Felder werden in die Datenbank gespeichert und in ein Logfile geschrieben.

Mittels rsync wird das Logfile auf den Dockercontainer verschoben und dort von Splunk indexiert. Durch den Einsatz von Splunk stehen uns nun viele Möglichkeiten für die Auswertung der Telegramme und deren Felder zur verfügung. Splunk würde ausserdem eine Alarmfunktion mitbringen. Eine detailierte Auswertung in Splunk haben wir in diesem Projekt nicht umgesetz. Zum jetztigen Stand steht nur eine Anzeige zur Verfügung.

Die Instalation auf dem RaspberryPi wurde mit einem Script automatisiert. Es muss nur das Betriebssystem, die Java Aplikation, die Configfiles und das Installationsscript auf den Raspberry kopiert werden. Das Skript instaliert / aktualisiert die benötigten Pakete, unter anderem jre8, java-rxtx und rsync.

### Dokument Projektmanagement
Für das Modul BTI7082 (Projektmanagement) wurde ein Leistungsnachweis im Zusammenhang mit diesem Projekt erstellt.
Zum Dokument: [PDF](/documentation/abgabe_projektmanagement.pdf)

### Statediagram
![Statediagram](/documentation/6_state_diagram.png)

### Sourcecode
ToDo: Doxygen


## Installation / Projekt Setup
Für die Installation notwendige Schritte.

Alle Dokumente werden in Markdown erfasst. Für das Betrachten der Dokumente empfielt sich der Atom Editor mit folgendem Plugin: https://atom.io/packages/markdown-preview-enhanced.

### RaspberryPi 3
ToDo

### Splunk (Docker Container)
ToDo

### ToDo für MacOS

Gnu RXTX Serial Driver http://jlog.org/v4/macosx/mac-10.5/librxtxSerial.jnilib in das Projektverzeichnis legen.
Pfad zum USB300 anpassen im config.properties (/dev/tty.usbserial-FTZ9SGXC).


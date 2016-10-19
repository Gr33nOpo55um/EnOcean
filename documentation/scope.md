## Aktuelle Situation

Die Firma Enoca AG ist spezialisiert auf Home Automationssysteme. Mit ihnen lassen sich zahlreiche Vorgänge automatisieren.
Automatische Jalousinen, temperaturgesteuerte Heizungen und funkbasierte Mess- und Steuersysteme.
Beim Installieren dieser Systeme muss den unterschiedlichsten Anforderungen Rechnung getragen werden.
Die meisten Lösungen welche verkauft werden sind kostenintensive Einzelanfertigungen.
In einer Zeit mit starkem Konkurenzdruck müssen Offerten mit sehr tiefen Margen herausgegeben werden.

Momentan müssen bei Installationsarbeiten die Räume von hand ausgemessen werden, dies erforderet eine hohe zeitliche Belastung der Technicker da Sie überen einen längerem Zeitraum vor Ort sein müssen.
Auch nach diesem Zeitraum ist nicht sichergestellt dass alles korrekt vermessen wurde und die Geräte immer genügend Funkkontakt haben, da dies auch durch das Wetter bestimmt wird.
Im schlimmsten Fall sind für das Unternehmen kostenintensive Nachbesserungen nötig, welche nur mit Unverständnis auf den Kunden abgewältzt werden könnten.

## Situation danach
Der Monteur soll mit mehren RasperryPis zum Kunden gehen können, welche mit Enocean Hardware bestückt sind. Sobald die Geräte am Strom sind, startet ein Analyse Tool.
Die erhaltenen Informationen werden in eine Datenbank gespeichert. Nach ca. 1 Woche holt der Monteur die Geräte wieder ab und wertet die Daten aus. Er kann nun sicher sein, wo die Repeater installiert werden müssen, um die gesamte Installation ohne Störungen betreiben zu können.


## Projekt Start / Projekt Ende
Das Projekt wird im Laufe des Herbstsemesters 2016/2017 stattfinden. Nach erfolgereichem Projekt soll der Sourcecode freigeben werden und als Opensource Projekt weitergeführt werden.

## Inhalte

Das Projekt beinhaltet folgende Architektur Komponten
- RasperryPi mit Linux
- SQLite Datenbank
- Enocean Hardware dongle


## Ziele

Mit dem zu erstellenden Enocean Analysetool soll es möglich sein die verschiedenen Geräte, welche mit dem Enocean Protokoll miteinander funken, zu katalogisieren und deren Signale zu deuten. Diese Daten können über einen beliebig langen Zeitraum erfasst werden. Das Tool schreibt diese in eine Datenbank, welche beim nächsten Besuch als Referenzwert dient.
In der Datenbank finden sich auch die Informationen welche Geräte technische Probleme haben.

### Wirtschaftlich
- Zeiteinsparung beim Analysieren der Geräte
- Der Monteur muss nur noch eine kurze Zeit vor Ort sein

### System
- Das System unterstützt den Techniker bei installieren neuer Geräte
- Das System stellt eine Datenbank für Auswertungen zur Verfügung

### Personell
- Personen welche bei installieren beteiligt sind können sich auf die Auswertung der gesammelten Daten konzentrieren

### Vorgehen
- Das System steht Technikern und Endanwendern zur Verfügung, eine Ablösung ist nicht nötig, da eine vorherige Lösung nicht existiert

### Qualität
- Das System kann durch den Endanwender durch einfaches Doppelklicken einer Datei ausgeführt werden
- Das System soll stabil sein und nicht durch Fehler in der Datensammlung unterbrochen werden.

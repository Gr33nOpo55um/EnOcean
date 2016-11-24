# Systemanforderungen

Aufraggeber     | Enoca AG
--------------- | ----------------
Projektleiter   | Louis Siegrist
Autor           | Silas Stegmüller
Klassifizierung | Intern
Status          | In Arbeit

Inhaltsverzeichnis

<!-- toc orderedList:0 depthFrom:1 depthTo:6 -->

- [Systemanforderungen](#systemanforderungen)
	- [Grobanforderungen](#grobanforderungen)
		- [Wirtschaftlich](#wirtschaftlich)
		- [System](#system)
		- [Personell](#personell)
		- [Vorgehen](#vorgehen)
		- [Qualität](#qualität)
		- [Sicherheit](#sicherheit)
		- [Nicht-Ziele](#nicht-ziele)
	- [Übersicht](#übersicht)
		- [Technik: Funktionsbaum](#technik-funktionsbaum)
		- [Technik: Use Case](#technik-use-case)
			- [Use Case Diagramm](#use-case-diagramm)
	- [Detailanforderungen](#detailanforderungen)
		- [Anforderungen der Geschäftsorganisation](#anforderungen-der-geschäftsorganisation)
		- [Funktionale Anforderungen](#funktionale-anforderungen)
			- [Technik 2: Beschreibung mittels User-Story](#technik-2-beschreibung-mittels-user-story)
			- [Technik 3: Beschreibung mittels Use-Case](#technik-3-beschreibung-mittels-use-case)
		- [Qualitätsanforderungen](#qualitätsanforderungen)
		- [Anforderungen Systemarchitektur](#anforderungen-systemarchitektur)
- [Systemarchitektur](#systemarchitektur)
	- [Übersicht und Struktur des Systems](#übersicht-und-struktur-des-systems)
		- [Übersicht](#übersicht-1)
		- [Architekturen / Modelle](#architekturen-modelle)
	- [Schnittstellen und Abgrenzung](#schnittstellen-und-abgrenzung)
	- [Machbarkeit](#machbarkeit)
	- [Anforderungsabdeckung](#anforderungsabdeckung)

<!-- tocstop -->

 ## Grobanforderungen

### Wirtschaftlich

- Zeiteinsparung beim Analysieren der Geräte.
- Der Monteur muss nur noch eine kurze Zeit vor Ort sein.
- Das Gerät kostet mit geschätzten Materialkosten von ca. 100 Franken nur ein Bruchteil anderer kommerzieller Geräte.

  ### System

- Das System unterstützt den Techniker bei installieren neuer Geräte.

- Das System stellt eine Datenbank für Auswertungen zur Verfügung.

  ### Personell

- Personen welche bei installieren beteiligt sind können sich auf die Auswertung der gesammelten Daten konzentrieren.

  ### Vorgehen

- Das System steht Technikern und Endanwendern zur Verfügung, eine Ablösung ist nicht nötig, da eine vorherige Lösung nicht existiert.

  ### Qualität

- Das System wird automatisch gestartet, sobald das Gerät am Strom angeschlossen wird.

- Das System soll stabil sein und nicht durch Fehler in der Datensammlung unterbrochen werden.

  ### Sicherheit

- Da der Benutzer ebenfalls einen begrenzten Zugang zum System haben wird muss sichergestellt werden, dass er nur auch seine Daten Zugriff hat. Allfällige andere Daten von andere Kunden müssen daher in gesonderten und geschützten Verzeichnissen abgelegt werden.

  ### Nicht-Ziele

- Zeil dieser Lösung wird nur die automatische Datenerfassung und Darstellung sein. Wie die Daten interpretiert werden müssen, muss vom Monteur entschieden werden.

- Es wird nicht möglich sein, Komponenten zu steuern oder Ihnen Befehle zu senden. Der Fokus liegt in der Einfachheit der Anwendung.

## Übersicht

### Technik: Funktionsbaum

### Technik: Use Case

#### Use Case Diagramm

```{puml}
@startuml
:User:
:Monteur:
:Endkunde:

User --|> Endkunde
User --|> Monteur


User -> (Umgebung starten)
User -> (Statistik aufrufen)

Monteur -> (Aufzeichnung Vergleichen)

@enduml
```

## Detailanforderungen

### Anforderungen der Geschäftsorganisation

### Funktionale Anforderungen

#### Technik 2: Beschreibung mittels User-Story

- Als Monteur möchte ich die Zeit welche ich beim Kunden verbringe so eiffzient wie möglich einsezen.

- Ich möchte Abläufe wie die Ausmessung der Enocean Abdeckung automatisieren.

#### Technik 3: Beschreibung mittels Use-Case

```{puml}
@startuml
:User:
:Monteur:
:Endkunde:

User --|> Endkunde
User --|> Monteur


User -> (Umgebung starten)
User -> (Statistik aufrufen)

Monteur -> (Aufzeichnung Vergleichen)

@enduml
```

### Qualitätsanforderungen

Name                         | Einfachheit
---------------------------- | --------------------------------------------------------------------------------------------------------------
Beschreibung                 | Das System wird automatisch gestartet, sobald das Gerät am Strom angeschlossen wird.
Abnahmekriterien             | Das Gerät startet, sobald es am Strom angeschlossen ist. Dazu ist keine zusätzliche Userinteraktion notwendig.
Wichtigkeit (5-1): 4         | Dringlichkeit (5-1): 2                                                                                         |
Risiko/Kritikalität (5-1): 2 | Aufwandgrösse (5-1): 2                                                                                         |

### Anforderungen Systemarchitektur

Name                         | Stabilität
---------------------------- | --------------------------------------------------------------------------------------------
Beschreibung                 | Das System soll stabil sein und nicht durch Fehler in der Datensammlung unterbrochen werden.
Abnahmekriterien             | Das Produkt muss über einen Zeitraum von mindestens 3 Tagen unterbrochen Datensammeln.
Wichtigkeit (5-1): 5         | Dringlichkeit (5-1): 4
Risiko/Kritikalität (5-1): 3 | Aufwandgrösse (5-1): 4

Name                       | Datenkonsistenz bei Stromunterbruch
-------------------------- | ------------------------------------------------------------------------------------------------------------------------------------
Beschreibung               | Das System soll im Falle eines Stromunterbruchs, keine Daten verlieren und selbstständig wieder mit dem Loggen von Daten beginnen.
Abnahmekriterien           | Das Produkt wird 3 Stromunterbrüche im Zeitraum von 60 min erhalten und muss danach automatisch mit der Datenspeicherung fortfahren. Dabei wird auf die Bestehende DB ohne Datenverlust geschrieben.
Wichtigkeit (5-1):         | Dringlichkeit (5-1):
Risiko/Kritikalität (5-1): | Aufwandgrösse (5-1):

# Systemarchitektur
## Übersicht und Struktur des Systems

Übersichtsdiagramme gemäss den Methoden des Erstellers

### Übersicht

```{puml}
@startuml
node "Project" {
  node {
    [Rasperry PI]
    }


    database "SQlite" {
      folder "Enocean Telegrams" {
        [Data]
        }

    }
}

[Enocean Device 1] --> [Rasperry PI]
[Enocean Device 2] --> [Rasperry PI]
[Enocean Device 3] --> [Rasperry PI]


[Rasperry PI] --> [Data]

@enduml
```



### Architekturen / Modelle

Hinweis auf Detailstudien Abhängig vom Projektergebnis. Beispielsweise Geschäftsprozessmodell, Funktionsmodell (z.B. mit UseCases/Userstories), Datenarchitektur/ Datenmodell etc. Technische Architektur des IT-Systems Eingesetzte Produkte, Versionen

## Schnittstellen und Abgrenzung

```{puml}
@startuml

[Enocean Device 1] --> [Enocean Stick]
[Enocean Device 2] --> [Enocean Stick]
[Enocean Device 3] --> [Enocean Stick]


[Enocean Stick] --> [Java Applikation]

[Java Applikation] --> [MariaDB]
[Java Applikation] --> [Linux]
[Linux] --> [MariaDB]
[Linux] --> [File System (SD Card)]
[MariaDB] --> [File System (SD Card)]
[Rasperry PI] --> [Data]

@enduml
```

## Machbarkeit

Die Techniken welche vorgehesehen sind, werden bereits heute gebraucht.

Zudem wurde bereits ein POC mit der Enocean Java library durchgeführt. Dieser POC hat gezeigt, dass ohne weiteres Telegramme gelesen und weiterverarbeitet werden.

## Anforderungsabdeckung

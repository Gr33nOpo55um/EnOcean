# Systemanforderungen

Aufraggeber     | Enoca AG
--------------- | ----------------
Projektleiter   | Louis Siegrist
Autor           | Silas Stegmüller
Klassifizierung | Intern
Status          | In Arbeit

# Inhaltsverzeichnis

<!-- toc orderedList:0 depthFrom:1 depthTo:6 -->

- [Systemanforderungen](#systemanforderungen)
- [Inhaltsverzeichnis](#inhaltsverzeichnis)
- [Aktuelle Situation](#aktuelle-situation)
- [Situation danach](#situation-danach)
- [Ziele](#ziele)
- [Systemkontext](#systemkontext)
	- [Grobanforderungen](#grobanforderungen)
		- [Wirtschaftlichkeit](#wirtschaftlichkeit)
		- [Einsparungen für den Monteur](#einsparungen-für-den-monteur)
		- [System](#system)
		- [Personell](#personell)
		- [Qualität](#qualität)
		- [Sicherheit](#sicherheit)
		- [Nicht-Ziele](#nicht-ziele)
	- [Übersicht](#übersicht)
		- [Technik: Use Case](#technik-use-case)
			- [Use Case Diagramm](#use-case-diagramm)
	- [Detailanforderungen](#detailanforderungen)
		- [Anforderungen der Geschäftsorganisation](#anforderungen-der-geschäftsorganisation)
		- [Funktionale Anforderungen](#funktionale-anforderungen)
			- [Technik 1: Beschreibung mittels User-Story](#technik-1-beschreibung-mittels-user-story)
			- [Technik 2: Beschreibung mittels Use-Case](#technik-2-beschreibung-mittels-use-case)
		- [Wirtschaftlichkeit](#wirtschaftlichkeit-1)
		- [System](#system-1)
		- [Qualität](#qualität-1)
		- [Sicherheit](#sicherheit-1)
		- [Anforderungen Systemarchitektur](#anforderungen-systemarchitektur)
- [Systemarchitektur](#systemarchitektur)
	- [Übersicht und Struktur des Systems](#übersicht-und-struktur-des-systems)
		- [Übersicht](#übersicht-1)
		- [Architekturen / Modelle](#architekturen-modelle)
	- [Schnittstellen und Abgrenzung](#schnittstellen-und-abgrenzung)
	- [Machbarkeit](#machbarkeit)
	- [Anforderungsabdeckung](#anforderungsabdeckung)

<!-- tocstop -->

 # Aktuelle Situation

Die Firma Enoca AG ist spezialisiert auf Home Automationssysteme. Mit ihnen lassen sich zahlreiche Vorgänge automatisieren. Automatische Jalousinen, temperaturgesteuerte Heizungen und funkbasierte Mess- und Steuersysteme. Beim Installieren dieser Systeme muss den unterschiedlichsten Anforderungen Rechnung getragen werden. Die meisten Lösungen welche verkauft werden sind kostenintensive Einzelanfertigungen. In einer Zeit mit starkem Konkurrenzdruck müssen Offerten mit sehr tiefen Margen herausgegeben werden.

Momentan müssen bei Installationsarbeiten die Räume von Hand ausgemessen werden, dies erfordert eine hohe zeitliche Belastung der Techniker da Sie über einen längerem Zeitraum vor Ort sein müssen. Auch nach diesem Zeitraum ist nicht sichergestellt dass alles korrekt vermessen wurde und die Geräte immer genügend Funkkontakt haben, da dies auch durch das Wetter bestimmt wird. Im schlimmsten Fall sind für das Unternehmen kostenintensive Nachbesserungen nötig, welche nur mit Unverständnis auf den Kunden abgewälzt werden könnten.

# Situation danach

Aus diesem Grund will die Enoca AG ein Gerät entwickeln welches dieses Problem löst. Der Monteur soll mit mehren RasperryPi's zum Kunden gehen können, welche mit Enocean Hardware bestückt sind. Sobald die Geräte am Strom sind, startet ein Analyse Tool. Die erhaltenen Informationen werden in eine Datenbank gespeichert. Nach ca. 1 Woche holt der Monteur die Geräte wieder ab und wertet die Daten aus. Er kann nun sicher sein, wo die Repeater installiert werden müssen, um die gesamte Installation ohne Störungen betreiben zu können.

# Ziele

Mit dem zu erstellenden Enocean Analysetool soll es möglich sein die verschiedenen Geräte, welche mit dem Enocean Protokoll 3.0 miteinander funken, zu katalogisieren und deren Signale zu deuten. Diese Daten können über einen beliebig langen Zeitraum erfasst werden (Bis der Speicherplatz des Gerätes erschöpft ist). Das Tool schreibt diese in eine Datenbank, welche beim nächsten Besuch als Referenzwert dient. In der Datenbank finden sich auch die Informationen welche Gerätetechnische Probleme haben. Bei diesem Projekt liegt der Fokus ganz klar auf der Datenerfassung.
Später in einem weiteren Nachfolgeprojekt ist nicht auszuschliessen, dass auch eine Datenanalyse Teil der Lösung sein wird.




# Systemkontext

![system context diagram](http://www.plantuml.com/plantuml/png/oyjFILLG2YZApqfDBb5IgEPIKCW32O4O2WhHGOd51Qb5HPKA0PwnO95QBYumdP9OafYKM0pK6noOarcI2j4AqfEMdvEIMgIWv9gNdvoQcASGafgJcbwKc5kCK08qs0Me7s8YI0_GL0W5P4J3DBgabcKcfoeOnYhewjgXEGLTaH4nYeonAG9QYEn9Y5rWrm40)

Mehre Enocean Funkgeräte senden ihre Signale. Diese werden dann von einem Einplatinenrechner mit USB Dongle empfangen. Der Einplatinenrechner wertet diese Informationen dann aus und speichert sie in eine Datenbank. Von dort aus können die Daten weiter ausgelesen werden. Sei dies für eine Webseite oder eine Analyseapplikation.

## Grobanforderungen

### Wirtschaftlichkeit

Die Monitoringlösung sollte Elektrikern und Elektroinstallateuren die mit EnOcean Komponenten vor Ort Installationsarbeiten durchführen die Arbeit vereinfachen und so eine zu einer massiven Zeiteinsparung führen. So kann wetvolle Zeit sowohl beim Kunden wie auch beim Monteur eingespart werden. Diese Zeiteinsparung soll den finanziellen Aufwand für die Anschaffung des Produktes aufwiegen. Ebenfalls soll dem Kunden durch die Datenerhebung einen Mehrwert geboten werden.

### Einsparungen für den Monteur

Der Monteur der die Installationsarbeiten der EnOcean Komponenten vor Ort durchführt, muss nach der Installation die reibungslose Funktion testen, dazu muss er die Funktion aller Komponenten manuell durch gehen. Wenn eine Komponente nicht einwandfrei funktioniert, gestalltet sich die Fehlersuche äuserst Zeitaufwändig. Gerade bei einer unstabilen Funkverbindung können viele Faktoren mitspielen. Der Monteur muss mit einem Notebook und einem Funkempfänger die Wohnung abschreiten und manuell Messungen zur Signalqualität durchführen.

##

Kosten | Betrag in CHF
------ | --
Hardware | 120
Etwicklungskosten | 6000
Nutzen | -

- Zeiteinsparung beim Analysieren der Geräte.
- Der Monteur muss nur noch eine kurze Zeit vor Ort sein.
- Das Gerät kostet mit geschätzten Materialkosten von ca. 100 Franken nur ein Bruchteil anderer kommerzieller Geräte.

  ### System

- Das System unterstützt den Techniker bei installieren neuer Geräte.

- Das System stellt eine Datenbank für Auswertungen zur Verfügung.

  ### Personell

- Personen welche bei installieren beteiligt sind können sich auf die Auswertung der gesammelten Daten konzentrieren.



  ### Qualität

- Das System wird automatisch gestartet, sobald das Gerät am Strom angeschlossen wird.

- Das System soll stabil sein und nicht durch Fehler in der Datensammlung unterbrochen werden.

  ### Sicherheit

- Da der Benutzer ebenfalls einen begrenzten Zugang zum System haben wird muss sichergestellt werden, dass er nur auch seine Daten Zugriff hat. Allfällige andere Daten von andere Kunden müssen daher in gesonderten und geschützten Verzeichnissen abgelegt werden.

  ### Nicht-Ziele

- Zeil dieser Lösung wird nur die automatische Datenerfassung und Darstellung sein. Wie die Daten interpretiert werden müssen, muss vom Monteur entschieden werden.

- Es wird nicht möglich sein, Komponenten zu steuern oder Ihnen Befehle zu senden. Der Fokus liegt in der Einfachheit der Anwendung.

## Übersicht

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

#### Technik 1: Beschreibung mittels User-Story

- Als Monteur möchte ich die Zeit welche ich beim Kunden verbringe so eiffzient wie möglich einsezen.

- Ich möchte Abläufe wie die Ausmessung der Enocean Abdeckung automatisieren.

#### Technik 2: Beschreibung mittels Use-Case

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

### Wirtschaftlichkeit

### System

Name                         | Simplicy
---------------------------- | --------------------------------------------------------------------------------------------------------------
Beschreibung                 | Die Anwender sollen die Box nur einstecken können und es soll keine zusätzliche Konfiguration notwendig sein. Der Start der Datenaufnahme soll auch durch unqualifiziertes Personal möglich sein.
Abnahmekriterien             | Das Gerät muss nach dem einstecken in eine Stromquelle automatisch seinen Dienst verrichten.
Wichtigkeit (5-1): 4         | Dringlichkeit (5-1): 5                                                                                         |
Risiko/Kritikalität (5-1): 2 | Aufwandgrösse (5-1): 3                                                                                         |


Name                         | Datastore
---------------------------- | --------------------------------------------------------------------------------------------------------------
Beschreibung                 | Alle Daten von Encocean Geräten welche dem Protokoll 3.0 entsprechen und der USB Dongle empfängt werden in die Datenbank gespeichert. Dies betrifft auch fehlerhafte Telegramme, sei es durch defekte Geräte.
Abnahmekriterien             | Es werden dem System 20 zufällig generierte Packete mit korrekte Struktur, aber fehlerhaften Daten gesendet, welche in der DB abgespeichert werden müssen.
Wichtigkeit (5-1): 4         | Dringlichkeit (5-1): 2                                                                                         |
Risiko/Kritikalität (5-1): 2 | Aufwandgrösse (5-1): 2                                                                                         |







### Qualität

Name                         | Einfachheit
---------------------------- | --------------------------------------------------------------------------------------------------------------
Beschreibung                 | Das System wird automatisch gestartet, sobald das Gerät am Strom angeschlossen wird.
Abnahmekriterien             | Das Gerät startet, sobald es am Strom angeschlossen ist. Dazu ist keine zusätzliche Userinteraktion notwendig.
Wichtigkeit (5-1): 4         | Dringlichkeit (5-1): 2                                                                                         |
Risiko/Kritikalität (5-1): 2 | Aufwandgrösse (5-1): 2                                                                                         |


### Sicherheit



Name                         | Security
---------------------------- | --------------------------------------------------------------------------------------------------------------
Beschreibung                 | Da der Benutzer ebenfalls einen begrenzten Zugang zum System haben wird muss sichergestellt werden, dass er nur auch seine Daten Zugriff hat. Allfällige andere Daten von andere Kunden müssen daher in gesonderten  Verzeichnissen abgelegt werden. Da die Daten aber keine Rückschlüsse auf einzelene Personen ermöglichen ist keine Verschlüsselung notwendig.
Abnahmekriterien             | Sobald das System vom Strom getrennt wird, wird ein neues Verzeichnis angelegt, mit einem neuen Datastore, damit hat der Kunde keine Möglichkeit auf die Daten anderer Kunden zuzugreifen.
Wichtigkeit (5-1): 4         | Dringlichkeit (5-1): 4                                                                                         |
Risiko/Kritikalität (5-1): 2 | Aufwandgrösse (5-1): 4                                                                                         |



### Anforderungen Systemarchitektur

Name                         | Stabilität
---------------------------- | --------------------------------------------------------------------------------------------
Beschreibung                 | Das System soll stabil sein und nicht durch Fehler in der Datensammlung unterbrochen werden.
Abnahmekriterien             | Das Produkt muss über einen Zeitraum von mindestens 3 Tagen unterbrochen Datensammeln.
Wichtigkeit (5-1): 5         | Dringlichkeit (5-1): 4
Risiko/Kritikalität (5-1): 3 | Aufwandgrösse (5-1): 4

Name                       | Datenkonsistenz bei Stromunterbruch
-------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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

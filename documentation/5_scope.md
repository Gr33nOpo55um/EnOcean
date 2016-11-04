# Ziele und Scope

<!-- toc orderedList:0 -->

- [Ziele und Scope](#ziele-und-scope)
- [Aktuelle Situation](#aktuelle-situation)
- [Situation danach](#situation-danach)
- [Projekt Start / Projekt Ende](#projekt-start-projekt-ende)
- [Inhalte](#inhalte)
- [Ziele](#ziele)
	- [Wirtschaftlich](#wirtschaftlich)
	- [System](#system)
	- [Personell](#personell)
	- [Vorgehen](#vorgehen)
	- [Qualität](#qualität)
	- [Sicherheit](#sicherheit)
- [Nicht-Ziele](#nicht-ziele)
- [Systemkontext](#systemkontext)

<!-- tocstop --><br><br>

# Aktuelle Situation

Die Firma Enoca AG ist spezialisiert auf Home Automationssysteme. Mit ihnen lassen sich zahlreiche Vorgänge automatisieren. Automatische Jalousinen, temperaturgesteuerte Heizungen und funkbasierte Mess- und Steuersysteme. Beim Installieren dieser Systeme muss den unterschiedlichsten Anforderungen Rechnung getragen werden. Die meisten Lösungen welche verkauft werden sind kostenintensive Einzelanfertigungen. In einer Zeit mit starkem Konkurrenzdruck müssen Offerten mit sehr tiefen Margen herausgegeben werden.

Momentan müssen bei Installationsarbeiten die Räume von Hand ausgemessen werden, dies erfordert eine hohe zeitliche Belastung der Techniker da Sie über einen längerem Zeitraum vor Ort sein müssen. Auch nach diesem Zeitraum ist nicht sichergestellt dass alles korrekt vermessen wurde und die Geräte immer genügend Funkkontakt haben, da dies auch durch das Wetter bestimmt wird. Im schlimmsten Fall sind für das Unternehmen kostenintensive Nachbesserungen nötig, welche nur mit Unverständnis auf den Kunden abgewälzt werden könnten.

# Situation danach

Aus diesem Grund will die Enoca AG ein Gerät entwickeln welches dieses Problem löst. Der Monteur soll mit mehren RasperryPi's zum Kunden gehen können, welche mit Enocean Hardware bestückt sind. Sobald die Geräte am Strom sind, startet ein Analyse Tool. Die erhaltenen Informationen werden in eine Datenbank gespeichert. Nach ca. 1 Woche holt der Monteur die Geräte wieder ab und wertet die Daten aus. Er kann nun sicher sein, wo die Repeater installiert werden müssen, um die gesamte Installation ohne Störungen betreiben zu können.

![enter image description here](http://www.plantuml.com/plantuml/img/JOwn3i8m34HtVqL66Fe36QfqO6H2PG_42L5R8oNsKl7no6ahsCxtxavsI46M6S1LzeLLsh5YiM2lRs8KLHSAar102w3CTDsdDuVvP-qDE6AzEOrBmeTGCcqUwVn3D_QSA-V9U8b5eaBO9rfWaBXYVhv8-tSiQTQhnTpszXS0)

# Projekt Start / Projekt Ende

Das Projekt wird im Laufe des Herbstsemesters 2016/2017 stattfinden. Nach erfolgreichem Projekt soll der Sourcecode freigeben werden und als OpenSource Projekt weitergeführt werden.

# Inhalte

Das Projekt beinhaltet folgende Architektur Komponenten:

- RasperryPi mit Linux
- SQLite Datenbank
- Enocean Hardware Dongle

# Ziele

Mit dem zu erstellenden Enocean Analysetool soll es möglich sein die verschiedenen Geräte, welche mit dem Enocean Protokoll miteinander funken, zu katalogisieren und deren Signale zu deuten. Diese Daten können über einen beliebig langen Zeitraum erfasst werden. Das Tool schreibt diese in eine Datenbank, welche beim nächsten Besuch als Referenzwert dient. In der Datenbank finden sich auch die Informationen welche Geräte technische Probleme haben. Bei diesem Projekt liegt der Fokus ganz klar auf der Datenerfassung. Später in einem weiteren Nachfolgeprojekt ist nicht auszuschliessen, dass auch eine Datenanalyse Teil der Lösung sein wird.

## Wirtschaftlich

- Zeiteinsparung beim Analysieren der Geräte.
- Der Monteur muss nur noch eine kurze Zeit vor Ort sein.
- Das Gerät kostet mit geschätzten Materialkosten von ca. 100 Franken nur ein Bruchteil anderer kommerzieller Geräte.

## System

- Das System unterstützt den Techniker bei installieren neuer Geräte.
- Das System stellt eine Datenbank für Auswertungen zur Verfügung.

## Personell

- Personen welche bei installieren beteiligt sind können sich auf die Auswertung der gesammelten Daten konzentrieren.

## Vorgehen

- Das System steht Technikern und Endanwendern zur Verfügung, eine Ablösung ist nicht nötig, da eine vorherige Lösung nicht existiert.

## Qualität

- Das System wird automatisch gestartet, sobald das Gerät am Strom angeschlossen wird.
- Das System soll stabil sein und nicht durch Fehler in der Datensammlung unterbrochen werden.

## Sicherheit

- Da der Benutzer ebenfalls einen begrenzten Zugang zum System haben wird muss sichergestellt werden, dass er nur auch seine Daten Zugriff hat. Allfällige andere Daten von andere Kunden müssen daher in gesonderten und geschützten Verzeichnissen abgelegt werden.

# Nicht-Ziele

- Zeil dieser Lösung wird nur die automatische Datenerfassung und Darstellung sein. Wie die Daten interpretiert werden müssen, muss vom Monteur entschieden werden.
- Es wird nicht möglich sein, Komponenten zu steuern oder Ihnen Befehle zu senden. Der Fokus liegt in der Einfachheit der Anwendung.

# Systemkontext

![system context diagram](http://www.plantuml.com/plantuml/png/oyjFILLG2YZApqfDBb5IgEPIKCW32O4O2WhHGOd51Qb5HPKA0PwnO95QBYumdP9OafYKM0pK6noOarcI2j4AqfEMdvEIMgIWv9gNdvoQcASGafgJcbwKc5kCK08qs0Me7s8YI0_GL0W5P4J3DBgabcKcfoeOnYhewjgXEGLTaH4nYeonAG9QYEn9Y5rWrm40)

//Abschnitt gerneralisieren, aktuell noch zu spezifisch, dafür etwas detailierter.

Mehre Enocean Devices senden ihre Signale. Der Rasperry PI fängt diese Signale auf und speichert diese in eine SQL Datenbank. Von dort aus können die Daten dann ausgelesen werden.

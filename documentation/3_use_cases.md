# Fall 1, Monteur sicht
@startuml


(Umgebung starten)
(Aufzeichnung starten)
(Aufzeichnung beenden)
(Aufzeichnung vergleichen)





@enduml


# Fall 2, Endkunde Strommessung
@startuml


(Umgebung starten)
(Aufzeichnung starten)
(Statistik aufrufen)





@enduml

@startuml
:User:
:Monteur:
:Endkunde:

User --|> Endkunde
User --|> Monteur


User -> (Umgebung starten)
User -> (Aufzeichnung starten) 
User -> (Statistik aufrufen)

Monteur -> (Aufzeichnung Vergleichen)

@enduml



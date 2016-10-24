# Fall 1, Monteur sicht
```{puml}
@startuml


(Umgebung starten)
(Aufzeichnung starten)
(Aufzeichnung beenden)
(Aufzeichnung vergleichen)





@enduml
```


# Fall 2, Endkunde Strommessung
```{puml}
@startuml


(Umgebung starten)
(Aufzeichnung starten)
(Statistik aufrufen)



@enduml
```

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

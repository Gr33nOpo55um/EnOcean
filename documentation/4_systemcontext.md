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

```{puml}

@startuml

[*] --> RasperryPI
RasperryPI --> RasperryPI
RasperryPI --> enocaService
enocaService --> Java
Java --> EnOceanApp
EnocaListener --> EnOceanApp
EnOceanApp --> EnocaListener

RasperryPI : Arch Linux is running, fully working Linux
enocaService : Enoca Service, can be started with systemd
Java : Run the JVM with optimised Parameters
EnOceanApp: Java Application in Jar Container
EnocaListener: Listen to the telegrams

@enduml


```

```{puml}
@startuml



' Class
abstract class TelegramHeader{
private String data;
private String telegram;
private String syncByte;
private int dataLength;
private int optionalLenght;
private String crcHeader;
private String crdData
}

class RadioERP1{

private int subTelNum;
private String destinationID;
private int dbm;
private String securityLevel;
}


class Response{
private int returnCode;
}

class RadioSubTel{
private int subTelNum;
private String destinationID;
private int dbm;
private String securityLevel;
private Date timeStamp;
private int tickSubTel;
private int dbmSubTel;
private String statusSubTel;
}

class Event{
private int EventCode;
private String EventData;

}


class CommonCommand{

private int ccCode;
private String ccData;
}


class SmartAckCommand{
private int smartAckCommandNr;
private String smartAckCommandData;

}


class RemoteManCommand{
private String destinationID;
private String sourceID;
private int dbm;
private int sendDelay;

}

class Radiomessage{

private String destinationID;
private String sourceID;
private int dbm;

}

class RadioERP2{
private String int subTelNum;
private String int dbm;

}


class Radio{

private int rssi;
}



' interfaces
interface Collection{
void encode();
void decode();
}

interface Persistance{
void Store();
}







' Relations
Response <|--	TelegramHeader

CommonCommand <|--	TelegramHeader
SmartAckCommand <|--	TelegramHeader
RemoteManCommand <|--	TelegramHeader
Radiomessage <|--	TelegramHeader
RadioERP2 <|--	TelegramHeader
Radio <|--	TelegramHeader



Event <|--	TelegramHeader
RadioSubTel<|--	TelegramHeader
RadioERP1 <|--	TelegramHeader
TelegramHeader .. Collection
TelegramHeader .. Persistance




/'


class SaConfirmLearn {
private int eventCode;
private String priority;
private String manufacturer;
private String eep;
private int RSSI;
private String canidateID;
private String ackClientID;
private int HopCount;

}

class SaConfirmLearnResponse{
private int returnCode;
private int responsetime;
private int confirmCode;
}

class SaLearnAck {
private int eventCode;
private int responseTime;
private int confirmCode;
}


class SaLearnAck{
private int eventCode;
private int responseTime;
private int confirmCode;

}


class CoReady{
private int eventCode;
private int resetCode;

}


class CoEventSecuredevices{
private int eventCode;
private int eventCause;
private String deviceID;

}



class CoDutyCycleLimit{
private int eventCode;
private int eventCause;

}


class CoTransmitFailed{
private int eventCode;
private int eventCause;
}
'/

@enduml
```

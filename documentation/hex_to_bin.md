print(bin(0x 55 (sync)  00 07 (Data length)   07(optional data lentgh )    01 (package type)  7a (checksum)   f6700022a13430 (data)   01ffffffff2d00  (optional data)  44 (checksum)




![Bildschirmfoto von »2016-10-21 11-40-43«](</assets/Bildschirmfoto von »2016-10-21 11-40-43«.png>)

![Bildschirmfoto von »2016-10-21 11-41-29«](</assets/Bildschirmfoto von »2016-10-21 11-41-29«.png>)


Sync byte = 0+2, must be 55
header = 2+ 8 = 10
crc8h = 10+2
Data = 12+length(data_lenght)
Optional data= 13+length(header)+length(optional lenght)
last byte checksum

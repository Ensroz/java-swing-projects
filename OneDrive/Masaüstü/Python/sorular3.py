def toplama(a,b):
    print(a,b)

x=toplama(3,4)
print(x)
def usselişlem(x=5,y=3):
    print(x**y)

usselişlem(2,4)
usselişlem(5,3)
def myLoop(*args):
    for element in args:
        print(element / 2)
myLoop(3,2,1,5,3,4)        

List=[]
myList=[2,3,4,5,6]
def myFunc(num):
    for x in num:
        List.append(x**3)
myFunc(myList)
print(List)
barkodDizisi = ["ABC231","SA3123XYZ","XYZA123Q","QRE1231KJ","X112QGL"]
newBarkod=[]
for x in barkodDizisi:
    if x=="...X...":
        newBarkod.append(x)
print(newBarkod)



myVar = "Atil Samancioglu"

def ornekFonksiyon():
    myVar = "Atil"
    
    def digerFonksiyon():
        print(myVar)
    
    digerFonksiyon()
ornekFonksiyon()  
class Kedi():
        
    def __init__(self,isim,yas=5):
        self.isim = isim
        self.yas = yas
        
    def yasiCarp(self):
        return self.yas * 3
kedim = Kedi("Tonton")
kedim.yasiCarp()
class Ogrenci():
    
    def __init__(self,isim,sinavNotu):
        self.isim = isim
        self.__sinavNotu = sinavNotu
    
    def notuGoster(self):
        print(f"{self.isim} sınav notu: {self.__sinavNotu}")
ogrenci = Ogrenci("Mehmet",85)
ogrenci.__sinavNotu = 75
ogrenci.notuGoster()  

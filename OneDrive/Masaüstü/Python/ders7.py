#polymorphism
class Banana():
    def __init__(self,name):
        self.name=name
    def info(self):
        return print("100 kalori",self.name)

class Apple():
    def __init__(self,name):
        self.name=name
    def info(self):
        return print("150 kalori",self.name)
banana=Banana("banana")
apple=Apple("apple")
fruitList=[banana,apple]
for fruit in fruitList:
    print(fruit.info())

#encapsulation
class Phone():
    def __init__(self,name,price):
        self.name=name
        self.__price=price
    def info(self):
        print("Marka:",self.name ,"Fiyat:",self.__price)
    def changeprice(self,value):
        self.__price=value
iphone=Phone("Iphone 14",300)
iphone.info()
iphone.__price=500
iphone.info()

iphone.changeprice(500)
iphone.info()       



class Person():
    name=""
    age=0
    gender=""
    #method, initializer
    def __init__(self,age,name,gender):
        self.age=age
        self.name=name
        self.gender=gender
        print("init excuted")
        def test(self):
            print("test")  

ensar=Person(30,"Ensar","male")

class Dog():
    year=7
    def __init__(self,age):
        self.age=age
        self.dogHumanage=age*self.year
    def humanYear(self): #1. yöntem
        return self.age*self.year
 
myDog=Dog(3)
print(myDog.age)
print(myDog.humanYear())
print(myDog.dogHumanage)
#inheritance
class Musician():
    def __init__(self,name):
        self.name=name
        print("Musician class")
    def test1(self):
        print("test1")
    def test2(self):
        print("test2")

class MusicianPlus(Musician):
    def __init__(self,name):
        Musician.__init__(self,name)
        print("Musician plus")

atlas=MusicianPlus("Ensar")
print(atlas.name)

        


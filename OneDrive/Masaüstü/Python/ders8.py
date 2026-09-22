#abstraction
from abc import ABC, abstractmethod
class Car(ABC):
    @abstractmethod
    def maxSpeed(self):
        pass

class Tesla(Car):
    def maxSpeed(self):
        print("200 km")

class Mercedes(Car):
     
     def maxSpeed(self):
        print("150 km")


mercedes=Mercedes()
tesla=Tesla()        
mercedes.maxSpeed()
tesla.maxSpeed()
class Fruit():
    def __init__(self,name,calories):
        self.name=name
        self.calories=calories

fruit=Fruit("Banana",200)
print(fruit.name)

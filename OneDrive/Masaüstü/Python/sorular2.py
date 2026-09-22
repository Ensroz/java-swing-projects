x = 5
y = 3
z = 6
print(x>y and z>x)
print(x < y or z > y)
my_dictionary = {"k1":10,"k2k":"a","k32":30,"k4":"c"}
for x in my_dictionary.values():
    if x=="c":
        print(x)

my_other_dictionary = {"b":203,"c":"a","a":400,"d":"f"}
for key in my_other_dictionary.keys():
    if key=="a":
        print(key);


my_numbers = [1,2,3,4,5,6,19,20,32,21,20,1111,23,24]
for num in my_numbers:
    if num%2==0:
        print(num)


çevre_list=[]
pi=3.14
r_list = [3,2,5,8,4,6,9,12]
for r in r_list:
    cevre=2*pi*r
    çevre_list.append(cevre)


print(çevre_list);
age_name_list = [("Ahmet",30),("Ayse",24),("Mehmet",40),("Fatma",29)]
age_List=[]
for (x,y) in age_name_list:
    age_List.append(y)

print(age_List)

metal_list = ["Metallica","Iron Maiden","Dream Theater","Megadeth","AC/DC"]
from random import randint
print(metal_list[randint(0,len(metal_list)-1)]) 
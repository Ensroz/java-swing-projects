my_list=[10,20,30,40,50,60,70];
for x in my_list:
    print(x)
    if(x==40):
        break #bu durdurur
     
for y in my_list:  
    if(y==40):
        continue #bu komutta alttaki komutu çaliştirmaz
    print(y);    
for z in my_list:
    pass  #bu ise eğer içi boşsa hata vermesini engellemek için kullanilir
#while loop
x=0
while x<10:
    print(x);
    x=x+1;
name=input("isim giriniz");
print(f"welcome {name}") #bu şekilde de yazabilirsin
print("welcome",name) #veya bu şekilde
print(list(range(5,25,2)))
for element in enumerate(my_list): #hem indeksi verir hem de değeri verir list
    print(element);    
for (x,value) in enumerate(my_list):
    print(x)
    #random
    
    
from random import randint
print(randint(0,100));
from random import shuffle
print(shuffle(my_list))
print(randint(0,len(my_list)-1))
print(my_list[randint(0,len(my_list)-1)])

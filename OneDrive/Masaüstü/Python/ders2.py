myString="Ensar";
print(myString[4]); #indekste belirtilen karakteri getirir
myName="james hetfield";
print(myName[len(myName)-1]);
barcode="ABCD123123345789";
print("a"*5);
#slicing starting index:stopping index:stepping size
print(barcode[0:2:1]);
print(barcode.index("D")); #kaçinci  indexte olduğunu gösterir
#list
#ÖNEMLİ !! LİSTELER DEĞİŞTİRİLEBİLİR
myList=[10,20,30,40,50,60,70];
print(myList);
myList[0]=100;
print(myList);
myList.append(10);  # son indexe 10 sayisini ekler
print(myList);
myList.insert(2,35); #2. indexe 35 sayisini ekler
myList.pop(); #son index elemani atar
myList.remove(40); #40 i siler
print(myList);
myList.reverse(); #ters alma
print(myList);
myList.sort(); # siralama
print(myList);
x=input("enter x");
print(type(x));
print(x);
inputList=[];
y=input("enter y");
z=input(" enter z");
inputList.append(x);
inputList.append(y);
inputList.append(z);
print(inputList);
myInteger=50
str(myInteger); # int stringe çevirme int(myInteger) float(myInteger) bunlarda olabilir
print(myInteger);
print(int(inputList[1])*2);
myNestedList=[10,20,30,"ensar",[1,2,3]];
smallList=myNestedList[4];
print(smallList[1]); # böylede alinabilir
print(myNestedList[4][1]); # böylede olabilir
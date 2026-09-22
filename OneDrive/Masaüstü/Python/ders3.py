#key -value
car_list=["fiat","bmw"];
buy_list=[100,150];
all_list={"fiat":100,"bmw":150}; #bu şekilde birlikte yazilabilir
print(all_list["fiat"]);
print(all_list["bmw"]);
print(all_list.values());
print(all_list.keys());  #bu ve üstteki kod yazilanlari getirir
all_list["bmw"]=200;
print(all_list);
all_list["mercedes"]=400; #bu şekilde ekleme yapabiliriz
print(all_list);
all_list.get("mercedes",0);
print(all_list.get("mercedes",0)); #bu metotta key üzerindeki değeri getirir eğer o key yoksa yaninda yazilan  value değeri getirir
my_mixed_dictionary={"key1":100,"key2":3.14,"key3":[10,20,30]};
print(my_mixed_dictionary["key3"][1]);
last_dictionary={"k1":10,"k2":[10,20,30,40,50],"k3":"string","k4":{"a":100,"b":200}};
print(last_dictionary["k2"][3]);
print(last_dictionary["k4"]["b"]);
#SET
my_list={10,20,20,30,50,40,30,40,50,};
my_set=set(my_list); #her değerden bir tane getirir
print(my_set);
my_set.add(50); #eklemez 
print(my_set);
my_set2={10,60,70,80};
print(my_set.union(my_set2)); #bu değerleri birleştirir
print(my_set.intersection(my_set2)); #bu 2 listedeki değerlerden kesişenleri alir
#DİKKAT tuple metodu list gibidir fakat içeriği değiştirelemez
age=input("yaş giriniz");
print(18>int(age));
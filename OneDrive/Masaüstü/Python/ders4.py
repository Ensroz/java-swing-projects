my_superhero="Batman";
if my_superhero=="Batman":
    #indentation
    print("ensar");
    print("batman")
######### bu # kisimdan itibaren yazilirsa if bloğuna dahil edilmez 
my_superhero=input("bir süper kahraman giriniz");
if my_superhero=="Batman":
    print("Batman");
elif my_superhero=="Superman":
    print("superman");
elif my_superhero=="Aquaman":
    print("aquaman");
else:
    print("üzgünüm yok");
#elif komutu else if in kisaltilmiş halidir
#for loop while loop
my_list=[10,20,30,40,50,60,70];
for no in my_list:
    if no%6==0:
        print(no);

number_List=[1,2,3,4,5,6,7,8,9];
for nu in number_List:
    if nu%2==1:
        print(nu);
# tuple unpacking
my_tuple=(("a","b"),("c","d"),("e","f"),("g","h"));
for (x,y) in my_tuple:
    print(x);
my_tuple=((1,2,3),(4,5,6),(7,8,9),(10,11,12));
for (x,y,z) in my_tuple:
    print(z);
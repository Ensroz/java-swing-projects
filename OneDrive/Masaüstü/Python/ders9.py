#try-except
while True:
    try:
         myAge=int(input("enter age"))
         print(myAge*2)
         break
    except:
          print("enter age!!!!")
#File
file=open("dosya.txt","w")
file.write("Merhaba dünya\n")
file.write("Ben Ensar")
print(file.read)
with open("dosya.txt",mode="r") as file:
        for satir in file:
              print(satir)
with open("dosya.txt",mode="a") as file: #"a" ekleme yapar sona "w" ise eski içeriği silip yeniden yazar
      file.write("Öztürk")


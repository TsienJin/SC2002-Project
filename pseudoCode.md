### Pseudo Code

```python
class FileIO():
    
    def writeToFile(self, fileName:str, lineToWrite:str) -> None:
        pass




class Menu():
    
    def getUsrInputInt() -> int:
        return input("Choice:")

    def getUsrInputStr() -> str:
        return input("Input:")

    def printMenu() -> int:
        print("1.Something")
        print("2.Something")
        print("3.Something")
        return self.getUsrInput()

    def movieCreateMenu() -> movie:
        thisMovie = movie()
        print("What is the name of the Movie")
        thisMovie.setName(getUsrInput())




class CSVDriver():
    def Something(self) -> None:
        pass


class StaffCSVDriver(CSVDriver):
    def createMovieListing(newMovie:Movie) -> None:
        FileIO().writeToFile("fileName.csv", newMovie.toCSVString())
```



```python
class Usr():
    def __init__(self):
        pass


class StaffUsr(usr):
    
    def __init__(self):
        self.menu = Menu()
        self.getInut = UsrInput()
        self.CSVDriver = StaffCSVDriver()

    @override
    def __auth() -> bool:
        pass

    def __createMovie() -> None:
        movieBuilder = MovieBuilder()
        movieBuilder.setMovieName(self.getInput.usrString("Enter Movie Name:"))
        movieBuilder.setMovieName(self.getInput.usrString("Enter Movie ID:"))\
        ### .....
        newMovie:Movie = movieBuilder.makeMovie()
        self.CSVDriver.createMovieListing(newMovie)

    def __runMain() -> None:
        ### skip the menu
        # intention is to create movie listing
        self.createMovie()

    def run() -> None:
        while(not self.__auth()):
            pass
        self.runMain()

    


class CustomerUsr(usr):
    def run():
        pass
```



```python
### Main App Function

class UsrFactory():
    def createUsr(usrType):
        if usrType === "Customer":
            return CustomerUsr()
        else:
            return StaffUsr()



class Main():
    usrType:Str = "Staff" # usr, should be enum in java

    def Main() -> None:
        self.usrType = getUsrType()
        
        # dependant on usrType
        usrApp = UsrFactory().createUsr(self.usrType)

        usrApp.run() # think: inception dropping into a lower 'dream'
```

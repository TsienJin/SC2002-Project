![image](https://user-images.githubusercontent.com/32679064/201461109-af579f87-abd5-47d3-bd6b-71c632580fe7.png)

# SC2002: MOvie Booking and LIsting Management Application (MOBLIMA)

## About
MOBLIMA is an application to computerize the processes of making online booking and purchase of movie tickets, listing of movies and sale reporting. It will be used by the movie goers and cinema staff.

## Installation

Ensure that you have the required Java SDKs. I'm using `OpenJDK 11.0.17`  

	java --version

![image](https://user-images.githubusercontent.com/32679064/201460580-44711f7e-ccc5-491f-b0b7-864414830e9d.png)

Download the source code via `git`

	git clone https://github.com/TsienJin/SC2002-Project


Head to `src/` folder and compile ByteCode
	
	cd SC2002-Project/src
	javac App.java


Move up 1 directory (outside of `src/` folder) and execute `App.class`
	
	cd ..
	java -cp src/ App 


## Examples

#### Login
Administrators are able to login to the application using a Predefined Username and Password.

Input:

	1
	admin
	********
	14

![example01](https://user-images.githubusercontent.com/32679064/200111797-2e34dea1-ba1d-41a3-a4de-f8c65c4a0988.gif)

#### Create/Update/Remove Movie Listing
Administrators are able to Create, Update, and Remove Movie Listings on the Application.

Input:

	1
	admin
	********
	3
	2
	0245429
	Spirited Away
	2
	1
	During her family's move to the suburbs& a sullen 10-year-old girl wanders into a world ruled by gods& witches& and spirits& and where humans are changed into beasts.
	Hayao Miyazaki
	Rumi Hiiragi, Miyu Irino
	3
	6
	0245429
	2
	4
	3
	7
	0245429
	3
	14

![example02](https://user-images.githubusercontent.com/32679064/200112994-b93db69a-7ee1-4fb1-ae40-c586134747a3.gif)


#### Create/Update/Remove Cinema Showtime
Administrators are able to Create, Update, and Remove Showtime on the Application.

Input:

	1
	admin
	********
	9
	8
	ST12
	6443346
	G03
	202211111735
	9
	11
	ST12
	3
	202211101245
	9
	12
	ST12
	9
	14

![example03](https://user-images.githubusercontent.com/32679064/200113703-5052f794-e5b7-4b82-ae45-522572199c85.gif)

## Contributions
- TsienJin
- keenlim
- Baby-McBabyFace
- rphoen
- Roseus9

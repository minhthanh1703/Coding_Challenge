# Coding_Challenge
The program allows these functions:
1. Create a new canvas 
2. Draw on the canvas by issuing various commands 
3. Quit 


|Command 		|Description|
|----|----|
|C w h          | Create a new canvas of width w and height h.|
|L x1 y1 x2 y2  | Draw a new line from (x1,y1) to (x2,y2). Currently, only|
|               | horizontal or vertical lines are supported. Horizontal and vertical lines|
|               | will be drawn using the 'x' character.|
|R x1 y1 x2 y2  | Draw a rectangle whose upper left corner is (x1,y1) and|
|               | lower right corner is (x2,y2). Horizontal and vertical lines will be drawn|
|               | using the 'x' character.|
|B x y c        | Fill the entire area connected to (x,y) with "colour" c. The|
|               | behaviour of this is the same as that of the "bucket fill" tool in paint|
|               | programs.|
|Q              | Quit|
----------- 


## Sample

Below is a sample run of the program. User input is prefixed with enter command:
```
enter command: C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------

L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                horizontal or vertical lines are supported. Horizontal and vertical lines
                will be drawn using the 'x' character.

R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                using the 'x' character.

B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
                behaviour of this is the same as that of the "bucket fill" tool in paint
                programs.
                
Q               Should quit the program.
```

## Build environment

- JDK: 1.8.0_241
- JRE: 1.8.0_241
- IDE: IntelliJ
- JUnit(4.12) is used for testing


## Note:
- Run main.class to start application

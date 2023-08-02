#Solves an input sudoku puzzle in source through backtracking
#Chris Bonner
#11/16/2020
#completed 12/1/2020
#continuing issues:
#the backtracking algorythm continues until it resets the board to its
    #original state, but the completed board state is captured before the reset
    #so all that is wasted is computing power
#blank spaces need to have 0s in them in order for it to run. In future, I
    #could read in blank spaces as 0s from the gui
#reset sets all values to 0, instead of null which would be ideal
#does not check solutions


import tkinter as tk
from tkinter import *
import os

#solves the puzzle through backtracking
def solveButton():
    #read inputs to the array
    puzzle[0][0]=int(p00.get())
    puzzle[0][1]=int(p01.get())
    puzzle[0][2]=int(p02.get())
    puzzle[0][3]=int(p03.get())
    puzzle[0][4]=int(p04.get())
    puzzle[0][5]=int(p05.get())
    puzzle[0][6]=int(p06.get())
    puzzle[0][7]=int(p07.get())
    puzzle[0][8]=int(p08.get())

    puzzle[1][0]=int(p10.get())
    puzzle[1][1]=int(p11.get())
    puzzle[1][2]=int(p12.get())
    puzzle[1][3]=int(p13.get())
    puzzle[1][4]=int(p14.get())
    puzzle[1][5]=int(p15.get())
    puzzle[1][6]=int(p16.get())
    puzzle[1][7]=int(p17.get())
    puzzle[1][8]=int(p18.get())

    puzzle[2][0]=int(p20.get())
    puzzle[2][1]=int(p21.get())
    puzzle[2][2]=int(p22.get())
    puzzle[2][3]=int(p23.get())
    puzzle[2][4]=int(p24.get())
    puzzle[2][5]=int(p25.get())
    puzzle[2][6]=int(p26.get())
    puzzle[2][7]=int(p27.get())
    puzzle[2][8]=int(p28.get())

    puzzle[3][0]=int(p30.get())
    puzzle[3][1]=int(p31.get())
    puzzle[3][2]=int(p32.get())
    puzzle[3][3]=int(p33.get())
    puzzle[3][4]=int(p34.get())
    puzzle[3][5]=int(p35.get())
    puzzle[3][6]=int(p36.get())
    puzzle[3][7]=int(p37.get())
    puzzle[3][8]=int(p38.get())
    
    puzzle[4][0]=int(p40.get())
    puzzle[4][1]=int(p41.get())
    puzzle[4][2]=int(p42.get())
    puzzle[4][3]=int(p43.get())
    puzzle[4][4]=int(p44.get())
    puzzle[4][5]=int(p45.get())
    puzzle[4][6]=int(p46.get())
    puzzle[4][7]=int(p47.get())
    puzzle[4][8]=int(p48.get())
    
    puzzle[5][0]=int(p50.get())
    puzzle[5][1]=int(p51.get())
    puzzle[5][2]=int(p52.get())
    puzzle[5][3]=int(p53.get())
    puzzle[5][4]=int(p54.get())
    puzzle[5][5]=int(p55.get())
    puzzle[5][6]=int(p56.get())
    puzzle[5][7]=int(p57.get())
    puzzle[5][8]=int(p58.get())
    
    puzzle[6][0]=int(p60.get())
    puzzle[6][1]=int(p61.get())
    puzzle[6][2]=int(p62.get())
    puzzle[6][3]=int(p63.get())
    puzzle[6][4]=int(p64.get())
    puzzle[6][5]=int(p65.get())
    puzzle[6][6]=int(p66.get())
    puzzle[6][7]=int(p67.get())
    puzzle[6][8]=int(p68.get())
    
    puzzle[7][0]=int(p70.get())
    puzzle[7][1]=int(p71.get())
    puzzle[7][2]=int(p72.get())
    puzzle[7][3]=int(p73.get())
    puzzle[7][4]=int(p74.get())
    puzzle[7][5]=int(p75.get())
    puzzle[7][6]=int(p76.get())
    puzzle[7][7]=int(p77.get())
    puzzle[7][8]=int(p78.get())

    puzzle[8][0]=int(p80.get())
    puzzle[8][1]=int(p81.get())
    puzzle[8][2]=int(p82.get())
    puzzle[8][3]=int(p83.get())
    puzzle[8][4]=int(p84.get())
    puzzle[8][5]=int(p85.get())
    puzzle[8][6]=int(p86.get())
    puzzle[8][7]=int(p87.get())
    puzzle[8][8]=int(p88.get())

    
    solve(0,0)

def solve(row, col):
    #checks if value is given
##    if puzzle[row][col]== null:
##        puzzle[row][col]= 0
    if puzzle[row][col] !=0:
        if(col<8):
            solve(row, col+1)
        elif(row<8):
            solve(row+1, 0)
            
        #run is complete, output solution
        else:
            display()
            return
        
    #checks the cell and runs next level of the algorimth
    else:
        for i in range(1,10):
            if(check(row, col, i)=="true"):
                puzzle[row][col]= i
                if(col<8):
                    solve(row, col+1)
                elif(row<8):
                    solve(row+1, 0)
                    
                #run is complete, output solution
                else:
                    display()
                    return 
            
            puzzle[row][col]= 0
        return                
                   
#checks accuracy of cell
def check(row, col, i):
    #checks against the row
    for j in range(9):
        if puzzle[row][j]== i:
            return "false"

    #checks against the column
    for j in range(9):
        if puzzle[j][col]== i:
            return "false"

    #checks against the 3x3 box
    boxRow= int(row/3)
    boxCol= int(col/3)
    for j in range(3):
        for k in range(3):
            if puzzle[boxRow*3+j][boxCol*3+k]== i:
                return "false"

    #all checks passed
    return "true"

def reset():
    for i in range(9):
        for j in range(9):
            
            puzzle[i][j]= 0

    display()

def display():
    p00.delete(0)
    p00.insert(0, puzzle[0][0])
    p01.delete(0)
    p01.insert(0, puzzle[0][1])
    p02.delete(0)
    p02.insert(0, puzzle[0][2])
    p03.delete(0)
    p03.insert(0, puzzle[0][3])
    p04.delete(0)
    p04.insert(0, puzzle[0][4])
    p05.delete(0)
    p05.insert(0, puzzle[0][5])
    p06.delete(0)
    p06.insert(0, puzzle[0][6])
    p07.delete(0)
    p07.insert(0, puzzle[0][7])
    p08.delete(0)
    p08.insert(0, puzzle[0][8])

    p10.delete(0)
    p10.insert(0, puzzle[1][0])
    p11.delete(0)
    p11.insert(0, puzzle[1][1])
    p12.delete(0)
    p12.insert(0, puzzle[1][2])
    p13.delete(0)
    p13.insert(0, puzzle[1][3])
    p14.delete(0)
    p14.insert(0, puzzle[1][4])
    p15.delete(0)
    p15.insert(0, puzzle[1][5])
    p16.delete(0)
    p16.insert(0, puzzle[1][6])
    p17.delete(0)
    p17.insert(0, puzzle[1][7])
    p18.delete(0)
    p18.insert(0, puzzle[1][8])

    p20.delete(0)
    p20.insert(0, puzzle[2][0])
    p21.delete(0)
    p21.insert(0, puzzle[2][1])
    p22.delete(0)
    p22.insert(0, puzzle[2][2])
    p23.delete(0)
    p23.insert(0, puzzle[2][3])
    p24.delete(0)
    p24.insert(0, puzzle[2][4])
    p25.delete(0)
    p25.insert(0, puzzle[2][5])
    p26.delete(0)
    p26.insert(0, puzzle[2][6])
    p27.delete(0)
    p27.insert(0, puzzle[2][7])
    p28.delete(0)
    p28.insert(0, puzzle[2][8])

    p30.delete(0)
    p30.insert(0, puzzle[3][0])
    p31.delete(0)
    p31.insert(0, puzzle[3][1])
    p32.delete(0)
    p32.insert(0, puzzle[3][2])
    p33.delete(0)
    p33.insert(0, puzzle[3][3])
    p34.delete(0)
    p34.insert(0, puzzle[3][4])
    p35.delete(0)
    p35.insert(0, puzzle[3][5])
    p36.delete(0)
    p36.insert(0, puzzle[3][6])
    p37.delete(0)
    p37.insert(0, puzzle[3][7])
    p38.delete(0)
    p38.insert(0, puzzle[3][8])

    p40.delete(0)
    p40.insert(0, puzzle[4][0])
    p41.delete(0)
    p41.insert(0, puzzle[4][1])
    p42.delete(0)
    p42.insert(0, puzzle[4][2])
    p43.delete(0)
    p43.insert(0, puzzle[4][3])
    p44.delete(0)
    p44.insert(0, puzzle[4][4])
    p45.delete(0)
    p45.insert(0, puzzle[4][5])
    p46.delete(0)
    p46.insert(0, puzzle[4][6])
    p47.delete(0)
    p47.insert(0, puzzle[4][7])
    p48.delete(0)
    p48.insert(0, puzzle[4][8])

    p50.delete(0)
    p50.insert(0, puzzle[5][0])
    p51.delete(0)
    p51.insert(0, puzzle[5][1])
    p52.delete(0)
    p52.insert(0, puzzle[5][2])
    p53.delete(0)
    p53.insert(0, puzzle[5][3])
    p54.delete(0)
    p54.insert(0, puzzle[5][4])
    p55.delete(0)
    p55.insert(0, puzzle[5][5])
    p56.delete(0)
    p56.insert(0, puzzle[5][6])
    p57.delete(0)
    p57.insert(0, puzzle[5][7])
    p58.delete(0)
    p58.insert(0, puzzle[5][8])

    p60.delete(0)
    p60.insert(0, puzzle[6][0])
    p61.delete(0)
    p61.insert(0, puzzle[6][1])
    p62.delete(0)
    p62.insert(0, puzzle[6][2])
    p63.delete(0)
    p63.insert(0, puzzle[6][3])
    p64.delete(0)
    p64.insert(0, puzzle[6][4])
    p65.delete(0)
    p65.insert(0, puzzle[6][5])
    p66.delete(0)
    p66.insert(0, puzzle[6][6])
    p67.delete(0)
    p67.insert(0, puzzle[6][7])
    p68.delete(0)
    p68.insert(0, puzzle[6][8])

    p70.delete(0)
    p70.insert(0, puzzle[7][0])
    p71.delete(0)
    p71.insert(0, puzzle[7][1])
    p72.delete(0)
    p72.insert(0, puzzle[7][2])
    p73.delete(0)
    p73.insert(0, puzzle[7][3])
    p74.delete(0)
    p74.insert(0, puzzle[7][4])
    p75.delete(0)
    p75.insert(0, puzzle[7][5])
    p76.delete(0)
    p76.insert(0, puzzle[7][6])
    p77.delete(0)
    p77.insert(0, puzzle[7][7])
    p78.delete(0)
    p78.insert(0, puzzle[7][8])

    p80.delete(0)
    p80.insert(0, puzzle[8][0])
    p81.delete(0)
    p81.insert(0, puzzle[8][1])
    p82.delete(0)
    p82.insert(0, puzzle[8][2])
    p83.delete(0)
    p83.insert(0, puzzle[8][3])
    p84.delete(0)
    p84.insert(0, puzzle[8][4])
    p85.delete(0)
    p85.insert(0, puzzle[8][5])
    p86.delete(0)
    p86.insert(0, puzzle[8][6])
    p87.delete(0)
    p87.insert(0, puzzle[8][7])
    p88.delete(0)
    p88.insert(0, puzzle[8][8])

    
puzzle= [[0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0]]


#making the GUI
root = tk.Tk()
canvas= tk.Canvas(root, height= 550, width= 500, bg=("white"))
canvas.pack()

#drawing the board
border= tk.Frame(canvas, bg="black")
border.place(width=5, height=500, x=0, y=0)
border= tk.Frame(canvas, bg="black")
border.place(width=5, height=500, x=167, y=0)
border= tk.Frame(canvas, bg="black")
border.place(width=5, height=500, x=333, y=0)
border= tk.Frame(canvas, bg="black")
border.place(width=5, height=500, x=500, y=0)

border= tk.Frame(canvas, bg="black")
border.place(width=500, height=5, x=0, y=0)
border= tk.Frame(canvas, bg="black")
border.place(width=500, height=5, x=0, y=167)
border= tk.Frame(canvas, bg="black")
border.place(width=500, height=5, x=0, y=333)
border= tk.Frame(canvas, bg="black")
border.place(width=500, height=5, x=0, y=500)

border= tk.Frame(canvas, bg="black")
border.place(width=2, height=500, x=55, y=0)
border= tk.Frame(canvas, bg="black")
border.place(width=2, height=500, x=111, y=0)

border= tk.Frame(canvas, bg="black")
border.place(width=2, height=500, x=222, y=0)
border= tk.Frame(canvas, bg="black")
border.place(width=2, height=500, x=278, y=0)

border= tk.Frame(canvas, bg="black")
border.place(width=2, height=500, x=388, y=0)
border= tk.Frame(canvas, bg="black")
border.place(width=2, height=500, x=444, y=0)

border= tk.Frame(canvas, bg="black")
border.place(width=500, height=2, x=0, y=55)
border= tk.Frame(canvas, bg="black")
border.place(width=500, height=2, x=0, y=111)

border= tk.Frame(canvas, bg="black")
border.place(width=500, height=2, x=0, y=222)
border= tk.Frame(canvas, bg="black")
border.place(width=500, height=2, x=0, y=278)

border= tk.Frame(canvas, bg="black")
border.place(width=500, height=2, x=0, y=388)
border= tk.Frame(canvas, bg="black")
border.place(width=500, height=2, x=0, y=444)


p00= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p00.place(width= 45, height= 45, x=6, y=7)
        
p10= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p10.place(width= 45, height= 45, x=6, y=60)

p20= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p20.place(width= 45, height= 45, x=6, y=116)

p30= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p30.place(width= 45, height= 45, x=6, y=172)
        
p40= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p40.place(width= 45, height= 45, x=6, y=228)

p50= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p50.place(width= 45, height= 45, x=6, y=284)

p60= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p60.place(width= 45, height= 45, x=6, y=339)
        
p70= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p70.place(width= 45, height= 45, x=6, y=396)

p80= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p80.place(width= 45, height= 45, x=6, y=450)


p01= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p01.place(width= 45, height= 45, x=65, y=7)
        
p11= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p11.place(width= 45, height= 45, x=65, y=60)

p21= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p21.place(width= 45, height= 45, x=65, y=116)

p31= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p31.place(width= 45, height= 45, x=65, y=172)
        
p41= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p41.place(width= 45, height= 45, x=65, y=228)

p51= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p51.place(width= 45, height= 45, x=65, y=284)

p61= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p61.place(width= 45, height= 45, x=65, y=339)
        
p71= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p71.place(width= 45, height= 45, x=65, y=396)

p81= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p81.place(width= 45, height= 45, x=65, y=450)


p02= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p02.place(width= 45, height= 45, x=116, y=7)
        
p12= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p12.place(width= 45, height= 45, x=116, y=60)

p22= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p22.place(width= 45, height= 45, x=116, y=116)

p32= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p32.place(width= 45, height= 45, x=116, y=172)
        
p42= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p42.place(width= 45, height= 45, x=116, y=228)

p52= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p52.place(width= 45, height= 45, x=116, y=284)

p62= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p62.place(width= 45, height= 45, x=116, y=339)
        
p72= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p72.place(width= 45, height= 45, x=116, y=396)

p82= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p82.place(width= 45, height= 45, x=116, y=450)


p03= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p03.place(width= 45, height= 45, x=176, y=7)
        
p13= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p13.place(width= 45, height= 45, x=176, y=60)

p23= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p23.place(width= 45, height= 45, x=176, y=116)

p33= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p33.place(width= 45, height= 45, x=176, y=172)
        
p43= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p43.place(width= 45, height= 45, x=176, y=228)

p53= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p53.place(width= 45, height= 45, x=176, y=284)

p63= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p63.place(width= 45, height= 45, x=176, y=339)
        
p73= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p73.place(width= 45, height= 45, x=176, y=396)

p83= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p83.place(width= 45, height= 45, x=176, y=450)


p04= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p04.place(width= 45, height= 45, x=230, y=7)
        
p14= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p14.place(width= 45, height= 45, x=230, y=60)

p24= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p24.place(width= 45, height= 45, x=230, y=116)

p34= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p34.place(width= 45, height= 45, x=230, y=172)
        
p44= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p44.place(width= 45, height= 45, x=230, y=228)

p54= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p54.place(width= 45, height= 45, x=230, y=284)

p64= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p64.place(width= 45, height= 45, x=230, y=339)
        
p74= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p74.place(width= 45, height= 45, x=230, y=396)

p84= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p84.place(width= 45, height= 45, x=230, y=450)


p05= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p05.place(width= 45, height= 45, x=285, y=7)
        
p15= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p15.place(width= 45, height= 45, x=285, y=60)

p25= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p25.place(width= 45, height= 45, x=285, y=116)

p35= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p35.place(width= 45, height= 45, x=285, y=172)
        
p45= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p45.place(width= 45, height= 45, x=285, y=228)

p55= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p55.place(width= 45, height= 45, x=285, y=284)

p65= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p65.place(width= 45, height= 45, x=285, y=339)
        
p75= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p75.place(width= 45, height= 45, x=285, y=396)

p85= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p85.place(width= 45, height= 45, x=285, y=450)


p06= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p06.place(width= 45, height= 45, x=341, y=7)
        
p16= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p16.place(width= 45, height= 45, x=341, y=60)

p26= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p26.place(width= 45, height= 45, x=341, y=116)

p36= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p36.place(width= 45, height= 45, x=341, y=172)
        
p46= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p46.place(width= 45, height= 45, x=341, y=228)

p56= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p56.place(width= 45, height= 45, x=341, y=284)

p66= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p66.place(width= 45, height= 45, x=341, y=339)
        
p76= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p76.place(width= 45, height= 45, x=341, y=396)

p86= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p86.place(width= 45, height= 45, x=341, y=450)


p07= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p07.place(width= 45, height= 45, x=396, y=7)
        
p17= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p17.place(width= 45, height= 45, x=396, y=60)

p27= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p27.place(width= 45, height= 45, x=396, y=116)

p37= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p37.place(width= 45, height= 45, x=396, y=172)
        
p47= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p47.place(width= 45, height= 45, x=396, y=228)

p57= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p57.place(width= 45, height= 45, x=396, y=284)

p67= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p67.place(width= 45, height= 45, x=396, y=339)
        
p77= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p77.place(width= 45, height= 45, x=396, y=396)

p87= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p87.place(width= 45, height= 45, x=396, y=450)


p08= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p08.place(width= 45, height= 45, x=451, y=7)
        
p18= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p18.place(width= 45, height= 45, x=451, y=60)

p28= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p28.place(width= 45, height= 45, x=451, y=116)

p38= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p38.place(width= 45, height= 45, x=451, y=172)
        
p48= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p48.place(width= 45, height= 45, x=451, y=228)

p58= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p58.place(width= 45, height= 45, x=451, y=284)

p68= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p68.place(width= 45, height= 45, x=451, y=339)
        
p78= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p78.place(width= 45, height= 45, x=451, y=396)

p88= tk.Entry(canvas, font= "Calibri 22 bold", justify= "center", bd=0)
p88.place(width= 45, height= 45, x=451, y=450)

solveButton= Button(canvas, text="Solve", command=solveButton)
solveButton.place(width= 100, height= 40, x= 200, y=510)

resetButton= Button(canvas, text="Reset", command= reset)
resetButton.place(width= 100, height= 40, x= 350, y=510)






root.mainloop()


puzzle= [[5, 3, 0, 0, 7, 0, 0, 0, 0],
         [6, 0, 0, 1, 9, 5, 0, 0, 0],
         [0, 9, 8, 0, 0, 0, 0, 6, 0],
         [8, 0, 0, 0, 6, 0, 0, 0, 3],
         [4, 0, 0, 8, 0, 3, 0, 0, 1],
         [7, 0, 0, 0, 2, 0, 0, 0, 6],
         [0, 6, 0, 0, 0, 0, 2, 8, 0],
         [0, 0, 0, 4, 1, 9, 0, 0, 5],
         [0, 0, 0, 0, 8, 0, 0, 7, 9]]
display()

#starts the algorithm
#solve(0,0)

















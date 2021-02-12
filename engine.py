from termcolor import colored

class World:
    """
    -------------------------------------------------
    World is the object that content all the Objects.
    -------------------------------------------------
    #Attributes:
        -[int] width       : map's width
        -[int] height      : map's height
        -[list] collisions : list of all hard-collisions

    #Methods:
        -add...() : append a given object in a list
        -mk...()  : make an object at the given positions
        -update() : refresh all objects' positions of the world
    """
    def __init__(self, width, height):
        self.width = width
        self.height = height
        self.caseList = []
        self.hardCollisions = []
        self.softCollisions = []
        self.mkMap()


    def mkMap(self):
        self.map = []
        for h in list(range(self.height)):
            self.map.append([" "]*self.width)

    def mkCase(self, case):
        self.map[case.pos[0]][case.pos[1]] = case.texture

    def addCase(self, case):
        self.caseList.append([case, case.pos])

    def addHardCollision(self, case):
        self.hardCollisions.append(case.pos)

    def addSoftCollision(self, case):
        self.softCollisions.append(case.pos)

    def searchCase(self, caseType, coords):
        for cl in self.caseList:
            if type(cl[0]) == caseType and cl[1] == coords:
                return cl[0]

    def update(self):
        self.mkMap()
        for c in self.caseList:
            self.mkCase(c[0])

    def winCondition(self):
        targetList = []
        boxList = []
        for case in self.caseList:
            if type(case[0]) == Target:
                targetList.append(case[1])
            if type(case[0]) == Box:
                boxList.append(case[1])
        targetList.sort()
        boxList.sort()
        if boxList == targetList:
            for case in self.caseList:
                case[0].texture = colored("W", "green")
            return 1

    def __str__(self):
        string = ""
        for line in self.map:
            for c in line:
                string += str(c)
            string += "\n"
        return string

class EmptyCase:
    """
    ------------------------------
    Empty case with no collisions.
    ------------------------------
    #Attributes:
        -[list] pos : case's position
    """
    def __init__(self, pos):
        self.pos = pos
        self.texture = " "
        self.collision = 0

class Wall:
    """
    --------------------------
    Case with hard-collisions.
    --------------------------
    #Attributes:
        -[list] pos : case's position
    """
    def __init__(self, pos):
        self.pos = pos
        self.texture = colored("O", "blue")
        self.collisions = 1

class Box:
    """
    --------------------------------------------------------
    Case with soft-collisions. It can be move by the player.
    --------------------------------------------------------
    #Attributes:
        -[list] pos : case's position
    """
    def __init__(self, pos):
        self.pos = pos
        self.texture = colored("#", "white")

    def right(self, world):
       nextCase = [self.pos[0]+1, self.pos[1]]
       if nextCase not in world.softCollisions+world.hardCollisions:
           self.pos[0] += 1
           return 1

    def left(self, world):
        nextCase = [self.pos[0]-1, self.pos[1]]
        if nextCase not in world.hardCollisions+world.softCollisions:
            self.pos[0] -= 1
            return 1

    def down(self, world):
        nextCase = [self.pos[0], self.pos[1]+1]
        if nextCase not in world.hardCollisions+world.softCollisions:
            self.pos[1] += 1
            return 1

    def up(self, world):
        nextCase = [self.pos[0], self.pos[1]-1]
        if nextCase not in world.hardCollisions+world.softCollisions:
            self.pos[1] -= 1
            return 1

class Player:
    """
    ---------------------------------------------------------------
    This case is controled by the user. It can move in 4 directions
    if there's no collisions with other objects of the world.
    ---------------------------------------------------------------
    #Attributes:
        -[list] pos : case's position

    #Methods:
        -right, left, down, up : move the player in the given direction if 
                                 there's no collision's conflict
    """
    def __init__(self, pos):
        self.pos = pos
        self.texture = colored("X", "red")

    def down(self, world): 
        nextCase = [self.pos[0]+1, self.pos[1]]
        if nextCase in world.softCollisions:
            box = world.searchCase(Box, nextCase)
            if box.right(world):
                self.pos[0] += 1
        elif self.pos[0]+1<world.width and [self.pos[0]+1, self.pos[1]] not in world.hardCollisions:
            self.pos[0] += 1

    def up(self, world):
        nextCase = [self.pos[0]-1 ,self.pos[1]]
        if nextCase in world.softCollisions:
            box = world.searchCase(Box, nextCase)
            if box.left(world):
                self.pos[0] -= 1
        elif self.pos[0]-1>=0 and [self.pos[0]-1, self.pos[1]] not in world.hardCollisions:
            self.pos[0] -= 1

    def right(self, world):
        nextCase = [self.pos[0], self.pos[1]+1]
        if nextCase in world.softCollisions:
            box = world.searchCase(Box, nextCase)
            if box.down(world):
                self.pos[1] += 1
        elif self.pos[1]+1<world.height and [self.pos[0], self.pos[1]+1] not in world.hardCollisions:
            self.pos[1] += 1

    def left(self, world):
        nextCase = [self.pos[0], self.pos[1]-1]
        if nextCase in world.softCollisions:
            box = world.searchCase(Box, nextCase)
            if box.up(world):
                self.pos[1] -= 1
        elif self.pos[1]-1>=0 and [self.pos[0], self.pos[1]-1] not in world.hardCollisions:
            self.pos[1] -= 1

class Target:
    """
    -----------------------------------------
    Case where the player must move a box on.
    -----------------------------------------
    #Attributes:
        -[list] pos : case's postition
    """
    def __init__(self, pos):
        self.pos = pos
        self.texture = colored("*", "green")

class Game:
    """
    ----------------------------------------------
    Main class.
    It starts a game with the given configuration.
    ----------------------------------------------
    #Attributes:

    #Methods:
        -start() : starts the game loop and ask the user for action.
                   If the user choose to leave this loop the program stops.
    """
    def __init__(self, world, player, walls):
        self.world = world
        self.player = player
        self.walls = walls
        for w in self.walls:
            self.world.addCase(w)
            self.world.addHardCollision(w)

        self.target = Target([1, 2])
        self.world.addCase(self.target)
        self.box = Box([3, 2])
        self.world.addCase(self.box)
        self.world.addSoftCollision(self.box)

        self.target2 = Target([1, 6])
        self.world.addCase(self.target2)
        self.box2 = Box([4, 2])
        self.world.addCase(self.box2)
        self.world.addSoftCollision(self.box2)

        self.target3 = Target([7, 2])
        self.world.addCase(self.target3)
        self.box3 = Box([4, 4])
        self.world.addCase(self.box3)
        self.world.addSoftCollision(self.box3)

        self.target4 = Target([7, 7])
        self.world.addCase(self.target4)
        self.box4 = Box([7, 4])
        self.world.addCase(self.box4)
        self.world.addSoftCollision(self.box4)
        self.world.addCase(self.player)

    def start(self):
        scanner = ""
        while scanner.upper() != 'EXIT':
            world.update()
            print(world)
            if world.winCondition():
                print("You win")
                scanner = "EXIT"
                world.update()
                print(world)
                continue
            print("Z,Q,S,D or exit :", end="")
            scanner = input()
            if scanner.upper() == 'Z':
                self.player.up(world)
            elif scanner.upper() == 'S':
                self.player.down(world)
            elif scanner.upper() == 'Q':
                self.player.left(world)
            elif scanner.upper() == 'D':
                self.player.right(world)
            elif scanner.upper() == 'EXIT':
                continue
            else:
                print("Command not found")
        


if __name__ == "__main__": 
    world = World(10, 10)  
    player = Player([6, 2])
    walls = []
    wallsPositions = ([0, 0], [0, 1], [0, 2], [0, 3], [0, 4], [0, 5], [0, 6,], [0, 7], [0, 8], [0, 9],
                      [1, 0], [1, 9],
                      [2, 0], [2, 2], [2, 4], [2, 5], [2, 7], [2, 9],
                      [3, 0], [3, 5], [3, 9],
                      [4, 0], [4, 9],
                      [5, 0], [5, 2], [5, 6], [5, 8], [5, 9],
                      [6, 0], [6, 3], [6, 9],
                      [7, 0], [7, 6], [7, 8], [7, 9],
                      [8, 0], [8, 2], [8, 8], [8, 9],
                      [9, 0], [9, 1], [9, 2], [9, 3], [9, 4], [9, 5], [9, 6], [9, 7], [9, 8], [9, 9])
    for w in wallsPositions:
        walls.append(Wall(w)) 
    game = Game(world, player, walls)
    game.start()

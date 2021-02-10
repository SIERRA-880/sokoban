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
        self.wallList = []
        self.boxList = []
        self.targetList = []
        self.playerList = []
        self.collisions = []
        self.mkMap()


    def mkMap(self):
        self.map = []
        for h in list(range(self.height)):
            self.map.append([" "]*self.width)


    def mkCase(self, pos):
        self.map[pos[1]][pos[0]] = " "

    def mkWall(self, pos):
        text = colored("O", "blue")
        self.map[pos[1]][pos[0]] = text

    def mkBox(self, pos):
        text = colored("#", "white")
        self.map[pos[1]][pos[0]] = text

    def mkTarget(self, pos):
        text = colored("*", "green")
        self.map[pos[1]][pos[0]] = text

    def mkPlayer(self, pos):
        text = colored("X", "red")
        self.map[pos[1]][pos[0]] = text

    def addCase(self, case):
        self.caseList.append(case)

    def addWall(self, wall):
        self.wallList.append(wall)
        self.collisions.append(wall.pos)

    def addBox(self, box):
        self.boxList.append(box)

    def addTarget(self, target):
        self.targetList.append(target)

    def addPlayer(self, player):
        self.playerList.append(player)

    def update(self):
        self.mkMap()
        for c in self.caseList:
            self.mkCase(c.pos)
        for w in self.wallList:
            self.mkWall(w.pos)
        for b in self.boxList:
            self.mkBox(b.pos)
        for t in self.targetList:
            self.mkTarget(t.pos)
        for p in self.playerList:
            self.mkPlayer(p.pos)

    def __str__(self):
        string = ""
        for line in self.map:
            for c in line:
                string += str(c)
            string += "\n"
        return string

class Case:
    """
    ------------------------------
    Empty case with no collisions.
    ------------------------------
    #Attributes:
        -[list] pos : case's position
    """
    def __init__(self, pos):
        self.pos = pos

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
        
    def right(self, world):
        if self.pos[0]+1<world.width and [self.pos[0]+1, self.pos[1]] not in world.collisions:
            self.pos[0] += 1

    def left(self, world):
        if self.pos[0]-1>=0 and [self.pos[0]-1, self.pos[1]] not in world.collisions:
            self.pos[0] -= 1

    def down(self, world):
        if self.pos[1]+1<world.height and [self.pos[0], self.pos[1]+1] not in world.collisions:
            self.pos[1] += 1

    def up(self, world):
        if self.pos[1]-1>=0 and [self.pos[0], self.pos[1]-1] not in world.collisions:
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
        self.world.addPlayer(self.player)
        self.walls = walls
        for w in self.walls:
            self.world.addWall(w)
        self.target = Target([8, 8])
        self.world.addTarget(self.target)
        self.box = Box([2, 1])
        self.world.addBox(self.box)

    def start(self):
        scanner = ""
        while scanner.upper() != 'EXIT':
            world.update()
            print(world)
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
    player = Player([1, 1])
    walls = []
    wallsPositions = ([0, 0], [0, 1], [0, 2], [0, 3], [0, 4], [0, 5], [0, 6,], [0, 7], [0, 8], [0, 9],
                      [1, 0], [1, 2], [1, 5], [1, 7], [1, 9],
                      [2, 0], [2, 2], [2, 3], [2, 5], [2, 7], [2, 9],
                      [3, 0], [3, 5], [3, 9],
                      [4, 0], [4, 3], [4, 4], [4, 5], [4, 7], [4, 9],
                      [5, 0], [5, 1], [5, 7], [5, 9],
                      [6, 0], [6, 3], [6, 5], [6, 6], [6, 7], [6, 9],
                      [7, 0], [7, 2], [7, 3], [7, 5], [7, 9],
                      [8, 0], [8, 5], [8, 7], [8, 9],
                      [9, 0], [9, 1], [9, 2], [9, 3], [9, 4], [9, 5], [9, 6], [9, 7], [9, 8], [9, 9])
    for w in wallsPositions:
        walls.append(Wall(w)) 
    game = Game(world, player, walls)
    game.start()

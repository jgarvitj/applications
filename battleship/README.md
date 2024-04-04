Battleship game

    Automated game
    game init -> take input from user
    Users give inputs
        Number of players
        Size of the board
        add ships
            start locations -> for each player -> check if valid
            persist locations only after new ship has been for every player
    start game
        keep a list of available shipm -> map of list of ships
        fire strategy
            keep saving where the rockets have been fired
            maybe save available locations in a list of each user, init as part of game init
    2 actions
    game.init
    start game

    Possible Entities
    Player -> what will player do? or own?
    Board

    Service
    Game -> BattleshipGame implements Game
    
    Strategy
    FireStrategy
    RandomFireStrategy implements FireStrategy 
        fire(list size) -> returns a random number from [0,size)


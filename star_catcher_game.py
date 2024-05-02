import pygame
import time
import random

def draw_window(player, elapsed_time, stars, WINDOW, BACKROUND, FONT):
    """
    The function `draw_window` draws a game window with a background, player, elapsed time, and stars.
    
    :param player: The "player" parameter is a rectangle object that represents the player's character
    in the game. It is used to draw the player's character on the game window
    :param elapsed_time: The elapsed_time parameter is the amount of time that has passed since the
    start of the game. It is a float value representing the number of seconds
    :param stars: The "stars" parameter is a list of rectangles representing the positions and sizes of
    stars in the game window. Each rectangle is defined by its top-left corner coordinates (x, y) and
    its width and height
    """
    WINDOW.blit(BACKROUND, (0, 0))
    time_text = FONT.render(f"Time: {round(elapsed_time)}s", 1, (255, 255, 255))
    WINDOW.blit(time_text, (10, 10))
    pygame.draw.rect(WINDOW, (255, 0, 0), player)
    
    for star in stars:
        pygame.draw.rect(WINDOW, (255, 255, 255), star)
    
    pygame.display.update()

def update_stars(stars, star_count, STAR_HEIGHT, STAR_WIDTH, STAR_VEL, WIDTH, HEIGHT):
    """
    The function updates the positions of stars and adds new stars to the list based on a given star
    count.
    
    :param stars: A list of pygame.Rect objects representing the stars on the screen
    :param star_count: The `star_count` parameter represents the current count of stars in the game. It
    is used to determine when to spawn a new star. In this code, a new star is spawned every time
    `star_count` is a multiple of 10
    :return: the updated list of stars.
    """
    if star_count % 10 == 0:  # The modulus value controls the star spawning rate
        star_x = random.randint(0, WIDTH - STAR_WIDTH)
        star = pygame.Rect(star_x, -STAR_HEIGHT, STAR_WIDTH, STAR_HEIGHT)
        stars.append(star)
    
    for star in stars[:]:
        star.y += STAR_VEL
        if star.y > HEIGHT:
            stars.remove(star)
    
    return stars

def check_collision(stars, player):
    """
    The function checks if there is a collision between the player and any of the stars.
    
    :param stars: A list of rectangles representing the stars in the game
    :param player: The player parameter is an object that represents the player in the game. It likely
    has properties such as position, size, and a method to check for collision with other objects
    :return: a boolean value. It returns True if there is a collision between the player and any of the
    stars, and False otherwise.
    """
    for star in stars:
        if player.colliderect(star):
            return True
    return False

def main():
    """
    The main function runs a game loop that updates the position of stars and the player, checks for
    collisions, and displays the game over text if a collision occurs.
    """
    # Initializing pygame font and modules
    pygame.font.init()

    # Constants
    WINDOW = pygame.display.set_mode((0, 0), pygame.FULLSCREEN)
    WIDTH, HEIGHT = WINDOW.get_size()
    BACKROUND_IMAGE = pygame.image.load("BACKROUND.jpeg").convert()
    BACKROUND = pygame.transform.scale(BACKROUND_IMAGE, (WIDTH, HEIGHT))
    PLAYER_WIDTH, PLAYER_HEIGHT, PLAYER_VEL = 40, 60, 5
    STAR_WIDTH, STAR_HEIGHT, STAR_VEL = 10, 20, 3
    FONT = pygame.font.SysFont("comicsans", 30)
    
    hit = False
    clock = pygame.time.Clock()
    start_time = time.time()
    stars = []
    star_count = 0
    player = pygame.Rect(200, HEIGHT - PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_HEIGHT)
    
    while True:
        elapsed_time = time.time() - start_time
        star_count += 1
        clock.tick(60)
        
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                break
        
        keys = pygame.key.get_pressed()
        if keys[pygame.K_LEFT] and player.x - PLAYER_VEL > 0:
            player.x -= PLAYER_VEL
        if keys[pygame.K_RIGHT] and player.x + PLAYER_VEL + player.width < WIDTH:
            player.x += PLAYER_VEL
        
        stars = update_stars(stars, star_count, STAR_HEIGHT, STAR_WIDTH, STAR_VEL, WIDTH, HEIGHT)
        hit = check_collision(stars, player)
        
        if hit:
            game_over_text = FONT.render("GAME OVER", 1, (255, 255, 255))
            WINDOW.blit(game_over_text, (WIDTH//2 - game_over_text.get_width()//2, HEIGHT//2 - game_over_text.get_height()//2))
            pygame.display.update()
            pygame.time.delay(2000)  # Display the game over text for 2 seconds
            break
        
        draw_window(player, elapsed_time, stars, WINDOW, BACKROUND, FONT)
    
    pygame.quit()

if __name__ == "__main__":
    main()
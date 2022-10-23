import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Player.NotRegisteredException;
import ru.netology.Player.Player;
import ru.netology.Player.Game;

public class GameTest {
    Player player1 = new Player(1, "Katya", 12);
    Player player2 = new Player(2, "Ivan", 120);
    Player player3 = new Player(3, "Lena", 1);
    Player player4 = new Player(4, "Petya", 302);
    Player player5 = new Player(5, "Kolya", 302);

    @Test
    public void winFirst() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 1;
        int actual = game.round("Ivan", "Katya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void winSecond() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 2;
        int actual = game.round("Lena", "Petya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notWin() {
        Game game = new Game();
        game.register(player4);
        game.register(player5);

        int expected = 0;
        int actual = game.round("Petya", "Kolya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notRegisteredFirst() {
        Game game = new Game();
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Lena", "Kolya");
        });
    }

    @Test
    public void notRegisteredSecond() {
        Game game = new Game();
        game.register(player4);
        game.register(player5);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Petya", "Katya");
        });
    }

}

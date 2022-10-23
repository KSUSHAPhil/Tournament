package ru.netology.Player;

import java.util.ArrayList;
import java.util.List;

import ru.netology.Player.NotRegisteredException;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int findByName(String name) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int round(String playerName1, String playerName2) {
        int player1 = findByName(playerName1);
        int player2 = findByName(playerName2);

        if (player1 == -1) {
            throw new NotRegisteredException("Игрок" + playerName1 + " не найден");
        }

        if (player2 == -1) {
            throw new NotRegisteredException("Игрок" + playerName2 + " не найден");
        }
        int strenght1 = players.get(player1).getStrength();
        int strenght2 = players.get(player2).getStrength();

        if (strenght1 == strenght2) {
            return 0;
        }
        if (strenght1 > strenght2) {
            return 1;
        }
        return 2;
    }
}

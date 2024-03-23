package dev.gether.getcustomitem.item;

import dev.gether.getcustomitem.item.customize.FrozenSword;
import org.bukkit.entity.Player;

import java.util.*;

public class FrozenManager {

    private Map<UUID, Long> frozenPlayers = new HashMap<>();

    /*
    public boolean isFrozen(Player player) {
        Long timeFrozenMS = frozenPlayers.get(player.getUniqueId());
        return timeFrozenMS != null && timeFrozenMS > System.currentTimeMillis();
    }
    */
    public double getFrozenTime(Player player) {
        // check the player is frozen //  default == 0 - no frozen
        Long frozenEndMS = frozenPlayers.get(player.getUniqueId());
        long currentTimeMillis = System.currentTimeMillis(); // current time

        // no frozen player found or frozen time has expired
        if(frozenEndMS == null || frozenEndMS <= currentTimeMillis) {
            return 0;
        }

        // calc how many second you can't move
        long diffTime = frozenEndMS - currentTimeMillis; // there is a difference in MS like: 2500 - 2.5 sec
        double secondsLeft = (double) diffTime / 1000; // getting frozen time (second) but with wrong format - 1.44443423 sec

        return Double.parseDouble(String.format(Locale.US, "%.2f", secondsLeft)); // change double to 2 decimal places
    }

    public void freeze(Player player, FrozenSword frozenSword) {
        if(frozenSword.getFrozenSeconds() == 0)
            return;

        long frozenEndMS = System.currentTimeMillis() + 1000L * frozenSword.getFrozenSeconds();

        // put to map
        frozenPlayers.put(player.getUniqueId(), frozenEndMS);
    }

    public void cleanCache(Player player) {
        frozenPlayers.remove(player.getUniqueId());
    }
}

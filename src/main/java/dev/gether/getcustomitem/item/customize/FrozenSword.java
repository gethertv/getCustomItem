package dev.gether.getcustomitem.item.customize;

import com.fasterxml.jackson.annotation.JsonTypeName;
import dev.gether.getconfig.domain.Item;
import dev.gether.getconfig.domain.config.sound.SoundConfig;
import dev.gether.getcustomitem.item.CustomItem;
import dev.gether.getcustomitem.item.ItemType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonTypeName("frozen_sword")
public class FrozenSword extends CustomItem {
    private int frozenSeconds;
    private double chanceToFrozen;

    public FrozenSword() {}

    public FrozenSword(String key, String categoryName, int usage, Item item, ItemType itemType, int cooldown, String permissionBypass, SoundConfig soundConfig, List<String> notifyYourself, List<String> notifyOpponents, int frozenSeconds, double chanceToFrozen) {
        super(key, categoryName, usage, item, itemType, cooldown, permissionBypass, soundConfig, notifyYourself, notifyOpponents);
        this.frozenSeconds = frozenSeconds;
        this.chanceToFrozen = chanceToFrozen;
    }
    @Override
    protected Map<String, String> replacementValues() {
        return Map.of(
                "{chance}", String.valueOf(chanceToFrozen),
                "{seconds}", String.valueOf(frozenSeconds)
        );
    }
}

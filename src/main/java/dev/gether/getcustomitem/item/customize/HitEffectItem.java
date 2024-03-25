package dev.gether.getcustomitem.item.customize;

import com.fasterxml.jackson.annotation.JsonTypeName;
import dev.gether.getconfig.domain.Item;
import dev.gether.getconfig.domain.config.potion.PotionEffectConfig;
import dev.gether.getconfig.domain.config.sound.SoundConfig;
import dev.gether.getcustomitem.item.CustomItem;
import dev.gether.getcustomitem.item.ItemType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonTypeName("hit_effect")
public class HitEffectItem extends CustomItem {
    private List<PotionEffectConfig> potionEffectConfigs;
    private double chance;
    public HitEffectItem() {}

    public HitEffectItem(String key, String categoryName, int usage, Item item, ItemType itemType, int cooldown, String permissionBypass, SoundConfig soundConfig, List<String> notifyYourself, List<String> notifyOpponents, List<PotionEffectConfig> potionEffectConfigs, double chance) {
        super(key, categoryName, usage, item, itemType, cooldown, permissionBypass, soundConfig, notifyYourself, notifyOpponents);
        this.potionEffectConfigs = potionEffectConfigs;
        this.chance = chance;
    }

    @Override
    protected Map<String, String> replacementValues() {
        return Map.of(
                "{chance}", String.valueOf(chance)
        );
    }


}

package dev.gether.getcustomitem.item.customize;

import com.fasterxml.jackson.annotation.JsonTypeName;
import dev.gether.getconfig.annotation.Comment;
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
@JsonTypeName("effect_radius")
public class EffectRadiusItem extends CustomItem {

    @Comment("apply the effect to yourself")
    private boolean includingYou;
    @Comment("apply the effect to players within a radius")
    private boolean otherPlayers;
    private int radius;
    private List<PotionEffectConfig> activeEffect;
    private List<String> removeEffect;

    public EffectRadiusItem() {}

    public EffectRadiusItem(String key, String categoryName, int usage, Item item, ItemType itemType, int cooldown, String permissionBypass, SoundConfig soundConfig, List<String> notifyYourself, List<String> notifyOpponents, boolean includingYou, boolean otherPlayers, int radius, List<PotionEffectConfig> activeEffect, List<String> removeEffect) {
        super(key, categoryName, usage, item, itemType, cooldown, permissionBypass, soundConfig, notifyYourself, notifyOpponents);
        this.includingYou = includingYou;
        this.otherPlayers = otherPlayers;
        this.radius = radius;
        this.activeEffect = activeEffect;
        this.removeEffect = removeEffect;
    }

    @Override
    protected Map<String, String> replacementValues() {
        return Map.of(
                "{radius}", String.valueOf(radius)
        );
    }

    // todo: custom particles etc.
}

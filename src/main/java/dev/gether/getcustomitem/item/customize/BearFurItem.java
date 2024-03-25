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
@JsonTypeName("bear_fur")
public class BearFurItem extends CustomItem {

    private double reducedDamage;
    private int seconds;
    public BearFurItem() {}

    public BearFurItem(String key, String categoryName, int usage, Item item, ItemType itemType, int cooldown, String permissionBypass, SoundConfig soundConfig, List<String> notifyYourself, List<String> notifyOpponents, double reducedDamage, int seconds) {
        super(key, categoryName, usage, item, itemType, cooldown, permissionBypass, soundConfig, notifyYourself, notifyOpponents);
        this.reducedDamage = reducedDamage;
        this.seconds = seconds;
    }

    @Override
    protected Map<String, String> replacementValues() {
        return Map.of(
                "{reduced-damage}", String.valueOf(reducedDamage),
                "{seconds}", String.valueOf(seconds)
        );
    }

}

package dev.gether.getcustomitem.item.customize;

import com.fasterxml.jackson.annotation.JsonTypeName;
import dev.gether.getconfig.domain.Item;
import dev.gether.getconfig.domain.config.TitleMessage;
import dev.gether.getconfig.domain.config.sound.SoundConfig;
import dev.gether.getcustomitem.item.CustomItem;
import dev.gether.getcustomitem.item.ItemType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


@Getter
@Setter
@JsonTypeName("hook")
public class HookItem extends CustomItem {
    private double multiply;
    private double divideHeight;
    private double divideGliding;

    public HookItem() {

    }

    public HookItem(String key,
                    String categoryName,
                    int usage,
                    Item item,
                    ItemType itemType,
                    int cooldown,
                    String permissionBypass,
                    SoundConfig soundConfig,
                    List<String> notifyYourself,
                    List<String> notifyOpponents,
                    TitleMessage titleYourself,
                    TitleMessage titleOpponents,
                    double multiply,
                    double divideHeight,
                    double divideGliding) {

        super(key, categoryName, usage, item, itemType, cooldown,
                permissionBypass, soundConfig, notifyYourself,
                notifyOpponents, titleYourself, titleOpponents);

        this.multiply = multiply;
        this.divideHeight = divideHeight;
        this.divideGliding = divideGliding;
    }

    @Override
    protected Map<String, String> replacementValues() {
        return Map.of();
    }


}

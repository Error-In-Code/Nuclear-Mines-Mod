package NuclearMines.content;

import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.power.ImpactReactor;
import mindustry.world.blocks.power.NuclearReactor;
import mindustry.world.blocks.production.GenericCrafter;

import static mindustry.type.ItemStack.with;

public class NuclearBlocks implements ContentList {
    public static Block ioniumMixer, ioniumReactor;

    @Override
    public void load() {
        ioniumMixer = new GenericCrafter("ionium-mixer"){{
            localizedName = "Ionium Mixer";
           requirements(Category.crafting, with(Items.lead, 200, Items.thorium, 50, Items.titanium, 100));
            // Research: blast-mixer, lead 2000, thorium 300, titanium 300
           consumesPower = true;
           consumes.items(with(Items.thorium, 3, Items.blastCompound, 1));
           consumes.power(12);
           outputItem = new ItemStack(NuclearItems.ionium, 1);
           size = 3;
           craftTime = 90;
        }};

        ioniumReactor = new NuclearReactor("ionium-reactor"){{
            localizedName = "Ionium Reactor";
           requirements(Category.power, with(Items.lead, 1000, Items.titanium, 700, Items.graphite, 800, Items.metaglass, 800, Items.surgeAlloy, 300));
           // research: impact-reactor
           powerProduction = 800;
            hasLiquids = true;
            liquidCapacity = 30;
            consumes.item(NuclearItems.ionium, 2);
            consumes.liquid(Liquids.cryofluid, 10);
            size = 5;
        }};
    }
}

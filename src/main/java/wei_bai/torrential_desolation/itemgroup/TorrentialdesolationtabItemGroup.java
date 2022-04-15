
package wei_bai.torrential_desolation.itemgroup;

import wei_bai.torrential_desolation.item.TorrentialDesolationworldconsoleItem;
import wei_bai.torrential_desolation.TorrentialDesolationModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@TorrentialDesolationModElements.ModElement.Tag
public class TorrentialdesolationtabItemGroup extends TorrentialDesolationModElements.ModElement {
	public TorrentialdesolationtabItemGroup(TorrentialDesolationModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtorrentialdesolationtab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TorrentialDesolationworldconsoleItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}

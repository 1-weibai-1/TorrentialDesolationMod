
package wei_bai.torrential_desolation.item;

import wei_bai.torrential_desolation.itemgroup.TorrentialdesolationtabItemGroup;
import wei_bai.torrential_desolation.TorrentialDesolationModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@TorrentialDesolationModElements.ModElement.Tag
public class ChaosbeadItem extends TorrentialDesolationModElements.ModElement {
	@ObjectHolder("torrential_desolation:chaosbead")
	public static final Item block = null;

	public ChaosbeadItem(TorrentialDesolationModElements instance) {
		super(instance, 41);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TorrentialdesolationtabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("chaosbead");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}

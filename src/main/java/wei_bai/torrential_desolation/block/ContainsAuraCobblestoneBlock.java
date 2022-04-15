
package wei_bai.torrential_desolation.block;

import wei_bai.torrential_desolation.itemgroup.TorrentialdesolationtabItemGroup;
import wei_bai.torrential_desolation.TorrentialDesolationModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

@TorrentialDesolationModElements.ModElement.Tag
public class ContainsAuraCobblestoneBlock extends TorrentialDesolationModElements.ModElement {
	@ObjectHolder("torrential_desolation:contains_aura_cobblestone")
	public static final Block block = null;

	public ContainsAuraCobblestoneBlock(TorrentialDesolationModElements instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(TorrentialdesolationtabItemGroup.tab))
				.setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(10f, 12f).setLightLevel(s -> 1).harvestLevel(10)
					.harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("contains_aura_cobblestone");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 14;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}

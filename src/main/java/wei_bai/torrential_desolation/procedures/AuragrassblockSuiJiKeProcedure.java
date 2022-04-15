package wei_bai.torrential_desolation.procedures;

import wei_bai.torrential_desolation.block.AuragrassblockBlock;
import wei_bai.torrential_desolation.block.AuraDirtBlock;
import wei_bai.torrential_desolation.TorrentialDesolationMod;

import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.IPlantable;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Block;

import java.util.Map;

public class AuragrassblockSuiJiKeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency world for procedure AuragrassblockSuiJiKe!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency x for procedure AuragrassblockSuiJiKe!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency y for procedure AuragrassblockSuiJiKe!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency z for procedure AuragrassblockSuiJiKe!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (!world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0))) && !(new Object() {
			public boolean checkPlantType(IWorld world, BlockPos pos) {
				Block _block = world.getBlockState(pos).getBlock();
				return _block instanceof IPlantable ? ((IPlantable) _block).getPlantType(world, pos) == PlantType.PLAINS : false;
			}
		}.checkPlantType(world, new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)))) && Math.random() * 10 < 0.1) {
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 0)), AuraDirtBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 0)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 0)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 0)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 0)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 0)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 0)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 1)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 1)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 1)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z - 1)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z - 1)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z - 1)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 1)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 1)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z - 1)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z - 1)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z - 1)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 1)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 1)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 1)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z - 1)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z - 1)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z - 1)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 0)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x + 1), (int) (y + 2), (int) (z + 0)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 2), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 0)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 0)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x - 1), (int) (y + 2), (int) (z + 0)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 2), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 0)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 1)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 2), (int) (z + 1)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 2), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 1)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z - 1)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 2), (int) (z - 1)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 2), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z - 1)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x + 1), (int) (y + 2), (int) (z + 1)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 2), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z - 1)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x - 1), (int) (y + 2), (int) (z - 1)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 2), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z - 1)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 1)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x - 1), (int) (y + 2), (int) (z + 1)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 2), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 1)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
		if (Math.random() * 10 < 0.1
				&& (world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z - 1)))).getBlock() == AuraDirtBlock.block
				&& world.isAirBlock(new BlockPos((int) (x + 1), (int) (y + 2), (int) (z - 1)))
				&& world.isAirBlock(new BlockPos((int) (x + 0), (int) (y + 2), (int) (z + 0)))) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z - 1)), AuragrassblockBlock.block.getDefaultState(), 3);
		}
	}
}

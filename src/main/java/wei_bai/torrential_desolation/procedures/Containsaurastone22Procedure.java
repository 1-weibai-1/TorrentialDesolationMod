package wei_bai.torrential_desolation.procedures;

import wei_bai.torrential_desolation.block.SpiritPulseBlock;
import wei_bai.torrential_desolation.TorrentialDesolationMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Map;

public class Containsaurastone22Procedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency world for procedure Containsaurastone22!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency x for procedure Containsaurastone22!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency y for procedure Containsaurastone22!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency z for procedure Containsaurastone22!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)))).getBlock() == SpiritPulseBlock.block) {
			return true;
		}
		return false;
	}
}

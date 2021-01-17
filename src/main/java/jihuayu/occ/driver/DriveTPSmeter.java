package jihuayu.occ.driver;

import gregtech.tileentity.sensors.MultiTileEntityTPSmeter;
import li.cil.oc.api.driver.NamedBlock;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverSidedTileEntity;
import li.cil.oc.integration.ManagedTileEntityEnvironment;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class DriveTPSmeter extends DriverSidedTileEntity {
    @Override
    public Class<?> getTileEntityClass() {
        return MultiTileEntityTPSmeter.class;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, int x, int y, int z, ForgeDirection side) {
        return new Environment((MultiTileEntityTPSmeter) world.getTileEntity(x, y, z));
    }

    public static final class Environment extends ManagedTileEntityEnvironment<MultiTileEntityTPSmeter> implements NamedBlock {

        public Environment(final MultiTileEntityTPSmeter tileEntity) {
            super(tileEntity, "gt_tps_meter");
        }

        @Callback(doc = "function():number")
        public Object[] getCurrentValue(final Context context, final Arguments args) {
            return new Object[]{tileEntity.mCurrentTime};
        }
        @Override
        public String preferredName() {
            return "gt_tps_meter";
        }

        @Override
        public int priority() {
            return 2;
        }
    }
}

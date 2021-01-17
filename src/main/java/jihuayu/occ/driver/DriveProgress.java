package jihuayu.occ.driver;

import gregapi.cover.ITileEntityCoverable;
import gregapi.tileentity.data.ITileEntityProgress;
import gregapi.tileentity.machines.ITileEntitySwitchableOnOff;
import li.cil.oc.api.driver.NamedBlock;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverSidedTileEntity;
import li.cil.oc.integration.ManagedTileEntityEnvironment;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class DriveProgress extends DriverSidedTileEntity {
    @Override
    public Class<?> getTileEntityClass() {
        return ITileEntityProgress.class;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, int x, int y, int z, ForgeDirection side) {
        return new Environment((ITileEntityProgress) world.getTileEntity(x, y, z));
    }

    public static final class Environment extends ManagedTileEntityEnvironment<ITileEntityProgress> implements NamedBlock {

        public Environment(final ITileEntityProgress tileEntity) {
            super(tileEntity, "gt_progress");
        }
        @Callback(doc = "function(side:number):number")
        public Object[] getProgressValue(final Context context, final Arguments args) {
            return new Object[]{tileEntity.getProgressValue((byte) args.checkInteger(0))};
        }
        @Callback(doc = "function(side:number):number")
        public Object[] getProgressMax(final Context context, final Arguments args) {
            return new Object[]{tileEntity.getProgressMax((byte) args.checkInteger(0))};
        }
        @Override
        public String preferredName() {
            return "gt_progress";
        }

        @Override
        public int priority() {
            return 1;
        }
    }
}

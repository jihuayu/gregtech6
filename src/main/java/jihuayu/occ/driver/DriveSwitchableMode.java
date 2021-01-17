package jihuayu.occ.driver;

import gregapi.tileentity.machines.ITileEntitySwitchableMode;
import li.cil.oc.api.driver.NamedBlock;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverSidedTileEntity;
import li.cil.oc.integration.ManagedTileEntityEnvironment;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class DriveSwitchableMode extends DriverSidedTileEntity {
    @Override
    public Class<?> getTileEntityClass() {
        return ITileEntitySwitchableMode.class;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, int x, int y, int z, ForgeDirection side) {
        return new Environment((ITileEntitySwitchableMode) world.getTileEntity(x, y, z));
    }

    public static final class Environment extends ManagedTileEntityEnvironment<ITileEntitySwitchableMode> implements NamedBlock {
        public Environment(final ITileEntitySwitchableMode tileEntity) {
            super(tileEntity, "gt_switchable_mode");
        }
        @Callback(doc = "function():number")
        public Object[] getStateMode(final Context context, final Arguments args) {
            return new Object[]{tileEntity.getStateMode()};
        }
        @Callback(doc = "function(state:number):number")
        public Object[] setStateMode(final Context context, final Arguments args) {
            return new Object[]{tileEntity.setStateMode((byte) args.checkInteger(0))};
        }
        @Override
        public String preferredName() {
            return "gt_switchable_mode";
        }

        @Override
        public int priority() {
            return 1;
        }
    }
}

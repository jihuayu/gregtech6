package jihuayu.occ.driver;

import gregapi.tileentity.machines.ITileEntitySwitchableMode;
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

public class DriveSwitchableOnOff extends DriverSidedTileEntity {
    @Override
    public Class<?> getTileEntityClass() {
        return ITileEntitySwitchableOnOff.class;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, int x, int y, int z, ForgeDirection side) {
        return new Environment((ITileEntitySwitchableOnOff) world.getTileEntity(x, y, z));
    }
    
    public static final class Environment extends ManagedTileEntityEnvironment<ITileEntitySwitchableOnOff> implements NamedBlock {
        public Environment(final ITileEntitySwitchableOnOff tileEntity) {
            super(tileEntity, "gt_switchable_on_off");
        }
        @Callback(doc = "function(mode:boolean):boolean")
        public Object[] setStateOnOff(final Context context, final Arguments args) {
            return new Object[]{tileEntity.setStateOnOff(args.checkBoolean(0))};
        }
        @Callback(doc = "function():boolean")
        public Object[] getStateOnOff(final Context context, final Arguments args) {
            return new Object[]{tileEntity.getStateOnOff()};
        }
        @Override
        public String preferredName() {
            return "gt_switchable_on_off";
        }

        @Override
        public int priority() {
            return 0;
        }
    }
}

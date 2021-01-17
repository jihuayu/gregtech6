package jihuayu.occ.driver;

import gregapi.tileentity.base.TileEntityBase07Paintable;
import gregapi.tileentity.data.ITileEntityProgress;
import li.cil.oc.api.driver.NamedBlock;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverSidedTileEntity;
import li.cil.oc.integration.ManagedTileEntityEnvironment;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class DrivePaintable extends DriverSidedTileEntity {
    @Override
    public Class<?> getTileEntityClass() {
        return TileEntityBase07Paintable.class;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, int x, int y, int z, ForgeDirection side) {
        return new Environment((TileEntityBase07Paintable) world.getTileEntity(x, y, z));
    }

    public static final class Environment extends ManagedTileEntityEnvironment<TileEntityBase07Paintable> implements NamedBlock {

        public Environment(final TileEntityBase07Paintable tileEntity) {
            super(tileEntity, "gt_paintable");
        }

        @Callback(doc = "function():number")
        public Object[] getColor(final Context context, final Arguments args) {
            return new Object[]{tileEntity.getPaint()};
        }
        @Override
        public String preferredName() {
            return "gt_paintable";
        }

        @Override
        public int priority() {
            return 1;
        }
    }
}

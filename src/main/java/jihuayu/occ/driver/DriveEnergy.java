package jihuayu.occ.driver;

import gregapi.code.TagData;
import gregapi.data.TD;
import gregapi.tileentity.energy.ITileEntityEnergy;
import li.cil.oc.api.driver.NamedBlock;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverSidedTileEntity;
import li.cil.oc.integration.ManagedTileEntityEnvironment;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class DriveEnergy extends DriverSidedTileEntity {
    @Override
    public Class<?> getTileEntityClass() {
        return ITileEntityEnergy.class;
    }

    @Override
    public ManagedEnvironment createEnvironment(World world, int x, int y, int z, ForgeDirection side) {
        return new Environment((ITileEntityEnergy) world.getTileEntity(x, y, z));
    }

    public static final class Environment extends ManagedTileEntityEnvironment<ITileEntityEnergy> implements NamedBlock {

        public Environment(final ITileEntityEnergy tileEntity) {
            super(tileEntity, "gt_energy");
        }

        @Callback(doc = "function(energy:string, side:number):number")
        public Object[] getEnergySizeOutputMin(final Context context, final Arguments args) {
            String arg0 = args.checkString(0).toLowerCase();
            int arg1 = args.checkInteger(1);
            for (TagData i : TD.Energy.ALL) {
                if (i.mName.toLowerCase().equals(arg0) || i.getLocalisedNameShort().toLowerCase().equals(arg0) || i.getLocalisedNameLong().toLowerCase().equals(arg0)) {
                    return new Object[]{tileEntity.getEnergySizeOutputMin(i, (byte) arg1)};
                }
            }
            throw new IllegalArgumentException("Error energy name!");
        }

        @Callback(doc = "function(energy:string, side:number):number")
        public Object[] getEnergySizeInputRecommended(final Context context, final Arguments args) {
            String arg0 = args.checkString(0).toLowerCase();
            int arg1 = args.checkInteger(1);
            for (TagData i : TD.Energy.ALL) {
                if (i.mName.toLowerCase().equals(arg0) || i.getLocalisedNameShort().toLowerCase().equals(arg0) || i.getLocalisedNameLong().toLowerCase().equals(arg0)) {
                    return new Object[]{tileEntity.getEnergySizeInputRecommended(i, (byte) arg1)};
                }
            }
            throw new IllegalArgumentException("Error energy name!");
        }

        @Callback(doc = "function(energy:string, side:number):number")
        public Object[] getEnergySizeOutputRecommended(final Context context, final Arguments args) {
            String arg0 = args.checkString(0).toLowerCase();
            int arg1 = args.checkInteger(1);
            for (TagData i : TD.Energy.ALL) {
                if (i.mName.toLowerCase().equals(arg0) || i.getLocalisedNameShort().toLowerCase().equals(arg0) || i.getLocalisedNameLong().toLowerCase().equals(arg0)) {
                    return new Object[]{tileEntity.getEnergySizeOutputRecommended(i, (byte) arg1)};
                }
            }
            throw new IllegalArgumentException("Error energy name!");
        }

        @Callback(doc = "function(energy:string, side:number):number")
        public Object[] getEnergySizeOutputMax(final Context context, final Arguments args) {
            String arg0 = args.checkString(0).toLowerCase();
            int arg1 = args.checkInteger(1);
            for (TagData i : TD.Energy.ALL) {
                if (i.mName.toLowerCase().equals(arg0) || i.getLocalisedNameShort().toLowerCase().equals(arg0) || i.getLocalisedNameLong().toLowerCase().equals(arg0)) {
                    return new Object[]{tileEntity.getEnergySizeOutputMax(i, (byte) arg1)};
                }
            }
            throw new IllegalArgumentException("Error energy name!");
        }

        @Callback(doc = "function(energy:string, side:number):number")
        public Object[] getEnergySizeInputMin(final Context context, final Arguments args) {
            String arg0 = args.checkString(0).toLowerCase();
            int arg1 = args.checkInteger(1);
            for (TagData i : TD.Energy.ALL) {
                if (i.mName.toLowerCase().equals(arg0) || i.getLocalisedNameShort().toLowerCase().equals(arg0) || i.getLocalisedNameLong().toLowerCase().equals(arg0)) {
                    return new Object[]{tileEntity.getEnergySizeInputMin(i, (byte) arg1)};
                }
            }
            throw new IllegalArgumentException("Error energy name!");
        }

        @Callback(doc = "function(energy:string, side:number, isEmitting:boolean):number")
        public Object[] isEnergyType(final Context context, final Arguments args) {
            String arg0 = args.checkString(0).toLowerCase();
            int arg1 = args.checkInteger(1);
            boolean arg2 = args.checkBoolean(1);
            for (TagData i : TD.Energy.ALL) {
                if (i.mName.toLowerCase().equals(arg0) || i.getLocalisedNameShort().toLowerCase().equals(arg0) || i.getLocalisedNameLong().toLowerCase().equals(arg0)) {
                    return new Object[]{tileEntity.isEnergyType(i, (byte) arg1, arg2)};
                }
            }
            throw new IllegalArgumentException("Error energy name!");
        }

        @Callback(doc = "function(energy:string, side:number):number")
        public Object[] getEnergySizeInputMax(final Context context, final Arguments args) {
            String arg0 = args.checkString(0).toLowerCase();
            int arg1 = args.checkInteger(1);
            for (TagData i : TD.Energy.ALL) {
                if (i.mName.toLowerCase().equals(arg0) || i.getLocalisedNameShort().toLowerCase().equals(arg0) || i.getLocalisedNameLong().toLowerCase().equals(arg0)) {
                    return new Object[]{tileEntity.getEnergySizeInputMax(i, (byte) arg1)};
                }
            }
            throw new IllegalArgumentException("Error energy name!");
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
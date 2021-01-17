package jihuayu.occ;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import ic2.core.crop.TileEntityCrop;
import jihuayu.occ.driver.*;
import li.cil.oc.api.Driver;
import li.cil.oc.api.event.GeolyzerEvent;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "occ",name = "OpenComputerComponent")
public class OCCMain {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Driver.add(new DriveSwitchableMode());
        Driver.add(new DriveSwitchableOnOff());
        Driver.add(new DriveProgress());
        Driver.add(new DriveEnergy());
        Driver.add(new DriveTPSmeter());
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onGeolyzerEvent(GeolyzerEvent.Analyze e){
        TileEntity te = e.host.world().getTileEntity(e.x,e.y,e.z);
        if (te instanceof TileEntityCrop){
            e.data.put("exStorage",((TileEntityCrop) te).exStorage);
            e.data.put("waterStorage",((TileEntityCrop) te).waterStorage);
            e.data.put("nutrientStorage",((TileEntityCrop) te).nutrientStorage);
            if (((TileEntityCrop) te).getCrop()!=null){
                e.data.put("airQuality",((TileEntityCrop) te).airQuality);
                e.data.put("humidity",((TileEntityCrop) te).humidity);
                e.data.put("nutrients",((TileEntityCrop) te).nutrients);
                e.data.put("statGain",((TileEntityCrop) te).statGain);
                e.data.put("statGrowth",((TileEntityCrop) te).statGrowth);
                e.data.put("statResistance",((TileEntityCrop) te).statResistance);
                e.data.put("growthPoints",((TileEntityCrop) te).growthPoints);
                e.data.put("crop",((TileEntityCrop) te).getCrop().name());
            }
            else{
                e.data.put("upgraded",((TileEntityCrop) te).upgraded);
            }
//            e.data.remove("color");
//            e.data.remove("metadata");
//            e.data.remove("harvestLevel");
//            e.data.remove("hardness");
            ((TileEntityCrop) te).setScanLevel((byte) 5);
        }
    }
}

package mindustry.content;

import arc.struct.*;
import mindustry.game.conditions.*;
import mindustry.type.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.TechTree.*;

public class TantrosTechTree{
    public static void load(){
        Planets.tantros.techTree = nodeRoot("tantros", Liquids.water, () -> {
            node(coralChunk, () -> {
                
            });
            
            nodeProduce(Items.sand, () -> {
                nodeProduce(Liquids.oil, () -> {

                });
            });
        });
    }
}

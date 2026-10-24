package mindustry.content;

import arc.struct.*;
import mindustry.game.conditions.*;
import mindustry.type.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.TechTree.*;

public class TantrosTechTree{
    public static void load(){
        Planets.tantros.techTree = nodeRoot("tantros", coreRally, () -> {
            node(darksand, () -> {
                node(duneWall, () -> {
                    
                });
                node(redmat, () -> {
                    node(redweed, () -> {
                        
                    });
                });
                node(bluemat, () -> {
                    node(purbush, () -> {
                        
                    });
                    node(yellowCoral, () -> {
                        node(coralChunk, () -> {
                            
                        });
                    });
                });
            });
            
            nodeProduce(Items.sand, () -> {
                nodeProduce(Liquids.oil, () -> {

                });
            });
        });
    }
}

package mindustry.world.blocks.environment;

import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.*;
import mindustry.annotations.Annotations.*;
import mindustry.graphics.*;
import mindustry.world.*;

public class StaticCoralWall extends StaticWall{
    public @Load(value = "@-cluster#", length = 1) TextureRegion[] clusters;

    public StaticCoralWall(String name){
        super(name);
        variants = 1;
    }

    @Override
    public void drawBase(Tile tile){
        Draw.z(Layer.block);
        super.drawBase(tile);
        
        if(Mathf.randomSeed(tile.pos(), 10) < 2){
            Draw.z(Layer.power + 1);
            /** Draw.rect(clusters[0], tile.worldx(), tile.worldy(), Mathf.randomSeedRange(tile.pos() + 1, 180f)); */

            TextureRegion reg = clusters[0];
            float x = tile.worldx(), y = tile.worldy();
            Draw.rectv(reg, x, y, reg.width, reg.height, 0, vec -> vec.add(
                Mathf.sin(vec.y*3 + Vars.state.time, 1f, 0.2f) + Mathf.sin(vec.x*3 - Vars.state.time, 70, 0.8f),
                Mathf.cos(vec.x*3 + Vars.state.time + 8, 1f + 6f, 0.2f * 1.1f) + Mathf.sin(vec.y*3 - Vars.state.time, 50, 0.2f)
            ));
        }
    }
}

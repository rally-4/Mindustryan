package mindustry.world.blocks.environment;

import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.*;
import mindustry.annotations.Annotations.*;
import mindustry.graphics.*;
import mindustry.world.*;

//Experimental
public class CoralChunk extends Block{
    public @Load(value = "@-cluster#", length = 1) TextureRegion[] clusters;
    
    public StaticCoralWall(String name){
        super(name);
        variants = 1;
        solid = true;
        clipSize = 90;
        customShadow = true;
    }
    
    @Override
    public void drawBase(Tile tile){
        
        float
        x = tile.worldx(), y = tile.worldy(),
        rot = Mathf.randomSeedRange(tile.pos() + 1, 180f),
        w = region.width * region.scl(), h = region.height * region.scl(),
        scl = 1f, mag = 0.2f;
        
        TextureRegion base = variants == 0 ? region : region[Mathf.randomSeed(tile.pos(), 0, Math.max(0, region.length - 1))];
        
        Draw.z(Layer.block);
        Draw.rect(base, tile.worldx(), tile.worldy(), 0f);
        
        //TODO should function like yellowCoral
        TextureRegion coral = variants == 0 ? clusters[0] : clusters[Mathf.randomSeed(tile.pos(), 0, Math.max(0, clusters.length - 1))];
        
        Draw.z(Layer.power + 1);
        Draw.rectv(reg, x, y, w, h, rot, vec -> vec.add(
            Mathf.sin(vec.y*3 + Vars.state.time, scl, mag) + Mathf.sin(vec.x*3 - Vars.state.time, 70, 0.8f),
            Mathf.cos(vec.x*3 + Vars.state.time + 8, scl + 6f, mag * 1.1f) + Mathf.sin(vec.y*3 - Vars.state.time, 50, 0.2f)
        ));
    }
    
    @Override
    public void drawShadow(Tile tile){}
}

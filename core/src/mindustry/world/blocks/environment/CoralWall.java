package mindustry.world.blocks.environment;

import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.*;
import mindustry.annotations.Annotations.*;
import mindustry.graphics.*;
import mindustry.world.*;

public class CoralWall extends Block{
    public @Load(value = "@-cluster#", length = 1) TextureRegion[] clusters;

    static Rand rand = new Rand();
    
    public CoralWall(String name){
        super(name);
        variants = 1;
        solid = true;
        clipSize = 90;
        customShadow = true;
    }
    
    @Override
    public void drawBase(Tile tile){
        float x = tile.worldx(), y = tile.worldy(),
        rot = Mathf.randomSeedRange(tile.pos() + 1, 180f),
        w = region.width, h = region.height,
        scl = 30f, mag = 0.2f;
        
        TextureRegion base = variants == 0 ? region : variantRegions[Mathf.randomSeed(tile.pos(), 0, Math.max(0, variantRegions.length - 1))];
        
        Draw.z(Layer.block);
        Draw.rect(base, x, y, 0f);
        
        if(Mathf.randomSeed(tile.pos(), 10) < 2){
            TextureRegion coral = variants == 0 ? clusters[0] : clusters[Mathf.randomSeed(tile.pos(), 0, Math.max(0, clusters.length - 1))];
            
            Draw.z(Layer.power + 1);
            /** Draw.rect(coral, x, y, rot); */
            /** Draw.rectv(coral, x, y, w, h, rot, vec -> vec.add(
                Mathf.sin(vec.y*3 + Vars.state.time, scl, mag) + Mathf.sin(vec.x*3 - Vars.state.time, 70, 0.8f),
                Mathf.cos(vec.x*3 + Vars.state.time + 8, scl + 6f, mag * 1.1f) + Mathf.sin(vec.y*3 - Vars.state.time, 50, 0.2f)
            )); */
            float sclMin = 30f, sclMax = 50f, magMin = 5f, magMax = 15f, timeRange = 40f;
            float angle = Mathf.sin(Vars.state.time + rand.random(0, timeRange), rand.random(sclMin, sclMax), rand.random(magMin, magMax));
            Draw.rect(coral, x, y, w, h, angle);
        }
    }
    
    @Override
    public void drawShadow(Tile tile){}
}

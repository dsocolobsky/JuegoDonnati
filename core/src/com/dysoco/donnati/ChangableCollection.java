package com.dysoco.donnati;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChangableCollection {

    private LinkedHashMap<String, AtlasRegion> map;
    private ArrayList<AtlasRegion> indexMap;
    private int index;

    public ChangableCollection() {
        map = new LinkedHashMap<String, AtlasRegion>();
        indexMap = new ArrayList<AtlasRegion>(map.values());

        index = 0;
    }

    public AtlasRegion currentAtlas() {
        return indexMap.get(this.index);
    }

    public String currentKey() {
        int i = 0;

        for(Map.Entry<String, AtlasRegion> entry : map.entrySet()) {
            if(i == index) {
                return entry.getKey();
            }

            i++;
        }

        return null;
    }

    public void add(String key, AtlasRegion region) {
        map.put(key, region);
        indexMap = new ArrayList<AtlasRegion>(map.values());
    }

    public void forward() {
        if(index == (map.size() - 1)) {
            index = 0;
        } else {
            index++;
        }
    }

    public void backwards() {
        if(index == 0) {
            index = map.size() - 1;
        } else {
            index--;
        }
    }

}

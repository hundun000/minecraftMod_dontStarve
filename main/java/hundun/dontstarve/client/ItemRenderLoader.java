package hundun.dontstarve.client;

import hundun.dontstarve.block.BlockLoader;
import hundun.dontstarve.item.ItemLoader;

public class ItemRenderLoader {
    public ItemRenderLoader()
    {
        ItemLoader.registerRenders();
        BlockLoader.registerRenders();
    }

}

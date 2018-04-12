package hundun.dontstarve.crafting;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class RecipeRot extends ShapelessRecipes{
	
	private static int ROTMAXDAMAGE=100;

	public RecipeRot(ItemStack output, List<ItemStack> inputList) {
		super(output, inputList);
	}
	
    /**
     * Used to check if a recipe matches current crafting inventory
     */
	@Override
    public boolean matches(InventoryCrafting inv, World worldIn)
    {
        List<ItemStack> list = Lists.newArrayList(this.recipeItems); //待测目标List
        int sumDamage=0;
        int count=0;
        
        for (int i = 0; i < inv.getHeight(); ++i)
        {
            for (int j = 0; j < inv.getWidth(); ++j)
            {
                ItemStack itemstack = inv.getStackInRowAndColumn(j, i);  //遍历选中合成台的一格
                

                if (itemstack != null)
                {
                    boolean flag = false;

                    for (ItemStack itemstack1 : list)  //尝试和待测目标List项目的每一项比较
                    {
                    
                    	//移除了检测Metadata匹配
                        if (itemstack.getItem() == itemstack1.getItem() ) //&& (itemstack1.getMetadata() == 32767 || itemstack.getMetadata() == itemstack1.getMetadata())
                        {
                            flag = true;    //本项没有错误匹配
                            sumDamage+=itemstack.getItemDamage()*itemstack.stackSize;
                            count+=itemstack.stackSize;
                            list.remove(itemstack1); //匹配成功则从待测目标List移除
                            System.out.println("匹配成功一项，腐败度："+itemstack.getItemDamage()*itemstack.stackSize+",数量"+itemstack.stackSize);
                            break;
                        }
                    }

                    if (!flag)
                    {
                        return false;  //只要有一项错误匹配则整个合成失败
                    }
                }
            }
        }
        
        boolean res=list.isEmpty();
        if(res){
        	resetRecipeOutput(sumDamage,count);
        	
        }
        	
		return res;
    }
	
	@Override
	public ItemStack[] getRemainingItems(InventoryCrafting inv)
    {
        ItemStack[] aitemstack = new ItemStack[inv.getSizeInventory()];
        inv.clear();

        
        for (int i = 0; i < aitemstack.length; ++i)
        {
            aitemstack[i] = null;  //暂时暴力地全部清空
        }

        return aitemstack;
    }
	
	
	private void resetRecipeOutput(long sumDamge,int count){
		int trueSum;
		if(count>20)
			count=20;
		int damage=(int) (sumDamge/count);
		if(damage>ROTMAXDAMAGE)
			damage=ROTMAXDAMAGE;
		System.out.println("合成结果将为："+count+"个,腐败为"+damage);
		super.getRecipeOutput().setItemDamage(damage);
		super.getRecipeOutput().stackSize=count;
	}

}

package hundun.dontstarve.achievement;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import hundun.dontstarve.DontStarve;
import hundun.dontstarve.item.ItemLoader;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class AchievementLoader {
	
	public static Achievement getFirstBerries = buildAchievement("getFirstBerries", 0, 0, ItemLoader.berries, null);
	

	
	public static AchievementPage achievementPageDontstarve; 
	
	private static ArrayList<Achievement> achievements=new ArrayList();
	
	public AchievementLoader()
    {
		achievements.add(getFirstBerries.initIndependentStat().registerStat());
		
		
		
		
		achievementPageDontstarve= new AchievementPage(DontStarve.NAME, achievements.toArray(new Achievement[achievements.size()]));
		AchievementPage.registerAchievementPage(achievementPageDontstarve);
		
    }
	
	private static Achievement buildAchievement(String name, int column, int row, Item itemIn, Achievement parent){
		return new Achievement("achievement."+DontStarve.MODID+"."+name,DontStarve.MODID+"."+name, column, row, itemIn, parent);
	}
	
	
}

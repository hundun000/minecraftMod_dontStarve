package hundun.dontstarve.command;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

import hundun.dontstarve.capability.CapabilityLoader;
import hundun.dontstarve.capability.IPositionHistory;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;;

public class CommandPosition extends CommandBase {

	@Override
	public String getCommandName() {
		return "position";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "commands.position.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length > 1)
        {
            throw new WrongUsageException("commands.position.usage");
        }
        else
        {
            EntityPlayerMP entityPlayerMP = args.length > 0 ? CommandBase.getPlayer(server, sender, args[0])
                    : CommandBase.getCommandSenderAsPlayer(sender);
            Vec3d pos = entityPlayerMP.getPositionVector();
            
            if (entityPlayerMP == sender && entityPlayerMP.hasCapability(CapabilityLoader.positionHistory, null))
            {
                sender.addChatMessage(new TextComponentTranslation("commands.position.history"));
                IPositionHistory histories = entityPlayerMP.getCapability(CapabilityLoader.positionHistory, null);
                for (Vec3d vec3 : histories.getHistories())
                {
                    if (vec3 != null)
                    {
                        sender.addChatMessage(new TextComponentTranslation(vec3.toString()));
                    }
                }
                histories.pushHistory(pos);
            }
            
            sender.addChatMessage(new TextComponentTranslation("commands.position.success", entityPlayerMP.getName(),
                    pos, entityPlayerMP.worldObj.provider.getDimension()));
        }
	}
	
	@Override
    public int getRequiredPermissionLevel()
    {
        return 2;
    }
	
	@Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos)
    {
        if (args.length == 1)
        {
            String[] names =server.getAllUsernames();
            return CommandBase.getListOfStringsMatchingLastWord(args, names);
        }
        return null;
    }
	

}

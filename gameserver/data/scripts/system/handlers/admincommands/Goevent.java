/*
 * This file is part of aion-unique <aion-unique.org>.
 *
 *  aion-unique is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  aion-unique is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with aion-unique.  If not, see <http://www.gnu.org/licenses/>.
 */
package admincommands;

import gameserver.configs.administration.AdminConfig;
import gameserver.model.gameobjects.player.Player;
import gameserver.utils.PacketSendUtility;
import gameserver.utils.chathandlers.AdminCommand;
/**
 * @author Alfa
 * @remodel Khaos
 */
public class Goevent extends AdminCommand
{
	public Goevent()
	   {
	      super("goevent");
	   }
	   @Override
	   public void executeCommand(Player admin, String[] params)
	   {
	      if(admin.getAccessLevel() < AdminConfig.COMMAND_GOEVENT)
	      {
	          PacketSendUtility.sendMessage(admin, "You do not have sufficient rights to execute this command");
	          return;
	      }
	
	      if(admin.isLookingForEvent())
	      {
	         admin.setLookingForEvent(false);
	         PacketSendUtility.sendMessage(admin, "You are no longer waiting for event.");
	      }
	      else
	      {
	         admin.setLookingForEvent(true);
	         PacketSendUtility.sendMessage(admin, "You are waiting for the event.");
	      }
	   }

}

package com.justmangostudio.barrels.items;

import com.justmangostudio.barrels.block.Barrel;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.inventory.ItemUtils;

public abstract class BarrelModule extends SimpleSlimefunItem<ItemUseHandler> {
	public BarrelModule(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
		super(category, item, recipeType, recipe);
	}
	
	public abstract boolean applyUpgrade(Block b);

	@Override
	public ItemUseHandler getItemHandler() {
		return e -> {
			if (e.getSlimefunBlock().isPresent()) {
				SlimefunItem barrel = e.getSlimefunBlock().get();
				
				if (barrel instanceof Barrel) {
	                if (applyUpgrade(e.getClickedBlock().get())) return;
	                
	                ItemUtils.consumeItem(e.getItem(), false);
	                e.getPlayer().sendMessage(ChatColor.GREEN + "Module successfully applied!");
	            }
			}
		};
	}

}

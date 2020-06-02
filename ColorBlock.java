package me.prostedeni.goodcraft.colorblock;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Objects;

public final class ColorBlock extends JavaPlugin implements Listener {

    ArrayList<String> colourList = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() != null) {
                if (e.getItem().toString().contains("DYE")) {
                    if(e.getPlayer().hasPermission("colorblock.dye")) {
                        for (int i = 3; i >= 1; ) {
                            i--;
                            if (Objects.requireNonNull(e.getClickedBlock()).getBlockData().getMaterial().toString().endsWith("_POWDER") || e.getClickedBlock().getBlockData().getMaterial().toString().endsWith("_PANE") || e.getClickedBlock().getBlockData().getMaterial().toString().endsWith("_GLASS") || e.getClickedBlock().getBlockData().getMaterial().toString().endsWith("_BOX") || e.getClickedBlock().getBlockData().getMaterial().toString().endsWith("_CONCRETE") || e.getClickedBlock().getBlockData().getMaterial().toString().endsWith("_TERRACOTTA") || e.getClickedBlock().getBlockData().getMaterial().toString().endsWith("_WOOL")) {
                                Material BlockMaterial = e.getClickedBlock().getType();
                                Material DyeMaterial = e.getItem().getType();

                                String stringBlockMaterial = BlockMaterial.toString();
                                String stringDyeMaterial = DyeMaterial.toString();

                                String changedDyeMaterial = stringDyeMaterial.replaceFirst("_DYE", "");

                                colourList.add("RED");
                                colourList.add("GREEN");
                                colourList.add("PURPLE");
                                colourList.add("CYAN");
                                colourList.add("LIGHT_GRAY");
                                colourList.add("GRAY");
                                colourList.add("PINK");
                                colourList.add("LIME");
                                colourList.add("YELLOW");
                                colourList.add("LIGHT_BLUE");
                                colourList.add("MAGENTA");
                                colourList.add("ORANGE");
                                colourList.add("BLUE");
                                colourList.add("BROWN");
                                colourList.add("BLACK");
                                colourList.add("WHITE");

                                for (String string : colourList) {
                                    if (stringBlockMaterial.contains(string)) {

                                        Material changedBlockMaterialMaterial = Material.getMaterial(stringBlockMaterial.replaceFirst(string, changedDyeMaterial));

                                        if (changedBlockMaterialMaterial != null) {
                                            if (!(changedBlockMaterialMaterial.toString().equals(stringBlockMaterial))) {

                                                e.getClickedBlock().setType(changedBlockMaterialMaterial);

                                                if (e.getClickedBlock().getBlockData().getMaterial().toString().endsWith("_BOX")) {
                                                    e.setCancelled(true);
                                                }
                                                if (!(e.getPlayer().getGameMode().toString().equals("CREATIVE"))) {
                                                    int amount = e.getItem().getAmount();
                                                    e.getItem().setAmount((amount - 1));
                                                }

                                            }
                                        }
                                        if (colourList.get(0) != null) {
                                            colourList.clear();
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}

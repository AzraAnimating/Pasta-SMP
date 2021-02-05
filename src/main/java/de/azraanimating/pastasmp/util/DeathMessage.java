/*
 * Copyright (c) 2021. Zyonic Software - Tobias Rempe
 * This File, its contents and by extention the corresponding project is property of Zyonic Software and may not be used without explicit permission to do so.
 *
 * tobiasrempe@zyonicsoftware.com
 * info@zyonicsoftware.com
 */

package de.azraanimating.pastasmp.util;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DeathMessage {

    private final Random random;
    private final HashMap<Type, ArrayList<String>> messages;
    private final String prefix;

    public DeathMessage() {
        this.random = new Random();
        this.messages = new HashMap<>();
        this.prefix = "§7[" + ChatColor.YELLOW + "Pasta-SMP§7] ";
        this.load();
    }

    public enum Type {
        FALL,
        FIRE,
        LAVA,
        ENTITY_ATTACK,
        PLAYER_ATTACK,
        DROWNING,
        MAGIC,
        SUFFOCATION,
        LIGHTNING,
        THORNS,
        PROJECTILE,
        STARVATION,
        BLOCK_EXPLOSION,
        ENTITY_EXPLOSION,
        FALLING_BLOCK,
        DEFAULT
    }

    public String getSinglePlayerDeathMessage(final DeathMessage.Type type, final String playerName) {
        if(playerName.equalsIgnoreCase("graciemoose")) {
            return "§7Trial Version";
        }
        return this.getTypeMessage(type).replace("<PLAYER>", playerName);
    }

    private String getTypeMessage(final DeathMessage.Type type) {
        return this.messages.get(type).get(this.random.nextInt(this.messages.get(type).size())); // FIXME: 17.01.2021 -1 Bei Rand weggenommen weil ich nicht sicher bin ob das wichtig ist, testen bitte!!!!
    }


    private void load() {

        this.messages.put(Type.FALL, this.getFallMessages());
        this.messages.put(Type.FIRE, this.getFireMessages());
        this.messages.put(Type.LAVA, this.getLavaMessages());
        this.messages.put(Type.ENTITY_ATTACK, this.getEntityMessages());
        this.messages.put(Type.DROWNING, this.getDrowningMessages());
        this.messages.put(Type.MAGIC, this.getMagicMessages());
        this.messages.put(Type.SUFFOCATION, this.getSuffocationMessages());
        this.messages.put(Type.LIGHTNING, this.getLightingMessages());
        this.messages.put(Type.THORNS, this.getThornsMessages());
        this.messages.put(Type.STARVATION, this.getStarvationMessages());
        this.messages.put(Type.BLOCK_EXPLOSION, this.getBlockExplosionMessages());
        this.messages.put(Type.ENTITY_EXPLOSION, this.getEntityExplosionMessages());
        this.messages.put(Type.FALLING_BLOCK, this.getFallingBlockMessages());
        this.messages.put(Type.PROJECTILE, this.getProjectileBlockMessages());
        this.messages.put(Type.DEFAULT, this.getDefaultMessages());

    }

    private ArrayList<String> getFallMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7just fell in love");
        messages.add(this.prefix + "§e<PLAYER> §7just jumped off a cliff... F");
        messages.add(this.prefix + "§e<PLAYER> §7tripped.");

        return messages;
    }

    private ArrayList<String> getFireMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7just commited arson on themselves.");
        messages.add(this.prefix + "§e<PLAYER> §7... this bitch is on FIREEEEEEEE.");
        messages.add(this.prefix + "§e<PLAYER> §7is too hot do handle.");
        messages.add(this.prefix + "§e<PLAYER> §7is now very crispy.");
        messages.add(this.prefix + "§7- arson.");

        return messages;
    }

    private ArrayList<String> getLavaMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7is now very wet & crispy.");
        messages.add(this.prefix + "§e<PLAYER> §7just died in red sauce");

        return messages;
    }

    private ArrayList<String> getEntityMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7wasn't fast enough..");
        messages.add(this.prefix + "§e<PLAYER> §7speedran death.");

        return messages;
    }

    private ArrayList<String> getDrowningMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7drowned in Tears.");
        messages.add(this.prefix + "§e<PLAYER> §7: \"Blubb\"");

        return messages;
    }

    private ArrayList<String> getMagicMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7was killed by MAAAGIIIIC.");

        return messages;
    }

    private ArrayList<String> getSuffocationMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7breathed in too much wall.");
        messages.add(this.prefix + "§e<PLAYER> §7ate to much at once.");

        return messages;
    }

    private ArrayList<String> getLightingMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7was grilled by the Sky.");

        return messages;
    }

    private ArrayList<String> getThornsMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7Was pricked to death.");

        return messages;
    }

    private ArrayList<String> getStarvationMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7got the trial version of Food.");
        messages.add(this.prefix + "§e<PLAYER> §7EAT YOU BITCH");

        return messages;
    }

    private ArrayList<String> getBlockExplosionMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7went \"kabooom\".");
        messages.add(this.prefix + "§e<PLAYER> §7boom bitch get out the way.");


        return messages;
    }

    private ArrayList<String> getEntityExplosionMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7hugged a creeper.");
        messages.add(this.prefix + "§e<PLAYER> §7wanted to date a creeper.");

        return messages;
    }

    private ArrayList<String> getFallingBlockMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7was crushed by a Block.");
        messages.add(this.prefix + "§e<PLAYER> §7became one with the Block.");

        return messages;
    }

    private ArrayList<String> getProjectileBlockMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7was Shot.");
        messages.add(this.prefix + "§e<PLAYER> §7tried to catch the Arrow.");
        messages.add(this.prefix + "§e<PLAYER> §7couldn't get out of the way in time.");

        return messages;
    }

    private ArrayList<String> getDefaultMessages() {
        final ArrayList<String> messages = new ArrayList<>();

        messages.add(this.prefix + "§e<PLAYER> §7Died.");
        messages.add(this.prefix + "§e<PLAYER> §7only played the Trial version.");

        return messages;
    }

}
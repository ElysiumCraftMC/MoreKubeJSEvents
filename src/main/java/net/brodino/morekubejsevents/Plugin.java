package net.brodino.morekubejsevents;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.util.ClassFilter;
import dev.latvian.mods.rhino.Script;
import net.brodino.morekubejsevents.events.Events;

public class Plugin extends KubeJSPlugin {

    public void registerClasses(Script type, ClassFilter filter) {
        filter.allow("net.brodino.morekubejsevents");
    }

    @Override
    public void registerEvents() {
        Events.GROUP.register();
    }
}
